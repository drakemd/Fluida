package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class Atm11 extends Fragment{

    TextView textView;
    Button klik;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm11, container, false);

        klik = (Button) rootView.findViewById(R.id.atm11btn);

        textView = (TextView) rootView.findViewById(R.id.atm11hide);

        textView.setVisibility(View.GONE);

        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                klik.setVisibility(View.GONE);
            }
        });

        return rootView; //return the slide view
    }
}
