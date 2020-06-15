package io.kpereira.permissionschallenge.ui.showPermissions;

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

import java.util.List;

import io.kpereira.permissionschallenge.R;
import io.kpereira.permissionschallenge.adapter.ShowPermissionRecyclerViewAdapter;
import io.kpereira.permissionschallenge.model.Permission;
import io.kpereira.permissionschallenge.model.PermissionViewModel;

public class ShowPermissionsFragment extends Fragment {
    private PermissionViewModel permissionViewModel;
    private RecyclerView recyclerView;
    private ShowPermissionRecyclerViewAdapter showPermissionRecyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_show_permissions,
                container, false);
        permissionViewModel = new ViewModelProvider(this.requireActivity())
                .get(PermissionViewModel.class);

        recyclerView = root.findViewById(R.id.list_permissions_recycleview);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        permissionViewModel.getAllPermissions().observe(getViewLifecycleOwner(), new Observer<List<Permission>>() {
            @Override
            public void onChanged(List<Permission> permissions) {
                showPermissionRecyclerViewAdapter = new ShowPermissionRecyclerViewAdapter(getContext(), permissions);
                recyclerView.setAdapter(showPermissionRecyclerViewAdapter);
            }
        });
        return root;
    }
}