package io.kpereira.permissionschallenge.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import io.kpereira.permissionschallenge.model.Permission;

@Database(entities = {Permission.class}, version = 1, exportSchema = false)
public abstract class PermissionRoomDatabase extends RoomDatabase {
    public static volatile PermissionRoomDatabase INSTANCE;
    private static RoomDatabase.Callback roomDatabaseCallBack =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    public static PermissionRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PermissionRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PermissionRoomDatabase.class, "permission_database")
                            .addCallback(roomDatabaseCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract PermissionDao permissionDao();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final PermissionDao permissionDao;

        private PopulateDbAsync(PermissionRoomDatabase db) {
            this.permissionDao = db.permissionDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
