package com.example.com.minimaltodo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = findViewById(R.id.list);
        button = findViewById(R.id.button);

        ArrayList<String> todoList = new ArrayList<String>();
        final ArrayAdapter listAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, todoList);
        todoList.add("Test");
        list.setAdapter( listAdapter );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdderActivity.class);
                startActivity(intent);
            }
        });

        if (getIntent().getExtras() != null) {
            Intent adderIntent = getIntent();
            String todo = adderIntent.getStringExtra("title");
            if (adderIntent.getIntExtra("position", -1) != -1) {
                todoList.set(adderIntent.getIntExtra("position", 0), todo);
                listAdapter.notifyDataSetChanged();
            } else {
                todoList.add(todo);
                listAdapter.notifyDataSetChanged();
            }
            int position = adderIntent.getIntExtra("position", -1);
            Log.d("ASDf", Integer.toString(position));

        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = list.getAdapter().getItem(position).toString();
                Intent intent = new Intent(MainActivity.this, AdderActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("title", title);
                startActivity(intent);
                Log.d("ASDf", Integer.toString(position));
            }
        });
    }
}
