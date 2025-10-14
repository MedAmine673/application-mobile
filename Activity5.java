package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5);

        TextView txtName  = findViewById(R.id.txtName);
        TextView txtCourse= findViewById(R.id.txtCourse);
        TextView txtLevel = findViewById(R.id.txtLevel);
        Button btnLesson  = findViewById(R.id.btnLesson);
        Button btnQuiz    = findViewById(R.id.btnQuiz);
        Button btnBack    = findViewById(R.id.btnBack);

        Intent in = getIntent();
        final String name   = in.getStringExtra("EXTRA_NAME");
        final String course = in.getStringExtra("EXTRA_COURSE");
        final String level  = in.getStringExtra("EXTRA_LEVEL");

        txtName.setText("Nom : " + (name==null?"-":name));
        txtCourse.setText("Matière : " + (course==null?"-":course));
        txtLevel.setText("Niveau : " + (level==null?"-":level));

        btnLesson.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(Activity5.this, "Ouverture de la leçon de " + course, Toast.LENGTH_SHORT).show();
            }
        });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(Activity5.this, "Lancement du quiz " + course, Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("EXTRA_MSG_BACK", "✅ Cours prêt : " + (name==null?"-":name) + " — " + (course==null?"-":course));
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}
