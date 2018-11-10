package com.ayuan.videoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //检查vitamio框架是否可用
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        //找到控件
        final VideoView videoView = (VideoView) findViewById(R.id.vv);
        //设置播放的路径
        videoView.setVideoPath("http://172.50.223.22:8080/bb.mp4");
        /*videoView.setVideoPath("http://172.50.223.22:8080/cc.avi");*/
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //开始播放视频
                videoView.start();
            }
        });
        //这只video的控制器
        videoView.setMediaController(new MediaController(this));
    }
}
