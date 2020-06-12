package io.kpereira.permissionschallenge.ui.requestPermissions;

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
import io.kpereira.permissionschallenge.adapter.RequestPermissionRecyclerViewAdapter;
import io.kpereira.permissionschallenge.model.Permission;
import io.kpereira.permissionschallenge.utils.RequestPermission;

public class RequestPermissionFragment extends Fragment {
    private RecyclerView recyclerView;
    private RequestPermissionRecyclerViewAdapter recyclerViewAdapter;
    List<Permission> permissions = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_request_permissions, container, false);

        recyclerView = root.findViewById(R.id.set_permissions_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        this.permissions.add(new Permission( "Write Contacts", android.Manifest.permission.WRITE_CONTACTS));
        this.permissions.add(new Permission("Write External Storage", android.Manifest.permission.WRITE_EXTERNAL_STORAGE));
        this.permissions.add(new Permission("Read SMS", android.Manifest.permission.READ_SMS));
        this.permissions.add(new Permission("Camera", android.Manifest.permission.CAMERA));


        recyclerViewAdapter = new RequestPermissionRecyclerViewAdapter(getContext(), permissions);
        recyclerView.setAdapter(recyclerViewAdapter);
        return root;
    }
}