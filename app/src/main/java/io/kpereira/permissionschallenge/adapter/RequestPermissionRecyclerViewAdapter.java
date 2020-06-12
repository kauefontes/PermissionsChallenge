package io.kpereira.permissionschallenge.adapter;

import android.app.ActivityManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.kpereira.permissionschallenge.R;
import io.kpereira.permissionschallenge.model.Permission;
import io.kpereira.permissionschallenge.utils.RequestPermission;

public class RequestPermissionRecyclerViewAdapter extends RecyclerView.Adapter<RequestPermissionRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Permission> permissions;

    public RequestPermissionRecyclerViewAdapter(Context context, List<Permission> permissions) {
        this.context = context;
        this.permissions = permissions;
    }

    @NonNull
    @Override
    public RequestPermissionRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_request_permissions, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestPermissionRecyclerViewAdapter.ViewHolder holder, int position) {
        Permission permission = this.permissions.get(position);

        holder.permission.setText(permission.getName());
        if (RequestPermission.hasPermission(this.context, permission.getDescription()))
            holder.permission.setChecked(true);
        else
            holder.permission.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return permissions.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public Switch permission;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
