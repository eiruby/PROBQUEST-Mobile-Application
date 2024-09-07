package com.enverzo.probquest.ui.tests.topicnine;

public class TopicNineQuestion {
    //Pre Test
    public String t9G1PreTestQuestions[] = {
            "In how many ways can 7 different trees be planted in a circle?",
            "What is the number of circular permutations of 6 singers?",
            "Five different keys are to be placed on a circular key chain. How many different arrangements are there?",
            "In how many ways can 10 horses be arranged in a merry-go-round?",
            "How many ways can eight unique beads be arranged on a chain without a clasp?"
    };
    public String t9G2PreTestQuestions[] = {
            "In how many ways can six ladies be seated in a circle if they can sit anywhere?",
            "How many ways can 7 people be seated in a circular table?",
            "How many circular permutations are there of the numbers on the face of the clock?",
            "How many ways can 6 boy scouts and 3 master scouts be seated around a campfire if no restrictions are imposed?",
            "In how many ways can 5 students be seated in a circle if two particular students must sit next to each other?"
    };
    public String t9G3PreTestQuestions[] = {
            "In how many ways can eleven members of a committee sit at a round table if the President and a secretary always sit together?",
            "At a dinner party, 5 men and 5 women sit at a round table. In how many ways can they sit if Buds and Mikee must sit next to each other?",
            "How many ways in which 5 boys and 4 girls sit around a table so that all the boys sit together?",
            "In how many ways can four couples be seated at a round table if the men and women want to sit alternately?",
            "How many ways can 8 teachers and 8 students be seated at a round table if the teachers and the students are to occupy alternate seats?"
    };
    public String t9G1PreTestChoices[][] = {
            {"720", "4,520", "5,040", "6,280"},
            {"720", "4,520", "5,040", "6,280"},
            {"5", "12", "24", "120"},
            {"3,628,800", "3,627,180", "382,240", "362,880"},
            {"5,340", "5,040", "40,320", "40,240"}
    };
    public String t9G2PreTestChoices[][] = {
            {"840", "720", "240", "120"},
            {"920", "720", "640", "520"},
            {"11!", "12! × 2", "11! × 2", "11! - 2"},
            {"362,880", "50,200", "40,320", "4,320"},
            {"5!2", "3!2!", "4!7!", "5!3!"}
    };
    public String t9G3PreTestChoices[][] = {
            {"10! × 2", "10!", "11! × 2", "9! × 2"},
            {"60,640", "70,604", "80,640", "89,,460"},
            {"4!5!", "5!5!", "9!3!", "4!3!"},
            {"144", "360", "180", "540"},
            {"16!6!", "12!8!", "7!8!", "8!16!"}
    };
    public String t9G1PreTestAnswers[] = {
            "720", "720", "24", "362,880", "5,040"
    };
    public String t9G2PreTestAnswers[] = {
            "120", "720", "11!", "40,320", "3!2!"
    };
    public String t9G3PreTestAnswers[] = {
            "9! × 2", "80,640", "4!5!", "144", "7!8!"
    };
    public String t9Solution[] = {
            "", "", "", "", "", "", "", "", "", ""
    };

    public String getG1PreTestQuestion(int a) {
        String question = t9G1PreTestQuestions[a];
        return question;
    }
    public String getG2PreTestQuestion(int a) {
        String question = t9G2PreTestQuestions[a];
        return question;
    }
    public String getG3PreTestQuestion(int a) {
        String question = t9G3PreTestQuestions[a];
        return question;
    }
    public String getG1PreTestChoice1(int a) {
        String choice = t9G1PreTestChoices[a][0];
        return choice;
    }
    public String getG2PreTestChoice1(int a) {
        String choice = t9G2PreTestChoices[a][0];
        return choice;
    }
    public String getG3PreTestChoice1(int a) {
        String choice = t9G3PreTestChoices[a][0];
        return choice;
    }
    public String getG1PreTestChoice2(int a) {
        String choice = t9G1PreTestChoices[a][1];
        return choice;
    }
    public String getG2PreTestChoice2(int a) {
        String choice = t9G2PreTestChoices[a][1];
        return choice;
    }
    public String getG3PreTestChoice2(int a) {
        String choice = t9G3PreTestChoices[a][1];
        return choice;
    }
    public String getG1PreTestChoice3(int a) {
        String choice = t9G1PreTestChoices[a][2];
        return choice;
    }
    public String getG2PreTestChoice3(int a) {
        String choice = t9G2PreTestChoices[a][2];
        return choice;
    }
    public String getG3PreTestChoice3(int a) {
        String choice = t9G3PreTestChoices[a][2];
        return choice;
    }
    public String getG1PreTestChoice4(int a) {
        String choice = t9G1PreTestChoices[a][3];
        return choice;
    }
    public String getG2PreTestChoice4(int a) {
        String choice = t9G2PreTestChoices[a][3];
        return choice;
    }
    public String getG3PreTestChoice4(int a) {
        String choice = t9G3PreTestChoices[a][3];
        return choice;
    }
    public String getG1PreTestAnswer(int a) {
        String answer = t9G1PreTestAnswers[a];
        return answer;
    }
    public String getG2PreTestAnswer(int a) {
        String answer = t9G2PreTestAnswers[a];
        return answer;
    }
    public String getG3PreTestAnswer(int a) {
        String answer = t9G3PreTestAnswers[a];
        return answer;
    }
    public String getSolution(int a) {
        String answer = t9Solution[a];
        return answer;
    }

