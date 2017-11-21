package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class Atm13 extends Fragment implements View.OnClickListener{

    Button btnA, btnB, btnC, btnD, tryagain, solusi;
    ImageView imgSol;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm13, container, false);

        btnA = (Button) rootView.findViewById(R.id.buttonA);
        btnB = (Button) rootView.findViewById(R.id.buttonB);
        btnC = (Button) rootView.findViewById(R.id.buttonC);
        btnD = (Button) rootView.findViewById(R.id.buttonD);
        tryagain = (Button) rootView.findViewById(R.id.tryagain);
        solusi = (Button) rootView.findViewById(R.id.solution);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        tryagain.setOnClickListener(this);
        solusi.setOnClickListener(this);

        imgSol = (ImageView) rootView.findViewById(R.id.atmsol);

        imgSol.setVisibility(View.GONE);
        tryagain.setVisibility(View.GONE);
        solusi.setVisibility(View.GONE);

        return rootView; //return the slide view
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonA :
                btnA.setBackgroundResource(R.drawable.btnwrong);
                btnA.setTextColor(Color.WHITE);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                tryagain.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonB :
                btnB.setBackgroundResource(R.drawable.btncorrect);
                btnB.setTextColor(Color.WHITE);
                btnB.setEnabled(false);
                btnA.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                solusi.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonC :
                btnC.setBackgroundResource(R.drawable.btnwrong);
                btnC.setTextColor(Color.WHITE);
                btnC.setEnabled(false);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnD.setEnabled(false);
                tryagain.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonD :
                btnD.setBackgroundResource(R.drawable.btnwrong);
                btnD.setTextColor(Color.WHITE);
                btnD.setEnabled(false);
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                tryagain.setVisibility(View.VISIBLE);
                break;
            case R.id.tryagain :
                btnA.setEnabled(true);
                btnB.setEnabled(true);
                btnC.setEnabled(true);
                btnD.setEnabled(true);

                btnA.setBackgroundResource(R.drawable.btnsoal);
                btnB.setBackgroundResource(R.drawable.btnsoal);
                btnC.setBackgroundResource(R.drawable.btnsoal);
                btnD.setBackgroundResource(R.drawable.btnsoal);

                btnA.setTextColor(Color.BLACK);
                btnB.setTextColor(Color.BLACK);
                btnC.setTextColor(Color.BLACK);
                btnD.setTextColor(Color.BLACK);

                tryagain.setVisibility(View.GONE);
                break;
            case R.id.solution :
                imgSol.setVisibility(View.VISIBLE);
                break;
        }
    }
}
