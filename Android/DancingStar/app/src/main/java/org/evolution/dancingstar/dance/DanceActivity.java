package org.evolution.dancingstar.dance;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import org.evolution.dancingstar.R;

public class DanceActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance);

        mVideoView = findViewById(R.id.dance_video_view);

        TextView tvUser = findViewById(R.id.dance_tv_user);
        tvUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo();
            }
        });
    }

    public void playVideo() {
        String path = "android.resource://org.evolution.dancingstar/"+R.raw.dance_example;

        Uri uri = Uri.parse(path);

        mVideoView.setVideoURI(uri);
        mVideoView.start();
    }
}
