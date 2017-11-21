package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.net.URI;
import java.util.Random;

import edu.upi.cs.sukidaa.fluida.R;
import edu.upi.cs.sukidaa.fluida.VideoActivity;

/**
 * Created by drake on 6/18/2017.
 */

public class Atm3 extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm3
                , container, false);

        TextView atm31 = (TextView) rootView.findViewById(R.id.tvatm31);
        Button play = (Button) rootView.findViewById(R.id.play);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            atm31.setText(Html.fromHtml(getString(R.string.atm31), Html.FROM_HTML_MODE_COMPACT));
        }else{
            atm31.setText(Html.fromHtml(getString(R.string.atm31)));
        }

        play.setOnClickListener(this);

        return rootView; //return the slide view
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play :
                int id = R.raw.videoatm31;
                Intent intent = new Intent();
                intent.putExtra("uri", id);
                intent.putExtra("pos", 0);
                Log.i("uri1", ""+id);
                intent.setClass(getActivity(), VideoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
