package edu.upi.cs.sukidaa.fluida.Materi.HukumPascal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.CustomVideoView;
import edu.upi.cs.sukidaa.fluida.R;
import edu.upi.cs.sukidaa.fluida.VideoActivity;

/**
 * Created by drake on 6/20/2017.
 */

public class AplPascal2 extends Fragment{

    CustomVideoView videoView1;
    ImageView play1;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.aplipascal2
                , container,false);

        videoView1 = (CustomVideoView) rootView.findViewById(R.id.apli2pvv1);
        play1 = (ImageView) rootView.findViewById(R.id.apl2play);

        videoView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("uri", R.raw.aplpascalv2);
                startActivity(intent);

                return false;
            }
        });


        return rootView; //return the slide view
    }
}
