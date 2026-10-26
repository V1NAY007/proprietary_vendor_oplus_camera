/*
 * Copyright (C) 2026 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.coloros.gallery3d.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "ColorOSGalleryShim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        try {
            forwardIntent(intent);
        } catch (Exception e) {
            Log.e(TAG, "Error forwarding gallery intent", e);
        } finally {
            finish();
        }
    }

    private void forwardIntent(Intent src) {
        if (src == null) {
            return;
        }

        Uri uri = src.getData();
        String type = src.getType();
        String action = src.getAction();
        PackageManager pm = getPackageManager();

        Log.d(TAG, "Received intent: action=" + action + ", data=" + uri + ", type=" + type);

        if (action == null || action.isEmpty()) {
            action = (uri != null || type != null) ? Intent.ACTION_VIEW : Intent.ACTION_MAIN;
        }

        Intent dest = new Intent(action);
        if (Intent.ACTION_MAIN.equals(action) && uri == null && type == null) {
            dest.addCategory(Intent.CATEGORY_APP_GALLERY);
        }

        if (uri != null && type != null) {
            dest.setDataAndType(uri, type);
        } else if (uri != null) {
            dest.setData(uri);
        } else if (type != null) {
            dest.setType(type);
        }

        dest.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_GRANT_READ_URI_PERMISSION
                | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        if (uri != null) {
            dest.setClipData(ClipData.newRawUri("media", uri));
        }

        Bundle extras = src.getExtras();
        if (extras != null) {
            dest.putExtras(extras);
        }

        // 1. Try OnePlus / OPlus Gallery ViewGallery explicitly
        Intent oplusViewIntent = new Intent(dest);
        oplusViewIntent.setComponent(new ComponentName("com.oneplus.gallery", "com.oppo.gallery3d.app.ViewGallery"));
        if (oplusViewIntent.resolveActivity(pm) != null) {
            try {
                Log.d(TAG, "Launching com.oneplus.gallery ViewGallery");
                startActivity(oplusViewIntent);
                return;
            } catch (Exception e) {
                Log.w(TAG, "Failed to launch com.oppo.gallery3d.app.ViewGallery", e);
            }
        }

        // 2. Try OnePlus / OPlus Gallery package-level
        Intent oplusIntent = new Intent(dest);
        oplusIntent.setPackage("com.oneplus.gallery");
        if (oplusIntent.resolveActivity(pm) != null) {
            try {
                Log.d(TAG, "Launching com.oneplus.gallery");
                startActivity(oplusIntent);
                return;
            } catch (Exception e) {
                Log.w(TAG, "Failed to launch com.oneplus.gallery", e);
            }
        }

        // 3. Try Google Photos (com.google.android.apps.photos)
        Intent photosIntent = new Intent(dest);
        photosIntent.setPackage("com.google.android.apps.photos");
        if (photosIntent.resolveActivity(pm) != null) {
            try {
                Log.d(TAG, "Launching Google Photos");
                startActivity(photosIntent);
                return;
            } catch (Exception e) {
                Log.w(TAG, "Failed to launch Google Photos", e);
            }
        }

        // 4. Try any installed gallery app handling the current action (excluding this shim)
        dest.setPackage(null);
        dest.setComponent(null);
        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(dest, 0);
        for (ResolveInfo info : resolveInfos) {
            if (info.activityInfo != null && !getPackageName().equals(info.activityInfo.packageName)) {
                try {
                    Intent target = new Intent(dest);
                    target.setClassName(info.activityInfo.packageName, info.activityInfo.name);
                    Log.d(TAG, "Launching fallback activity: " + info.activityInfo.packageName + "/" + info.activityInfo.name);
                    startActivity(target);
                    return;
                } catch (Exception e) {
                    Log.w(TAG, "Failed to launch activity: " + info.activityInfo.name, e);
                }
            }
        }

        // 5. Fallback to generic ACTION_VIEW if action was REVIEW and nothing resolved
        if (!Intent.ACTION_VIEW.equals(dest.getAction())) {
            dest.setAction(Intent.ACTION_VIEW);
            resolveInfos = pm.queryIntentActivities(dest, 0);
            for (ResolveInfo info : resolveInfos) {
                if (info.activityInfo != null && !getPackageName().equals(info.activityInfo.packageName)) {
                    try {
                        Intent target = new Intent(dest);
                        target.setClassName(info.activityInfo.packageName, info.activityInfo.name);
                        Log.d(TAG, "Launching ACTION_VIEW fallback: " + info.activityInfo.packageName + "/" + info.activityInfo.name);
                        startActivity(target);
                        return;
                    } catch (Exception e) {
                        Log.w(TAG, "Failed to launch ACTION_VIEW activity: " + info.activityInfo.name, e);
                    }
                }
            }
        }

        Log.w(TAG, "No activity found to handle intent");
    }
}
