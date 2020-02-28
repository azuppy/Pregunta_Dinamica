package com.desafiolatam.desafio03;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TheSuperFragment extends Fragment {
    TextView pregunta,
             categoria,
             dificultad;

    RadioGroup radioGroupOpciones;

    RadioButton radioButton,
                radioButton2;

    public TheSuperFragment() {
    }

    public static TheSuperFragment newInstance(String category,
                                        String type,
                                        String difficulty,
                                        String question,
                                        String correctAnswer,
                                        List<String> incorrectAnswers){

        TheSuperFragment fragment = new TheSuperFragment();
        Bundle arguments = new Bundle();
        arguments.putString("CATEGORIA", category);
        arguments.putString("TIPO", type);
        arguments.putString("DIFICULTAD", difficulty);
        arguments.putString("PREGUNTA", question);
        arguments.putString("RESPUESTA CORRECTA", correctAnswer);
        arguments.putStringArrayList("RESPUESTA INCORRECTA", (ArrayList<String>)incorrectAnswers);
        fragment.setArguments(arguments);

        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        final String category = Objects.requireNonNull(getArguments().getString("CATEGORIA"));
        final String type = Objects.requireNonNull(getArguments().getString("TIPO"));
        final String difficulty = Objects.requireNonNull(getArguments().getString("DIFICULTAD"));
        final String question = Objects.requireNonNull(getArguments().getString("PREGUNTA"));
        final String correctAnswer = Objects.requireNonNull(getArguments().getString("RESPUESTA CORRECTA"));
        final List<String> incorrectAnswers = Objects.requireNonNull(getArguments().getStringArrayList("RESPUESTA INCORRECTA"));

        initializeViews(view);

        pregunta.setText(question);
        categoria.setText(category);
        dificultad.setText(difficulty);
        radioButton.setText(correctAnswer);
        radioButton2.setText(incorrectAnswers.get(0));

        return view;
    }


    private void initializeViews(View view){
        pregunta = view.findViewById(R.id.pregunta);
        categoria = view.findViewById(R.id.categoria);
        dificultad = view.findViewById(R.id.dificultad);
        radioGroupOpciones = view.findViewById(R.id.radioGroupOpciones);
        radioButton = view.findViewById(R.id.radioButton);
        radioButton2 = view.findViewById(R.id.radioButton2);
    }



}
