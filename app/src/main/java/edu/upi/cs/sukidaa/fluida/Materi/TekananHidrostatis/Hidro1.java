package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

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
import android.widget.VideoView;

import edu.upi.cs.sukidaa.fluida.CustomVideoView;
import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class Hidro1 extends Fragment implements View.OnTouchListener{

    CustomVideoView videoView1, videoView2;
    ImageView play1,play2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hidro1
                , container, false);

        videoView1 = (CustomVideoView) rootView.findViewById(R.id.hidro1vv1);
        videoView2 = (CustomVideoView) rootView.findViewById(R.id.hidro1vv2);

        play1 = (ImageView) rootView.findViewById(R.id.play1);
        play2 = (ImageView) rootView.findViewById(R.id.play2);

        MediaController mediaController = new MediaController(getActivity());
        videoView1.setVideoURI(Uri.parse("android.resource://" +  getActivity().getPackageName() + "/" + R.raw.hidro11));
        mediaController.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController);

        MediaController mediaController2 = new MediaController(getActivity());
        videoView2.setVideoURI(Uri.parse("android.resource://" +  getActivity().getPackageName() + "/" + R.raw.hidro12));
        mediaController.setAnchorView(videoView2);
        videoView2.setMediaController(mediaController2);

        videoView1.setOnTouchListener(this);
        videoView2.setOnTouchListener(this);

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

        videoView2.setPlayPauseListener(new CustomVideoView.PlayPauseListener() {
            @Override
            public void onPlay() {
                play2.setVisibility(View.GONE);
            }

            @Override
            public void onPause() {
                play2.setVisibility(View.VISIBLE);
                videoView2.setStopPosition(videoView2.getCurrentPosition()+1);
            }
        });

        videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play1.setVisibility(View.VISIBLE);
                videoView1.seekTo(0);
            }
        });

        videoView2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play2.setVisibility(View.VISIBLE);
                videoView2.seekTo(0);
            }
        });

        return rootView; //return the slide view
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.hidro1vv1:
                if(!videoView1.isPlaying() && videoView1.getCurrentPosition() == 0){
                    videoView1.start();
                }else if(!videoView1.isPlaying()){
                    videoView1.seekTo(videoView1.getStopPosition());
                    videoView1.start();
                }
                break;
            case R.id.hidro1vv2:
                if(!videoView2.isPlaying() && videoView2.getCurrentPosition() == 0){
                    videoView2.start();
                }else if(!videoView2.isPlaying()){
                    videoView2.seekTo(videoView2.getStopPosition());
                    videoView2.start();
                }
                break;
        }

        return false;
    }
}
