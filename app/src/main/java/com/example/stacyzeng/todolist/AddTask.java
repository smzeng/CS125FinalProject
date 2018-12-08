package com.example.stacyzeng.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTask extends AppCompatActivity {
    String taskName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button saveTaskButton = findViewById(R.id.saveTaskButton);

        saveTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent i = new Intent(AddTask.this, CategoryActivity.class);
                startActivity(i);
            }
        });
    }
}
