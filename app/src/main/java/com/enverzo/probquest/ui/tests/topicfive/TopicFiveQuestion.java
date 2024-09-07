package com.enverzo.probquest.ui.tests.topicfive;

public class TopicFiveQuestion {


//Pre-test

    public String g1PreTestQuestions[] = {
            "A die and coin are tossed. What is the probability of getting a 6 and a tail?",
            "You roll a fair die twice. What is the probability of rolling a 3 on the first roll and an even number on the second roll?",
            "A die is rolled three times. What is the probability all results are number greater than 3?",
            "A green die and red die are tossed. What is the probability that a “4” shows on the green and a “5” shows on the red die?",
            "A spinner below is divided into equal parts. Find the probability that you get 150 on your first spin and 25 on the second spin."
    };

    public String g2PreTestQuestions[] = {
            "Two dice are rolled. What is the probability that a number 1 is rolled on the first die and a factor of 6 is rolled on the second die?",
            "A die is tossed once and a spinner with 8 congruent sectors each of which is numbered from 1 to 8 is spun once? What is the probability of an odd number turning up and the spinner stops at an even number?",
            "You randomly select two marbles from a bag that contains 15 green, 6 blue, and 9 red marbles. What is the probability that the first marble is green and the second marble is not green if you replace the first marble before selecting the second?",
            "Each of the eight congruent sectors of a spinner is labeled with the letters A,B,C,D, E, F, G, and H. What is the probability that the spinner stops at consonants if it spun twice?",
            "What is the probability of drawing two queens from a deck of cards if the first card is replaced before the second is drawn?"
    };

    public String g3PreTestQuestions[] = {
            "A card is drawn from a standard deck of cards. Then the card is replaced, the card is reshuffled, and a second card is drawn. What is the probability of a 5 on the first draw and a 6 on the second?",
            "A jar contains 4 red balls and 1 yellow ball. A ball is drawn from the jar and returned before the next draw. What is the probability of drawing 3 red balls?",
            "You flip a fair coin and pick 1 card out of a hat containing 20 cards numbered 1 - 20. What is the probability of getting heads on the coin and a number greater than 15 from the hat?",
            "From a standard deck of cards, what is the probability of choosing a red and then a spade with replacement?",
            "A die is tossed twice. What is the probability of getting a 2 or 3 on the first toss and a 4, 5, or 6 on the second toss?"
    };
    public String g1PreTestChoices[][] = {
            {"1/12","5/12","7/12","11/12"},
            {"11/12","7/12","5/12","1/12"},
            {"1/2","1/10","1/8","1/6"},
            {"11/36","7/36","5/36","1/36"},
            {"11/36","9/32","5/32","1/32"}
    };
    public String g2PreTestChoices[][] = {
            {"7/9","5/9","3/9","1/9"},
            {"1/8","1/6","1/4","1/2"},
            {"9/30","3/4","1/4","1/2"},
            {"11/16","9/16","7/16","5/16"},
            {"8/169","4/169","2/169","1/169"}
    };
    public String g3PreTestChoices[][] = {
            {"1/169","3/149","5/129","7/109"},
            {"84/95","74/115","64/125","54/135"},
            {"1/8","1/6","1/4","1/3"},
            {"1/12","1/8","1/6","1/4"},
            {"11/12","5/6","4/5","3/4"}
    };
    public String g1PreTestAnswers[] = {
            "1/12", "1/12", "1/8", "1/36", "1/32"
    };
    public String g2PreTestAnswers[] = {
            "1/9", "1/4", "1/4", "9/16", "1/169"
    };
    public String g3PreTestAnswers[] = {
            "1/169","64/125","1/8","1/8","5/6"
    };

