
package ilyosbek.com.youttubeappsection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

@SuppressLint("Registered")
public class YoutubeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {
    private static final String TAG = "message";
    static String VIDEO_CODE = "P4dT-lW9260";
    static String PLAYLIST_CODE = "PLXtTjtWmQhg2eXpUPa7ZctfU7kcrfh5un";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(constraintLayout);
        YouTubePlayerView youTubePlayerView = new YouTubePlayerView(this);

        youTubePlayerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        constraintLayout.addView(youTubePlayerView);
        youTubePlayerView.initialize(Youtube.getApiKey(), this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Log.d(TAG, "onInitializationSuccess: " + provider.getClass().toString());
        Toast.makeText(this, "Running was successfull!", Toast.LENGTH_SHORT).show();

        if (!b) {
            youTubePlayer.loadVideo(VIDEO_CODE);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "ERROR occured!", Toast.LENGTH_SHORT).show();
    }


}

