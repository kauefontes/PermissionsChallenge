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

        this.permissionList.add(new Permission( "Write Contacts",
                android.Manifest.permission.WRITE_CONTACTS));
        this.permissionList.add(new Permission("Write External Storage",
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE));
        this.permissionList.add(new Permission("Read SMS",
                android.Manifest.permission.READ_SMS));
        this.permissionList.add(new Permission("Camera",
                android.Manifest.permission.CAMERA));
        this.permissionList.add(new Permission("ACCEPT_HANDOVER",
                android.Manifest.permission.ACCEPT_HANDOVER));
        this.permissionList.add(new Permission("Background Locarion",
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION));
        this.permissionList.add(new Permission("Access Network State",
                android.Manifest.permission.ACCESS_NETWORK_STATE));
        this.permissionList.add(new Permission("Access Wifi State",
                android.Manifest.permission.ACCESS_WIFI_STATE));
        this.permissionList.add(new Permission("Answer Phone Calls",
                android.Manifest.permission.ANSWER_PHONE_CALLS));
        this.permissionList.add(new Permission("Bluetooth",
                android.Manifest.permission.BLUETOOTH));
        this.permissionList.add(new Permission("Body Sensors",
                android.Manifest.permission.BODY_SENSORS));
        this.permissionList.add(new Permission("Broadcast Sticky",
                android.Manifest.permission.BROADCAST_STICKY));
        this.permissionList.add(new Permission("Expand Status Bar",
                android.Manifest.permission.EXPAND_STATUS_BAR));
        this.permissionList.add(new Permission("Get Accounts",
                android.Manifest.permission.GET_ACCOUNTS));
        this.permissionList.add(new Permission("Get Package Size",
                android.Manifest.permission.GET_PACKAGE_SIZE));
        this.permissionList.add(new Permission("Install Shorcut",
                android.Manifest.permission.INTERNET));
        this.permissionList.add(new Permission("NFC",
                android.Manifest.permission.NFC));
        this.permissionList.add(new Permission("Write Calendar",
                android.Manifest.permission.WRITE_CALENDAR));
        this.permissionList.add(new Permission("Record Audio",
                android.Manifest.permission.RECORD_AUDIO));

        showPermissionRecyclerViewAdapter = new ShowPermissionRecyclerViewAdapter(getContext(), permissionList);
        recyclerView.setAdapter(showPermissionRecyclerViewAdapter);
        return root;
    }
}