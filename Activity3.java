package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        String name   = getIntent().getStringExtra("EXTRA_NAME");
        String course = getIntent().getStringExtra("EXTRA_COURSE");
        String level  = getIntent().getStringExtra("EXTRA_LEVEL");

        TextView txtSummary3 = findViewById(R.id.txtSummary3);
        txtSummary3.setText("Élève : " + (name==null?"-":name) +
                "\nMatière : " + (course==null?"-":course) +
                "\nNiveau : " + (level==null?"-":level));

        Button btnFinish3 = findViewById(R.id.btnFinish3);
        btnFinish3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // Aller vers Activity4 pour inscription détaillée
                // (si tu préfères revenir, remplace par finish();)
                startActivity(new android.content.Intent(Activity3.this, Activity4.class));
            }
        });
    }
}
