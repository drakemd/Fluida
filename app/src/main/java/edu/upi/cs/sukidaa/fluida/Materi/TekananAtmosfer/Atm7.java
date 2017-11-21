package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

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

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class Atm7 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm7, container, false);

        TextView atm71 = (TextView) rootView.findViewById(R.id.tvatm71);
        TextView atm72 = (TextView) rootView.findViewById(R.id.tvatm72);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            atm71.setText(Html.fromHtml(getString(R.string.atm71), Html.FROM_HTML_MODE_COMPACT));
            atm72.setText(Html.fromHtml(getString(R.string.atm72), Html.FROM_HTML_MODE_COMPACT));
        }else{
            atm71.setText(Html.fromHtml(getString(R.string.atm71)));
            atm72.setText(Html.fromHtml(getString(R.string.atm72)));
        }

        return rootView; //return the slide view
    }
}
