package com.enverzo.probquest.ui.tests.topictwelve;

public class TopicTwelveQuestion {
    //Pre Test
    public String g1Questions1[] = {
            "How many outfits are possible with 3 pairs of pants, 5 T-shirts, and 2 shoes?",
            "The Parent-Teacher Association will be electing new officers. There are 3 candidates for president, 4 candidates for vice-president, and 5 candidates for secretary. How many possible different combinations of officers are possible?",
            "The digits 2,4,5, and 6, are to be used to form a four-digit number. How many different numbers can be formed such that no digits can be used more than once?",
            "A coin is tossed four times. How many different outcomes are possible?",
            "How many three-digit numbers can you form using the digits 1,2,3,4,5, and 6 without repetition?"
    };
    public String g2Questions1[] = {
            "How many numbers greater than 50 000 can be formed from the digits 1,3,5,7, and 9 if repetition is allowed?",
            "A coin is tossed, and a die is rolled. How many outcomes are possible?",
            "A current license plate format in the Philippines consists of three letters followed by four numbers (e.g. ABC 1234). How many different license plates are possible?",
            "A multiple choice exam has 7 questions. Each question has four options: A, B, C, and D. How many different ways to answer the test?",
            "Suppose an experiment consists of tossing a coin three times. How many outcomes have at least 1 head?"
    };
    public String g3Questions1[] = {
            "","","","",""
    };
    public String g1Choices1[][] = {
            {"10","30","352","1,440"},
            {"20","50","60","80"},
            {"24","65","85","480"},
            {"8","16","36","64"},
            {"27","110","120","462"}
    };
    public String g2Choices1[][] = {
            {"1,115","1,180","1,675","1,875"},
            {"36","18","12","8"},
            {"175,760,000","6,760","700","260"},
            {"28","1,675","16,348","16,384"},
            {"7","12","16","20"}
    };
    public String g3Choices1[][] = {
            {"10","30","352","1,440"},
            {"20","50","60","80"},
            {"24","65","85","480"},
            {"8","16","36","64"},
            {"27","110","120","462"}
    };
    public String g1CorrectAnswer1[] = {
            "30","60","24","16","120"
    };
    public String g2CorrectAnswer1[] = {
            "1,875","12","175,760,000","16,384","7"
    };
    public String g3CorrectAnswer1[] = {
            "","","","",""
    };
    public String g1Solutions1[] = {
            "3 \\cdot 5 \\cdot 2 = 30",
            "3 \\cdot 4 \\cdot 5 =60",
            "4 \\cdot 3 \\cdot 2 \\cdot 1 = 24",
            "2 \\cdot 2 \\cdot 2 \\cdot 2 = 16",
            "6 \\cdot 5 \\cdot 4 = 120"
    };
    public String g2Solutions1[] = {
            "3 \\cdot 5 \\cdot 5 \\cdot 5 \\cdot 5 = 1,875",
            "2 \\cdot 6 = 12",
            "26 \\cdot 26 \\cdot 26 \\cdot 10 \\cdot 10 \\cdot 10 \\cdot 10 = 175,760,000",
            "4 \\cdot 4 \\cdot 4 \\cdot 4 \\cdot 4 \\cdot 4 \\cdot 4 = 16,384",
            "(2 \\cdot 2 \\cdot 2) - 1 = 8 - 1 = 7 \\\\ \\text{All outcomes except TTT have at least one head}"
    };
    public String g3Solutions1[] = {
            "","","","",""
    };

