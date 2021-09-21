package com.hadimusthafa.galleryfromurl2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    ;

    JSONArray jsonArray1 = new JSONArray();
    JSONArray jsonArray2 = new JSONArray();
    JSONArray jsonArray3 = new JSONArray();
    JSONArray jsonArray4 = new JSONArray();
    JSONArray jsonArray5 = new JSONArray();
    String JSONaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        viewPager = findViewById(R.id.view_pager);

        String[] pageTitle = {"ALL", "IMAGE", "VIDEO", "AUDIO", "PDF"};
        tabLayout = findViewById(R.id.tab_layout);
        for (int i = 0; i < 5; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        {
            JSONaa = "[\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Kangaroo_MusiQue_-_The_Neverwritten_Role_Playing_Game.mp3\",\n" +
                    "    \"Name\": \"The Neverwritten Playing_Game\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Sevish_-__nbsp_.mp3\",\n" +
                    "    \"Name\": \"Assets Sevish\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/codeskulptor-assets/Collision8-Bit.ogg\",\n" +
                    "    \"Name\": \"Collision8-Bit\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/codeskulptor-assets/Epoq-Lepidoptera.ogg\",\n" +
                    "    \"Name\": \"Epoq Lepidoptera\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/codeskulptor-assets/jump.ogg\",\n" +
                    "    \"Name\": \"Callisto bit jump\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3\",\n" +
                    "    \"Name\": \"Learningcontainer loop\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://www.buildingjavaprograms.com/ch07_sample.pdf\",\n" +
                    "    \"Name\": \"Java Array\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://www.tutorialspoint.com/java/pdf/java_basic_datatypes.pdf\",\n" +
                    "    \"Name\": \"Java datatypes\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://web.cse.ohio-state.edu/~kiel.32/JavaLoopsAndMethods.pdf\",\n" +
                    "    \"Name\": \"Java Loops And Methods\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://www.csd.uoc.gr/~hy252/assist08/pdf/CS252Strings08.pdf\",\n" +
                    "    \"Name\": \"Java Strings\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4\",\n" +
                    "    \"Name\": \"Big Buck Bunny\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4\",\n" +
                    "    \"Name\": \"Elephant Dream\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4\",\n" +
                    "    \"Name\": \"For Bigger Blazes\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4\",\n" +
                    "    \"Name\": \"For Bigger Escape\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4\",\n" +
                    "    \"Name\": \"For Bigger Fun\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4\",\n" +
                    "    \"Name\": \"For Bigger Joyrides\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4\",\n" +
                    "    \"Name\": \"For Bigger Meltdowns\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4\",\n" +
                    "    \"Name\": \"Sintel\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4\",\n" +
                    "    \"Name\": \"Subaru Outback On Street And Dirt\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4\",\n" +
                    "    \"Name\": \"Tears of Steel\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4\",\n" +
                    "    \"Name\": \"Volkswagen GTI Review\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4\",\n" +
                    "    \"Name\": \"We Are Going On Bullrun\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4\",\n" +
                    "    \"Name\": \"What care can you get for a grand?\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1595086135888-942899e89e46?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80\",\n" +
                    "    \"Name\": \"Shanghai Botanical Garden,China \"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1604300026959-cb23c7a9871c?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=785&q=80\",\n" +
                    "    \"Name\": \"Ferrara, FE, Italia\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1573546550252-0c5f30feb2b9?ixid=MXwxMjA3fDB8MHxwcm9maWxlLXBhZ2V8NDJ8fHxlbnwwfHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60\",\n" +
                    "    \"Name\": \"Gävle, Sweden\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1534313314376-a72289b6181e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1534&q=80\",\n" +
                    "    \"Name\": \"Neuschwanstein Castle, Schwangau, Germany\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1538136038156-98596408ffaa?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=237&q=80\",\n" +
                    "    \"Name\": \"Neuschwanstein Castle, Schwangau, Germany\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1611348948700-5b24e15587f6?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80\",\n" +
                    "    \"Name\": \"Kelly Sikkema\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1507838153414-b4b713384a76?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80\",\n" +
                    "    \"Name\": \"Marius Masalar\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1506157786151-b8491531f063?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80\",\n" +
                    "    \"Name\": \"Hanny Naibaho\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1554080353-a576cf803bda?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80\",\n" +
                    "    \"Name\": \"Erik Mclean\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1550879228-c334643b41b2?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=752&q=80\",\n" +
                    "    \"Name\": \"CLERMONT FERRAND, France\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1610899510324-268e41ac648c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80\",\n" +
                    "    \"Name\": \"Dorel Gnatiuc\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1576788903709-5c3eda911324?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80\",\n" +
                    "    \"Name\": \"Daniel Norris\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1522012188892-24beb302783d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80\",\n" +
                    "    \"Name\": \"Nathan Dumlao\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1475296204602-08d15839e95f?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=750&q=80\",\n" +
                    "    \"Name\": \"GC Libraries Creative Tech Lab\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1510422877342-80dc5ea91c5c?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=750&q=80\",\n" +
                    "    \"Name\": \"Coffee For Sasquatch, Los Angeles, United States\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1517640033243-dc06bb716df5?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80\",\n" +
                    "    \"Name\": \"Nathan Dumlao\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1494976388531-d1058494cdd8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80\",\n" +
                    "    \"Name\": \"2016 Mustang GT, San Francisco, United States\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1546356594-3bb0e904d8dc?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=750&q=80\",\n" +
                    "    \"Name\": \"Brad R\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"Url\": \"https://images.unsplash.com/photo-1577174881658-0f30ed549adc?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NHx8c29ueXxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60\",\n" +
                    "    \"Name\": \"NeONBRAND Digital Marketing, Las Vegas, United States\"\n" +
                    "  }\n" +
                    "]";
        }

        try {
            JSONArray jsonArray = new JSONArray(JSONaa);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String Url = jsonObject.getString("Url");
                String extension = Url.substring(Url.lastIndexOf("."));
                if (extension.equals(".mp4") || extension.equals(".MP4") || extension.equals(".mp3") || extension.equals(".MP3") || extension.equals(".pdf") || extension.equals(".PDF") || extension.equals(".ogg") || extension.equals(".OGG") || extension.equals(".unsplash") || extension.equals(".png") || extension.equals(".PNG") || extension.equals(".jpg") || extension.equals(".JPG") || extension.equals(".JPEG") || extension.equals(".jpeg")) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    jsonArray1.put(jsonObject1);
                }
                if (Url.contains(".unsplash") || extension.equals(".png") || extension.equals(".PNG") || extension.equals(".jpg") || extension.equals(".JPG") || extension.equals(".JPEG") || extension.equals(".jpeg")) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    jsonArray2.put(jsonObject1);
                }
                if (extension.equals(".mp4") || extension.equals(".MP4")) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    jsonArray3.put(jsonObject1);
                }
                if (extension.equals(".mp3") || extension.equals(".ogg")) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    jsonArray4.put(jsonObject1);
                }
                if (extension.equals(".pdf") || extension.equals(".PDF")) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    jsonArray5.put(jsonObject1);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, jsonArray1, jsonArray2, jsonArray3, jsonArray4, jsonArray5);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}