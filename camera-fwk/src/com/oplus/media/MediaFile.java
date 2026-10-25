package com.oplus.media;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.webkit.MimeTypeMap;

public class MediaFile {
    public static class MediaFileType {
        public final int fileType;
        public final String mimeType;

        public MediaFileType(int fileType, String mimeType) {
            this.fileType = fileType;
            this.mimeType = mimeType;
        }
    }

    public static Uri getDefaultAlarmUri(Context context) {
        return Settings.System.DEFAULT_ALARM_ALERT_URI;
    }

    public static Uri getDefaultNotificationUri(Context context) {
        return Settings.System.DEFAULT_NOTIFICATION_URI;
    }

    public static Uri getDefaultSmsNotificationUri(Context context) {
        return Settings.System.DEFAULT_NOTIFICATION_URI;
    }

    public static MediaFileType getFileType(String path) {
        String mime = getMimeTypeForFile(path);
        return new MediaFileType(0, mime != null ? mime : "");
    }

    public static int getFileTypeForMimeType(String mimeType) {
        return 0;
    }

    public static String getMimeType(String path, int fileType) {
        return getMimeTypeForFile(path);
    }

    public static String getMimeTypeForFile(String path) {
        if (path == null) return null;
        String ext = MimeTypeMap.getFileExtensionFromUrl(path);
        if (ext == null || ext.isEmpty()) {
            int dot = path.lastIndexOf('.');
            if (dot >= 0) ext = path.substring(dot + 1);
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext != null ? ext.toLowerCase() : "");
    }

    public static boolean isAudioFileType(int fileType) {
        return false;
    }

    public static boolean isVideoFileType(int fileType) {
        return false;
    }

    public static boolean isImageFileType(int fileType) {
        return false;
    }

    public static boolean isAudioMimeType(String mimeType) {
        return mimeType != null && mimeType.startsWith("audio/");
    }

    public static boolean isVideoMimeType(String mimeType) {
        return mimeType != null && mimeType.startsWith("video/");
    }

    public static boolean isImageMimeType(String mimeType) {
        return mimeType != null && mimeType.startsWith("image/");
    }

    public static boolean isRawImageMimeType(String mimeType) {
        return mimeType != null && (mimeType.equals("image/x-adobe-dng") || mimeType.contains("raw"));
    }

    public static boolean isApkFileType(int fileType) {
        return false;
    }

    public static boolean isApkMimeType(String mimeType) {
        return "application/vnd.android.package-archive".equalsIgnoreCase(mimeType);
    }

    public static boolean isCompressFileType(int fileType) {
        return false;
    }

    public static boolean isDocFileType(int fileType) {
        return false;
    }

    public static boolean isDocMimeType(String mimeType) {
        return false;
    }

    public static boolean isDrmFileType(int fileType) {
        return false;
    }
}