    public String getG1PreTestQuestion(int a) {
        String question = g1Questions1[a];
        return question;
    }
    public String getG2PreTestQuestion(int a) {
        String question = g2Questions1[a];
        return question;
    }
    public String getG3PreTestQuestion(int a) {
        String question = g3Questions1[a];
        return question;
    }
    public String getG1PreTestChoice1(int a) {
        String choice = g1Choices1[a][0];
        return choice;
    }
    public String getG2PreTestChoice1(int a) {
        String choice = g2Choices1[a][0];
        return choice;
    }
    public String getG3PreTestChoice1(int a) {
        String choice = g3Choices1[a][0];
        return choice;
    }
    public String getG1PreTestChoice2(int a) {
        String choice = g1Choices1[a][1];
        return choice;
    }
    public String getG2PreTestChoice2(int a) {
        String choice = g2Choices1[a][1];
        return choice;
    }
    public String getG3PreTestChoice2(int a) {
        String choice = g3Choices1[a][1];
        return choice;
    }
    public String getG1PreTestChoice3(int a) {
        String choice = g1Choices1[a][2];
        return choice;
    }
    public String getG2PreTestChoice3(int a) {
        String choice = g2Choices1[a][2];
        return choice;
    }
    public String getG3PreTestChoice3(int a) {
        String choice = g3Choices1[a][2];
        return choice;
    }
    public String getG1PreTestChoice4(int a) {
        String choice = g1Choices1[a][3];
        return choice;
    }
    public String getG2PreTestChoice4(int a) {
        String choice = g2Choices1[a][3];
        return choice;
    }
    public String getG3PreTestChoice4(int a) {
        String choice = g3Choices1[a][3];
        return choice;
    }
    public String getG1PreTestCorrectAnswer(int a) {
        String answer = g1CorrectAnswer1[a];
        return answer;
    }
    public String getG2PreTestCorrectAnswer(int a) {
        String answer = g2CorrectAnswer1[a];
        return answer;
    }
    public String getG3PreTestCorrectAnswer(int a) {
        String answer = g3CorrectAnswer1[a];
        return answer;
    }
    public String getG1PreTestSolution(int a) {
        String solution = g1Solutions1[a];
        return solution;
    }
    public String getG2PreTestSolution(int a) {
        String solution = g2Solutions1[a];
        return solution;
    }
    public String getG3PreTestSolution(int a) {
        String solution = g3Solutions1[a];
        return solution;
    }

    //Post Test
    public String g1Questions2[] = {
            "How many outfits are possible with 4 pairs of pants, 3 t-shirts, and 6 shoes?",
            "The Parent-Teacher Association will be electing new officers. There are 6 candidates for president, 3 candidates for vice-president, and 5 candidates for secretary. How many possible different combinations of officers are possible?",
            "The digits 1, 3, 6, 7, and 9, are to be used to form a five-digit number. How many different numbers can be formed such that no digits can be used more than once?",
            "A coin is tossed five times. How many different outcomes are possible?",
            "How many two-digit numbers can you form using the digits 1, 3, 4, 7, 8, and 9 without repetition?"
    };
    public String g2Questions2[] = {
            "How many numbers greater than 40 000 can be formed from the digits 1, 2, 3, 4, and 5 if repetition is allowed?",
            "A coin is tossed, and a die is rolled. How many outcomes are possible?",
            "A current license plate format in the Philippines consists of two letters followed by five numbers for motorcycles (e.g. AB 12345). How many different license plates are possible?",
            "A multiple choice exam has 8 questions. Each question has four options: A, B, C, and D. How many different ways to answer the test?",
            "Suppose an experiment consists of tossing a coin three times. How many outcomes have at least 2 heads?"
    };
    public String g3Questions2[] = {
            "","","","",""
    };
    public String g1Choices2[][] = {
            {"72","42","24","13"},
            {"14","90","120","150"},
            {"3,125","985","420","120"},
            {"58","36","32","10"},
            {"120","45","30","18"}
    };
    public String g2Choices2[][] = {
            {"1,250","1,176","1,676","1,776"},
            {"12","18","21","64"},
            {"97,840,000","87,610,000","67,600,000","47,660,000"},
            {"525","675","745","805"},
            {"7","12","16","20"}
    };
    public String g3Choices2[][] = {
            {"72","42","24","13"},
            {"14","90","120","150"},
            {"3,125","985","420","120"},
            {"58","36","32","10"},
            {"120","45","30","18"}
    };
    public String g1CorrectAnswer2[] = {
            "72","90","120","32","30"
    };
    public String g2CorrectAnswer2[] = {
            "1,250","12","67,600,000","525","7"
    };
    public String g3CorrectAnswer2[] = {
            "","","","",""
    };
    public String g1Solutions2[] = {
            "4 \\cdot 3 \\cdot 6 = 72",
            "6 \\cdot 3 \\cdot 5 = 90",
            "5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 120",
            "2 \\cdot 2 \\cdot 2 \\cdot 2 \\cdot 2 = 32",
            "6 \\cdot 5 = 30"
    };
    public String g2Solutions2[] = {
            "2 \\cdot 5 \\cdot 5 \\cdot 5 \\cdot 5 = 1,250",
            "2 \\cdot 6 = 12",
            "26 \\cdot 26 \\cdot 10 \\cdot 10 \\cdot 10 \\cdot 10 \\cdot 10 \\\\ = 67,600,000",
            "4 \\cdot 4 \\cdot 4 \\cdot 4 \\cdot 4 \\cdot 4 \\cdot 4 \\cdot 4 \\\\ = 4^8 = 65,536",
            "\\text{The possible outcomes with at least two\\\\heads are HHT, HTH, THH, and HHH.\\\\There are 4 possible outcomes}."
    };
    public String g3Solutions2[] = {
            "","","","",""
    };

