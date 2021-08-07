package com.example.calmdemo;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.calmdemo.Adapter.RecyclerViewAdapter;
import com.example.calmdemo.Model.Exercise;
import com.example.calmdemo.Utils.DataInitializer;

import java.util.ArrayList;
import java.util.List;

public class ListExercisesActivity extends AppCompatActivity {

    private List<Exercise> exerciseList = new ArrayList<>();

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerView recyclerView;

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises);

        DataInitializer.initData(exerciseList);

        recyclerView = (RecyclerView) findViewById(R.id.list_exercises);

        recyclerViewAdapter = new RecyclerViewAdapter(exerciseList, getBaseContext());

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
