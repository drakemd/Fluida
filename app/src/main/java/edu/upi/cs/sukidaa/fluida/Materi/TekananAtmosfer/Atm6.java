package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class Atm6 extends Fragment implements View.OnClickListener {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";

    ViewFlipper viewFlipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm6, container, false);

        viewFlipper = (ViewFlipper) rootView.findViewById(R.id.viewFlipperatm6);

        viewFlipper.setInAnimation(this.getContext(), R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this.getContext(), R.anim.slide_out_left);

        ImageButton prev, next;
        prev = (ImageButton) rootView.findViewById(R.id.btnPrev);
        next = (ImageButton) rootView.findViewById(R.id.btnNext);

        prev.setOnClickListener(this);
        next.setOnClickListener(this);

        TextView atm61 = (TextView) rootView.findViewById(R.id.tvatm61);
        TextView atm62 = (TextView) rootView.findViewById(R.id.tvatm62);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            atm61.setText(Html.fromHtml(getString(R.string.atm61), Html.FROM_HTML_MODE_COMPACT));
            atm62.setText(Html.fromHtml(getString(R.string.atm62), Html.FROM_HTML_MODE_COMPACT));
        }else{
            atm61.setText(Html.fromHtml(getString(R.string.atm61)));
            atm62.setText(Html.fromHtml(getString(R.string.atm62)));
        }

        return rootView; //return the slide view
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrev:
                viewFlipper.showPrevious();
                break;
            case R.id.btnNext:
                viewFlipper.showNext();
                break;
        }
    }
}
