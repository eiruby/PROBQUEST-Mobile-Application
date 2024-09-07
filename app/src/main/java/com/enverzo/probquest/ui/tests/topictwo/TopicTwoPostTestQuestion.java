package com.enverzo.probquest.ui.tests.topictwo;

public class TopicTwoPostTestQuestion {
    public String group1Questions[] = {
            "Drawing a king of diamonds from a deck of cards.",
            "Drawing a face card from an ordinary deck of cards.",
            "Rolling an odd number on a die, then tossing a tail on a coin.",
            "Getting at least one tail when a coin tossed twice.",
            "Spinning an odd number from a roulette numbered 1 to 8."
    };
    public String group2Questions[] = {
            "Picking two red balls or three blue balls in succession.",
            "Getting at tail on the 1st toss and a head on the 2nd toss.",
            "Drawing a heart, replacing the card, then drawing a jack of clubs from a standard deck of cards.",
            "Rolling a 3 on a die and getting heads on a coin toss.",
            "Getting at least a sum of 10 in rolling two dice."
    };
    public String group1CorrectAnswer[] = {
            "S", "S", "C", "C", "S"
    };
    public String group2CorrectAnswer[] = {
            "C", "C", "C", "C", "C"
    };
    public String solutions[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
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
    public String getSolution(int a) {
        String solution = solutions[a];
        return solution;
    }
}
