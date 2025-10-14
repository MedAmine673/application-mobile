package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    private EditText inputName1;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        inputName1 = findViewById(R.id.inputName1);
        Button btnToActivity2 = findViewById(R.id.btnToActivity2);

        btnToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String name = inputName1.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(Activity1.this, "Veuillez entrer votre nom", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(Activity1.this, Activity2.class);
                i.putExtra("EXTRA_NAME", name);
                startActivity(i);
            }
        });
    }
}
