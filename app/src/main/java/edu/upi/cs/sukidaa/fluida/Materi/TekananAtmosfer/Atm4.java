package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import edu.upi.cs.sukidaa.fluida.CustomVideoView;
import edu.upi.cs.sukidaa.fluida.R;
import edu.upi.cs.sukidaa.fluida.VideoActivity;

/**
 * Created by drake on 6/18/2017.
 */

public class Atm4 extends Fragment{

    CustomVideoView videoView;
    ImageView play;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm4
                , container, false);

        videoView = (CustomVideoView) rootView.findViewById(R.id.videoatm41);
        play = (ImageView) rootView.findViewById(R.id.play);

        MediaController mediaController = new MediaController(getActivity());
        videoView.setVideoURI(Uri.parse("android.resource://" +  getActivity().getPackageName() + "/" + R.raw.videoatm41));
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setPlayPauseListener(new CustomVideoView.PlayPauseListener() {
            @Override
            public void onPlay() {
                play.setVisibility(View.GONE);
            }

            @Override
            public void onPause() {
                play.setVisibility(View.VISIBLE);
                videoView.setStopPosition(videoView.getCurrentPosition()+1);
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play.setVisibility(View.VISIBLE);
                videoView.seekTo(0);
            }
        });

        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!videoView.isPlaying() && videoView.getCurrentPosition() == 0){
                    videoView.start();
                }else if(!videoView.isPlaying()){
                    videoView.seekTo(videoView.getStopPosition());
                    videoView.start();
                }
                return false;
            }
        });

        return rootView; //return the slide view
    }
}
