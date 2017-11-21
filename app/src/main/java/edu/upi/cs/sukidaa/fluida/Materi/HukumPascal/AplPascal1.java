package edu.upi.cs.sukidaa.fluida.Materi.HukumPascal;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;

import edu.upi.cs.sukidaa.fluida.CustomVideoView;
import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/20/2017.
 */

public class AplPascal1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.aplipascal1
                , container, false);

        return rootView; //return the slide view
    }
}
