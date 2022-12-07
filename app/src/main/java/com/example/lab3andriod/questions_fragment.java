package com.example.lab3andriod;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link questions_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questions_fragment extends Fragment {
    TextView questionstext;
    int questions;
    int color;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static questions_fragment newInstance(int qId, int clrId) {

        Bundle args = new Bundle();
        args.putInt("QuestionId",qId);
        args.putInt("ColorId",clrId);
        questions_fragment fragment = new questions_fragment();
        fragment.setArguments(args);
        return fragment;

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment questions_fragment.
     */
    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_questions_fragment,
                container, false);
         questionstext = (TextView) view.findViewById(R.id.questionstext);
         color = getArguments().getInt("ColorId");
         questions = getArguments().getInt("questionId");
         questionstext.setText(questions);
         questionstext.setBackgroundResource(color);

        return view;


    }
}