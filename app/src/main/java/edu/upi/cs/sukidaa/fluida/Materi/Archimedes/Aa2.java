package edu.upi.cs.sukidaa.fluida.Materi.Archimedes;

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
 * Created by Sutrisna Aji on 21/06/2017.
 */

public class Aa2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.aa2, container, false);
        TextView teksaa21 = (TextView)rootView.findViewById(R.id.teksaa21);
        TextView teksaa24 = (TextView)rootView.findViewById(R.id.teksaa24);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            teksaa21.setText(Html.fromHtml(getString(R.string.aa21), Html.FROM_HTML_MODE_COMPACT));
            teksaa24.setText(Html.fromHtml(getString(R.string.aa24), Html.FROM_HTML_MODE_COMPACT));
        }else{
            teksaa21.setText(Html.fromHtml(getString(R.string.aa21)));
            teksaa24.setText(Html.fromHtml(getString(R.string.aa24)));
        }
        return rootView;
    }
}
