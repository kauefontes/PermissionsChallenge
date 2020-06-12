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

        this.permissions.add(new Permission( "Write Contacts",
                android.Manifest.permission.WRITE_CONTACTS));
        this.permissions.add(new Permission("Write External Storage",
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE));
        this.permissions.add(new Permission("Read SMS",
                android.Manifest.permission.READ_SMS));
        this.permissions.add(new Permission("Camera",
                android.Manifest.permission.CAMERA));
        this.permissions.add(new Permission("ACCEPT_HANDOVER",
                android.Manifest.permission.ACCEPT_HANDOVER));
        this.permissions.add(new Permission("Background Locarion",
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION));
        this.permissions.add(new Permission("Access Network State",
                android.Manifest.permission.ACCESS_NETWORK_STATE));
        this.permissions.add(new Permission("Access Wifi State",
                android.Manifest.permission.ACCESS_WIFI_STATE));
        this.permissions.add(new Permission("Answer Phone Calls",
                android.Manifest.permission.ANSWER_PHONE_CALLS));
        this.permissions.add(new Permission("Bluetooth",
                android.Manifest.permission.BLUETOOTH));
        this.permissions.add(new Permission("Body Sensors",
                android.Manifest.permission.BODY_SENSORS));
        this.permissions.add(new Permission("Broadcast Sticky",
                android.Manifest.permission.BROADCAST_STICKY));
        this.permissions.add(new Permission("Expand Status Bar",
                android.Manifest.permission.EXPAND_STATUS_BAR));
        this.permissions.add(new Permission("Get Accounts",
                android.Manifest.permission.GET_ACCOUNTS));
        this.permissions.add(new Permission("Get Package Size",
                android.Manifest.permission.GET_PACKAGE_SIZE));
        this.permissions.add(new Permission("Install Shorcut",
                android.Manifest.permission.INTERNET));
        this.permissions.add(new Permission("NFC",
                android.Manifest.permission.NFC));
        this.permissions.add(new Permission("Write Calendar",
                android.Manifest.permission.WRITE_CALENDAR));
        this.permissions.add(new Permission("Record Audio",
                android.Manifest.permission.RECORD_AUDIO));

        recyclerViewAdapter = new RequestPermissionRecyclerViewAdapter(getContext(), permissions);
        recyclerView.setAdapter(recyclerViewAdapter);
        return root;
    }
}