package edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer;

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
import android.widget.VideoView;

import edu.upi.cs.sukidaa.fluida.CustomVideoView;
import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class Atm9 extends Fragment{

    CustomVideoView videoView;
    ImageView play;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.atm9
                , container, false);

        videoView = (CustomVideoView) rootView.findViewById(R.id.atm9videoview);
        play = (ImageView) rootView.findViewById(R.id.play);
        TextView atm91 = (TextView) rootView.findViewById(R.id.tvatm91);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            atm91.setText(Html.fromHtml(getString(R.string.atm91), Html.FROM_HTML_MODE_COMPACT));
        }else{
            atm91.setText(Html.fromHtml(getString(R.string.atm91)));
        }

        MediaController mediaController = new MediaController(getActivity());
        videoView.setVideoURI(Uri.parse("android.resource://" +  getActivity().getPackageName() + "/" + R.raw.terjunpayung));
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
