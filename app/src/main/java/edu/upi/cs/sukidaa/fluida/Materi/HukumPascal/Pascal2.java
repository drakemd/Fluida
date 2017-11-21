package edu.upi.cs.sukidaa.fluida.Materi.HukumPascal;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by drake on 6/20/2017.
 */

public class Pascal2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.pascal2, container, false);

        TextView pascal21 = (TextView) rootView.findViewById(R.id.pascal2tv1);

        final ImageView play = (ImageView) rootView.findViewById(R.id.play);

        final GifImageView gif = (GifImageView) rootView.findViewById(R.id.pascal2gif);
        gif.setImageResource(R.drawable.pascal2anim);
        final GifDrawable gifDrawable = (GifDrawable) gif.getDrawable();
        gifDrawable.stop();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            pascal21.setText(Html.fromHtml(getString(R.string.pascal11), Html.FROM_HTML_MODE_COMPACT));
        }else{
            pascal21.setText(Html.fromHtml(getString(R.string.pascal11)));
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
