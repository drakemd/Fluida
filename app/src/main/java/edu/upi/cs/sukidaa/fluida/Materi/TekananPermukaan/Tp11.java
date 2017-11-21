package edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan;

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
 * Created by Sutrisna Aji on 19/06/2017.
 */

public class Tp11 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tp11, container, false);
        TextView tp113 = (TextView)rootView.findViewById(R.id.tekstp113);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tp113.setText(Html.fromHtml(getString(R.string.tp113), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tp113.setText(Html.fromHtml(getString(R.string.tp113)));
        }

        return rootView;
    }
}
