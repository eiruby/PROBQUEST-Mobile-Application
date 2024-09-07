package com.enverzo.probquest.ui.tests.topicone;

public class TopiOnePreTestQuestion {
    public String g1Questions[] = {
            "In rolling a die, what is the probability of getting a 4?",
            "A coin is tossed. What is the probability of getting a head?",
            "If a card is drawn from a well-shuffled deck of cards, what is the probability that it is a king of diamonds?",
            "A multiple choice question has 5 possible answers. If a student picks the answer at random, what is the probability that is correct?",
            "A card is selected at random from an ordinary deck of playing cards. What is the probability that the card is a red queen?",
    };
    public String g2Questions[] = {
            "If a letter is to be selected from the word ENRICHMENT, find the probability that the letter is a vowel?",
            "A box contains five red, four white, and six green balls. If a ball is selected at random, what is the probability that it is a green?",
            "A spinner, numbered from 1 – 15, is spun once. What is the probability of spinning an odd number?",
            "A fair die is rolled. What is the probability of getting a factor of 4?",
            "A spinner, numbered from 1 – 15, is spun once. What is the probability of the spinner landing on a number less than 4?"
    };
    public String g3Questions[] = {
            "A roulette wheel has 10 red numbers, 8 black numbers, and 12 green numbers. What is the probability that the ball will land on a red number on one spin?",
            "In a box, there are 30 balls numbered from 1 to 30. If a ball is drawn from the box, what is the probability of getting a number divisible by 3?",
            "Number cards from 1 to 20 is shuffled and placed faced down. If one card is picked at random, what is the probability that it contains a prime number?",
            "A couple wants to have 2 children. What is the probability that both will be girls?",
            "There are 40 balls in a bag. The probability of choosing a red ball is exactly 2/5. What is the number of balls in the bags that are NOT red?"
    };
    public String g1Choices[][] = {
            {"1/2","1/4","1/6","1/2"},
            {"1/2","1/3","1/4","1/6"},
            {"1/4","1/13","1/48","1/52"},
            {"1/5","2/5","3/5","4/5"},
            {"1/13","1/26","3/26","4/26"},
    };
    public String g2Choices[][] = {
            {"3/10","3/7","2/3","1/3"},
            {"4/5","3/5","2/5","1/5"},
            {"11/15","8/15","7/15","4/15"},
            {"1/6","1/5","1/3","1/2"},
            {"11/15","4/5","3/15","1/5"}
    };
    public String g3Choices[][] = {
            {"5/6","4/5","3/4","1/3"},
            {"7/30","4/30","2/3","1/3"},
            {"4/5","3/5","2/5","1/5"},
            {"1/4","2/4","3/4","1/8"},
            {"9","15","21","24"}
    };
    public String g1CorrectAnswer[] = {
            "1/6", "1/2", "1/52", "1/5", "1/26"
    };
    public String g2CorrectAnswer[] = {
            "3/10", "2/5", "8/15", "1/6", "1/5"
    };
    public String g3CorrectAnswer[] = {
            "1/3","1/3","2/5","1/4","24"
    };
    public String g1Solutions[] = {
            "Event = getting a 4 in a die\nNote: There is only one 4 in a die, thus\nn(E) = 1\nSample space = {1, 2, 3, 4, 5, 6}\nn(S) = 6",
            "Event = getting a head in a coin\nn(E) = 1\nSample space = {Head, Tail}\nn(S) = 2",
            "Event = drawing a king of diamond\nNote: There is only one king of diamonds, thus,\nn(E) = 1\nSample space =\n{Diamonds: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King},\n{Hearts: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King},\n{Clubs: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King},\n{Spade: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King}\nn(S) = 52",
            "",
            "Event = drawing a red queen\nThere are two red queen in a deck of cards, that is, a queen of diamonds and a queen of hearts. Thus,\nn(E) = 2\nSample space =\n{Diamonds: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King},\n{Hearts: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King},\n{Clubs: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King},\n{Spade: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King}\nn(S) = 52"
    };
    public String g2Solutions[] = {
            "Event = selecting a vowel from the word ENRICHMENT\nThere are three vowels, thus\nn(E) = 3\nSample space = {E, N, R, I, C, H, M, E, N, T}\nn(S) = 10",
            "Event = drawing a green ball\nThere are six green balls. Thus,\nn(E) = 6\nSample space = {five red balls, four white balls, and six green balls}\nn(S) = 15",
            "Event = spinning odd number\nThere are eight odd numbers in a spinner such as 1, 3, 5, 7, 9, 11, 13, and 15. Thus,\nn(E) = 8\nSample space = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}\nn(S) = 15",
            "",
            "Event = landing on a number less than 4\nThere are three numbers less than four, thus\nn(E) = 3\nSample space = {five red balls, four white balls, six green balls}\nn(S) = 15"
    };
    public String g3Solutions[] = {
            "Event = the ball landing on a red number\nThere are ten red numbers, thus\nn(E) = 10\nSample space = {10(red), 8(black), 12(green)}\nn(S) = 30",
            "Event = drawing a ball numbered divisible by 3\nThere are ten balls, thus\nn(E) = 10\nSample space = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}\nn(S) = 30",
            "",
            "",
            ""
    };
    public String g1SolAnswers[] = {
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{1}{6}",
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{1}{2}",
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{1}{52}",
            "\\frac{1}{5}",
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{1}{26}"
    };
    public String g2SolAnswers[] = {
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{3}{10}",
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{6}{15} = \\frac{2}{5}",
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{8}{15}",
            "\\frac{1}{6}",
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{3}{15} = \\frac{1}{5}"
    };
    public String g3SolAnswers[] = {
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{10}{30} = \\frac{1}{3}",
            "\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample spcae}}\\\\P(E) = \\frac{n(\\text{event})}{n(\\text{sample space})} = \\frac{10}{30} = \\frac{1}{3}",
            "\\frac{2}{5}",
            "\\frac{1}{4}",
            "24"
    };