    public String[] g1PreTestSolutions= {
            "\\frac{1}{6} \\times \\frac{3}{6} = \\frac{1}{12}",
            "\\frac{1}{6} \\times \\frac{3}{6} = \\frac{1}{12}",
            "\\frac{3}{6} \\times \\frac{3}{6} \\times \\frac{3}{6} = \\frac{1}{8}",
            "\\frac{1}{6} \\times \\frac{1}{6} = \\frac{1}{36}",
            "\\frac{1}{8} \\times \\frac{2}{8} = \\frac{1}{32}"
    };

    public String[] g2PreTestSolutions= {
            "\\frac{1}{6} \\times \\frac{4}{6} = \\frac{1}{9}",
            "\\frac{3}{6} \\times \\frac{4}{8} = \\frac{1}{4}",
            "\\frac{15}{30} \\times \\frac{15}{30} = \\frac{1}{4}",
            "\\frac{6}{8} \\times \\frac{6}{8} = \\frac{9}{16}",
            "\\frac{4}{52} \\times \\frac{4}{52} = \\frac{1}{169}"
    };

    public String[] g3PreTestSolutions= {
            "\\frac{4}{52} \\times \\frac{4}{52} = \\frac{1}{169}",
            "\\frac{4}{5} \\times \\frac{4}{5} \\times \\frac{4}{5} = \\frac{64}{125}",
            "\\frac{1}{2} \\times \\frac{5}{20} = \\frac{1}{8}",
            "\\frac{26}{52} \\times \\frac{13}{52} = \\frac{1}{8}",
            "(\\frac{1}{6} + \\frac{1}{6}) \\times (\\frac{1}{6} + \\frac{1}{6} + \\frac{1}{6}) \\\\ = \\frac{5}{6}"
    };

    public String getG1PreTestQuestion(int a) {
        String question = g1PreTestQuestions[a];
        return question;
    }
    public String getG2PreTestQuestion(int a) {
        String question = g2PreTestQuestions[a];
        return question;
    }
    public String getG3PreTestQuestion(int a) {
        String question = g3PreTestQuestions[a];
        return question;
    }
    public String getG1PreTestChoice1(int a) {
        String choice = g1PreTestChoices[a][0];
        return choice;
    }
    public String getG2PreTestChoice1(int a) {
        String choice = g2PreTestChoices[a][0];
        return choice;
    }
    public String getG3PreTestChoice1(int a) {
        String choice = g3PreTestChoices[a][0];
        return choice;
    }
    public String getG1PreTestChoice2(int a) {
        String choice = g1PreTestChoices[a][1];
        return choice;
    }
    public String getG2PreTestChoice2(int a) {
        String choice = g2PreTestChoices[a][1];
        return choice;
    }
    public String getG3PreTestChoice2(int a) {
        String choice = g3PreTestChoices[a][1];
        return choice;
    }
    public String getG1PreTestChoice3(int a) {
        String choice = g1PreTestChoices[a][2];
        return choice;
    }
    public String getG2PreTestChoice3(int a) {
        String choice = g2PreTestChoices[a][2];
        return choice;
    }
    public String getG3PreTestChoice3(int a) {
        String choice = g3PreTestChoices[a][2];
        return choice;
    }
    public String getG1PreTestChoice4(int a) {
        String choice = g1PreTestChoices[a][3];
        return choice;
    }
    public String getG2PreTestChoice4(int a) {
        String choice = g2PreTestChoices[a][3];
        return choice;
    }
    public String getG3PreTestChoice4(int a) {
        String choice = g3PreTestChoices[a][3];
        return choice;
    }
    public String getG1PreTestAnswer(int a) {
        String answer = g1PreTestAnswers[a];
        return answer;
    }
    public String getG2PreTestAnswer(int a) {
        String answer = g2PreTestAnswers[a];
        return answer;
    }
    public String getG3PreTestAnswer(int a) {
        String answer = g3PreTestAnswers[a];
        return answer;
    }
    public String getG1PreTestSolution(int a) {
        String solution = g1PreTestSolutions[a];
        return solution;
    }
    public String getG2PreTestSolution(int a) {
        String solution = g2PreTestSolutions[a];
        return solution;
    }
    public String getG3PreTestSolution(int a) {
        String solution = g3PreTestSolutions[a];
        return solution;
    }

// Post-test

