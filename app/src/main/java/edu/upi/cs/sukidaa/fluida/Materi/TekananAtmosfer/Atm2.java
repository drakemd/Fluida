package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Random;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/18/2017.
 */

public class Atm2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm2, container, false);

        TextView atm21 = (TextView) rootView.findViewById(R.id.tvatm21);
        TextView atm22 = (TextView) rootView.findViewById(R.id.tvatm22);
        TextView atm23 = (TextView) rootView.findViewById(R.id.tvatm23);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            atm21.setText(Html.fromHtml(getString(R.string.atm21), Html.FROM_HTML_MODE_COMPACT));
            atm22.setText(Html.fromHtml(getString(R.string.atm22), Html.FROM_HTML_MODE_COMPACT));
            atm23.setText(Html.fromHtml(getString(R.string.atm23), Html.FROM_HTML_MODE_COMPACT));
        }else{
            atm21.setText(Html.fromHtml(getString(R.string.atm21)));
            atm22.setText(Html.fromHtml(getString(R.string.atm22)));
            atm23.setText(Html.fromHtml(getString(R.string.atm23)));
        }

        return rootView; //return the slide view
    }
}
