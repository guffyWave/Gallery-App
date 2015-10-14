package com.gufrankhurshid.galleryapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gufrankhurshid.galleryapp.R;
import com.gufrankhurshid.galleryapp.dto.Gallery;
import com.squareup.picasso.Picasso;

/**
 * Created by gufran on 10/14/15.
 */
public class GalleryAdapter extends BaseAdapter {

    Gallery gallery;
    Context context;

    View itemView;

    LayoutInflater inflater;

    public GalleryAdapter(Context context, Gallery gallery) {
        this.context = context;
        this.gallery = gallery;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return gallery.getGalleryImageList().size();
    }

    @Override
    public Object getItem(int position) {
        return gallery.getGalleryImageList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            itemView = new View(context);
            itemView = inflater.inflate(R.layout.layout_gallery_grid_item, null);
            TextView gridTextView = (TextView) itemView.findViewById(R.id.gridTextView);
            ImageView gridImageView = (ImageView) itemView.findViewById(R.id.gridImageView);

            gridTextView.setText(gallery.getGalleryImageList().get(position).getDescription());

            Picasso.with(context)
                    .load(Uri.parse(gallery.getGalleryImageList().get(position).getFileUri()))
                    .fit().centerCrop()
                    .into(gridImageView);
        } else {
            itemView = (View) convertView;
        }
        return itemView;
    }


}
