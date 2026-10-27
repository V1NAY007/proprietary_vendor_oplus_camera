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
        } catch (Throwable t) {
            Log.e(TAG, "Fatal error forwarding gallery intent", t);
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

        // Grant read URI permission to the target gallery app.
        // DO NOT add FLAG_GRANT_WRITE_URI_PERMISSION as the shim does not own
        // the MediaStore URI and attempting to grant write permission triggers
        // SecurityException on Android 11+ (Scoped Storage).
        dest.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        if (uri != null) {
            dest.setClipData(ClipData.newRawUri("media", uri));
        }

        Bundle extras = src.getExtras();
        if (extras != null) {
            dest.putExtras(extras);
        }

        // Special handling for ACTION_EDIT
        if (Intent.ACTION_EDIT.equals(action)) {
            forwardEditIntent(dest, pm);
            return;
        }

        // 1. Try OnePlus / OPlus Gallery ViewGallery explicitly
        Intent oplusViewIntent = new Intent(dest);
        oplusViewIntent.setComponent(new ComponentName("com.oneplus.gallery", "com.oppo.gallery3d.app.ViewGallery"));
        if (oplusViewIntent.resolveActivity(pm) != null) {
            try {
                Log.d(TAG, "Launching com.oneplus.gallery ViewGallery");
                startActivity(oplusViewIntent);
                return;
            } catch (Throwable t) {
                Log.e(TAG, "Failed to launch com.oppo.gallery3d.app.ViewGallery", t);
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
            } catch (Throwable t) {
                Log.e(TAG, "Failed to launch com.oneplus.gallery", t);
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
            } catch (Throwable t) {
                Log.e(TAG, "Failed to launch Google Photos", t);
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
                } catch (Throwable t) {
                    Log.e(TAG, "Failed to launch activity: " + info.activityInfo.name, t);
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
                    } catch (Throwable t) {
                        Log.e(TAG, "Failed to launch ACTION_VIEW activity: " + info.activityInfo.name, t);
                    }
                }
            }
        }

        Log.w(TAG, "No activity found to handle intent");
    }

    private void forwardEditIntent(Intent dest, PackageManager pm) {
        // 1. Try OnePlus Gallery PhotoEditorActivity explicitly
        Intent oplusEditorIntent = new Intent(dest);
        oplusEditorIntent.setComponent(new ComponentName("com.oneplus.gallery", "com.oplus.gallery.pictureeditorpage.PhotoEditorActivity"));
        if (oplusEditorIntent.resolveActivity(pm) != null) {
            try {
                Log.d(TAG, "Launching com.oneplus.gallery PhotoEditorActivity");
                startActivity(oplusEditorIntent);
                return;
            } catch (Throwable t) {
                Log.e(TAG, "Failed to launch PhotoEditorActivity", t);
            }
        }

        // 2. Try OnePlus Gallery package-level for EDIT
        Intent oplusIntent = new Intent(dest);
        oplusIntent.setPackage("com.oneplus.gallery");
        if (oplusIntent.resolveActivity(pm) != null) {
            try {
                Log.d(TAG, "Launching com.oneplus.gallery for EDIT");
                startActivity(oplusIntent);
                return;
            } catch (Throwable t) {
                Log.e(TAG, "Failed to launch com.oneplus.gallery EDIT", t);
            }
        }

        // 3. Try Google Photos for EDIT
        Intent photosIntent = new Intent(dest);
        photosIntent.setPackage("com.google.android.apps.photos");
        if (photosIntent.resolveActivity(pm) != null) {
            try {
                Log.d(TAG, "Launching Google Photos for EDIT");
                startActivity(photosIntent);
                return;
            } catch (Throwable t) {
                Log.e(TAG, "Failed to launch Google Photos EDIT", t);
            }
        }

        // 4. Try any installed editor app handling ACTION_EDIT
        dest.setPackage(null);
        dest.setComponent(null);
        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(dest, 0);
        for (ResolveInfo info : resolveInfos) {
            if (info.activityInfo != null && !getPackageName().equals(info.activityInfo.packageName)) {
                try {
                    Intent target = new Intent(dest);
                    target.setClassName(info.activityInfo.packageName, info.activityInfo.name);
                    Log.d(TAG, "Launching fallback editor: " + info.activityInfo.packageName + "/" + info.activityInfo.name);
                    startActivity(target);
                    return;
                } catch (Throwable t) {
                    Log.e(TAG, "Failed to launch editor: " + info.activityInfo.name, t);
                }
            }
        }

        // 5. Fallback: try ACTION_VIEW if no editor is found
        Log.w(TAG, "No editor found for ACTION_EDIT, falling back to ACTION_VIEW");
        dest.setAction(Intent.ACTION_VIEW);
        forwardIntent(dest);
    }
}
