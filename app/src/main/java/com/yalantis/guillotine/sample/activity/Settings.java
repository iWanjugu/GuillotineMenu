package com.yalantis.guillotine.sample.activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.yalantis.guillotine.animation.GuillotineAnimation;
import com.yalantis.guillotine.sample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Settings extends AppCompatActivity {

    LinearLayout prof;
    LinearLayout feed;
    LinearLayout activity;
    LinearLayout settings;

    private static final long RIPPLE_DURATION = 250;


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ButterKnife.inject(this);


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine_settings, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        prof = (LinearLayout)findViewById(R.id.profile_group);
        feed = (LinearLayout)findViewById(R.id.feed_group);
        activity = (LinearLayout)findViewById(R.id.activity_group);
        settings = (LinearLayout)findViewById(R.id.settings_group);

        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.profile_group:
                        Intent b = new Intent(Settings.this, Profile.class);
                        startActivity(b);
                        break;

                }
            }
        });

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.feed_group:
                        Intent b = new Intent(Settings.this, Feed.class);
                        startActivity(b);
                        break;

                }
            }
        });

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.activity_group:
                        Intent b = new Intent(Settings.this, MainActivity.class);
                        startActivity(b);
                        break;

                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.settings_group:
                        Intent b = new Intent(Settings.this, Settings.class);
                        startActivity(b);
                        break;

                }
            }
        });
    }

}
