package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "FAQ")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;

    private String answer;

    private int rate;

    public Faq() {
    }

    public Faq(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


}
