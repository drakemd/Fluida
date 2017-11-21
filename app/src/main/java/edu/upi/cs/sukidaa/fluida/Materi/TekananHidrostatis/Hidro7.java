package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/20/2017.
 */

public class Hidro7 extends Fragment implements View.OnClickListener{

    ViewFlipper viewFlipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro7, container, false);

        viewFlipper = (ViewFlipper) rootView.findViewById(R.id.viewFlipper);

        viewFlipper.setInAnimation(this.getContext(), R.anim.fade_in_activity);
        viewFlipper.setOutAnimation(this.getContext(), R.anim.fade_out_activity);

        ImageButton prev, next;
        prev = (ImageButton) rootView.findViewById(R.id.btnPrev);
        next = (ImageButton) rootView.findViewById(R.id.btnNext);

        prev.setOnClickListener(this);
        next.setOnClickListener(this);

        return rootView; //return the slide view
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPrev:
                viewFlipper.showPrevious();
                break;
            case R.id.btnNext:
                viewFlipper.showNext();
                break;
        }
    }
}
