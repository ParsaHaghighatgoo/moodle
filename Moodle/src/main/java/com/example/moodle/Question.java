package com.example.moodle;

import javafx.scene.control.CheckBox;

public class Question {
    private String questionTest;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private CheckBox correct;
    private String questionDes;
    private String answerDes;
    private QuestionType Qtype;

    public Question(String questionTest, String option1, String option2, String option3, String option4, CheckBox correct, QuestionType qtype) {
        this.questionTest = questionTest;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        this.correct = correct;
        Qtype = qtype;
    }

    public Question(String questionDes, String answerDes, QuestionType qtype) {
        this.questionDes = questionDes;
        this.answerDes = answerDes;
        Qtype = qtype;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (Qtype == QuestionType.TEST) {
            stringBuilder.append("TEST Type Question:\n")
                    .append("------------------------\n")
                    .append("\t\tquestionTest='").append(questionTest).append("',\n")
                    .append("\t\tOption1='").append(Option1).append("',\n")
                    .append("\t\tOption2='").append(Option2).append("',\n")
                    .append("\t\tOption3='").append(Option3).append("',\n")
                    .append("\t\tOption4='").append(Option4).append("',\n")
                    .append("=========>>>>\tcorrect=").append(correct).append("\t<<<<=========,\n")
                    .append("Qtype=").append(Qtype).append("\n")
                    .append("------------------------").append("\n");
        } else {
            stringBuilder.append("DESCRIPTIVE Type Question:\n")
                    .append("------------------------\n")
                    .append("\t\tquestionDes='").append(questionDes).append("',\n")
                    .append("\t\tanswerDes='").append(answerDes).append("',\n")
                    .append("Qtype=").append(Qtype).append("\n")
                    .append("------------------------").append("\n");
        }

        return stringBuilder.toString();
    }



}

