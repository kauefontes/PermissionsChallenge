package io.kpereira.permissionschallenge.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.kpereira.permissionschallenge.data.PermissionDao;
import io.kpereira.permissionschallenge.data.PermissionRoomDatabase;
import io.kpereira.permissionschallenge.model.Permission;

public class PermissionRepository {
    private PermissionDao permissionDao;
    private LiveData<List<Permission>> allPermissions;

    public PermissionRepository(Application application) {
        PermissionRoomDatabase db = PermissionRoomDatabase.getDatabase(application);
        permissionDao = db.permissionDao();
        allPermissions = permissionDao.getAllPermissions();
    }

    public LiveData<List<Permission>> getAllPermissions() {
        return allPermissions;
    }

    public void insert(Permission permission) {
        new insertAsyncTask(permissionDao).execute(permission);
    }

    private class insertAsyncTask extends AsyncTask<Permission, Void, Void> {
        private PermissionDao asyncTaskDao;

        public insertAsyncTask(PermissionDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Permission... permissions) {
            if(!permissionDao.exists(permissions[0].getDescription())){
                asyncTaskDao.insert(permissions[0]);
            }
            return null;
        }
    }
}