    public String g1PostTestQuestions[] = {
            "A die and coin are tossed. What is the probability of getting a “2” and a head?",
            "You roll a fair die twice. What is the probability of rolling a “4” on the first roll and an even number on the second roll?",
            "A die is rolled three times. What is the probability all results are number greater than 4?",
            "A green die and red die are tossed. What is the probability that a “4” shows on the green and an “odd number” shows on the red die?",
            "A spinner below is divided into equal parts. Find the probability that you get 150 on your first spin and 10 on the second spin."
    };

    public String g2PostTestQuestions[] = {
            "Two dice are rolled. What is the probability that a number “2” is rolled on the first die and a factor of 6 is rolled on the second die?",
            "A die is tossed once and a spinner with 8 congruent sectors each of which is numbered from 1 to 8 is spun once? What is the probability of an even number turning up and the spinner stops at an odd number?",
            "You randomly select two marbles from a bag that contains 12 green, 8 brown, and 10 red marbles. What is the probability that the first marble is brown and the second marble is not brown if you replace the first marble before selecting the second?",
            "Each of the eight congruent sectors of a spinner is labeled with the letters A,B,C,D, E, F, G, and H. What is the probability that the spinner stops at consonants if it spun twice?",
            "What is the probability of drawing two aces from a deck of cards if the first card is replaced before the second is drawn?"
    };

    public String g3PostTestQuestions[] = {
            "A card is drawn from a deck of cards. Then the card is replaced, the card is reshuffled, and a second card is drawn. What is the probability of a “5” on the first draw and a “6” on the second?",
            "A jar contains 4 red balls and 2 yellow ball. A ball is drawn from the jar and returned before the next draw. What is the probability of drawing 3 red balls?",
            "You flip a fair coin and pick one card out of a hat containing 20 cards numbered 1 - 20. What is the probability of getting heads on the coin and a number greater than 10 from the hat?",
            "From a standard deck of cards, what is the probability of choosing a red and then a diamond with replacement?",
            "A die is tossed twice. What is the probability of getting a 2 or 3 on the first toss and a 4, 5, or 6 on the second toss?"
    };

    public String g1PostTestChoices[][] = {
            {"11/12","7/12","5/12","1/12"},
            {"5/12","1/12","5/8","1/8"},
            {"1/27","1/9","1/8","1/6"},
            {"5/8","3/8","5/12","1/12"},
            {"1/64","1/32","1/16","1/8"}
    };
    public String g2PostTestChoices[][] = {
            {"7/9","5/9","4/9","1/9"},
            {"1/8","1/6","1/4","1/2"},
            {"44/225","21/115","11/45","1/15"},
            {"11/16","9/16","7/16","5/16"},
            {"1/169","20/169","42/169","52/169"}
    };
    public String g3PostTestChoices[][] = {
            {"1/169","4/139","7/119","9/89"},
            {"15/47","14/47","13/27","8/27"},
            {"1/8","1/6","1/4","1/3"},
            {"1/12","1/8","1/6","1/4"},
            {"8/11","5/11","5/6","1/6"}
    };
    public String g1PostTestAnswers[] = {
            "1/12", "1/12", "1/27", "1/12", "1/32"
    };
    public String g2PostTestAnswers[] = {
            "1/9", "1/4", "44/225", "9/16", "1/169"
    };
    public String g3PostTestAnswers[] = {
            "1/169","8/27","1/4","1/8","5/6"
    };

    public String[] g1PostTestSolutions= {
            "\\frac{1}{6} \\times \\frac{1}{2} = \\frac{1}{12}",
            "\\frac{1}{6} \\times \\frac{3}{6} = \\frac{1}{12}",
            "\\frac{2}{6} \\times \\frac{2}{6} \\times \\frac{2}{6} = \\frac{1}{27}",
            "\\frac{1}{6} \\times \\frac{3}{6} = \\frac{1}{12}",
            "\\frac{1}{8} \\times \\frac{2}{8} = \\frac{1}{32}"
    };

