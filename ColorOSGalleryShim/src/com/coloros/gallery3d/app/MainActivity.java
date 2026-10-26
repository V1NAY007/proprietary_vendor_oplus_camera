/*
 * Copyright (C) 2026 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.coloros.gallery3d.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "ColorOSGalleryShim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            forwardIntent();
        } catch (Exception e) {
            Log.e(TAG, "Error forwarding gallery intent", e);
        } finally {
            finish();
        }
    }

    private void forwardIntent() {
        Intent src = getIntent();
        if (src == null) {
            return;
        }

        Uri uri = src.getData();
        String type = src.getType();
        PackageManager pm = getPackageManager();

        Intent dest;
        if (uri == null && type == null) {
            dest = new Intent(Intent.ACTION_MAIN);
            dest.addCategory(Intent.CATEGORY_APP_GALLERY);
        } else {
            dest = new Intent(Intent.ACTION_VIEW);
            if (uri != null && type != null) {
                dest.setDataAndType(uri, type);
            } else if (uri != null) {
                dest.setData(uri);
            } else {
                dest.setType(type);
            }
        }

        dest.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        Bundle extras = src.getExtras();
        if (extras != null) {
            dest.putExtras(extras);
        }

        // 1. Try OnePlus / OPlus Gallery (com.oneplus.gallery)
        Intent oplusIntent = new Intent(dest);
        oplusIntent.setPackage("com.oneplus.gallery");
        if (oplusIntent.resolveActivity(pm) != null) {
            try {
                startActivity(oplusIntent);
                return;
            } catch (Exception e) {
                Log.w(TAG, "Failed to launch com.oneplus.gallery", e);
            }
        }

        // 2. Try Google Photos (com.google.android.apps.photos)
        Intent photosIntent = new Intent(dest);
        photosIntent.setPackage("com.google.android.apps.photos");
        if (photosIntent.resolveActivity(pm) != null) {
            try {
                startActivity(photosIntent);
                return;
            } catch (Exception e) {
                Log.w(TAG, "Failed to launch Google Photos", e);
            }
        }

        // 3. Fallback to any installed gallery app (excluding this shim)
        dest.setPackage(null);
        dest.setComponent(null);
        java.util.List<android.content.pm.ResolveInfo> resolveInfos = pm.queryIntentActivities(dest, 0);
        for (android.content.pm.ResolveInfo info : resolveInfos) {
            if (info.activityInfo != null && !getPackageName().equals(info.activityInfo.packageName)) {
                try {
                    Intent target = new Intent(dest);
                    target.setClassName(info.activityInfo.packageName, info.activityInfo.name);
                    startActivity(target);
                    return;
                } catch (Exception e) {
                    Log.w(TAG, "Failed to launch activity: " + info.activityInfo.name, e);
                }
            }
        }
    }
}
