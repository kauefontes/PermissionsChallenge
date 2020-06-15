package io.kpereira.permissionschallenge.ui.requestPermissions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.kpereira.permissionschallenge.R;
import io.kpereira.permissionschallenge.adapter.RequestPermissionRecyclerViewAdapter;
import io.kpereira.permissionschallenge.model.Permission;
import io.kpereira.permissionschallenge.model.PermissionViewModel;

public class RequestPermissionFragment extends Fragment {
    List<Permission> permissionList = new ArrayList<>();
    private PermissionViewModel permissionViewModel;
    private RecyclerView recyclerView;
    private RequestPermissionRecyclerViewAdapter recyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_request_permissions,
                container, false);
        permissionViewModel = new ViewModelProvider(this.requireActivity())
                .get(PermissionViewModel.class);

        recyclerView = root.findViewById(R.id.set_permissions_recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        this.permissionList.add(new Permission("Write Contacts",
                android.Manifest.permission.WRITE_CONTACTS));
        this.permissionList.add(new Permission("Write External Storage",
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE));
        this.permissionList.add(new Permission("Read SMS",
                android.Manifest.permission.READ_SMS));
        this.permissionList.add(new Permission("Camera",
                android.Manifest.permission.CAMERA));
        this.permissionList.add(new Permission("Answer Phone Calls",
                android.Manifest.permission.ANSWER_PHONE_CALLS));
        this.permissionList.add(new Permission("Body Sensors",
                android.Manifest.permission.BODY_SENSORS));
        this.permissionList.add(new Permission("Write Calendar",
                android.Manifest.permission.WRITE_CALENDAR));
        this.permissionList.add(new Permission("Record Audio",
                android.Manifest.permission.RECORD_AUDIO));

        for (Permission permission : permissionList)
            permissionViewModel.insert(permission);

        permissionViewModel.getAllPermissions().observe(getViewLifecycleOwner(), new Observer<List<Permission>>() {
            @Override
            public void onChanged(List<Permission> permissions) {
                recyclerViewAdapter = new RequestPermissionRecyclerViewAdapter(getContext(), permissions);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        return root;
    }
}