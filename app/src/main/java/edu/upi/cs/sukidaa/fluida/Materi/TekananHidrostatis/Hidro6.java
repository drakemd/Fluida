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

public class Hidro6 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro6, container, false);

        TextView hidro61 = (TextView) rootView.findViewById(R.id.hidro6tv1);
        TextView hidro62 = (TextView) rootView.findViewById(R.id.hidro6tv2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro61.setText(Html.fromHtml(getString(R.string.hidro61), Html.FROM_HTML_MODE_COMPACT));
            hidro61.setText(Html.fromHtml(getString(R.string.hidro62), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro61.setText(Html.fromHtml(getString(R.string.hidro61)));
            hidro62.setText(Html.fromHtml(getString(R.string.hidro62)));
        }

        return rootView; //return the slide view
    }
}
