package com.enverzo.probquest.ui.tests.topicten;

public class TopicTenQuestion {
    //Pre Test
    public String g1PreTestQuestions[] = {
            "How many different arrangements are possible for 9 cars in a line, if 2 are silver metallic, 3 are dark blue, and 4 are white pearl?",
            "Given the seven numbers, four 2’s, two 5’s, and one 6. What are the number of ways of arranging the seven numbers?",
            "How many different eight-digit numerals can be written using the digits 0, 0, 0, 2, 3, 3, 9, and 9?",
            "If a ship has only 12 flags, and 5 of them are alike, with which to send signals, how many different signals can be sent if all flags are used?",
            "A department store sells two same polo shirts, three same pairs of pants, four same rubber shoes, and one cap. How many different suits consisting of polo shirts, pairs of pants, rubber shoes, and a cap are possible?"
    };
    public String g2PreTestQuestions[] = {
            "How many unique passwords can be created using the letters in the word “passport”?",
            "How many ordered arrangements are there of the letters in the word PHILIPPINES?",
            "A music store wants to display 2 identical violins, 4 identical flutes, 2 identical drums, and 1 guitar in its store window. How many distinguishable displays are possible?",
            "During the mathematics quiz bee, three students are wearing green shirts, two are wearing violet shirts, five are wearing orange shirts, and one is wearing a gray shirt. If the students line up at the door of the venue, how many ways could the shirt colors be arranged?",
            "Ms. Mikee knows she used the letters in her name, and the numbers in her birthday, 2-22-88, to make her DepEd e-mail password, mixing them up to make it hard to guess. Unfortunately, she made it too hard to guess and forgot it. If the “reset password” option is unavailable, how many permutations might she need to guess?"
    };
    public String g1PreTestChoices[][] = {
            {"1,290", "1,260", "1,240", "1,220"},
            {"145", "125", "105", "95"},
            {"8,260", "6,180", "1,860", "1,680"},
            {"95,040", "95,400", "94,500", "94,050"},
            {"16,200", "12,600", "1,260", "12,060"}
    };
    public String g2PreTestChoices[][] = {
            {"10,280", "10,080", "10,820", "10,880"},
            {"100,800", "108,000", "18,000", "10,080"},
            {"3,870", "3,800", "3,780", "3,080"},
            {"2,720", "27,720", "20,270", "2,772"},
            {"15,120", "151,020", "151,012", "151,200"}
    };
    public String g1PreTestAnswer[] = {
            "1,260", "105", "1,680", "95,040", "12,600"
    };
    public String g2PreTestAnswer[] = {
            "10,080", "100,800", "3,780", "27,720", "151,200"
    };
    public String g1PreTestSolutions[] = {
            "\\frac{9!}{2! 3! 4!} \\\\ = \\frac{9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 1,260\\text{ ways} \\\\ \\text{There are 1,260 different arrangments.}",
            "\\frac{7!}{4! 2!} \\\\ = \\frac{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 105\\text{ ways} \\\\ \\text{There are 105 different arrangments.}",
            "\\frac{8!}{3! 2! 2!} \\\\ = \\frac{8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 1,680\\text{ ways} \\\\ \\text{There are 1,680 different arrangments.}",
            "\\frac{12!}{7!} \\\\ = \\frac{12 \\cdot 11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1} \\\\ = 95,040 \\text{ ways} \\\\ \\text{There are 95,040 different arrangments.}",
            "\\frac{10!}{2! 3! 4!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 12,600\\text{ ways} \\\\ \\text{There are 12,600 different arrangments.}"
    };
    public String g2PreTestSolutions[] = {
            "\\frac{8!}{2! 2!} \\\\ = \\frac{8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 10,080\\text{ ways} \\\\ \\text{There are 10,080 different arrangments.}",
            "\\frac{11!}{3! 3!} \\\\ = \\frac{11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 100,800\\text{ ways} \\\\ \\text{There are 100,800 different arrangments.}",
            "\\frac{9!}{2! 4! 2!} \\\\ = \\frac{9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 3,780\\text{ ways} \\\\ \\text{There are 3,780 different arrangments.}",
            "\\frac{11!}{3! 2! 5!} \\\\ = \\frac{11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1) \\cdot (5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 27,720\\text{ ways} \\\\ \\text{There are 27,720 different arrangments.}",
            "\\frac{10!}{2! 3! 2!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 151,200\\text{ ways} \\\\ \\text{There are 151,200 different arrangments.}"
    };

