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

public class Ha4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.ha4, container, false);
        TextView teksha41 = (TextView)rootView.findViewById(R.id.teksha41);
        TextView teksha42 = (TextView)rootView.findViewById(R.id.teksha42);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            teksha41.setText(Html.fromHtml(getString(R.string.ha41), Html.FROM_HTML_MODE_COMPACT));
            teksha42.setText(Html.fromHtml(getString(R.string.ha42), Html.FROM_HTML_MODE_COMPACT));
        }else{
            teksha41.setText(Html.fromHtml(getString(R.string.ha41)));
            teksha42.setText(Html.fromHtml(getString(R.string.ha42)));

        }
        return rootView;
    }
}
