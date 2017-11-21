package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/20/2017.
 */

public class Hidro10 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro10, container, false);

        TextView hidro101 = (TextView) rootView.findViewById(R.id.hidro10tv1);
        TextView hidro102 = (TextView) rootView.findViewById(R.id.hidro10tv2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro101.setText(Html.fromHtml(getString(R.string.hidro101), Html.FROM_HTML_MODE_COMPACT));
            hidro102.setText(Html.fromHtml(getString(R.string.hidro102), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro101.setText(Html.fromHtml(getString(R.string.hidro101)));
            hidro102.setText(Html.fromHtml(getString(R.string.hidro102)));
        }

        return rootView; //return the slide view
    }
}
