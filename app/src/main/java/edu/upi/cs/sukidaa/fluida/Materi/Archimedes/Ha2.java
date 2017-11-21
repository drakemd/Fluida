package edu.upi.cs.sukidaa.fluida.Materi.Archimedes;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by Sutrisna Aji on 20/06/2017.
 */

public class Ha2 extends Fragment  {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.ha2, container, false);
        TextView teksha21 = (TextView)rootView.findViewById(R.id.teksha21);
        TextView teksha24 = (TextView)rootView.findViewById(R.id.teksha24);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            teksha21.setText(Html.fromHtml(getString(R.string.ha21), Html.FROM_HTML_MODE_COMPACT));
            teksha24.setText(Html.fromHtml(getString(R.string.ha24), Html.FROM_HTML_MODE_COMPACT));
        }else{
            teksha21.setText(Html.fromHtml(getString(R.string.ha21)));
            teksha24.setText(Html.fromHtml(getString(R.string.ha24)));

        }
        return rootView; //return the slide view
    }
}
