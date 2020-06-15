package io.kpereira.permissionschallenge.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.kpereira.permissionschallenge.repository.PermissionRepository;

public class PermissionViewModel extends AndroidViewModel {
    private PermissionRepository permissionRepository;
    private LiveData<List<Permission>> allPermissions;

    public PermissionViewModel(@NonNull Application application) {
        super(application);
        permissionRepository = new PermissionRepository(application);
        allPermissions = permissionRepository.getAllPermissions();
    }

    public LiveData<List<Permission>> getAllPermissions() {
        return allPermissions;
    }

    public void insert(Permission permission) {
        permissionRepository.insert(permission);
    }
}
