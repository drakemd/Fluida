package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

import android.os.Build;
import android.os.Bundle;
import android.support.transition.Visibility;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class Atm10 extends Fragment implements View.OnClickListener{

    ViewFlipper viewFlipper;
    ImageButton prev, next;
    TextView atm101,textView;
    Button klik;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm10, container, false);

        viewFlipper = (ViewFlipper) rootView.findViewById(R.id.viewFlipperatm6);

        viewFlipper.setInAnimation(this.getContext(), R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this.getContext(), R.anim.slide_out_left);

        prev = (ImageButton) rootView.findViewById(R.id.btnPrev);
        next = (ImageButton) rootView.findViewById(R.id.btnNext);

        klik = (Button) rootView.findViewById(R.id.atm10btn);

        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        klik.setOnClickListener(this);

        atm101 = (TextView) rootView.findViewById(R.id.atm101tv);
        textView = (TextView) rootView.findViewById(R.id.tvtamb);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            atm101.setText(Html.fromHtml(getString(R.string.atm101), Html.FROM_HTML_MODE_COMPACT));
        }else{
            atm101.setText(Html.fromHtml(getString(R.string.atm101)));
        }

        viewFlipper.setVisibility(View.GONE);
        prev.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
        atm101.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);

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
            case R.id.atm10btn:
                viewFlipper.setVisibility(View.VISIBLE);
                prev.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                atm101.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                klik.setVisibility(View.GONE);
                break;
        }
    }
}