    public String getG1PostTestQuestion(int a) {
        String question = g1Questions2[a];
        return question;
    }
    public String getG2PostTestQuestion(int a) {
        String question = g2Questions2[a];
        return question;
    }
    public String getG3PostTestQuestion(int a) {
        String question = g3Questions2[a];
        return question;
    }
    public String getG1PostTestChoice1(int a) {
        String choice = g1Choices2[a][0];
        return choice;
    }
    public String getG2PostTestChoice1(int a) {
        String choice = g2Choices2[a][0];
        return choice;
    }
    public String getG3PostTestChoice1(int a) {
        String choice = g3Choices2[a][0];
        return choice;
    }
    public String getG1PostTestChoice2(int a) {
        String choice = g1Choices2[a][1];
        return choice;
    }
    public String getG2PostTestChoice2(int a) {
        String choice = g2Choices2[a][1];
        return choice;
    }
    public String getG3PostTestChoice2(int a) {
        String choice = g3Choices2[a][1];
        return choice;
    }
    public String getG1PostTestChoice3(int a) {
        String choice = g1Choices2[a][2];
        return choice;
    }
    public String getG2PostTestChoice3(int a) {
        String choice = g2Choices2[a][2];
        return choice;
    }
    public String getG3PostTestChoice3(int a) {
        String choice = g3Choices2[a][2];
        return choice;
    }
    public String getG1PostTestChoice4(int a) {
        String choice = g1Choices2[a][3];
        return choice;
    }
    public String getG2PostTestChoice4(int a) {
        String choice = g2Choices2[a][3];
        return choice;
    }
    public String getG3PostTestChoice4(int a) {
        String choice = g3Choices2[a][3];
        return choice;
    }
    public String getG1PostTestCorrectAnswer(int a) {
        String answer = g1CorrectAnswer2[a];
        return answer;
    }
    public String getG2PostTestCorrectAnswer(int a) {
        String answer = g2CorrectAnswer2[a];
        return answer;
    }
    public String getG3PostTestCorrectAnswer(int a) {
        String answer = g3CorrectAnswer2[a];
        return answer;
    }
    public String getG1PostTestSolution(int a) {
        String solution = g1Solutions2[a];
        return solution;
    }
    public String getG2PostTestSolution(int a) {
        String solution = g2Solutions2[a];
        return solution;
    }
    public String getG3PostTestSolution(int a) {
        String solution = g3Solutions2[a];
        return solution;
    }
}
