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

public class Hidro8 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro8, container, false);

        TextView hidro81 = (TextView) rootView.findViewById(R.id.hidro8tv1);
        TextView hidro82 = (TextView) rootView.findViewById(R.id.hidro8tv2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro81.setText(Html.fromHtml(getString(R.string.hidro81), Html.FROM_HTML_MODE_COMPACT));
            hidro82.setText(Html.fromHtml(getString(R.string.hidro82), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro81.setText(Html.fromHtml(getString(R.string.hidro81)));
            hidro82.setText(Html.fromHtml(getString(R.string.hidro82)));
        }

        return rootView; //return the slide view
    }
}
