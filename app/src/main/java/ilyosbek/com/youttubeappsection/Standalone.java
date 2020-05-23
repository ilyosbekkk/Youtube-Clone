package ilyosbek.com.youttubeappsection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

@SuppressLint("Registered")
public class Standalone extends AppCompatActivity implements View.OnClickListener {
    Button videoButton;
    Button playListButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        videoButton = findViewById(R.id.singleVideo);
        playListButton = findViewById(R.id.play_list);
        videoButton.setOnClickListener(this);
        playListButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.singleVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, Youtube.getApiKey(), YoutubeActivity.VIDEO_CODE, 0, true, true);
                break;
            case R.id.play_list:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, Youtube.getApiKey(), YoutubeActivity.PLAYLIST_CODE, 0, 0, true, true);
                break;
            default:

        }
        if (intent != null) {
            startActivity(intent);
        }
    }


}
