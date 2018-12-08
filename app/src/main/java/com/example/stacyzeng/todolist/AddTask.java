package com.example.stacyzeng.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddTask extends AppCompatActivity {
    String taskName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }
}
