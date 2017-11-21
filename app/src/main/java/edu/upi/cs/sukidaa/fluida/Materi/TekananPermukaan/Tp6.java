package edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;
import edu.upi.cs.sukidaa.fluida.VideoActivity;


import android.support.v4.app.Fragment;


/**
 * Created by Sutrisna Aji on 19/06/2017.
 */

public class Tp6 extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tp6, container, false);
        TextView tp62 = (TextView)rootView.findViewById(R.id.tekstp62);
        TextView tp63 = (TextView)rootView.findViewById(R.id.tekstp63);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tp62.setText(Html.fromHtml(getString(R.string.tp62), Html.FROM_HTML_MODE_COMPACT));
            tp63.setText(Html.fromHtml(getString(R.string.tp63), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tp62.setText(Html.fromHtml(getString(R.string.tp62)));
            tp63.setText(Html.fromHtml(getString(R.string.tp63)));

        }
        Button video = (Button)rootView.findViewById(R.id.btnVideo);
        video.setOnClickListener(this);

        return rootView;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVideo :
                int id = R.raw.videotp4;
                Intent intent = new Intent();
                intent.putExtra("uri", id);
                Log.i("uri1", ""+id);
                intent.setClass(getActivity(), VideoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
