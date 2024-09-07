package com.enverzo.probquest.ui.tests.topiceleven;

public class TopicElevenQuestion {
    //Pre Test
    public String g1PreTestQuestions[] = {
            "How many different committees of 3 people can be formed from a pool of 5 people?",
            "In how many ways can the first six players of a volleyball team be chosen from a 10-member volleyball team?",
            "How many combinations can be made from C, O, U, R, A, G, E if the letters are taken three at a time?",
            "In a lotto with 42 numbers, how many ways can we select 6 numbers?",
            "A teacher requires students to answer 7 out of 10 questions, without regard to order. How many ways can this be done?"
    };
    public String g2PreTestQuestions[] = {
            "A chalk box contains 5 green and 3 yellow chalks. In how many ways can we select 3 chalks with two green and one yellow color?",
            "In how many ways can a team consisting of 2 boys and 3 girls be formed if there are 7 boys and 8 girls who qualified to be in a team?",
            "In how many ways can a committee consisting of 4 faculty members and 2 students be formed if there are 7 faculty and 6 students asked to be in the committee?",
            "A box contains 8 red balls and 4 blue balls. Three balls are drawn at random. In how many ways can the three balls be drawn from the 12 balls if all three balls are red?",
            "A committee of 3 members is to be formed from 5 boys and 6 girls. The committee must include at least 2 girls. In how many ways can this be done?"
    };
    public String g3PreTestQuestions[] = {
            "","","","",""
    };
    public String g1PreTestChoices[][] = {
            {"10", "45", "60", "95"},
            {"140", "180", "210", "320"},
            {"180", "125", "120", "35"},
            {"5,245,786", "4,255,788", "3,642,780", "2,843,980"},
            {"220", "180", "120", "80"}
    };
    public String g2PreTestChoices[][] = {
            {"110", "80", "70", "30"},
            {"1,116", "1,176", "1,676", "1,776"},
            {"525", "675", "745", "805"},
            {"314", "218", "112", "56"},
            {"35", "85", "95", "115"}
    };
    public String g3PreTestChoices[][] = {
            {"10", "45", "60", "95"},
            {"140", "180", "210", "320"},
            {"180", "125", "120", "35"},
            {"5,245,786", "4,255,788", "3,642,780", "2,843,980"},
            {"220", "180", "120", "80"}
    };
    public String g1PreTestAnswers[] = {
            "10", "210", "35", "5,245,786", "120"
    };
    public String g2PreTestAnswers[] = {
            "30", "1,176", "525", "56", "95"
    };
    public String g3PreTestAnswer[] = {
            "","","","",""
    };
    public String g1PreTestSolutions[] = {
            "n=5\\text{, }r=3 \\\\ {}_5C_3 = \\frac{5!}{(5-3)!3!} = \\frac{5!}{2!3!} \\\\ = \\frac{5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 10\\text{ ways}",
            "n=10\\text{, }r=6 \\\\ {}_{10}C_6 = \\frac{10!}{(10-6)!6!} = \\frac{10!}{4!6!} \\\\ = 210 \\text{ ways}",
            "n=7\\text{, }r=3 \\\\ {}_7C_3 = \\frac{7!}{(7-3)!3!} = \\frac{7!}{4!3!} \\\\ = 35 \\text{ ways}",
            "n=42\\text{, }r=6 \\\\ {}_{42}C_6 = \\frac{42!}{(42-6)!6!} = \\frac{42!}{36!6!} \\\\ = 5,245,786\\text{ ways}",
            "n=10\\text{, }r=7 \\\\ {}_{10}C_7 = \\frac{10!}{(10-7)!7!} = \\frac{10!}{3!7!} \\\\ = 120\\text{ ways}",
    };
    public String g2PreTestSolutions[] = {
            "\\text{Need to select 2 out of 5 green chalks\\\\and 1 out of 3 yellow chalks.} \\\\ {}_5C_2 \\cdot {}_3C_1 = 10 \\cdot 3 = 30 \\text{ ways}",
            "\\text{Need to select 2 out of 7 boys\\\\and 3 out of 8 girls to form a team.} \\\\ {}_7C_2 \\cdot {}_8C_3 = 21 \\cdot 56 = 1,176 \\text{ ways}",
            "\\text{Need to select 4 out of 7 faculty\\\\and 2 out of 6 students to form\\\\a committee.} \\\\ {}_7C_4 \\cdot {}_6C_2 = (35 \\cdot 15) = 525 \\text{ ways}",
            "\\text{Need to select 3 balls out of 8 red balls.} \\\\ n=8 \\text{, } r=3 \\\\ {}_8C_3 = \\frac{8!}{(8-3)!3!} = \\frac{8!}{5!3!} \\\\ = 56 \\text{ ways}",
            "\\text{Since the committee needs at least 2\\\\girls to form a committee of 3 members,\\\\then the number of girls needed in the\\\\committee could either be 2 or 3.\\\\So, if there are 2 girls in the\\\\committee, then it needs 1 boy to\\\\complete the members in the committee.}\\\\ {}_6C_2 \\cdot {}5_C_1 \\\\ \\text{- apply the FCP to get the number of\\\\ways to form a committee with 2 girls\\\\and 1 boy while if there are 3 girls in\\\\the committee, then, there is no need\\\\from the number of boys since the\\\\members in the committee are already\\\\complete.}\\\\ {}_6C_3 \\cdot {}5_C_0 \\\\ \\text{- apply the FCP to get the number of\\\\ways to form a committee with 3 girls\\\\and 0 boy. After which, add the\\\\combination results to get the desired\\\\result.}\\\\ {}_6C_2 \\cdot {}_5C_1 + {}_6C_3 \\cdot {}_5C_0 \\\\ = (15 \\cdot 5) + (20 \\cdot 1) \\\\ = 75 + 20 = 95 \\text{ ways} \\\\ \\text{There are 95 different committees.}"
    };
    public String g3PreTestSolutions[] = {
            "","","","",""
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
    public String getG1PreTestCorrectAnswer(int a) {
        String answer = g1PreTestAnswers[a];
        return answer;
    }
    public String getG2PreTestCorrectAnswer(int a) {
        String answer = g2PreTestAnswers[a];
        return answer;
    }
    public String getG3PreTestCorrectAnswer(int a) {
        String answer = g3PreTestAnswer[a];
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

    //Post Test
    public String g1PostTestQuestions[] = {
            "How many different committees of 4 people can be formed from a pool of 6 people?",
            "In how many ways can the first six players of a volleyball team be chosen from a 12-member volleyball team?",
            "How many combinations can be made from C, O, U, R, A, G, E if the letters are taken five at a time?",
            "In a lotto with 48 numbers, how many ways can we select 6 numbers?",
            "A teacher requires students to answer 6 out of 10 questions, without regard to order."
    };
    public String g2PostTestQuestions[] = {
            "A chalk box contains 6 green and 4 yellow chalks. In how many ways can we select 4 chalks with three green and one yellow color?",
            "In how many ways can a team consisting of 3 boys and 2 girls be formed if there are 8 boys and 6 girls who qualified to be in a team?",
            "In how many ways can a committee consisting of 5 faculty members and 3 students be formed if there are 8 faculty and 5 students asked to be in the committee?",
            "A box contains 7 red balls and 3 blue balls. Three balls are drawn at random. In how many ways can the three balls be drawn from the 12 balls if all three balls are red?",
            "A committee of 3 members is to be formed from 7 boys and 5 girls. The committee must include at least 2 girls. In how many ways can this be done?"
    };
    public String g3PostTestQuestions[] = {
            "","","","",""
    };
    public String g1PostTestChoices[][] = {
            {"6", "15", "60", "95"},
            {"194", "374", "554", "924"},
            {"56", "74", "96", "124"},
            {"48!/6!", "48!/42!6!", "48!/42!", "48!/42•6!"},
            {"420", "380", "320", "210"}
    };
    public String g2PostTestChoices[][] = {
            {"110", "80", "70", "30"},
            {"840", "1,040", "1,240", "1,284"},
            {"525", "575", "560", "595"},
            {"104", "86", "62", "35"},
            {"105", "85", "80", "35"}
    };
    public String g3PostTestChoices[][] = {
            {"6", "15", "60", "95"},
            {"194", "374", "554", "924"},
            {"56", "74", "96", "124"},
            {"48!/6!", "48!/42!6!", "48!/42!", "48!/42•6!"},
            {"420", "380", "320", "210"}
    };
    public String g1PostTestAnswer[] = {
            "15", "924", "56", "48!/42!6!", "210"
    };
    public String g2PostTestAnswer[] = {
            "80", "840", "560", "35", "80"
    };
    public String g3PostTestAnswer[] = {
            "","","","",""
    };
    public String g1PostTestSolutions[] = {
            "n=6\\text{, }r=4 \\\\ {}_6C_4 = \\frac{6!}{(6-4)!4!} = \\frac{6!}{2!4!} = 15 \\text{ ways}",
            "n=10\\text{, }r=6 \\\\ {}_{10}C_6 = \\frac{10!}{(10-6)!6!} = \\frac{10!}{4!6!} = 924 \\text{ ways}",
            "n=7\\text{, }r=5 \\\\ {}_7C_5 = \\frac{7!}{(7-5)!5!} = \\frac{7!}{2!5!} = 56 \\text{ ways}",
            "n=48\\text{, }r=6 \\\\ {}_{42}C_6 = \\frac{48!}{(48-6)!6!} = \\frac{48!}{42!6!} = 12,271,512 \\text{ ways}",
            "n=10\\text{, }r=6 \\\\ {}_{10}C_6 = \\frac{10!}{(10-6)!6!} = \\frac{10!}{4!6!} = 210 \\text{ ways}"
    };
    public String g2PostTestSolutions[] = {
            "\\text{Need to select 3 out of 6 green chalks\\\\and 1 out of 4 yellow chalks.} \\\\ {}_6C_3 \\cdot {}_4C_1 = (20 \\cdot 4) = 80 \\text{ ways}",
            "\\text{Need to select 3 out of 8 boys and 2\\\\out of 6 girls to form a team.} \\\\ {}_8C_3 \\cdot {}_6C_2 = (56 \\cdot 15) = 840 \\text{ ways}",
            "\\text{Need to select 5 out of 8 faculty and 3\\\\out of 5 students to form a committee.} \\\\ {}_8C_5 \\cdot {}_5C_3 = (56 \\cdot 10) = 560 \\text{ ways}",
            "\\text{Need to select 3 balls out of 7 red balls.} \\\\ n=7\\text{, }r=3 \\\\ {}_7C_3 = \\frac{7!}{(7-3)!3!} = \\frac{7!}{4!3!} = 35 \\text{ ways}",
            "\\text{Since the committee needs at least 2\\\\girls to form a committee of 3 members,\\\\then the number of girls needed in the\\\\committee could either be 2 or 3.\\\\So, if there are 2 girls in the committee,\\\\then it needs 1 boy to complete the\\\\members in the committee.} \\\\ {}_5C_2 \\cdot {}_7C_1 \\\\ \\text{- apply the FCP to get the number of\\\\ways to form a committee with 2 girls\\\\and 1 boy while if there are 3 girls in\\\\the committee, then, there is no need\\\\from the number of boys since the\\\\members in the committee are already\\\\complete.} \\\\ {}_5C_3 \\cdot {}_7C_1 \\\\ \\text{- apply the FCP to get the number of\\\\ways to form a committee with 3 girls\\\\and 0 boy. Afterwhich, add the\\\\combination results to get the desired\\\\result.} \\\\ {}_5C_2 \\cdot {}_7C_1 + {}_5C_3 \\cdot {}_7C_0 \\\\ = (10 \\cdot 7) + (10 \\cdot 1) \\\\ = 70 + 10 = 80 \\text{ ways} \\\\ \\text{There are 80 different committees.}"
    };
    public String g3PostTestSolutions[] = {
            "","","","",""
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
    public String getG1PostTestCorrectAnswer(int a) {
        String answer = g1PostTestAnswer[a];
        return answer;
    }
    public String getG2PostTestCorrectAnswer(int a) {
        String answer = g2PostTestAnswer[a];
        return answer;
    }
    public String getG3PostTestCorrectAnswer(int a) {
        String answer = g3PostTestAnswer[a];
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
