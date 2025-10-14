package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private EditText inputCourse2;
    private SeekBar seekLevel;
    private TextView levelOut;

    private String levelText(int progress) {
        switch (progress) {
            case 0: return "Débutant";
            case 1: return "Intermédiaire";
            case 2: return "Avancé";
            default: return "Débutant";
        }
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        final String name = getIntent().getStringExtra("EXTRA_NAME");

        inputCourse2 = findViewById(R.id.inputCourse2);
        seekLevel    = findViewById(R.id.seekLevel);
        levelOut     = findViewById(R.id.txtLevelDisplay);
        Button btnToActivity3 = findViewById(R.id.btnToActivity3);

        if (levelOut != null) levelOut.setText(levelText(seekLevel.getProgress()));

        seekLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                if (levelOut != null) levelOut.setText(levelText(progress));
            }
            @Override public void onStartTrackingTouch(SeekBar sb) {}
            @Override public void onStopTrackingTouch(SeekBar sb) {}
        });

        btnToActivity3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String course = inputCourse2.getText().toString().trim();
                if (course.isEmpty()) {
                    Toast.makeText(Activity2.this, "Entre une matière.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String level = levelText(seekLevel.getProgress());
                Intent i = new Intent(Activity2.this, Activity3.class);
                i.putExtra("EXTRA_NAME", (name == null ? "-" : name));
                i.putExtra("EXTRA_COURSE", course);
                i.putExtra("EXTRA_LEVEL", level);
                startActivity(i);
            }
        });
    }
}
