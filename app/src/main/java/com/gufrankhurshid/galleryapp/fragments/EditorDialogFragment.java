package com.gufrankhurshid.galleryapp.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gufrankhurshid.galleryapp.R;
import com.gufrankhurshid.galleryapp.dao.GalleryImageDAO;
import com.gufrankhurshid.galleryapp.dao.GalleryImageDAOImpl;
import com.gufrankhurshid.galleryapp.dto.GalleryImage;
import com.gufrankhurshid.galleryapp.management.FragmentSetup;
import com.squareup.picasso.Picasso;

/**
 * Created by gufran on 10/14/15.
 */
public class EditorDialogFragment extends DialogFragment implements FragmentSetup {

    ///------->>
    LayoutInflater inflater;
    View mainView;
    Dialog dialog;


    //------------->>
    GalleryImageDAO galleryImageDAO;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        mainView = inflater.inflate(R.layout.layout_editor_dialog, null);
        ImageView selectedImageView = (ImageView) mainView.findViewById(R.id.selectedImageView);
        final TextView descriptionEditText = (TextView) mainView.findViewById(R.id.descriptionEditText);


        Bundle bundle = getArguments();
        final String selectedImage = bundle.getString("IMAGE_PATH");


        Picasso.with(getActivity())
                .load(Uri.parse(selectedImage))
                .fit().centerCrop()
                .into(selectedImageView);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String description = descriptionEditText.getText().toString();

                galleryImageDAO = new GalleryImageDAOImpl();
                GalleryImage gi = new GalleryImage(selectedImage, description);

                galleryImageDAO.addGalleryImage(gi);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setView(mainView);
        return builder.create();
    }


    @Override
    public void onResume() {
        super.onResume();
        applyTypeFace();
        initialize();
    }

    @Override
    public void referView() {

    }

    @Override
    public void applyTypeFace() {

    }

    @Override
    public void initialize() {
        //setStyle();
    }
}
