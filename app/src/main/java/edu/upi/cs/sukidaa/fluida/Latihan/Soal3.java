package edu.upi.cs.sukidaa.fluida.Latihan;

import android.graphics.Color;
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
 * Created by drake on 6/21/2017.
 */

public class Soal3 extends Fragment implements View.OnClickListener{

    Button btnA, btnB, btnC, btnD;
    int nomer = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.soal3
                , container, false);

        btnA = (Button) rootView.findViewById(R.id.buttonA);
        btnB = (Button) rootView.findViewById(R.id.buttonB);
        btnC = (Button) rootView.findViewById(R.id.buttonC);
        btnD = (Button) rootView.findViewById(R.id.buttonD);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

        TextView soal = (TextView) rootView.findViewById(R.id.tvSoal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            soal.setText(Html.fromHtml(getString(R.string.soal3), Html.FROM_HTML_MODE_COMPACT));
            btnA.setText(Html.fromHtml(getString(R.string.soal3a), Html.FROM_HTML_MODE_COMPACT));
            btnB.setText(Html.fromHtml(getString(R.string.soal3b), Html.FROM_HTML_MODE_COMPACT));
            btnC.setText(Html.fromHtml(getString(R.string.soal3c), Html.FROM_HTML_MODE_COMPACT));
            btnD.setText(Html.fromHtml(getString(R.string.soal3d), Html.FROM_HTML_MODE_COMPACT));
        }else{
            soal.setText(Html.fromHtml(getString(R.string.soal3)));
            btnA.setText(Html.fromHtml(getString(R.string.soal3a)));
            btnB.setText(Html.fromHtml(getString(R.string.soal3b)));
            btnC.setText(Html.fromHtml(getString(R.string.soal3c)));
            btnD.setText(Html.fromHtml(getString(R.string.soal3d)));
        }

        return rootView; //return the slide view
    }

    @Override
    public void onClick(View v) {
        ((Soal)getActivity()).selectButton(R.id.btnNo3);
        switch (v.getId()){
            case R.id.buttonA:
                ((Soal)getActivity()).setJawaban("a",nomer);
                btnA.setBackgroundResource(R.drawable.selectedbtn);
                btnB.setBackgroundResource(R.drawable.btnsoal);
                btnC.setBackgroundResource(R.drawable.btnsoal);
                btnD.setBackgroundResource(R.drawable.btnsoal);
                btnA.setTextColor(Color.WHITE);
                btnB.setTextColor(Color.BLACK);
                btnC.setTextColor(Color.BLACK);
                btnD.setTextColor(Color.BLACK);
                break;
            case R.id.buttonB:
                ((Soal)getActivity()).setJawaban("b",nomer);
                btnA.setBackgroundResource(R.drawable.btnsoal);
                btnB.setBackgroundResource(R.drawable.selectedbtn);
                btnC.setBackgroundResource(R.drawable.btnsoal);
                btnD.setBackgroundResource(R.drawable.btnsoal);
                btnB.setTextColor(Color.WHITE);
                btnA.setTextColor(Color.BLACK);
                btnC.setTextColor(Color.BLACK);
                btnD.setTextColor(Color.BLACK);
                break;
            case R.id.buttonC:
                ((Soal)getActivity()).setJawaban("c",nomer);
                btnA.setBackgroundResource(R.drawable.btnsoal);
                btnB.setBackgroundResource(R.drawable.btnsoal);
                btnC.setBackgroundResource(R.drawable.selectedbtn);
                btnD.setBackgroundResource(R.drawable.btnsoal);
                btnC.setTextColor(Color.WHITE);
                btnB.setTextColor(Color.BLACK);
                btnA.setTextColor(Color.BLACK);
                btnD.setTextColor(Color.BLACK);

                break;
            case R.id.buttonD:
                ((Soal)getActivity()).setJawaban("d",nomer);
                btnA.setBackgroundResource(R.drawable.btnsoal);
                btnB.setBackgroundResource(R.drawable.btnsoal);
                btnC.setBackgroundResource(R.drawable.btnsoal);
                btnD.setBackgroundResource(R.drawable.selectedbtn);
                btnD.setTextColor(Color.WHITE);
                btnB.setTextColor(Color.BLACK);
                btnC.setTextColor(Color.BLACK);
                btnA.setTextColor(Color.BLACK);

                break;
        }
    }
}
