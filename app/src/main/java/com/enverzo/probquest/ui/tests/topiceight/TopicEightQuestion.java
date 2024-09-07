package com.enverzo.probquest.ui.tests.topiceight;

public class TopicEightQuestion {
    //Pre Test
    public String t8G1PreTestQuestions[] = {
            "In how many different ways can 4 motorcycles be parked if there are 7 available parking spaces?",
            "In there are 10 people and only 6 chairs are available, in how many ways can they be seated?",
            "In how many ways can four-digit number (6,7,8, and 9) permute taken two at a time?",
            "How many permutations can be made from the letters in the word FAITH if 4 letters are used at a time?",
            "If a class has 12 groups of students, how many different arrangements can 5 group of students give a presentation to the class?"
    };
    public String t8G2PreTestQuestions[] = {
            "A class is to select a president, a vice-president, a secretary, and a treasurer from 7 class members. How many possible arrangements of class officers are possible?",
            "In a certain raffle from a facebook page, three major prizes are at stake. In how many ways can the first, second, and third prizes be drawn from a tambiolo containing 90 names?",
            "Suppose that 7 students enter a swimming meet. Assuming that there are no ties, in how many ways could the gold, silver, and bronze medals be awarded?",
            "Suppose we are going to use the symbols {a, b, c, d, e, f, g, h} to form a 5-character \"password\" having no repeated characters. How many different passwords are possible?",
            "How many three-digit codes can be made out of the digits 1, 2, 3, 4, and 5 if no digit is repeated in any number?",
    };
    public String t8G3PreTestQuestions[] = {
            "In how many ways can three different fiction books and four different non-fiction books be arranged on a shelf if the shelf is good for four books only?",
            "How many ways can the letters of the word “SMILE” be arranged so that the vowels come together?",
            "In how many ways can 7 children be arranged in a line such that two particulars of them are always together?",
            "In how many ways can three different science books and two different math books be arranged on a shelf if books of the same subject are grouped together?",
            "In how many ways can 4 children be arranged in a line such that two particular children of them are never together?"
    };

    public String t8G1PreTestChoices[][] = {
            {"540", "620", "640", "840"},
            {"133,020", "151,200", "240,020", "253,020"},
            {"12", "24", "120", "230"},
            {"20", "60", "120", "520"},
            {"76,454", "79,820", "83,260", "95,040"}
    };
    public String t8G2PreTestChoices[][] = {
            {"840","890","940","970"},
            {"760,250","720,810","704,880","702,350"},
            {"620","540","420","210"},
            {"6,720","6,780","7,220","7,780"},
            {"15","60","120","720"}
    };
    public String t8G3PreTestChoices[][] = {
            {"24", "48", "420", "576"},
            {"5", "24", "48", "96"},
            {"1,450", "1,440", "1,340", "1,320"},
            {"24", "48", "60", "120"},
            {"60", "48", "24", "12"}
    };

    public String t8G1PreTestAnswer[] = {
            "840", "151,200", "12", "120", "95,040"
    };
    public String t8G2PreTestAnswer[] = {
            "840", "704,880", "210", "6,720", "60"
    };
    public String t8G3PreTestAnswer[] = {
            "420", "48", "1,440", "24", "12"
    };
    public String t8G1PreTestSolution[] = {
            "{}_7P_4 = 840",
            "{}_{10}P_6 = 151,200",
            "{}_4P_2 = 12",
            "{}_5P_4 = 120",
            "{}_{12}P_5 = 95,040"
    };
    public String t8G2PreTestSolution[] = {
            "{}_7P_4 = 840",
            "{}_{90}P_3 = 704,880",
            "{}_7P_3 = 210",
            "{}_8P_5 = 6,720",
            "{}_5P_3 = 60"
    };
    public String t8G3PreTestSolution[] = {
            "{}_7P_4 = 840",
            "{}_4P_4 × {}_2P_2 = 48",
            "{}_6P_6 × {}_2P_2 = 1440",
            "{}_3P_3 × {}_2P_2 × {}_2P_2 = 24",
            "{}_4P_4 - ({}_3P_3 × {}_2P_2) = 12"
    };

