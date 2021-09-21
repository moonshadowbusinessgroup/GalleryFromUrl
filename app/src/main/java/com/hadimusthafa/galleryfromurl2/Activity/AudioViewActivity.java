package com.hadimusthafa.galleryfromurl2.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.arges.sepan.argmusicplayer.IndependentClasses.ArgAudio;
import com.arges.sepan.argmusicplayer.PlayerViews.ArgPlayerSmallView;
import com.hadimusthafa.galleryfromurl2.R;

public class AudioViewActivity extends AppCompatActivity {
    ArgPlayerSmallView audio_view;
    ArgAudio audioUrl;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_view);
        audio_view = findViewById(R.id.audio_view);
        name = findViewById(R.id.name);
        String mp3 = (getIntent().getExtras().getString("mp3"));
        String Name = (getIntent().getExtras().getString("name"));
        name.setText(Name);
        audioUrl = ArgAudio.createFromURL("One Piece", "Binks Sake", mp3);
        audio_view.enableNotification(AudioViewActivity.class);
        audio_view.play(audioUrl);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (audio_view != null) audio_view.pause();
    }
}
