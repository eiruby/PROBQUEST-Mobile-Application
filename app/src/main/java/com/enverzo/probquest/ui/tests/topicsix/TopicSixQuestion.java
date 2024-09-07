package com.enverzo.probquest.ui.tests.topicsix;

public class TopicSixQuestion {

//Pre-test

    public String[] g1PreTestQuestions= {
            "There are five glasses of orange juice and four glasses of red wine on the counter. Paul drinks two of them at random. What is the probability that he drank two glasses of orange juice?",
            "There are 5 red socks and 11 pink socks in a drawer. If one sock is taken out without looking and then a second is taken out, what is the probability that they both will be pink?",
            "A jar contains five white balls and two black balls. Two balls are drawn at random from the jar, one at a time without replacement. What is the probability that the first drawn ball is white and the second ball is black?",
            "A box of chocolates contains 5 milk chocolates, 8 dark chocolates, and 12 white chocolates. Iya randomly chooses a chocolate, eats it, and then randomly chooses another chocolate. What is the probability that Iya chooses a milk chocolate and a dark chocolate?",
            "Mrs. Cruz has to select two students from 35 girls and 15 boys to be part of the club. What is the probability that both students are girls?"
    };

    public String[] g2PreTestQuestions= {
            "A box contains 10 gray caps and 18 black caps. A cap is taken, not replaced, and then a second cap is taken. What is the probability of taking out a gray cap followed by a black cap?",
            "A box contains 5 yellow marbles and 7 red marbles. What is the probability of drawing 2 yellow marbles and 1 red marble in succession without replacement?",
            "Two cards are selected at random from a standard deck. What is the probability that the first card is an 8 and the second card is a queen if the first card is not replaced before the second is selected?",
            "There are 10 marbles in the box, 3 are blue and 7 are green. If we randomly selected two marbles from this box, what is the probability of drawing a green marble and then a blue marble without replacement?",
            "A class is composed of 12 boys and 13 girls. If two presenters to a poem recital are to be chosen in succession, what is the probability that the first is a boy and the second is a girl?"
    };

    public String[] g3PreTestQuestions= {
            "From a standard deck of cards, what is the probability of choosing a diamond, then a heart, then a black card without replacement?",
            "A box contains 3 brown marbles and 7 green marbles. What is the probability of drawing 3 green marbles without replacement?",
            "Two cards are drawn from a 52 deck of cards. What is the probability of drawing a king first followed by 8 if the first card is not replaced?",
            "Two cards are drawn at random from an ordinary deck of cards. What is the probability that all cards are black if no replacement is done?",
            "On a game show, a contestant is given four distinct digits to arrange in proper order to win a car. What is the probability of winning if the contestant guesses the position of each digit?"
    };

    public String[] g1PreTestAnswers= {
            "5/18","11/48","5/21","1/15","17/35"
    };

    public String[] g2PreTestAnswers= {
            "5/21","7/66","4/663","7/30","13/50"
    };

    public String[] g3PreTestAnswers= {
            "169/5100","7/24","4/663","25/102","0.24"
    };

    public String[][] g1PreTestChoices= {
            {"5/18","7/18","11/18","17/18"},
            {"9/24","11/48","21/51","27/52"},
            {"14/21","13/21","5/21","4/21"},
            {"1/15","3/16","4/19","6/21"},
            {"17/55","17/45","17/35","17/25"}
    };

    public String[][] g2PreTestChoices= {
            {"5/21","8/21","11/21","19/21"},
            {"12/33","7/66","5/33","1/33"},
            {"8/241","23/41","8/663","4/663"},
            {"7/30","13/30","17/30","23/30"},
            {"9/50","11/50","13/50","17/50"}
    };

    public String[][] g3PreTestChoices= {
            {"229/5100","169/5100","119/5100","89/5100"},
            {"15/54","13/44","9/34","7/24"},
            {"10/979","8/883","7/863","4/663"},
            {"27/106","25/102","23/100","21/94"},
            {"0.042","0.42","0.24","0.024"}
    };

    public String[] g1PreTestSolutions= {
            "\\frac{5}{9} \\times \\frac{4}{8} = \\frac{5}{18}",
            "\\frac{11}{16} \\times \\frac{10}{15} = \\frac{11}{48}",
            "\\frac{5}{7} \\times \\frac{2}{6} = \\frac{5}{21}",
            "\\frac{5}{25} \\times \\frac{8}{24} = \\frac{1}{15}",
            "\\frac{35}{50} \\times \\frac{34}{49} = \\frac{17}35}"
    };

    public String[] g2PreTestSolutions= {
            "\\frac{10}{28} \\times \\frac{18}{27} = \\frac{5}{21}",
            "\\frac{5}{12} \\times \\frac{4}{11} \\times \\frac{7}{10} = \\frac{7}{66}",
            "\\frac{4}{52} \\times \\frac{4}{51} = \\frac{4}{663}",
            "\\frac{7}{10} \\times \\frac{3}{9} = \\frac{7}{30}",
            "\\frac{12}{25} \\times \\frac{13}{24} = \\frac{13}{50}"
    };

