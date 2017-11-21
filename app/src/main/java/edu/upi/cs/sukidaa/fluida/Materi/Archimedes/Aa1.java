package edu.upi.cs.sukidaa.fluida.Materi.Archimedes;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by Sutrisna Aji on 21/06/2017.
 */

public class Aa1 extends Fragment implements View.OnClickListener {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";
    ImageButton aa1image1,aa1image2,aa1image3,aa1image4;
    TextView teksaa1,teksaa2,teksaa3,teksaa4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.aa1, container, false);
        aa1image1 = (ImageButton)rootView.findViewById(R.id.aa1image1);
        aa1image2 = (ImageButton)rootView.findViewById(R.id.aa1image2);
        aa1image3 = (ImageButton)rootView.findViewById(R.id.aa1image3);
        aa1image4 = (ImageButton)rootView.findViewById(R.id.aa1image4);
        teksaa1 = (TextView)rootView.findViewById(R.id.teksaa11);
        teksaa2 = (TextView)rootView.findViewById(R.id.teksaa12);
        teksaa3 = (TextView)rootView.findViewById(R.id.teksaa13);
        teksaa4 = (TextView)rootView.findViewById(R.id.teksaa14);
        aa1image1.setOnClickListener(this);
        aa1image2.setOnClickListener(this);
        aa1image3.setOnClickListener(this);
        aa1image4.setOnClickListener(this);
        teksaa1.setOnClickListener(this);
        teksaa2.setOnClickListener(this);
        teksaa3.setOnClickListener(this);
        teksaa4.setOnClickListener(this);

           return rootView; //return the slide view
}
    @Override
    public void onClick(View v) {
        final Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.aa1image1:
                break;
            case R.id.aa1image2:
                break;
            case R.id.aa1image3:
                break;
            case R.id.aa1image4:
                break;
            case R.id.teksaa11:
                break;
            case R.id.teksaa12:
                break;
            case R.id.teksaa13:
                break;
            case R.id.teksaa14:
                break;
        }
    }
}
