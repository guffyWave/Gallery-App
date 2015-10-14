package com.gufrankhurshid.galleryapp.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.gufrankhurshid.galleryapp.R;
import com.gufrankhurshid.galleryapp.management.GalleryAppFragment;

/**
 * Created by guffy on 10/12/15.
 */
public class WelcomeMenuFragment extends GalleryAppFragment {
    //----------->>View References
    View mainView;
    // TextView myTextView;
    Button myButton;
    ImageView imageView;


    //------------->>

    int RESULT_LOAD_IMG = 1234;

    FragmentManager fragmentManager;

    EditorDialogFragment editorDialogFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_welcome_menu, container, false);
        return mainView;
    }

    @Override
    public void referView() {
        // myTextView = (TextView) mainView.findViewById(R.id.myTextView);
        myButton = (Button) mainView.findViewById(R.id.myButton);
        imageView = (ImageView) mainView.findViewById(R.id.imageView);
    }

    @Override
    public void applyTypeFace() {

    }

    @Override
    public void initialize() {
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
            }
        });

//        for (GalleryImage gim :
//                g.getGalleryImageList()) {
//            System.out.println(gim.getFileUri() + " " + gim.getDescription());
//        }


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == RESULT_LOAD_IMG && resultCode == getActivity().RESULT_OK
                    && null != data) {
                Uri selectedImage = data.getData();

                System.out.println("Selected Image Path " + getPath(selectedImage));

                fragmentManager = getFragmentManager();
                editorDialogFragment = new EditorDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("IMAGE_PATH", getPath(selectedImage));
                editorDialogFragment.setArguments(bundle);
                editorDialogFragment.show(fragmentManager, "EDITOR_DIALOG_FRAGMENT");

            } else {
                Toast.makeText(getActivity(), "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public String getPath(Uri uri) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(uri,
                filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }

}
