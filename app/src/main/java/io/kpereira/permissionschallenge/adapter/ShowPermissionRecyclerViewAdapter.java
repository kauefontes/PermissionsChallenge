package io.kpereira.permissionschallenge.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.kpereira.permissionschallenge.R;
import io.kpereira.permissionschallenge.model.Permission;
import io.kpereira.permissionschallenge.utils.RequestPermission;

public class ShowPermissionRecyclerViewAdapter extends RecyclerView.Adapter<ShowPermissionRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Permission> permissionList;

    public ShowPermissionRecyclerViewAdapter(Context context, List<Permission> permissionList) {
        this.context = context;
        this.permissionList = permissionList;
    }

    @NonNull
    @Override
    public ShowPermissionRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_show_permissions_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowPermissionRecyclerViewAdapter.ViewHolder holder, int position) {
        Permission permission = this.permissionList.get(position);
        holder.permissionTextView.setText(permission.getName());
        if (RequestPermission.hasPermission(context, permission.getDescription())) {
            holder.permissionCardView.setCardBackgroundColor(Color.parseColor("#21de7c"));
            holder.lockIcon.setImageResource(R.drawable.ic_baseline_lock_open_24);
        }else {
            holder.permissionCardView.setCardBackgroundColor(Color.parseColor("#ffcccc"));
            holder.lockIcon.setImageResource(R.drawable.ic_baseline_lock_24);
        }
    }

    @Override
    public int getItemCount() {
        return permissionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView permissionTextView;
        public CardView permissionCardView;
        public ImageView lockIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            permissionCardView = itemView.findViewById(R.id.list_permission_carview);
            permissionTextView = itemView.findViewById(R.id.permission_textview);
            lockIcon = itemView.findViewById(R.id.lock_icon);
        }
    }
}
