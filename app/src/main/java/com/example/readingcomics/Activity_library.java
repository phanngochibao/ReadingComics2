package com.example.readingcomics;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ListFragment()).addToBackStack(null).commit();
    }
}
