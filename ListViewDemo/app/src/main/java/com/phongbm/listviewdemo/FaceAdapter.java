package com.phongbm.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FaceAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Face> faces;

    public FaceAdapter(Context context, ArrayList<Face> faces) {
        this.context = context;
        this.faces = faces;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return faces.size();
    }

    @Override
    public Face getItem(int position) {
        return faces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Bước 1: Ánh xạ item view
        // Phải sử dụng LayoutInflater để ánh xạ view
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_face, parent, false);

            holder = new ViewHolder();
            holder.imgPhoto = (ImageView) convertView.findViewById(R.id.img_photo);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Bước 2: Đổ dã liệu tương ứng từ mảng
        Face face = faces.get(position);
        holder.imgPhoto.setImageResource(face.getImageId());
        holder.tvName.setText(face.getName());

        // Lắng nghe sự kiện
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,
                        "Photo clicked: " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private class ViewHolder {
        private ImageView imgPhoto;
        private TextView tvName;
    }

}