    public String getG1PreTestQuestion(int a) {
        String question = t8G1PreTestQuestions[a];
        return question;
    }
    public String getG2PreTestQuestion(int a) {
        String question = t8G2PreTestQuestions[a];
        return question;
    }
    public String getG3PreTestQuestion(int a) {
        String question = t8G3PreTestQuestions[a];
        return question;
    }
    public String getG1PreTestChoice1(int a) {
        String choice = t8G1PreTestChoices[a][0];
        return choice;
    }
    public String getG2PreTestChoice1(int a) {
        String choice = t8G2PreTestChoices[a][0];
        return choice;
    }
    public String getG3PreTestChoice1(int a) {
        String choice = t8G3PreTestChoices[a][0];
        return choice;
    }
    public String getG1PreTestChoice2(int a) {
        String choice = t8G1PreTestChoices[a][1];
        return choice;
    }
    public String getG2PreTestChoice2(int a) {
        String choice = t8G2PreTestChoices[a][1];
        return choice;
    }
    public String getG3PreTestChoice2(int a) {
        String choice = t8G3PreTestChoices[a][1];
        return choice;
    }
    public String getG1PreTestChoice3(int a) {
        String choice = t8G1PreTestChoices[a][2];
        return choice;
    }
    public String getG2PreTestChoice3(int a) {
        String choice = t8G2PreTestChoices[a][2];
        return choice;
    }
    public String getG3PreTestChoice3(int a) {
        String choice = t8G3PreTestChoices[a][2];
        return choice;
    }
    public String getG1PreTestChoice4(int a) {
        String choice = t8G1PreTestChoices[a][3];
        return choice;
    }
    public String getG2PreTestChoice4(int a) {
        String choice = t8G2PreTestChoices[a][3];
        return choice;
    }
    public String getG3PreTestChoice4(int a) {
        String choice = t8G3PreTestChoices[a][3];
        return choice;
    }
    public String getG1PreTestAnswer(int a) {
        String answer = t8G1PreTestAnswer[a];
        return answer;
    }
    public String getG2PreTestAnswer(int a) {
        String answer = t8G2PreTestAnswer[a];
        return answer;
    }
    public String getG3PreTestAnswer(int a) {
        String answer = t8G3PreTestAnswer[a];
        return answer;
    }
    public String getG1PreTestSolution(int a) {
        String answer = t8G1PreTestSolution[a];
        return answer;
    }
    public String getG2PreTestSolution(int a) {
        String answer = t8G2PreTestSolution[a];
        return answer;
    }
    public String getG3PreTestSolution(int a) {
        String answer = t8G3PreTestSolution[a];
        return answer;
    }