    //Post Test
    public String t9G1PostTestQuestions[] = {
            "In how many ways can 8 different trees be planted in a circle?",
            "What is the number of circular permutations of 6 singers?",
            "Six different keys are to be placed on a circular key chain. How many different arrangements are there?",
            "How many ways in which 9 beads can be arranged to form a necklace?",
            "How many ways can ten unique beads be arranged on a chain without a clasp?"
    };
    public String t9G2PostTestQuestions[] = {
            "In how many ways can 7 ladies be seated in a circle if they can sit anywhere?",
            "How many ways can 8 people be seated in a circular table?",
            "In how many ways can 10 horses be arranged in a merry-go-round?",
            "How many ways can 8 boy scouts and 2 master scouts be seated around a campfire if no restrictions are imposed?",
            "How many ways in which 6 boys and 5 girls sit around a table so that all the boys sit together?"
    };
    public String t9G3PostTestQuestions[] = {
            "In how many ways can ten members of a committee sit at a round table if the President and a secretary always sit together?",
            "In how many ways can 6 students be seated in a circle if two particular students must sit next to each other?",
            "How many ways in which 5 boys and 4 girls sit around a table so that all the boys sit together?",
            "In how many ways can four couples be seated at a round table if the men and women want to sit alternately?",
            "How many ways can 3 teachers and 3 students be seated at a round table if the teachers and the students are to occupy alternate seats?"
    };
    public String t9G1PostTestChoices[][] = {
            {"5,040", "5,140", "20,340", "40,320"},
            {"720", "4,520", "5,040", "6,280"},
            {"720", "260", "210", "120"},
            {"362,880", "51,740", "40,320", "38,920"},
            {"3,628,800", "552,620", "452,840", "362,880"}
    };
    public String t9G2PostTestChoices[][] = {
            {"720", "840", "870", "5,040"},
            {"5,040", "4,230", "3,260", "2,520"},
            {"3,628,800", "3,627,180", "382,240", "362,880"},
            {"327,320","332,410","360,880","362,880"},
            {"11!5!","5!6!","5!5!","4!5!"}
    };
    public String t9G3PostTestChoices[][] = {
            {"10! × 2","10!","8! × 2","11! 2!"},
            {"12","24","36","48"},
            {"4!5!", "5!5!", "9!3!", "4!3!"},
            {"144", "360", "180", "540"},
            {"2! × 3!","6!3!","2! × 12!","3!3!"}
    };
    public String t9G1PostTestAnswers[] = {
            "5,040", "720", "120", "40,320", "362,880"
    };
    public String t9G2PostTestAnswers[] = {
            "720", "5,040", "362,880", "362,880", "5!6!"
    };
    public String t9G3PostTestAnswers[] = {
            "8! × 2", "48", "4!5!", "144", "2! × 3!"
    };
    public String t9G1PostTestSolutions[] = {
            "(n - 1)! = (8 - 1)! = 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 5,040\\\\\\text{There are 5,040 ways of planting the 8}\\\\\\text{different trees in a circle.}",
            "720",
            "(n - 1)! = (6 - 1)! = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120\\\\\\text{There are 120 ways of arranging the six}\\\\\\text{different keys on a circular key chain.}",
            "(n - 1)! = (9 - 1)! = 8! = 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 40,320\\\\\\text{There are 40,320 ways of arranging the 9}\\\\\\text{beads to form a necklace.}",
            "(n - 1)! = (10 - 1)! = 9! = 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 362,880\\\\\\text{There are 362,880 ways of arranging the eight}\\\\\\text{unique beads on a chain without a clasp.}"
    };
    public String t9G2PostTestSolutions[] = {
            "(n - 1)! = (7 - 1)! = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720\\\\\\text{There are 720 ways of arranging the 7}\\\\\\text{ladies they can sit anywhere around the circle.}",
            "5,040",
            "362,880",
            "(n - 1)! = (10 - 1)! = 9! = 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 362,880\\\\\\text{There are 362,880 ways of arranging the 8 boy}\\\\\\text{scouts and 2 master scouts to be seated around}\\\\\\text{a campfire with no restrictions.}",
            "\\text{Treat all boys as one group.}\\\\\\text{5 seats for girls plus 1 group seat for}\\\\\\text{boys = 6 seats to be arranged in a circle}\\\\(n - 1)! = (6 - 1)! = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120\\text{ ways}\\\\\\text{Moreover, the 6 boys can be arranged}\\\\\\text{within its group in 6! ways}\\\\\\text{By Fundamental Counting Principle,}\\\\\\text{the required number of ways can all the persons}\\\\\\text{be seated where all the boys sit together is}\\\\5! × 6! = 120 × 720 = 86,400\\text{ ways}"
    };
    public String t9G3PostTestSolutions[] = {
            "\\text{Since 2 particular persons, the president and a}\\\\\\text{secretary must sit together, take them as one person.}\\\\\\text{Then there are 9 members of a committee all together}\\\\\\text{and they can be arranged in}\\\\(n - 1)! = (9 - 1)! = 8! = 8 × 7 × 6 × 5 4 × 3 × 2 × 1\\\\= 40,320\\\\\\text{The two students can be arranged among themselves in}\\\\2! = 2 × 1 = 2\\text{ ways}\\\\\\text{Then the number of ways of arranging the 10}\\\\\\text{members of a committee at a round table with}\\\\\\text{the President and a secretary sitting together is}\\\\8! × 2 = 40,320 × 2 = 80,640\\text{ ways}",
            "\\text{Since 2 particular students must sit next to each}\\\\\\text{other, take them as one person. Then there are 5}\\\\\\text{students all together and they can be arranged in}\\\\(5 - 1)! = 4! = 4 × 3 × 2 × 1 = 24\\text{ ways}\\\\\\text{The two students can be arranged among themselves in}\\\\2! = 2 × 1 = 2\\text{ ways}\\\\\\text{Then the number of ways of arranging the 6}\\\\\\text{students at a round table with 2 particular}\\\\\\text{students sitting to each other is}\\\\4! × 2! = 24 × 2 = 48\\text{ ways}",
            "4!5!",
            "144",
            "\\text{Assign a teacher to a specific chair and let the other}\\\\\\text{2 be seated around the table. That is, find the number}\\\\\\text{of ways the 3 teachers can be seated at the round table.}\\\\(n - 1)! = (3 - 1)! = 2! = 2 × 1 = 2\\text{ ways}\\\\\\text{Then, the 3 students can be seated in 3 chairs}\\\\\\text{as if they are seated linearly. Thus,}\\\\n! = 3! = 3 × 2 × 1 = 6\\text{ ways}\\\\\\text{by the Fundamental Counting Principle,}\\\\\\text{the required number of ways can be seated is}\\\\2! × 3! = 2 × 6 = 12\\text{ ways}"
    };

