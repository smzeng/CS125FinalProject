package com.example.stacyzeng.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class TitlePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);

        //button that transfers you to the first page of the app
        final Button button = findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Intent i = new Intent(TitlePage.this, CategoryActivity.class);
            startActivity(i);
        }
    });
}

}
