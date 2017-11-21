package edu.upi.cs.sukidaa.fluida.Materi.Archimedes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;
import edu.upi.cs.sukidaa.fluida.VideoActivity;

/**
 * Created by Sutrisna Aji on 21/06/2017.
 */


public class Aa6 extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.aa6, container, false);
        TextView teksaa61 = (TextView)rootView.findViewById(R.id.teksaa62);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            teksaa61.setText(Html.fromHtml(getString(R.string.aa62), Html.FROM_HTML_MODE_COMPACT));

        }else{
            teksaa61.setText(Html.fromHtml(getString(R.string.aa62)));

        }
        Button video = (Button)rootView.findViewById(R.id.btnVideo);
        video.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVideo :
                int id = R.raw.videoaa1;
                Intent intent = new Intent();
                intent.putExtra("uri", id);
                Log.i("uri1", ""+id);
                intent.setClass(getActivity(), VideoActivity.class);
                startActivity(intent);
                break;
        }

    }
}