    public String[] g3PreTestSolutions= {
            "\\frac{13}{52} \\times \\frac{13}{51} = \\frac{169}{5100}",
            "\\frac{7}{10} \\times \\frac{6}{9} \\times \\frac{5}{8} = \\frac{7}{24}",
            "\\frac{4}{52} \\times \\frac{4}{51} = \\frac{4}{663}",
            "\\frac{26}{52} \\times \\frac{25}{51} = \\frac{25}{102}",
            "\\frac{1}{4} \\times \\frac{1}{3} \\times \\frac{1}{2} \\times \\frac{1}{1} \\\\ = \\frac{1}{24} = 0.24"
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

    public String[] g1PostTestQuestions= {
            "There are ten glasses of orange juice and four glasses of red wine on the counter. Oliver drinks two of them at random. What is the probability that he drank two glasses of orange juice?",
            "There are 6 red socks and 10 pink socks in a drawer. If one sock is taken out without looking and then a second is taken out, what is the probability that they both will be pink?",
            "A box contains 6 black marbles and 5 red marbles. What is the probability of drawing 2 black marbles and 1 red marble in succession without replacement?",
            "A box of chocolates contains 5 milk chocolates, 8 dark chocolates, and 12 white chocolates. Iya randomly chooses a chocolate, eats it, and then randomly chooses another chocolate. What is the probability that Iya will choose a dark chocolate and a white chocolate?",
            "Mrs. Cruz has to select two students from 25 boys and 10 girls to be part of the club. What is the probability that both students are girls?"
    };

    public String[] g2PostTestQuestions= {
            "A box contains 12 gray caps and 8 black caps. A cap is taken, not replaced, and then a second cap is taken. What is the probability of taking out a gray cap followed by a black cap?",
            "A jar contains six white balls and four black balls. Two balls are drawn at random from the jar, one at a time without replacement. What is the probability that the first drawn ball is white and the second ball is black?",
            "Two cards are selected at random from a standard deck. What is the probability that the first card is a 7 and the second card is a king if the first card is not replaced before the second is selected?",
            "There are 10 marbles in the box, 2 are blue and 8 are green. If we randomly selected two marbles from this box, what is the probability of drawing a blue marble and then a green marble without replacement?",
            "A class is composed of 11 boys and 14 girls. If two presenters to a poem recital are to be chosen in succession, what is the probability that the first is a boy and the second is a girl?"
    };

    public String[] g3PostTestQuestions= {
            "From a standard deck of cards, what is the probability of choosing a diamond, then a heart, then a black card without replacement?",
            "A box contains 3 brown marbles and 7 green marbles. What is the probability of drawing 3 brown marbles without replacement?",
            "Two cards are drawn from a 52 deck of cards. What is the probability of drawing a king first followed by 8 if the first card is not replaced?",
            "Two cards are drawn at random from an ordinary deck of cards. What is the probability that all cards are red if no replacement is done?",
            "On a game show, a contestant is given four distinct digits to arrange in proper order to win a car. What is the probability of winning if the contestant guesses the position of each digit?"
    };

    public String[] g1PostTestAnswers= {
            "45/91","3/8","5/33","4/25","9/119"
    };

    public String[] g2PostTestAnswers= {
            "24/95","4/15","4/663","8/45","77/300"
    };

    public String[] g3PostTestAnswers= {
            "169/5100","1/120","4/663","25/102","0.24"
    };

    public String[][] g1PostTestChoices= {
            {"48/81","46/81","45/91","44/91"},
            {"1/4","3/8","10/11","16/21"},
            {"12/33","7/33","5/33","4/33"},
            {"2/15","3/20","4/25","5/32"},
            {"9/119","7/116","5/113","3/109"}
    };

    public String[][] g2PostTestChoices= {
            {"29/75","27/85","24/95","23/115"},
            {"14/33","13/27","9/20","4/15"},
            {"8/241","23/41","8/663","4/663"},
            {"8/45","13/45","17/45","19/45"},
            {"67/285","77/300","87/305","97/325"}
    };

    public String[][] g3PostTestChoices= {
            {"229/5100","169/5100","119/5100","89/5100"},
            {"6/125","4/123","3/122","1/120"},
            {"4/663","7/783","8/893","11/963"},
            {"27/106","25/102","23/100","21/94"},
            {"0.042","0.42","0.24","0.024"}
    };

    public String[] g1PostTestSolutions= {
            "\\frac{10}{14} \\times \\frac{9}{13} = \\frac{45}{91}",
            "\\frac{10}{16} \\times \\frac{9}{15} = \\frac{3}{8}",
            "\\frac{6}{11} \\times \\frac{5}{10} \\times \\frac{5}{9} = \\frac{5}{33}",
            "\\frac{8}{25} \\times \\frac{12}{24} = \\frac{4}{25}",
            "\\frac{10}{35} \\times \\frac{9}{34} = \\frac{9}{119}"
    };

    public String[] g2PostTestSolutions= {
            "\\frac{12}{20} \\times \\frac{8}{19} = \\frac{24}{95}",
            "\\frac{6}{10} \\times \\frac{4}{9} = \\frac{4}{15}",
            "\\frac{4}{52} \\times \\frac{4}{51} = \\frac{4}{663}",
            "\\frac{2}{10} \\times \\frac{8}{9} = \\frac{8}{45}",
            "\\frac{11}{25} \\times \\frac{14}{24} = \\frac{77}{300}"
    };

    public String[] g3PostTestSolutions= {
            "\\frac{13}{52} \\times \\frac{13}{51} \\times \\frac{25}{50} = \\frac{169}{5100}",
            "\\frac{3}{10} \\times \\frac{2}{9} \\times \\frac{1}{8} = \\frac{1}{120}",
            "\\frac{4}{52} \\times \\frac{4}{51} = \\frac{4}{663}",
            "\\frac{26}{52} \\times \\frac{25}{51} = \\frac{25}{102}",
            "\\frac{1}{4} \\times \\frac{1}{3} \\times \\frac{1}{2} \\times \\frac{1}{1} \\\\ = \\frac{1}{24} = 0.24"
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
