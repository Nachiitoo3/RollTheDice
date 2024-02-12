package com.nadrial.rollthedice.Entities;

import android.net.Uri;

import java.util.List;

public class Question {


    private String question;
    private String correctAnswer;

    private List<String> options;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String img;



    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }
}
