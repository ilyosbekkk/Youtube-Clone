package ilyosbek.com.youttubeappsection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import java.util.regex.Pattern;


@SuppressLint("Registered")
public class Main extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    EditText text;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.mainButton);
        button2 = findViewById(R.id.standalaone);
        text = findViewById(R.id.editText);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String equal = "=|be/";
        Pattern pattern = Pattern.compile(equal, Pattern.CASE_INSENSITIVE);
        String[] result = pattern.split(text.getText().toString());
        Intent intent = null;


        switch (v.getId()) {
            case R.id.mainButton:
                if (text.getText().toString().equals("https://www.youtube.com/watch?v") || text.getText().toString().equals("https://www.youtu.")) {
                    Toast.makeText(this, "NO VIDEO AVAILABLE!", Toast.LENGTH_SHORT).show();
                }
                else if (text.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Empty Search!!!", Toast.LENGTH_SHORT).show();
                } else if (!result[0].equals("https://www.youtube.com/watch?v") && !result[0].equals("https://www.youtu.")) {
                    Toast.makeText(this, "Invalid Link!", Toast.LENGTH_SHORT).show();
                } else {
                    intent = YouTubeStandalonePlayer.createVideoIntent(this, Youtube.getApiKey(), result[1], 0, true, true);
                }
                break;
            case R.id.standalaone:
                intent = new Intent(this, Standalone.class);
                break;

        }
        if (intent != null) {
            startActivity(intent);

        }
    }
}
