package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by drake on 6/19/2017.
 */

public class Hidro4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro4, container, false);

        final TextView hidro41 = (TextView) rootView.findViewById(R.id.hidro4tv1);
        TextView hidro42 = (TextView) rootView.findViewById(R.id.hidro4tv2);

        final Button button = (Button) rootView.findViewById(R.id.hidro4btn);

        final ImageView play = (ImageView) rootView.findViewById(R.id.play);

        final GifImageView gif = (GifImageView) rootView.findViewById(R.id.hidro4anim1);
        gif.setImageResource(R.drawable.hidroanim2);
        final GifDrawable gifDrawable = (GifDrawable) gif.getDrawable();
        gifDrawable.stop();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro41.setText(Html.fromHtml(getString(R.string.hidro41), Html.FROM_HTML_MODE_COMPACT));
            hidro42.setText(Html.fromHtml(getString(R.string.hidro42), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro41.setText(Html.fromHtml(getString(R.string.hidro41)));
            hidro42.setText(Html.fromHtml(getString(R.string.hidro42)));
        }

        hidro41.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidro41.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
            }
        });

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
