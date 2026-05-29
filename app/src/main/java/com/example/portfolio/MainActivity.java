package com.example.portfolio;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RecyclerScroller recyclerScroller;
    LottieAnimationView codingAnimation;
    Animation animation;
    BottomNavigationView bottomNavigationView;

    private void initViews() {
        codingAnimation = findViewById(R.id.coding_animation);
        recyclerView = findViewById(R.id.recycler_view);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerAdapter = new RecyclerAdapter(this);
        recyclerScroller = new RecyclerScroller(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerScroller.attachToRecyclerView(recyclerView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.SectionHome) {
                recyclerScroller.smoothScrollTo(1, recyclerView);
            } else if (item.getItemId() == R.id.SectionProjects) {
                recyclerScroller.smoothScrollTo(2, recyclerView);
            } else if (item.getItemId() == R.id.SectionSkills) {
                recyclerScroller.smoothScrollTo(3, recyclerView);
            } else if (item.getItemId() == R.id.SectionExperience) {
                recyclerScroller.smoothScrollTo(4, recyclerView);
            } else if (item.getItemId() == R.id.SectionContact) {
                recyclerScroller.smoothScrollTo(5, recyclerView);
            }
            return true;
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                int firstVisible = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                if (firstVisible > 0 && firstVisible - 1 < bottomNavigationView.getMenu().size()) {
                    if (bottomNavigationView.getVisibility() != View.VISIBLE) {
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        bottomNavigationView.getMenu().getItem(firstVisible - 1).setChecked(true);
                    }
                } else {
                    bottomNavigationView.setVisibility(View.GONE);
                }
            }
        });

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            codingAnimation.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }, 4000);
    }
}