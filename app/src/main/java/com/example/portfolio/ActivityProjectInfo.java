package com.example.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityProjectInfo extends AppCompatActivity {
    LinearLayout container;
    LayoutInflater inflater;
    int projectId;
    TextView projectName;
    TextCustomization textCustomization = new TextCustomization();

    private void initViews() {
        container = findViewById(R.id.project_container);
        projectId = getIntent().getIntExtra("ProjectId", 1);
        inflater = LayoutInflater.from(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.project_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initViews();

        if (projectId == 1) {
            project1_view();
        } else if (projectId == 2) {
            project2_view();
        } else if (projectId == 3) {
            project3_view();
        }
    }

    private void project1_view() {
        inflater.inflate(R.layout.layout_project1, container, true);
        projectName = findViewById(R.id.project1_name);
        textCustomization.LabelUnderLine(projectName);
    }

    private void project2_view() {
        inflater.inflate(R.layout.layout_project2, container, true);
        projectName = findViewById(R.id.project2_name);
        textCustomization.LabelUnderLine(projectName);
    }

    private void project3_view() {
        inflater.inflate(R.layout.layout_project3, container, true);
        projectName = findViewById(R.id.project3_name);
        textCustomization.LabelUnderLine(projectName);
    }
}