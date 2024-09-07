package com.enverzo.probquest.ui.tests.topicseven;

public class TopicSevenQuestion {
    //Pre Test
    public String g1PreTestQuestions[] = {
            "In how many ways can Mang Boy arrange 6 potted plants in a row",
            "In how many ways can seven mathematics books be arranged on a shelf?",
            "A test has 5 questions which a student may answer in any order. In how many different orders can a student answer these questions?",
            "In how many ways can 4 teachers be arranged on a picture taking?",
            "In how many ways may a school principal assign 5 students to undergo student leadership training?"
    };
    public String g2PreTestQuestions[] = {
            "In how many different ways can 10 customers line up to buy pizza in Greenwich?",
            "How many ways can the letters of the word FAITH be arranged?",
            "How many permutations are there in the letters of the word SMART?",
            "In how many ways can 3 different bicycles be arranged in a parking lot?",
            "There are five finalists at Mutya ng Asingan Beauty Pageant. In how many ways can they be arranged to answer the Q and A?",
    };
    public String g3PreTestQuestions[] = {
            "How many permutations can be made for 6 different books on a shelf that can accommodate exactly these 6 books?",
            "How many ways can 5 students be seated in a row of 5 chairs?",
            "In how many ways can 2 students, 3 teachers, and 4 parents be arranged in a single line?",
            "In how many ways can 1 Algebra book, 2 Calculus books, 3 Geometry books, and 4 Trigonometry books be arranged on a shelf?",
            "A couple with four children is to pose for a family picture. In how many ways can they be arranged in a row if they can take any position?"
    };
    public String g1PreTestChoices[][] = {
            {"810", "720", "540", "330"},
            {"5,040", "3,410", "320", "160"},
            {"80", "95", "120", "145"},
            {"64", "48", "36", "24"},
            {"120", "230", "270", "310"}
    };
    public String g2PreTestChoices[][] = {
            {"1","10 × 10!","10!","100"},
            {"250","120","90","80"},
            {"5","20","120","720"},
            {"26","18","12","6"},
            {"54","110","120","340"}
    };
    public String g3PreTestChoices[][] = {
            {"12","36","120","720"},
            {"8","16","24","10"},
            {"9","2 × 4 × 4","9!","2! × 3! × 4!"},
            {"1 × 2 × 3 × 4","1! × 2! × 3! × 4!","10!","10"},
            {"5,040","720","120","10"}
    };
    public String g1PreTestAnswer[] = {
            "720", "5,040", "120", "24", "120"
    };
    public String g2PreTestAnswer[] = {
            "10!", "120", "120", "6", "120"
    };
    public String g3PreTestAnswer[] = {
            "720", "24", "9!", "10!", "720"
    };
    public String g1PreTestSolution[] = {
            "{}_6P_6 = 6! = 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 720 \\text{ ways}",
            "{}_7P_7 = 7! = 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 5,040 \\text{ ways}",
            "{}_5P_5 = 5! = 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 120 \\text{ ways}",
            "{}_4P_4 = 4! = 4 \\cdot 3 \\cdot 2 \\cdot 1 = 24 \\text{ ways}",
            "{}_5P_5 = 5! = 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 120 \\text{ ways}",
    };
    public String g2PreTestSolution[] = {
            "{}_{10}P_{10} = 10! = 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 362,880 \\text{ ways}",
            "{}_5P_5 = 5! = 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 120 \\text{ ways}",
            "{}_5P_5 = 5! = 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 120 \\text{ ways}",
            "{}_3P_3 = 3! = 3 \\cdot 2 \\cdot 1 = 6 \\text{ ways}",
            "{}_5P_5 = 5! = 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 120 \\text{ ways}"
    };
    public String g3PreTestSolution[] = {
            "{}_6P_6 = 6! = 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 720 \\text{ ways}",
            "{}_4P_4 = 4! = 4 \\cdot 3 \\cdot 2 \\cdot 1 = 24 \\text{ ways}",
            "{}_9P_9 = 9! \\text{ ways}",
            "{}_{10}P_{10} = 10! = 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 362,880 \\text{ ways}",
            "{}_6P_6 = 6! = 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 720 \\text{ ways}"
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
        String answer = g1PreTestAnswer[a];
        return answer;
    }
    public String getG2PreTestAnswer(int a) {
        String answer = g2PreTestAnswer[a];
        return answer;
    }
    public String getG3PreTestAnswer(int a) {
        String answer = g3PreTestAnswer[a];
        return answer;
    }
    public String getG1PreTestSolution(int a) {
        String solution = g1PreTestSolution[a];
        return solution;
    }
    public String getG2PreTestSolution(int a) {
        String solution = g2PreTestSolution[a];
        return solution;
    }
    public String getG3PreTestSolution(int a) {
        String solution = g3PreTestSolution[a];
        return solution;
    }

