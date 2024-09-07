package com.enverzo.probquest.ui.tests.topictwo;

public class TopicTwoPreTestQuestion {
    public String group1Questions[] = {
            "Tossing a coin twice in succession.",
            "Drawing a spade, replacing the card, then drawing a club from a standard deck cards.",
            "Drawing a red queen from an ordinary deck of cards.",
            "Picking two balls in succession without replacement.",
            "Getting a 3 when a die is rolled once."
    };
    public String group2Questions[] = {
            "Rolling an even number on a die, then tossing a head on a coin.",
            "Drawing a jack from a deck of cards.",
            "Spinning an odd number from a roulette numbered 1 to 10.",
            "Flipping a head on a coin toss.",
            "Rolling a 3 on a die and getting heads on a coin toss."
    };
    public String group1CorrectAnswer[] = {
            "C", "C", "S", "C", "S"
    };
    public String group2CorrectAnswer[] = {
            "C", "S", "S", "S", "C"
    };
    public String getGroup1Question(int a) {
        String question = group1Questions[a];
        return question;
    }
    public String getGroup2Question(int a) {
        String question = group2Questions[a];
        return question;
    }
    public String getGroup1CorrectAnswer(int a) {
        String answer = group1CorrectAnswer[a];
        return answer;
    }
    public String getGroup2CorrectAnswer(int a) {
        String answer = group2CorrectAnswer[a];
        return answer;
    }
}
