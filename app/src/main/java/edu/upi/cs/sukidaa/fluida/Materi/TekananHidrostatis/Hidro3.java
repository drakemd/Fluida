package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by drake on 6/19/2017.
 */

public class Hidro3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro3, container, false);

        TextView hidro31 = (TextView) rootView.findViewById(R.id.hidro3tv1);
        TextView hidro32 = (TextView) rootView.findViewById(R.id.hidro3tv2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro31.setText(Html.fromHtml(getString(R.string.hidro31), Html.FROM_HTML_MODE_COMPACT));
            hidro32.setText(Html.fromHtml(getString(R.string.hidro32), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro31.setText(Html.fromHtml(getString(R.string.hidro31)));
            hidro32.setText(Html.fromHtml(getString(R.string.hidro32)));
        }

        return rootView; //return the slide view
    }
}
