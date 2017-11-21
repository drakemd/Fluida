package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

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
 * Created by drake on 6/19/2017.
 */

public class Atm12 extends Fragment {

    TextView tv1, tv2;
    Button klik;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm12, container, false);

        klik = (Button) rootView.findViewById(R.id.atm12btn);

        tv1 = (TextView) rootView.findViewById(R.id.atm12tv1);
        tv2 = (TextView) rootView.findViewById(R.id.atm12tv2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tv1.setText(Html.fromHtml(getString(R.string.atm121), Html.FROM_HTML_MODE_COMPACT));
            tv2.setText(Html.fromHtml(getString(R.string.atm122), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tv1.setText(Html.fromHtml(getString(R.string.atm121)));
            tv2.setText(Html.fromHtml(getString(R.string.atm122)));
        }

        tv2.setVisibility(View.GONE);

        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setVisibility(View.VISIBLE);
                klik.setVisibility(View.GONE);
            }
        });

        return rootView; //return the slide view
    }
}
