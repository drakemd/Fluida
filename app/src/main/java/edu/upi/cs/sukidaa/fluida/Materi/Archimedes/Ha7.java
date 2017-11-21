package edu.upi.cs.sukidaa.fluida.Materi.Archimedes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import edu.upi.cs.sukidaa.fluida.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Sutrisna Aji on 20/06/2017.
 */

public class Ha7 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.ha7, container, false);
        final ImageView play = (ImageView) rootView.findViewById(R.id.play);
        final GifImageView gif = (GifImageView) rootView.findViewById(R.id.archimedes2);
        gif.setImageResource(R.drawable.archimedes2);
        final GifDrawable gifDrawable = (GifDrawable) gif.getDrawable();
        gifDrawable.stop();
        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gifDrawable.isPlaying()){
                    gifDrawable.stop();
                    play.setVisibility(View.VISIBLE);
                }else{
                    gifDrawable.start();
                    play.setVisibility(View.GONE);
                }
            }
        });
        return rootView;
    }

}
