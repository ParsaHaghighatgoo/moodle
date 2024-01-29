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

    public String getQuestionTest() {
        return questionTest;
    }

    public void setQuestionTest(String questionTest) {
        this.questionTest = questionTest;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public CheckBox getCorrect() {
        return correct;
    }

    public void setCorrect(CheckBox correct) {
        this.correct = correct;
    }

    public QuestionType getQtype() {
        return Qtype;
    }

    public void setQtype(QuestionType qtype) {
        Qtype = qtype;
    }
}

