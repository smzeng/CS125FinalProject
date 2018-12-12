package com.example.stacyzeng.todolist;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
   //adapter that allows us to access information from the text field
    ArrayAdapter<String> adapt;
    //button that adds the task
    Button add;
    //listView that holds all the items you add in your toDo list
    ListView list;
    //field where user inputs information
    EditText text;
    //array that holds all the tasks input by the user
    ArrayList<String> items;
    Button getGif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        add = findViewById(R.id.addButton);
        list = (ListView) findViewById(R.id.itemList);
        text = (EditText) findViewById(R.id.inputText);
        items = new ArrayList<>();
        adapt = new ArrayAdapter<String>(CategoryActivity.this, android.R.layout.simple_list_item_multiple_choice, items);
        //listens for user entering task into the edit text field and then gets the user input,adds the info into the array, resets the field
        View.OnClickListener addListener = new View.OnClickListener() {
            public void onClick(View v) {
                items.add(text.getText().toString());
                text.setText("");
                adapt.notifyDataSetChanged();
            }
        };
        //listens for a long click which it will then delete an item
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray positionChecker = list.getCheckedItemPositions();
                int count = list.getCount();
                //moves the items up the arraylist if item is deleted
                for (int item = count - 1; item >= 0; item--) {
                    if (positionChecker.get(item)) {
                        adapt.remove(items.get(item));

                        Toast.makeText(CategoryActivity.this,"item deleted successfully", Toast.LENGTH_SHORT).show();
                    }
                }
                positionChecker.clear();
                adapt.notifyDataSetChanged();
                if (items.size() == 0) {
                    getGif = findViewById(R.id.allDone);
                    getGif.setVisibility(View.VISIBLE);
                    getGif.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(final View view) {
                            Intent i = new Intent(CategoryActivity.this, gif.class);
                            startActivity(i);
                        }
                    });
                }
                return false;
            }
        });
        add.setOnClickListener(addListener);
        list.setAdapter(adapt);
    }
}