    public String getG1Question(int a) {
        String question = g1Questions[a];
        return question;
    }
    public String getG2Question(int a) {
        String question = g2Questions[a];
        return question;
    }
    public String getG3Question(int a) {
        String question = g3Questions[a];
        return question;
    }
    public String getG1Choice1(int a) {
        String choice = g1Choices[a][0];
        return choice;
    }
    public String getG2Choice1(int a) {
        String choice = g2Choices[a][0];
        return choice;
    }
    public String getG3Choice1(int a) {
        String choice = g3Choices[a][0];
        return choice;
    }
    public String getG1Choice2(int a) {
        String choice = g1Choices[a][1];
        return choice;
    }
    public String getG2Choice2(int a) {
        String choice = g2Choices[a][1];
        return choice;
    }
    public String getG3Choice2(int a) {
        String choice = g3Choices[a][1];
        return choice;
    }
    public String getG1Choice3(int a) {
        String choice = g1Choices[a][2];
        return choice;
    }
    public String getG2Choice3(int a) {
        String choice = g2Choices[a][2];
        return choice;
    }
    public String getG3Choice3(int a) {
        String choice = g3Choices[a][2];
        return choice;
    }
    public String getG1Choice4(int a) {
        String choice = g1Choices[a][3];
        return choice;
    }
    public String getG2Choice4(int a) {
        String choice = g2Choices[a][3];
        return choice;
    }
    public String getG3Choice4(int a) {
        String choice = g3Choices[a][3];
        return choice;
    }
    public String getG1CorrectAnswer(int a) {
        String answer = g1CorrectAnswer[a];
        return answer;
    }
    public String getG2CorrectAnswer(int a) {
        String answer = g2CorrectAnswer[a];
        return answer;
    }
    public String getG3CorrectAnswer(int a) {
        String answer = g3CorrectAnswer[a];
        return answer;
    }
    public String getG1Solution(int a) {
        String solution = g1Solutions[a];
        return solution;
    }
    public String getG2Solution(int a) {
        String solution = g2Solutions[a];
        return solution;
    }
    public String getG3Solution(int a) {
        String solution = g3Solutions[a];
        return solution;
    }
    public String getG1SolAnswer(int a) {
        String solAnswer = g1SolAnswers[a];
        return solAnswer;
    }
    public String getG2SolAnswer(int a) {
        String solAnswer = g2SolAnswers[a];
        return solAnswer;
    }
    public String getG3SolAnswer(int a) {
        String solAnswer = g3SolAnswers[a];
        return solAnswer;
    }
}
