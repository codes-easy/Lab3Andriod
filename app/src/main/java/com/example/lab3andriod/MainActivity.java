package com.example.lab3andriod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    int index;
    int QuesId;
    int ColorID;
    questions_fragment fragmentObj;
    QuestionList obj = new QuestionList();








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button truebut = findViewById(R.id.truebut);
        Button falsebut = findViewById(R.id.falsebut);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("QuestionIndex");
        }

        QuesId = obj.quetionBank.get(index).questions;
        ColorID = obj.color.get(index);
        UpdateFragment (QuesId, ColorID);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);


    }

    public void UpdateFragment(int quesId, int colorID){
        FragmentManager fragmentmanager = getSupportFragmentManager();
        fragmentmanager.findFragmentById(R.id.fragment_container);
        fragmentObj =  questions_fragment.newInstance(quesId, colorID);
        fragmentmanager.beginTransaction().replace(R.id.fragment_container, fragmentObj).commit();
    }
}