    //Post Test
    public String t8G1PostTestQuestions[] = {
            "In how many different ways can 5 motorcycles be parked if there are 7 available parking spaces?",
            "In there are 7 people and only 4 chairs are available, in how many ways can they be seated?",
            "In how many ways can five-digit number (5, 6,7,8, and 9) permute taken two at a time?",
            "How many permutations can be made from the letters in the word ENGLISH if 3 letters are used at a time?",
            "If a class has 9 groups of students, how many different arrangements can 6 group of students give a presentation to the class?"
    };
    public String t8G2PostTestQuestions[] = {
            "A class is to select a president, a vice-president, a secretary, and a treasurer from 9 class members. How many possible arrangements of class officers are possible?",
            "In a certain raffle from a facebook page, three major prizes are at stake. In how many ways can the first, second, and third prizes be drawn from a tambiolo containing 140 names?",
            "Suppose that 10 students enter a swimming meet. Assuming that there are no ties, in how many ways could the gold, silver, and bronze medals be awarded?",
            "Suppose we are going to use the symbols {a, b, c, @, e, f, g, #} to form a 6-character \"password\" having no repeated characters. How many different passwords are possible?",
            "How many three - digit codes can be made out of the digits 1, 2, 3, 4, and 5 if no digit is repeated in any number?"
    };
    public String t8G3PostTestQuestions[] = {
            "In how many ways can five different fiction books and two different non-fiction books be arranged on a shelf if the shelf is good for four books only?",
            "How many ways can the letters of the word “SURVEY” be arranged so that the vowels come together?",
            "In how many ways can 6 children be arranged in a line such that two particulars of them are always together?",
            "In how many ways can three different science books and five different math books be arranged on a shelf if books of the same subject are grouped together?",
            "In how many ways can 5 children be arranged in a line such that two particular children of them are never together?"
    };
    public String t8G1PostTestChoices[][] = {
            {"210", "2,420", "2,520", "3,120"},
            {"840", "860", "920", "980"},
            {"20", "60", "120", "140"},
            {"120", "340", "210", "160"},
            {"2,020", "4,020", "4,460", "6,480"}
    };
    public String t8G2PostTestChoices[][] = {
            {"2,810","3,024","3,540","3,830"},
            {"2,685,480","2,412,360","2,825,620","2,858,820"},
            {"860","780","770","720"},
            {"20,160","20,240","20,420","20,520"},
            {"15","60","120","720"}
    };
    public String t8G3PostTestChoices[][] = {
            {"24", "48", "420", "840"},
            {"6", "120", "240", "480"},
            {"240", "280", "560", "620"},
            {"2,400", "1,440", "1,120", "120"},
            {"36", "48", "60", "72"}
    };
    public String T8G1PostTestAnswers[] = {
            "2,520", "840", "20", "210", "6,480"
    };
    public String T8G2PostTestAnswers[] = {
            "3,024", "2,685,480", "720", "20,160", "60"
    };
    public String t8G3PostTestAnswers[] = {
            "840", "240", "240", "1,440", "72"
    };
    public String t8G1PostTestSolutions[] = {
            "\\text{FCP:}\\\\{}_7P_5 = 7 × 6 × 5 × 4 × 3 = 2,520\\\\\\text{Formula:}\\\\{}_7P_5 = \\frac{7!}{(7-5)!} = \\frac{7!}{2!}\\\\= \\frac{7 × 6 × 5 × 4 × 3 × 2!}{2!}\\\\= 2,520 \\text{ posibble arrangements}",
            "\\text{FCP:}\\\\{}_7P_4 = 7 × 6 × 5 × 4 = 840\\\\\\text{Formula:}\\\\{}_7P_4 = \\frac{7!}{(7-4)!} = \\frac{7!}{3!}\\\\= \\frac{7 × 6 × 5 × 4 × 3!}{3!}\\\\= 840 \\text{ posibble arrangements}",
            "\\text{FCP:}\\\\{}_5P_2 = 5 × 4 = 20\\\\\\text{Formula:}\\\\{}_5P_2 = \\frac{5!}{(5-2)!} = \\frac{5!}{3!}\\\\= \\frac{5 × 4 × 3!}{3!}\\\\= 20 \\text{ posibble arrangements}",
            "\\text{FCP:}\\\\{}_7P_3 = 7 × 6 × 5 = 210\\\\\\text{Formula:}\\\\{}_7P_3 = \\frac{7!}{(7-3)!} = \\frac{7!}{4!}\\\\= \\frac{7 × 6 × 5 × 4!}{4!}\\\\= 210 \\text{ posibble arrangements}",
            "\\text{FCP:}\\\\{}_9P_6 = 9 × 8 × 7 × 6 × 5 × 4 = 60,480\\\\\\text{Formula:}\\\\{}_9P_6 = \\frac{9!}{(9-6)!} = \\frac{9!}{3!}\\\\= \\frac{9 × 8 × 7 × 6 × 5 × 4 × 3!}{3!}\\\\= 60,480 \\text{ posibble arrangements}"
    };
    public String t8G2PostTestSolutions[] = {
            "\\text{FCP:}\\\\{}_9P_4 = 9 × 8 × 7 × 6 = 3,024\\\\\\text{Formula:}\\\\{}_9P_4 = \\frac{9!}{(9-4)!} = \\frac{9!}{5!}\\\\= \\frac{9 × 8 × 7 × 6 × 5!}{5!}\\\\= 3,024 \\text{ posibble arrangements}",
            "\\text{FCP:}\\\\{}_140P_3 = 140 × 139 × 138 = 2,685,480\\\\\\text{Formula:}\\\\{}_140P_3 = \\frac{140!}{(140-3)!} = \\frac{140!}{137!}\\\\= \\frac{140 × 139 × 138 × 137!}{137!}\\\\= 2,685,480 \\text{ posibble arrangements}",
            "\\text{FCP:}\\\\{}_10P_3 = 10 × 9 × 8 = 720\\\\\\text{Formula:}\\\\{}_10P_3 = \\frac{10!}{(10-3)!} = \\frac{10!}{7!}\\\\= \\frac{10 × 9 × 8 × 7!}{7!}\\\\= 720 \\text{ posibble arrangements}",
            "\\text{FCP:}\\\\{}_8P_6 = 8 × 7 × 6 × 5 × 4 × 3 = 20,160\\\\\\text{Formula:}\\\\{}_8P_6 = \\frac{8!}{(8-6)!} = \\frac{8!}{2!}\\\\= \\frac{8 × 7 × 6 × 5 × 4 × 3 × 2!}{2!}\\\\= 20,160 \\text{ posibble arrangements}",
            "{}_5P_3 = 60"
    };
    public String t8G3PostTestSolutions[] = {
            "{}_7P_4 = 840",
            "{}_5P_5 × {}_2P_2 = 240",
            "{}_5P_5 × {}_2P_2 = 240",
            "({}_3P_3 × {}_5P_5) × {}_2P_2 = 1,440",
            "{}_5P_5 - ({}_4P_4 × {}_2P_2) = 72"
    };