    public String getG1PreTestQuestion(int a) {
        String question = g1PreTestQuestions[a];
        return question;
    }
    public String getG2PreTestQuestion(int a) {
        String question = g2PreTestQuestions[a];
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
    public String getG1PreTestChoice2(int a) {
        String choice = g1PreTestChoices[a][1];
        return choice;
    }
    public String getG2PreTestChoice2(int a) {
        String choice = g2PreTestChoices[a][1];
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
    public String getG1PreTestChoice4(int a) {
        String choice = g1PreTestChoices[a][3];
        return choice;
    }
    public String getG2PreTestChoice4(int a) {
        String choice = g2PreTestChoices[a][3];
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
    public String getG1PreTestSolution(int a) {
        String solution = g1PreTestSolutions[a];
        return solution;
    }
    public String getG2PreTestSolution(int a) {
        String solution = g2PreTestSolutions[a];
        return solution;
    }

    //Post Test
    public String g1PostTestQuestions[] = {
            "How many different arrangements are possible for 12 cars in a line, if 3 are silver metallic, 4 are dark blue, and 5 are white pearl?",
            "Given nine numbers, two 4’s, three 8’s, and four 9’s. What are the number of ways of arranging the nine numbers?",
            "How many different eleven-digit numerals can be written using the digits 0, 2, 2, 2, 3, 4, 7, 7, 7, 8, and 8?",
            "If a ship has only six flags, and 4 of them are alike, with which to send signals, how many different signals can be sent if all flags are used?",
            "A department store sells three same polo shirts, four same pairs of pants, two same rubber shoes, and one cap. How many different suits consisting of polo shirts, pairs of pants, rubber shoes, and a cap are possible?"
    };
    public String g2PostTestQuestions[] = {
            "How many unique passwords can be created using the letters in the word “password”?",
            "How many ordered arrangements are there of the letters in the word PANGASINAN?",
            "A music store wants to display 3 identical violins, 4 identical pianos, 4 identical trumpets, and 1 guitar in its store window. How many distinguishable displays are possible?",
            "During the mathematics quiz bee, four students are wearing purple shirts, three are wearing red shirts, five are wearing white shirts, and one is wearing a brown shirt. If the students line up at the door of the venue, how many ways could the shirt colors be arranged?",
            "Ms. Ramcea knows she used the letters in her name, and the numbers in her birthday, 4-22-88, to make her DepEd e-mail password, mixing them up to make it hard to guess. Unfortunately, she made it too hard to guess and forgot it. If the “reset password” option is unavailable, how many permutations might she need to guess?"
    };
    public String g1PostTestChoices[][] = {
            {"27,960", "27,720", "27,640", "27,580"},
            {"1,260", "1,280", "1,360", "1,390"},
            {"514,420", "520,270", "534,440", "554,400"},
            {"20", "30", "110", "720"},
            {"183,620", "186,260", "138,600", "138,840"}
    };
    public String g2PostTestChoices[][] = {
            {"20,040", "20,120", "20,130", "20,160"},
            {"100,800", "100,080", "108,000", "18,000"},
            {"138,600", "138,060", "136,860", "136,680"},
            {"362,630", "360,360", "360,280", "360,240"},
            {"4,989,600", "4,989,060", "4,998,600", "4,999,860"}
    };
    public String g1PostTestAnswer[] = {
            "27,720", "1,260", "554,400", "30", "138,600"
    };
    public String g2PostTestAnswer[] = {
            "20,160", "100,800", "138,600", "360,360", "4,989,600"
    };
    public String g1PostTestSolutions[] = {
            "\\frac{12!}{3! 4! 5!} \\\\ = \\frac{12 \\cdot 11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 27,720\\text{ ways} \\\\ \\text{There are 27,720 different arrangments.}",
            "\\frac{9!}{2! 3! 4!} \\\\ = \\frac{9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 1,260\\text{ ways} \\\\ \\text{There are 1,260 different arrangments.}",
            "\\frac{11!}{3! 3! 2!} \\\\ = \\frac{11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 554,400\\text{ ways} \\\\ \\text{There are 554,400 different arrangments.}",
            "\\frac{6!}{4!} \\\\ = \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1}{(4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 30\\text{ ways} \\\\ \\text{There are 30 different arrangments.}",
            "\\frac{11!}{3! 4! 2!} \\\\ = \\frac{11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 138,600\\text{ ways} \\\\ \\text{There are 138,600 different arrangments.}"
    };
    public String g2PostTestSolutions[] = {
            "\\frac{8!}{2!} \\\\ = \\frac{8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1)} \\\\ = 20,160\\text{ ways} \\\\ \\text{There are 20,160 different arrangments.}",
            "\\frac{10!}{3! 3!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 100,800\\text{ ways} \\\\ \\text{There are 100,800 different arrangments.}",
            "\\frac{12!}{3! 4! 4!} \\\\ = \\frac{12 \\cdot 11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 138,600\\text{ ways} \\\\ \\text{There are 138,600 different arrangments.}",
            "\\frac{13!}{4! 3! 5!} \\\\ = \\frac{13 \\cdot 12 \\cdot 11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 360,360\\text{ ways} \\\\ \\text{There are 360,360 different arrangments.}",
            "\\frac{11!}{2! 2! 2!} \\\\ = \\frac{11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 4,989,600\\text{ ways} \\\\ \\text{There are 4,989,600 different arrangments.}"
    };

    public String getG1PostTestQuestion(int a) {
        String question = g1PostTestQuestions[a];
        return question;
    }
    public String getG2PostTestQuestion(int a) {
        String question = g2PostTestQuestions[a];
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
    public String getG1PostTestChoice2(int a) {
        String choice = g1PostTestChoices[a][1];
        return choice;
    }
    public String getG2PostTestChoice2(int a) {
        String choice = g2PostTestChoices[a][1];
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
    public String getG1PostTestChoice4(int a) {
        String choice = g1PostTestChoices[a][3];
        return choice;
    }
    public String getG2PostTestChoice4(int a) {
        String choice = g2PostTestChoices[a][3];
        return choice;
    }
    public String getG1PostTestAnswer(int a) {
        String answer = g1PostTestAnswer[a];
        return answer;
    }
    public String getG2PostTestAnswer(int a) {
        String answer = g2PostTestAnswer[a];
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
}
