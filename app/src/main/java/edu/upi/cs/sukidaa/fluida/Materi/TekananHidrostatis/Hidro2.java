package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import edu.upi.cs.sukidaa.fluida.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by drake on 6/19/2017.
 */

public class Hidro2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro2, container, false);

        TextView hidro21 = (TextView) rootView.findViewById(R.id.tv1);
        TextView hidro22 = (TextView) rootView.findViewById(R.id.tv2);

        final ImageView play = (ImageView) rootView.findViewById(R.id.play);

        final GifImageView gif = (GifImageView) rootView.findViewById(R.id.hidro2anim1);
        gif.setImageResource(R.drawable.animasihidro1);
        final GifDrawable gifDrawable = (GifDrawable) gif.getDrawable();
        gifDrawable.stop();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro21.setText(Html.fromHtml(getString(R.string.hidro11), Html.FROM_HTML_MODE_COMPACT));
            hidro22.setText(Html.fromHtml(getString(R.string.hidro12), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro21.setText(Html.fromHtml(getString(R.string.hidro11)));
            hidro22.setText(Html.fromHtml(getString(R.string.hidro12)));
        }

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

        return rootView; //return the slide view
    }
}
