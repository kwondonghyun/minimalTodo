package com.example.com.minimaltodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdderActivity extends AppCompatActivity {
    int position = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adder);

        final Button addbutton = findViewById(R.id.addButton);
        final EditText titleEditText = findViewById(R.id.titleEditText);

        if (getIntent().getExtras() != null) {
            Intent intent = getIntent();
            position = intent.getIntExtra("position",-1);
            titleEditText.setText(intent.getStringExtra("title"));
        }

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdderActivity.this, MainActivity.class);
                String title = titleEditText.getText().toString();
                intent.putExtra("title", title);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}

