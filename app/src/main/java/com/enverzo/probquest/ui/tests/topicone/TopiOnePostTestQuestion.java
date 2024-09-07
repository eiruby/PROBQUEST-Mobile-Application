package com.enverzo.probquest.ui.tests.topicone;

public class TopiOnePostTestQuestion {
    public String group1Questions[] = {
            "In rolling a die, what is the probability of getting a 5?",
            "A coin is tossed. What is the probability of getting NOT a head?",
            "If a card is drawn from a well – shuffled deck of cards, what is the probability that it is a queen of hearts?",
            "A multiple choice question has 3 possible answers. If a student picks the answer at random, what is the probability that is correct?",
            "A card is selected at random from an ordinary deck of playing cards. What is the probability that the card is a black king?"
    };
    public String group2Questions[] = {
            "If a letter is chosen at random from the word ACTIVITY, what is the probability that the letter chosen is a consonant?",
            "A box contains seven blue, three violet, and five yellow balls. If a ball is selected at random, what is the probability that it is a violet?",
            "A spinner, numbered from 1 – 15, is spun once. What is the probability of spinning an even number?",
            "A fair die is rolled. What is the probability of getting a factor of 2?",
            "A spinner, numbered from 1 – 15, is spun once. What is the probability of the spinner landing on a number greater than 10?"
    };
    public String group3Questions[] = {
            "A roulette wheel has 10 red numbers, 8 black numbers, and 12 green numbers. What is the probability that the ball will land on a green number on one spin?",
            "In a box, there are 30 balls numbered from 1 to 30. If a ball is drawn from the box, what is the probability of getting a number divisible by 5?",
            "Number cards from 1 to 18 are shuffled and placed faced down. If one card is picked at random, what is the probability that it contains a prime number?",
            "A couple wants to have 3 children. What is the probability that all will be boys?",
            "There are 45 balls in a bag. The probability of choosing a blue ball is exactly 3/5. What is the number of balls in the bags that are NOT blue?"
    };
    public String group1Choices[][] = {
            {"5/6","3/4","2/3","1/6"},
            {"1/2","1/4","1/5","1/6"},
            {"3/52","1/52","1/48","1/13"},
            {"3/5","2/3","1/3","1/2"},
            {"1/2","1/4","1/13","1/26"},
    };
    public String group2Choices[][] = {
            {"1/4","1/8","3/8","5/8"},
            {"7/15","4/15","1/5","1/15"},
            {"4/15","7/15","11/15","13/15"},
            {"1/6","1/4","1/3","1/2"},
            {"1/5","1/4","1/3","1/2"}
    };
    public String group3Choices[][] = {
            {"1/5","2/5","4/5","6/5"},
            {"1/5","2/15","3/5","4/15"},
            {"2/3","2/18","7/18","5/19"},
            {"1/2","1/4","1/6","1/8"},
            {"18","21","24","27"}
    };
    public String group1CorrectAnswer[] = {
            "1/6", "1/2", "1/52", "1/3", "1/26"
    };
    public String group2CorrectAnswer[] = {
            "5/8", "1/5", "7/15", "1/3", "1/3"
    };
    public String group3CorrectAnswer[] = {
            "2/5", "1/5", "7/18", "1/8", "18"
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
    public String getGroup3Question(int a) {
        String question = group3Questions[a];
        return question;
    }
    public String getGroup1Choice1(int a) {
        String choice = group1Choices[a][0];
        return choice;
    }
    public String getGroup2Choice1(int a) {
        String choice = group2Choices[a][0];
        return choice;
    }
    public String getGroup3Choice1(int a) {
        String choice = group3Choices[a][0];
        return choice;
    }
    public String getGroup1Choice2(int a) {
        String choice = group1Choices[a][1];
        return choice;
    }
    public String getGroup2Choice2(int a) {
        String choice = group2Choices[a][1];
        return choice;
    }
    public String getGroup3Choice2(int a) {
        String choice = group3Choices[a][1];
        return choice;
    }
    public String getGroup1Choice3(int a) {
        String choice = group1Choices[a][2];
        return choice;
    }
    public String getGroup2Choice3(int a) {
        String choice = group2Choices[a][2];
        return choice;
    }
    public String getGroup3Choice3(int a) {
        String choice = group3Choices[a][2];
        return choice;
    }
    public String getGroup1Choice4(int a) {
        String choice = group1Choices[a][3];
        return choice;
    }
    public String getGroup2Choice4(int a) {
        String choice = group2Choices[a][3];
        return choice;
    }
    public String getGroup3Choice4(int a) {
        String choice = group3Choices[a][3];
        return choice;
    }
    public String getGroup1CorrectAnswer(int a) {
        String answer = group1CorrectAnswer[a];
        return answer;
    }
    public String getGroup2CorrectAnswer(int a) {
        String answer = group2CorrectAnswer[a];
        return answer;
    }
    public String getGroup3CorrectAnswer(int a) {
        String answer = group3CorrectAnswer[a];
        return answer;
    }
    public String getSolution(int a) {
        String solution = solutions[a];
        return solution;
    }
}
