package com.hadimusthafa.galleryfromurl2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.hadimusthafa.galleryfromurl2.R;
import com.zolad.zoominimageview.ZoomInImageViewAttacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageViewActivity extends AppCompatActivity {
    ImageView imageView, info, right, left;
    String image, name, dma, from_iv, scrollImage, scrollImageName;
    RelativeLayout infoL;
    int cp, np, pp, length;
    boolean Visibility, notScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView = findViewById(R.id.imageView);
        info = findViewById(R.id.info);
        right = findViewById(R.id.right);
        left = findViewById(R.id.left);
        infoL = findViewById(R.id.infoL);

        ZoomInImageViewAttacher mIvAttacter = new ZoomInImageViewAttacher();
        mIvAttacter.attachImageView(imageView);
        image = (getIntent().getExtras().getString("image"));
        name = (getIntent().getExtras().getString("name"));
        from_iv = (getIntent().getExtras().getString("from_iv"));
        dma = (getIntent().getExtras().getString("dma"));
        cp = Integer.parseInt((getIntent().getExtras().getString("cp")));

        Glide.with(this).load(image).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Visibility == false) {
                    info.setVisibility(View.VISIBLE);
                    Visibility = true;
                } else {
                    info.setVisibility(View.GONE);
                    Visibility = false;
                }
            }
        });

        infoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Visibility == false) {
                    info.setVisibility(View.VISIBLE);
                    Visibility = true;
                } else {
                    info.setVisibility(View.GONE);
                    Visibility = false;
                }
            }
        });

        if (from_iv != null) {
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notScroll = true;
                    try {
                        JSONArray jsonArray = new JSONArray(dma);
                        length = jsonArray.length();
                        if (length == cp + 1) {
                            Snackbar.make(infoL, "No more images", Snackbar.LENGTH_LONG).show();
                        } else {
                            np = cp + 1;
                            JSONObject jsonObject = jsonArray.getJSONObject(np);
                            scrollImage = jsonObject.getString("Url");
                            scrollImageName = jsonObject.getString("Name");
                            Glide.with(getApplicationContext()).load(scrollImage).into(imageView);
                        }
                        Log.e("lenght", String.valueOf(length));
                        Log.e("cp", String.valueOf(cp));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (length != cp) {
                        cp++;
                    }
                }
            });
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notScroll = true;
                    try {
                        JSONArray jsonArray = new JSONArray(dma);
                        if (cp == 0) {
                            Snackbar.make(infoL, "No more images", Snackbar.LENGTH_LONG).show();
                        } else {
                            pp = cp - 1;
                            JSONObject jsonObject = jsonArray.getJSONObject(pp);
                            scrollImage = jsonObject.getString("Url");
                            scrollImageName = jsonObject.getString("Name");
                            Glide.with(getApplicationContext()).load(scrollImage).into(imageView);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (cp != -1) {
                        cp--;
                    }
                }
            });
        }

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageInfoActivity.class);
                if (notScroll) {
                    intent.putExtra("image", scrollImage);
                    intent.putExtra("name", scrollImageName);
                } else {
                    intent.putExtra("image", image);
                    intent.putExtra("name", name);
                }
                startActivity(intent);
            }
        });
    }
}


