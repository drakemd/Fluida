package edu.upi.cs.sukidaa.fluida.Materi.HukumPascal;

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
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by drake on 6/20/2017.
 */

public class Pascal3 extends Fragment {

    CustomVideoView videoView1;
    ImageView play1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.pascal3
                , container,false);

        videoView1 = (CustomVideoView) rootView.findViewById(R.id.pascal3vv1);
        play1 = (ImageView) rootView.findViewById(R.id.play);

        TextView pascal31 = (TextView) rootView.findViewById(R.id.pascal3tv1);
        TextView pascal32 = (TextView) rootView.findViewById(R.id.pascal3tv2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            pascal31.setText(Html.fromHtml(getString(R.string.pascal31), Html.FROM_HTML_MODE_COMPACT));
            pascal32.setText(Html.fromHtml(getString(R.string.pascal32), Html.FROM_HTML_MODE_COMPACT));
        }else{
            pascal31.setText(Html.fromHtml(getString(R.string.pascal31)));
            pascal32.setText(Html.fromHtml(getString(R.string.pascal32)));
        }

        MediaController mediaController = new MediaController(getActivity());
        videoView1.setVideoURI(Uri.parse("android.resource://" +  getActivity().getPackageName() + "/" + R.raw.pascal3v1));
        mediaController.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController);

        videoView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(!videoView1.isPlaying() && videoView1.getCurrentPosition() == 0){
                    videoView1.start();
                }else if(!videoView1.isPlaying()){
                    videoView1.seekTo(videoView1.getStopPosition());
                    videoView1.start();
                }

                return false;
            }
        });

        videoView1.setPlayPauseListener(new CustomVideoView.PlayPauseListener() {
            @Override
            public void onPlay() {
                play1.setVisibility(View.GONE);
            }

            @Override
            public void onPause() {
                play1.setVisibility(View.VISIBLE);
                videoView1.setStopPosition(videoView1.getCurrentPosition()+1);
            }
        });

        videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play1.setVisibility(View.VISIBLE);
                videoView1.seekTo(0);
            }
        });


        return rootView; //return the slide view
    }
}
