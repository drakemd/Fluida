package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by drake on 6/19/2017.
 */

public class Hidro5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro5, container, false);

        TextView hidro51 = (TextView) rootView.findViewById(R.id.hidro5tv1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro51.setText(Html.fromHtml(getString(R.string.hidro51), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro51.setText(Html.fromHtml(getString(R.string.hidro51)));
        }

        return rootView; //return the slide view
    }
}
