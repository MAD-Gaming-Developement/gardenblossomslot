package dev.andeng.flowerspin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class LoadingScr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_scr);

        VideoView videoView = findViewById(R.id.videoView);

        // Set the video path from the resources
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.splashhh; // Replace with your video file name
        Uri uri = Uri.parse(videoPath);

        // Set the video URI to the VideoView
        videoView.setVideoURI(uri);

        // Set a completion listener to finish the activity when the video playback is complete
        videoView.setOnCompletionListener(mp -> {
            // Add any additional code to navigate to the main activity or perform other actions
            Intent intent = new Intent(LoadingScr.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finish the current activity
        });

        // Start playing the video
        videoView.start();
    }
}
