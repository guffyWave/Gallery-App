package com.gufrankhurshid.galleryapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gufrankhurshid.galleryapp.R;
import com.gufrankhurshid.galleryapp.management.GalleryAppFragment;

/**
 * Created by guffy on 10/12/15.
 */
public class WelcomeMenuFragment extends GalleryAppFragment {
    //----------->>View References
    View mainView;
    TextView myTextView;
    Button myButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_welcome_menu, container, false);
        return mainView;
    }

    @Override
    public void referView() {
        myTextView = (TextView) mainView.findViewById(R.id.myTextView);
        myButton = (Button) mainView.findViewById(R.id.myButton);
    }

    @Override
    public void applyTypeFace() {

    }

    @Override
    public void initialize() {
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText("Another Bismillah Hirrahma Nirrahim");
            }
        });
    }
}