    public String getG1PostTestQuestion(int a) {
        String question = t9G1PostTestQuestions[a];
        return question;
    }
    public String getG2PostTestQuestion(int a) {
        String question = t9G2PostTestQuestions[a];
        return question;
    }
    public String getG3PostTestQuestion(int a) {
        String question = t9G3PostTestQuestions[a];
        return question;
    }
    public String getG1PostTestChoice1(int a) {
        String choice = t9G1PostTestChoices[a][0];
        return choice;
    }
    public String getG2PostTestChoice1(int a) {
        String choice = t9G2PostTestChoices[a][0];
        return choice;
    }
    public String getG3PostTestChoice1(int a) {
        String choice = t9G3PostTestChoices[a][0];
        return choice;
    }
    public String getG1PostTestChoice2(int a) {
        String choice = t9G1PostTestChoices[a][1];
        return choice;
    }
    public String getG2PostTestChoice2(int a) {
        String choice = t9G2PostTestChoices[a][1];
        return choice;
    }
    public String getG3PostTestChoice2(int a) {
        String choice = t9G3PostTestChoices[a][1];
        return choice;
    }
    public String getG1PostTestChoice3(int a) {
        String choice = t9G1PostTestChoices[a][2];
        return choice;
    }
    public String getG2PostTestChoice3(int a) {
        String choice = t9G2PostTestChoices[a][2];
        return choice;
    }
    public String getG3PostTestChoice3(int a) {
        String choice = t9G3PostTestChoices[a][2];
        return choice;
    }
    public String getG1PostTestChoice4(int a) {
        String choice = t9G1PostTestChoices[a][3];
        return choice;
    }
    public String getG2PostTestChoice4(int a) {
        String choice = t9G2PostTestChoices[a][3];
        return choice;
    }
    public String getG3PostTestChoice4(int a) {
        String choice = t9G3PostTestChoices[a][3];
        return choice;
    }
    public String getG1PostTestAnswer(int a) {
        String answer = t9G1PostTestAnswers[a];
        return answer;
    }
    public String getG2PostTestAnswer(int a) {
        String answer = t9G2PostTestAnswers[a];
        return answer;
    }
    public String getG3PostTestAnswer(int a) {
        String answer = t9G3PostTestAnswers[a];
        return answer;
    }
    public String getG1PostTestSolution(int a) {
        String solution = t9G1PostTestSolutions[a];
        return solution;
    }
    public String getG2PostTestSolution(int a) {
        String solution = t9G2PostTestSolutions[a];
        return solution;
    }
    public String getG3PostTestSolution(int a) {
        String solution = t9G3PostTestSolutions[a];
        return solution;
    }
}
