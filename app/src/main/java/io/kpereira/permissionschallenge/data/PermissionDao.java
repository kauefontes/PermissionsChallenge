package io.kpereira.permissionschallenge.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.kpereira.permissionschallenge.model.Permission;

@Dao
public interface PermissionDao {

    @Insert
    void insert(Permission permission);

    @Query("DELETE FROM permission_table")
    void deleteAll();

    @Query("DELETE FROM permission_table WHERE id = :id")
    int deleteAPermission(int id);

    @Query("UPDATE permission_table SET name_col = :name WHERE id = :id")
    int updatePermissionName(int id, String name);

    @Query("UPDATE permission_table SET description_col = :description WHERE id = :id")
    int updatePermissionDescription(int id, String description);

    @Query("SELECT * FROM permission_table ORDER BY name_col DESC")
    LiveData<List<Permission>> getAllPermissions();

    @Query("SELECT * FROM permission_table WHERE EXISTS (SELECT description_col FROM permission_table WHERE description_col = :description)")
    boolean exists(String description);
}
