package com.example.lab3andriod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    int index;
    int QuesId;
    int ColorID,totalScore;
    Button truebut, falsebut;
    ProgressBar progressBar;

    questions_fragment fragmentObj;
    QuestionList obj = new QuestionList();
    String question;
    String getAverage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        truebut = findViewById(R.id.truebut);
        truebut.setOnClickListener(this);
        falsebut = findViewById(R.id.falsebut);
        falsebut.setOnClickListener(this);
        progressBar = findViewById(R.id.progressBar);

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("QuestionIndex");
        }

        QuesId = index;
        question = obj.quetionBank.get(index).question;
        ColorID = obj.color.get(index);
        UpdateFragment(QuesId, ColorID, question);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);


    }

    //Saving the state

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("QuestionIndex", index);
    }

    public void UpdateFragment(int quesId, int colorID, String question) {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        fragmentmanager.findFragmentById(R.id.fragment_container);
        fragmentObj = questions_fragment.newInstance(quesId, colorID, question);
        fragmentmanager.beginTransaction().replace(R.id.fragment_container, fragmentObj).commit();
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        if (index < obj.quetionBank.size()-1) {
            Boolean answer = obj.quetionBank.get(index).answer;

            if (button.equals(truebut) && answer == true) {
                totalScore++;
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();

            } else if ((button.equals(truebut) && answer == false)) {
                Toast.makeText(this, "InCorrect Answer", Toast.LENGTH_SHORT).show();
            } else if (button.equals(falsebut) && answer == false) {
                totalScore++;
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "InCorrect Answer", Toast.LENGTH_SHORT).show();
            }

            index++;
            question = obj.quetionBank.get(index).question;
            ColorID = obj.color.get(index);
            UpdateFragment(index, ColorID, question);
            progressBar.setProgress(progressBar.getProgress() + 10);

        }else{
            showScore();
            index=0;
            question = obj.quetionBank.get(index).question;
            ColorID = obj.color.get(index);
            Collections.shuffle(obj.quetionBank);
            Collections.shuffle(obj.color);
            UpdateFragment(index, ColorID, question);
            progressBar.setProgress(0);
        }
    }

    private void showScore(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Your Scores are "+ "\t" + totalScore +"\t"+ " out of 10 !!");
        getAverage = totalScore +"/" + 10 + "#";
       // builder.setPositiveButton("Save", (dialogInterface, i) -> storageObject.SaveData
              //  (MainActivity.this,getAverage));

        totalScore=0;
        builder.setNegativeButton("Ignore",null);
        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
