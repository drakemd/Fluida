package edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class Tp2 extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tp2, container, false);
        TextView ttp1 = (TextView)rootView.findViewById(R.id.tekstp21);
        TextView ttp2 = (TextView)rootView.findViewById(R.id.tekstp22);
        TextView ttp3 = (TextView)rootView.findViewById(R.id.tekstp23);
        //Typeface textfont= Typeface.createFromAsset(this.getAssets(),"BENGUIAN.TTF");
        //ttp2.setTypeface(textfont);
        //ttp3.setTypeface(textfont);
        //ttp1.setTypeface(textfont);

        Button video = (Button)rootView.findViewById(R.id.btnvideotp1);
        video.setOnClickListener(this);
        return rootView; //return the slide view
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnvideotp1 :
                int id = R.raw.videotp1;
                Intent intent = new Intent();
                intent.putExtra("uri", id);
                Log.i("uri1", ""+id);
                intent.setClass(getActivity(), VideoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
