package com.hadimusthafa.galleryfromurl2.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.hadimusthafa.galleryfromurl2.R;

public class ImageInfoActivity extends AppCompatActivity {
    ImageView imageView1;
    TextView image_name;
    String image, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_info);
        image_name = findViewById(R.id.image_name);
        imageView1 = findViewById(R.id.imageView1);
        image = (getIntent().getExtras().getString("image"));
        name = (getIntent().getExtras().getString("name"));
        Glide.with(getApplicationContext()).load(image).into(imageView1);
        image_name.setText(name);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}




