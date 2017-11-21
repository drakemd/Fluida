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
 * Created by Sutrisna Aji on 20/06/2017.
 */

public class Tt6 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tt6, container, false);
        TextView tekstt61 = (TextView)rootView.findViewById(R.id.tekstt61);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tekstt61.setText(Html.fromHtml(getString(R.string.tt61), Html.FROM_HTML_MODE_COMPACT));

        }else{
            tekstt61.setText(Html.fromHtml(getString(R.string.tt51)));
        }
        return rootView;
    }
}