    public String getG1PostTestQuestion(int a) {
        String question = t8G1PostTestQuestions[a];
        return question;
    }
    public String getG2PostTestQuestion(int a) {
        String question = t8G2PostTestQuestions[a];
        return question;
    }
    public String getG3PostTestQuestion(int a) {
        String question = t8G3PostTestQuestions[a];
        return question;
    }
    public String getG1PostTestChoice1(int a) {
        String choice = t8G1PostTestChoices[a][0];
        return choice;
    }
    public String getG2PostTestChoice1(int a) {
        String choice = t8G2PostTestChoices[a][0];
        return choice;
    }
    public String getG3PostTestChoice1(int a) {
        String choice = t8G3PostTestChoices[a][0];
        return choice;
    }
    public String getG1PostTestChoice2(int a) {
        String choice = t8G1PostTestChoices[a][1];
        return choice;
    }
    public String getG2PostTestChoice2(int a) {
        String choice = t8G2PostTestChoices[a][1];
        return choice;
    }
    public String getG3PostTestChoice2(int a) {
        String choice = t8G3PostTestChoices[a][1];
        return choice;
    }
    public String getG1PostTestChoice3(int a) {
        String choice = t8G1PostTestChoices[a][2];
        return choice;
    }
    public String getG2PostTestChoice3(int a) {
        String choice = t8G2PostTestChoices[a][2];
        return choice;
    }
    public String getG3PostTestChoice3(int a) {
        String choice = t8G3PostTestChoices[a][2];
        return choice;
    }
    public String getG1PostTestChoice4(int a) {
        String choice = t8G1PostTestChoices[a][3];
        return choice;
    }
    public String getG2PostTestChoice4(int a) {
        String choice = t8G2PostTestChoices[a][3];
        return choice;
    }
    public String getG3PostTestChoice4(int a) {
        String choice = t8G3PostTestChoices[a][3];
        return choice;
    }
    public String getG1PostTestAnswer(int a) {
        String answer = T8G1PostTestAnswers[a];
        return answer;
    }
    public String getG2PostTestAnswer(int a) {
        String answer = T8G2PostTestAnswers[a];
        return answer;
    }
    public String getG3PostTestAnswer(int a) {
        String answer = t8G3PostTestAnswers[a];
        return answer;
    }
    public String getG1PostTestSolution(int a) {
        String solution = t8G1PostTestSolutions[a];
        return solution;
    }
    public String getG2PostTestSolution(int a) {
        String solution = t8G2PostTestSolutions[a];
        return solution;
    }
    public String getG3PostTestSolution(int a) {
        String solution = t8G3PostTestSolutions[a];
        return solution;
    }
}
