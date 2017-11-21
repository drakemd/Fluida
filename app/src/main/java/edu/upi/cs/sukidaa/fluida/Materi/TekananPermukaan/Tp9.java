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

public class Tp9 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tp9, container, false);
        TextView tp91 = (TextView)rootView.findViewById(R.id.tekstp91);
        TextView tp93 = (TextView)rootView.findViewById(R.id.tekstp93);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tp91.setText(Html.fromHtml(getString(R.string.tp91), Html.FROM_HTML_MODE_COMPACT));
            tp93.setText(Html.fromHtml(getString(R.string.tp93), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tp91.setText(Html.fromHtml(getString(R.string.tp91)));
            tp93.setText(Html.fromHtml(getString(R.string.tp93)));
        }

        return rootView;
    }
}
