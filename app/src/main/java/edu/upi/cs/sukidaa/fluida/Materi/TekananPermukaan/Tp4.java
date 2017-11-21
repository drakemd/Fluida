package edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan;

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
 * Created by Sutrisna Aji on 19/06/2017.
 */

public class Tp4 extends Fragment implements View.OnClickListener  {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tp4, container, false);
        TextView tp42 = (TextView)rootView.findViewById(R.id.tekstp42);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tp42.setText(Html.fromHtml(getString(R.string.tp42), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tp42.setText(Html.fromHtml(getString(R.string.tp42)));

        }
        Button video = (Button)rootView.findViewById(R.id.btnVideo);
        Button video2 = (Button)rootView.findViewById(R.id.btnVideo2);
        video.setOnClickListener(this);
        video2.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVideo :
                int id = R.raw.videotp2;
                Intent intent = new Intent();
                intent.putExtra("uri", id);
                Log.i("uri1", ""+id);
                intent.setClass(getActivity(), VideoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnVideo2 :
                id = R.raw.videotp3;
                intent = new Intent();
                intent.putExtra("uri", id);
                Log.i("uri1", ""+id);
                intent.setClass(getActivity(), VideoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
