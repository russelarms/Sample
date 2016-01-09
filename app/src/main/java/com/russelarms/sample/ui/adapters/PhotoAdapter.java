package com.russelarms.sample.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.russelarms.sample.R;
import com.russelarms.sample.data.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Ruslan on 09.01.2016
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private List<Photo> mPhotos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView mImageView;
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mView = v;
            mImageView = (ImageView) v.findViewById(R.id.imageView);
            mTextView = (TextView) v.findViewById(R.id.textView);
        }
    }

    public PhotoAdapter(List<Photo> photos) {
        mPhotos = photos;
    }

    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo = mPhotos.get(position);

        String name = photo.name;

        if (!TextUtils.isEmpty(name)) {
            holder.mTextView.setText(name);
        }

        Picasso.with(holder.mView.getContext())
                .load(photo.images.get(0).url)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
