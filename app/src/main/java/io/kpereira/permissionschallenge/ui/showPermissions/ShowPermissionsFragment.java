package io.kpereira.permissionschallenge.ui.showPermissions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.kpereira.permissionschallenge.R;
import io.kpereira.permissionschallenge.adapter.ShowPermissionRecyclerViewAdapter;
import io.kpereira.permissionschallenge.model.Permission;

public class ShowPermissionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ShowPermissionRecyclerViewAdapter showPermissionRecyclerViewAdapter;
    private List<Permission> permissionList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_show_permissions, container, false);

        recyclerView = root.findViewById(R.id.list_permissions_recycleview);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        this.permissionList.add(new Permission( "Write Contacts", android.Manifest.permission.WRITE_CONTACTS));
        this.permissionList.add(new Permission("Write External Storage", android.Manifest.permission.WRITE_EXTERNAL_STORAGE));
        this.permissionList.add(new Permission("Read SMS", android.Manifest.permission.READ_SMS));
        this.permissionList.add(new Permission("Camera", android.Manifest.permission.CAMERA));

        showPermissionRecyclerViewAdapter = new ShowPermissionRecyclerViewAdapter(getContext(), permissionList);
        recyclerView.setAdapter(showPermissionRecyclerViewAdapter);
        return root;
    }
}