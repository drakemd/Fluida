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

public class Tp3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tp3, container, false);
        TextView tp32 = (TextView)rootView.findViewById(R.id.tekstp32);
        TextView tp33 = (TextView)rootView.findViewById(R.id.tekstp33);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tp32.setText(Html.fromHtml(getString(R.string.tp31), Html.FROM_HTML_MODE_COMPACT));
            tp33.setText(Html.fromHtml(getString(R.string.tp31), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tp32.setText(Html.fromHtml(getString(R.string.tp31)));
            tp33.setText(Html.fromHtml(getString(R.string.tp32)));

        }
        return rootView;
    }
}
