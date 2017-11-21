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

public class Ha9 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.ha9, container, false);
        TextView teksha91 = (TextView)rootView.findViewById(R.id.teksha91);
        TextView teksha92 = (TextView)rootView.findViewById(R.id.teksha92);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            teksha91.setText(Html.fromHtml(getString(R.string.ha91), Html.FROM_HTML_MODE_COMPACT));
            teksha92.setText(Html.fromHtml(getString(R.string.ha92), Html.FROM_HTML_MODE_COMPACT));
        }else{
            teksha91.setText(Html.fromHtml(getString(R.string.ha91)));
            teksha92.setText(Html.fromHtml(getString(R.string.ha92)));
        }
        return rootView;
    }
}
