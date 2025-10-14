package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {

    private static final int REQ_TO_5 = 100;
    private EditText inputName, inputCourse, inputLevel;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);

        inputName   = findViewById(R.id.inputName);
        inputCourse = findViewById(R.id.inputCourse);
        inputLevel  = findViewById(R.id.inputLevel);
        Button btnGoTo5 = findViewById(R.id.btnGoTo5);

        btnGoTo5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String name = inputName.getText().toString().trim();
                String course = inputCourse.getText().toString().trim();
                String level = inputLevel.getText().toString().trim();

                if (name.isEmpty() || course.isEmpty() || level.isEmpty()) {
                    Toast.makeText(Activity4.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(Activity4.this, Activity5.class);
                i.putExtra("EXTRA_NAME", name);
                i.putExtra("EXTRA_COURSE", course);
                i.putExtra("EXTRA_LEVEL", level);
                startActivityForResult(i, REQ_TO_5);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_TO_5 && resultCode == RESULT_OK && data != null) {
            String msg = data.getStringExtra("EXTRA_MSG_BACK");
            Toast.makeText(this, msg == null ? "OK" : msg, Toast.LENGTH_SHORT).show();
        }
    }
}
