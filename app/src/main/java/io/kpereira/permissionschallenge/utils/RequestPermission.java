package io.kpereira.permissionschallenge.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

public class RequestPermission {
    public static boolean hasPermission(Context context, String permission) {
        if (context != null && permission != null) {
            if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                Log.d("PermissionCheck", "hasPermissions: " + permission + " Denied");
                return false;
            } else {
                Log.d("PermissionCheck", "hasPermissions: " + permission + " Granted");
            }
        }
        return true;
    }

    public static void requestPermission(Context context, String permission) {
        ActivityCompat.requestPermissions((Activity) context,
                new String[]{permission},
                1);
    }
}
