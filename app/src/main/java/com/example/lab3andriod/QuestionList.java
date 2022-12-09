package com.example.lab3andriod;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class QuestionList {
    ArrayList<Questions> quetionBank = new ArrayList<>();
    ArrayList<Integer> color = new ArrayList<>();


    QuestionList() {
        Questions ques1 = new Questions("Washington is the the capital city of USA", true);
        Questions ques2 = new Questions("Montreal is the capital city of Canada", false);
        Questions ques3 = new Questions("Itly is the capital city of France", false);
        Questions ques4 = new Questions("Rome is the capital city of Paris", false);
        Questions ques5 = new Questions("Southwales is the capital city of Australia", false);
        Questions ques6 = new Questions("Ottawa is the capital city of Canada", true);
        Questions ques7 = new Questions("Paris is the capital city of France", true);
        Questions ques8 = new Questions("Rome is the capital city of Itlay", true);
        Questions ques9 = new Questions("Sydney is the capital city of Australia", true);
        Questions ques10 = new Questions("Taj Mahal is in Duabi", false);

        quetionBank.add(ques1);
        quetionBank.add(ques2);
        quetionBank.add(ques3);
        quetionBank.add(ques4);
        quetionBank.add(ques5);
        quetionBank.add(ques6);
        quetionBank.add(ques7);
        quetionBank.add(ques8);
        quetionBank.add(ques9);
        quetionBank.add(ques10);


        color.add(R.color.SeaGreen);
        color.add(R.color.Lavender);
        color.add(R.color.Linen);
        color.add(R.color.Lime);
        color.add(R.color.Teal);
        color.add(R.color.Cyan);
        color.add(R.color.purple_200);
        color.add(R.color.PaleTurquoise);
        color.add(R.color.FireBrick);
        color.add(R.color.Orchid);

    }



}
