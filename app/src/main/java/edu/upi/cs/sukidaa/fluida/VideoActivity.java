package edu.upi.cs.sukidaa.fluida;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import static java.security.AccessController.getContext;

public class VideoActivity extends Activity implements View.OnClickListener{

    ImageView close;
    int uri,pos;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playvideo);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        this.getWindow().setLayout(width,height);
        close = (ImageView) findViewById(R.id.close);
        videoView = (VideoView) findViewById(R.id.videoView);

        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            uri = extras.getInt("uri");
            pos = extras.getInt("pos");
        }

        Log.i("uri", ""+R.raw.videoatm31);

        // create an object of media controller
        MediaController mediaController = new MediaController(this);
        videoView.setVideoURI(Uri.parse("android.resource://" +  getPackageName() + "/" + uri));
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        close.setOnClickListener(this);
        videoView.start();
        videoView.seekTo(pos);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close :
                finish();
                break;
            default:
                break;
        }
    }
}