    //Post Test
    public String t7G1PostTestQuestions[] = {
            "In how many ways can Mang Boy arrange 4 potted plants in a row",
            "In how many ways can 5 Calculus books be arranged on a shelf?",
            "A test has 9 questions which a student may answer in any order. In how many different orders can a student answer these questions?",
            "How many permutations are there in the letters of the word COURAGE?",
            "How many ways can the letters of the word MAPEH be arranged?"
    };
    public String t7G2PostTestQuestions[] = {
            "In how many ways can 6 teachers be arranged on a picture taking?",
            "In how many ways may a school principal assign 7 students to undergo student leadership training?",
            "In how many different ways can 6 customers line up to buy pizza in Greenwich?",
            "In how many ways can 11 different bicycles be arranged in a parking lot?",
            "There are 10 finalists at Mutya ng Asingan Beauty Pageant. In how many ways can they be arranged to answer the Q and A?",
    };
    public String t7G3PostTestQuestions[] = {
            "How many permutations can be made for 6 different books on a shelf that can accommodate exactly these 6 books?",
            "How many ways can 5 students be seated in a row of 5 chairs?",
            "In how many ways can 2 students, 3 teachers, and 4 parents be arranged in a single line?",
            "In how many ways can 1 Algebra book, 2 Calculus books, 3 Geometry books, and 4 Trigonometry books be arranged on a shelf?",
            "A couple with four children are to pose for a family picture. In how many ways can they be arranged in a row if they can take any position?"
    };
    public String t7G1PostTestChoices[][] = {
            {"24", "48", "64", "120"},
            {"120", "140", "170", "180"},
            {"430,120", "401,200", "362,880", "542,020"},
            {"8,340", "2,420", "8,320", "5,040"},
            {"340","240","120","100"}
    };
    public String t7G2PostTestChoices[][] = {
            {"560", "720", "740", "780"},
            {"6,700", "6,200", "54,120", "5,040"},
            {"720","340","320","240"},
            {"11!", "11", "10!", "11 × 2!"},
            {"5,650,120","3,628,800","821,300","720"}
    };
    public String t7G3PostTestChoices[][] = {
            {"12","36","120","720"},
            {"80","160","120","100"},
            {"9","2 × 4 × 4","9!","2! × 3! × 4!"},
            {"1 × 2 × 3 × 4","1! × 2! × 3! × 4!","10!","10"},
            {"5,040","720","120","10"}
    };
    public String t7G1PostTestAnswer[] = {
            "24", "120", "362,880", "5,040", "120"
    };
    public String t7G2PostTestAnswer[] = {
            "720", "5,040", "720", "11!", "3,628,800"
    };
    public String t7G3PostTestAnswer[] = {
            "720", "120", "9!", "10!", "720"
    };
    public String t7G1PostTestSolutions[] = {
            "{}_4P_4 = 4! = 4 × 3 × 2 × 1\\\\= 24 \\text{ ways}",
            "{}_5P_5 = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120 \\text{ ways}",
            "{}_9P_9 = 9! = 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 362,880 \\text{ ways}",
            "{}_7P_7 = 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 5,040 \\text{ ways}",
            "{}_5P_5 = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120 \\text{ ways}"
    };
    public String t7G2PostTestSolutions[] = {
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_7P_7 = 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 5,040 \\text{ ways}",
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_{11}P_{11} = 11! \\text{ ways}",
            "{}_{10}P_{10} = 10! = 10 × 9 × 8 × 7 × 6 × 5\\\\× 4 × 3 × 2 × 1 = 3,628,800 \\text{ ways}"
    };
    public String t7G3PostTestSolutions[] = {
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_5P_5 = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120 \\text{ ways}",
            "{}_9P_9 = 9! \\text{ ways}",
            "{}_{10}P_{10} = 10! = 10 × 9 × 8 × 7 × 6 × 5\\\\× 4 × 3 × 2 × 1 = 3,628,800 \\text{ ways}",
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}"
    };

    public String getG1PostTestQuestion(int a) {
        String question = t7G1PostTestQuestions[a];
        return question;
    }
    public String getG2PostTestQuestion(int a) {
        String question = t7G2PostTestQuestions[a];
        return question;
    }
    public String getG3PostTestQuestion(int a) {
        String question = t7G3PostTestQuestions[a];
        return question;
    }
    public String getG1PostTestChoice1(int a) {
        String choice = t7G1PostTestChoices[a][0];
        return choice;
    }
    public String getG2PostTestChoice1(int a) {
        String choice = t7G2PostTestChoices[a][0];
        return choice;
    }
    public String getG3PostTestChoice1(int a) {
        String choice = t7G3PostTestChoices[a][0];
        return choice;
    }
    public String getG1PostTestChoice2(int a) {
        String choice = t7G1PostTestChoices[a][1];
        return choice;
    }
    public String getG2PostTestChoice2(int a) {
        String choice = t7G2PostTestChoices[a][1];
        return choice;
    }
    public String getG3PostTestChoice2(int a) {
        String choice = t7G3PostTestChoices[a][1];
        return choice;
    }
    public String getG1PostTestChoice3(int a) {
        String choice = t7G1PostTestChoices[a][2];
        return choice;
    }
    public String getG2PostTestChoice3(int a) {
        String choice = t7G2PostTestChoices[a][2];
        return choice;
    }
    public String getG3PostTestChoice3(int a) {
        String choice = t7G3PostTestChoices[a][2];
        return choice;
    }
    public String getG1PostTestChoice4(int a) {
        String choice = t7G1PostTestChoices[a][3];
        return choice;
    }
    public String getG2PostTestChoice4(int a) {
        String choice = t7G2PostTestChoices[a][3];
        return choice;
    }
    public String getG3PostTestChoice4(int a) {
        String choice = t7G3PostTestChoices[a][3];
        return choice;
    }
    public String getG1PostTestAnswer(int a) {
        String answer = t7G1PostTestAnswer[a];
        return answer;
    }
    public String getG2PostTestAnswer(int a) {
        String answer = t7G2PostTestAnswer[a];
        return answer;
    }
    public String getG3PostTestAnswer(int a) {
        String answer = t7G3PostTestAnswer[a];
        return answer;
    }
    public String getG1PostTestSolution(int a) {
        String solution = t7G1PostTestSolutions[a];
        return solution;
    }
    public String getG2PostTestSolution(int a) {
        String solution = t7G2PostTestSolutions[a];
        return solution;
    }
    public String getG3PostTestSolution(int a) {
        String solution = t7G3PostTestSolutions[a];
        return solution;
    }
}
