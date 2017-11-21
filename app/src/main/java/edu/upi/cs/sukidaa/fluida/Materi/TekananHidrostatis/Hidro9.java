package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

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

/**
 * Created by drake on 6/20/2017.
 */

public class Hidro9 extends Fragment implements View.OnTouchListener{

    CustomVideoView videoView1;
    ImageView play1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro9
                , container, false);

        videoView1 = (CustomVideoView) rootView.findViewById(R.id.hidro9vv1);
        play1 = (ImageView) rootView.findViewById(R.id.play);
        MediaController mediaController = new MediaController(getActivity());
        videoView1.setVideoURI(Uri.parse("android.resource://" +  getActivity().getPackageName() + "/" + R.raw.hidro91));
        mediaController.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController);

        videoView1.setOnTouchListener(this);

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

        TextView hidro91 = (TextView) rootView.findViewById(R.id.hidro9tv1);
        TextView hidro92 = (TextView) rootView.findViewById(R.id.hidro9tv2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hidro91.setText(Html.fromHtml(getString(R.string.hidro91), Html.FROM_HTML_MODE_COMPACT));
            hidro92.setText(Html.fromHtml(getString(R.string.hidro92), Html.FROM_HTML_MODE_COMPACT));
        }else{
            hidro91.setText(Html.fromHtml(getString(R.string.hidro91)));
            hidro92.setText(Html.fromHtml(getString(R.string.hidro92)));
        }

        return rootView; //return the slide view
    }

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
}
