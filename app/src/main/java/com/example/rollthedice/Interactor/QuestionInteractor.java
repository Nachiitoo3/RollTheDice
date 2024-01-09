package com.example.rollthedice.Interactor;

import android.content.Context;


import com.example.rollthedice.Entities.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionInteractor {

    public Question getRandomQuestion(Context context, String JSONName) {
        List<Question> questions = loadQuestions(context, JSONName);

        if (questions != null && questions.size() > 0) {
            Random random = new Random();
            return questions.get(random.nextInt(questions.size()));
        }

        return null;
    }

    private List<Question> loadQuestions(Context context, String JSONName) {
        List<Question> questions = new ArrayList<>();

        try {
            int resourceId = context.getResources().getIdentifier(JSONName, "raw", context.getPackageName());
            InputStream is = context.getResources().openRawResource(resourceId);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Question question = new Question();
                question.setQuestion(jsonObject.getString("pregunta"));
                question.setCorrectAnswer(jsonObject.getString("respuesta_correcta"));

                JSONArray optionsArray = jsonObject.getJSONArray("opciones_respuesta");
                List<String> options = new ArrayList<>();
                for (int j = 0; j < optionsArray.length(); j++) {
                    options.add(optionsArray.getString(j));
                }
                question.setOptions(options);

                questions.add(question);
            }

            is.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return questions;
    }
}