    public String[] g2PostTestSolutions= {
            "\\frac{1}{6} \\times \\frac{4}{6} = \\frac{1}{9}",
            "\\frac{3}{6} \\times \\frac{4}{8} = \\frac{1}{4}",
            "\\frac{8}{30} \\times \\frac{22}{30} = \\frac{44}{225}",
            "\\frac{6}{8} \\times \\frac{6}{8} = \\frac{9}{16}",
            "\\frac{4}{52} \\times \\frac{4}{52} = \\frac{1}{169}"
    };

    public String[] g3PostTestSolutions= {
            "\\frac{4}{52} \\times \\frac{4}{52} = \\frac{1}{169}",
            "\\frac{4}{6} \\times \\frac{4}{6} \\times \\frac{4}{6} = \\frac{8}{27}",
            "\\frac{1}{2} \\times \\frac{10}{20} = \\frac{1}{4}",
            "\\frac{26}{52} \\times \\frac{13}{52} = \\frac{1}{8}",
            "(\\frac{1}{6} + \\frac{1}{6}) \\times (\\frac{1}{6} + \\frac{1}{6} + \\frac{1}{6}) \\\\ = \\frac{5}{6}"
    };

    public String getG1PostTestQuestion(int a) {
        String question = g1PostTestQuestions[a];
        return question;
    }
    public String getG2PostTestQuestion(int a) {
        String question = g2PostTestQuestions[a];
        return question;
    }
    public String getG3PostTestQuestion(int a) {
        String question = g3PostTestQuestions[a];
        return question;
    }
    public String getG1PostTestChoice1(int a) {
        String choice = g1PostTestChoices[a][0];
        return choice;
    }
    public String getG2PostTestChoice1(int a) {
        String choice = g2PostTestChoices[a][0];
        return choice;
    }
    public String getG3PostTestChoice1(int a) {
        String choice = g3PostTestChoices[a][0];
        return choice;
    }
    public String getG1PostTestChoice2(int a) {
        String choice = g1PostTestChoices[a][1];
        return choice;
    }
    public String getG2PostTestChoice2(int a) {
        String choice = g2PostTestChoices[a][1];
        return choice;
    }
    public String getG3PostTestChoice2(int a) {
        String choice = g3PostTestChoices[a][1];
        return choice;
    }
    public String getG1PostTestChoice3(int a) {
        String choice = g1PostTestChoices[a][2];
        return choice;
    }
    public String getG2PostTestChoice3(int a) {
        String choice = g2PostTestChoices[a][2];
        return choice;
    }
    public String getG3PostTestChoice3(int a) {
        String choice = g3PostTestChoices[a][2];
        return choice;
    }
    public String getG1PostTestChoice4(int a) {
        String choice = g1PostTestChoices[a][3];
        return choice;
    }
    public String getG2PostTestChoice4(int a) {
        String choice = g2PostTestChoices[a][3];
        return choice;
    }
    public String getG3PostTestChoice4(int a) {
        String choice = g3PostTestChoices[a][3];
        return choice;
    }
    public String getG1PostTestAnswer(int a) {
        String answer = g1PostTestAnswers[a];
        return answer;
    }
    public String getG2PostTestAnswer(int a) {
        String answer = g2PostTestAnswers[a];
        return answer;
    }
    public String getG3PostTestAnswer(int a) {
        String answer = g3PostTestAnswers[a];
        return answer;
    }
    public String getG1PostTestSolution(int a) {
        String solution = g1PostTestSolutions[a];
        return solution;
    }
    public String getG2PostTestSolution(int a) {
        String solution = g2PostTestSolutions[a];
        return solution;
    }
    public String getG3PostTestSolution(int a) {
        String solution = g3PostTestSolutions[a];
        return solution;
    }
}
