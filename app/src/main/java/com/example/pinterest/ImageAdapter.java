package com.example.pinterest;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;

    public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_trangchu, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int i) {
        Upload uploadCurrent = mUploads.get(i);
        holder.tvTieude.setText(uploadCurrent.getTieude());
        Picasso.with(mContext)
                .load(uploadCurrent.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, LayoutTrangchu1Activity.class);
                intent.putExtra("tieude", mUploads.get(i).getTieude());
                intent.putExtra("name",mUploads.get(i).getName());
                intent.putExtra("mota", mUploads.get(i).getMota());
                intent.putExtra("id", mUploads.get(i).getId());
                intent.putExtra("fileExtension", mUploads.get(i).getFileExtension());
                intent.putExtra("imageUrl", mUploads.get(i).getImageUrl());
                mContext.startActivity(intent);
                // downloadFile(holder.tvTieude.getContext(),mUploads.get(position).getId(),uploadCurrent.getFileExtension(),
                //       mUploads.get(position).getImageUrl());
            }
        });
    }


    public void downloadFile(Context context, String fileName, String fileExtension, String url) {
        DownloadManager downloadmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("Download");
        request.setDescription("Download file ...");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName + "." + fileExtension);

        if (downloadmanager != null) {
            downloadmanager.enqueue(request);
        }
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTieude;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTieude = itemView.findViewById(R.id.txtNameTrangChu);
            imageView = itemView.findViewById(R.id.imgHinhTrangChu);
        }
    }

}
