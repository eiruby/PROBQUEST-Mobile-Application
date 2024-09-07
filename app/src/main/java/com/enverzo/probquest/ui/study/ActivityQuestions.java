package com.enverzo.probquest.ui.study;

public class ActivityQuestions {

    //Topic 1

    public String[] t1Act1Questions = {
            "1. Find the number of outcomes of a sample space associated with each random experience.",
            "2. A spinner with 10 equally likely outcomes is spun. The possible outcomes are 1, 2, 3, 4, 5, 6, 7, 8, 9, and 10.",
            "3. A die is rolled.",
            "4. A card is drawn at random from a deck of 52 cards. What is the probability of getting",
            "5. There are x white balls, 4 black balls, and 2x + 6 green balls in a box. One ball is selected at random from the box. If the probability that the selected ball is white is equal to 1/4, what is the value of x? The selected ball is then put back into the box and another ball is then selected. Find the probability that the selected ball will be"
    };

    public String[] t1Act1SubQuestions = {
            "(a) Tossing a coin once",
            "(b) Tossing a coin 3 times",
            "(c) Rolling a die",
            "(d) Rolling 3 die",
            "(e) Tossing a die and a coin",
            "(a) What is the probability of getting a 5?",
            "(b) What is the probability of getting an odd number?",
            "(c) What is the probability of getting an even number?",
            "(d) What is the probability of getting a prime number?",
            "(e) What is the probability of getting a number that is divisible by 3?",
            "(a) What is the probability of getting a 5?",
            "(b) What is the probability of getting an odd number?",
            "(c) What is the probability of getting an even number?",
            "(d) What is the probability of getting a prime number?",
            "(e) What is the probability of getting a number that is divisible by 3?",
            "(a) a spade?",
            "(b) a red?",
            "(c) a 10?",
            "(d) a number card?",
            "(e) a black jack?",
            "(a) white",
            "(b) black",
            "(c) green",
            "(d) not white",
            "(e) blue"
    };

    public String[] t1Act1Answers = {
            "2","8","6","216","12","1/10","1/2","1/2","2/5","1/5","1/6","1/2","1/2","1","1/2","1/4","1/2","1/13","9/13","1/26","1/4","1/10","13/20","3/4","0"
    };

    public String getT1Act1Questions(int a) {
        String question = t1Act1Questions[a];
        return question;
    }

    public String getT1Act1SubQuestions(int a) {
        String question = t1Act1SubQuestions[a];
        return question;
    }

    public String getT1Act1Answers(int a) {
        String answer = t1Act1Answers[a];
        return answer;
    }

    //Topic1 Activity 2

    public String[] t1ActQuestions = {
            "1. In rolling a die, what is the probability of getting a 2?",
            "2. A coin is tossed. What is the probability of getting a tail?",
            "3. If a card is drawn from a well-shuffled deck of cards, what is the probability that it is a king of hearts?",
            "4. A card is selected at random from an ordinary deck of playing cards. What is the probability that the card is a red king?",
            "5. A box contains five red, four white, and six green balls. If a ball is selected at random, what is the probability that it is white?",
            "6. A spinner, numbered from 1 – 15, is spun once. What is the probability of spinning an even number?",
            "7. A spinner, numbered from 1 – 10, is spun once. What is the probability of the spinner landing on a number less than 4?",
            "8. If a letter is to be selected from the word PROBQUEST, find the probability that the letter is a vowel?",
            "9. In a box, there are 25 balls numbered from 1 to 25. If a ball is drawn from the box, what is the probability of getting a number divisible by 3?",
            "10. A roulette wheel has 10 red numbers, 8 black numbers, and 12 green numbers. What is the probability that the ball will land on a green number on one spin?",
            "11. A fair die is rolled. What is the probability of getting a factor of 3?",
            "12. Number cards from 1 to 15 is shuffled and placed faced down. If one card is picked at random, what is the probability that it contains a prime number?",
            "13. A multiple choice question has 5 possible answers. If a student picks the answer at random, what is the probability that is correct?",
            "14. There are 35 balls in a bag. The probability of choosing a blue ball is exactly 2/5. What is the number of balls in the bags that are NOT blue?",
            "15. A couple wants to have 3 children. What is the probability that all will be girls?"
    };

    public String[] t1ActAnswers = {
            "1/6","1/2","1/52","1/26","4/15", "7/15","3/10","1/3","8/25","2/5", "1/2","2/5","1/5","21","1/8"
    };

    public String t1ActChoices[][] = {
            {"4/6","1/4","1/6","1/2"},
            {"1/2","1","1/3","1/6"},
            {"1/4","4/13","1/13","1/52"},
            {"1/13","1/26","13/4","1/6"},
            {"2/7","1/15","4/15","1/6"},
            {"2/5","7/15","1/15","3/5"},
            {"2/5","3/10","1/4","1/2"},
            {"1/3","2/5","1/2","1/5"},
            {"3/14","2/15","3/10","8/25"},
            {"3/14","2/15","3/10","2/5"},
            {"1/2","1/6","1/3","4/6"},
            {"3/4","7/20","2/5","1/20"},
            {"1/5","2/3","2/7","1/4"},
            {"9","15","21","24"},
            {"3/8","1/2","1/4","1/8"}
    };

    public String getT1ActQuestions(int a) {
        String answer = t1ActQuestions[a];
        return answer;
    }

    public String getT1ActChoice1(int a) {
        String choice = t1ActChoices[a][0];
        return choice;
    }

    public String getT1ActChoice2(int a) {
        String choice = t1ActChoices[a][1];
        return choice;
    }

    public String getT1ActChoice3(int a) {
        String choice = t1ActChoices[a][2];
        return choice;
    }

    public String getT1ActChoice4(int a) {
        String choice = t1ActChoices[a][3];
        return choice;
    }

    public String getT1ActAnswers(int a) {
        String answer = t1ActAnswers[a];
        return answer;
    }

    //Topic 2

    public String t2ActQuestions[] = {
            "1. The probability of getting a 4 in rolling a standard die once.",
            "2. The probability of choosing a male student for SSG President.",
            "3. The probability of getting an even number or a multiple of 3 on a die in rolling a standard dice once.",
            "4. The probability of drawing a spade from a standard deck of cards. 5. The probability of drawing a heart and a red card from a standard deck of cards.",
            "5. The probability of drawing a heart and a red card from a standard deck of cards.",
            "6. A box contains 5 yellow marbles and 7 red marbles. What is the probability of drawing 2 yellow marbles and 1 red marble in succession without replacement?",
            "7. From a standard deck of cards, what is the probability of choosing a diamond, then a heart, then a black card without replacement?",
            "8. If you roll a six-sided die and flip a coin, what is the probability of rolling a five and getting head?",
            "9. Two cards are selected at random from a standard deck. What is the probability that the first card is an 8 and the second card is a queen if the first card is not replaced before the second is selected?",
            "10. In a box, there are 30 balls numbered from 1 to 30. If a ball is drawn from the box, what is the probability of getting a number divisible by 5?"
    };
    public String t2CorrectAnsCaps[] = {
            "S", "S", "C", "S", "C", "C", "C", "C", "C", "S"
    };
    public String t2CorrectAnsLow[] = {
            "s", "s", "c", "s", "c", "c", "c", "c", "c", "s"
    };
    public String getT2ActQuestion(int a) {
        String question = t2ActQuestions[a];
        return question;
    }
    public String getT2CorrectAnsCaps(int a) {
        String answer1 = t2CorrectAnsCaps[a];
        return answer1;
    }
    public String getT2CorrectAnsLow(int a) {
        String answer2 = t2CorrectAnsLow[a];
        return answer2;
    }

    //Topic 3 Activity 1

    public String[] t3Act1Questions = {
            "1. Drawing an ace or a face card from a standard deck of cards.",
            "2. Rolling a 4 or a number greater than 3 in a die.",
            "3. Drawing a multiple of 3 or a multiple of 4 from 1 to 30 written on a card.",
            "4. Drawing a 6 or a king from a standard deck of cards.",
            "5. Rolling a die or tossing a coin.",
            "6. Getting a head or a tail in tossing a coin.",
            "7. Rolling a 2 or a 3 in a die.",
            "8. Spinning a 4 or a number that is divisible by 2 in a roulette with numbers from 1 to 10.",
            "9. Selecting a consonant or a vowel from the word “event”.",
            "10. Drawing a heart or an ace in a standard deck of cards."
    };

    public String[] t3Act1Answers = {
            "Y","N","N","Y","Y","Y","Y","N","Y","N"
    };

    public String getT3Act1Question(int a) {
        String question = t3Act1Questions[a];
        return question;
    }
    public String getT3Act1Answer(int a) {
        String answer = t3Act1Answers[a];
        return answer;
    }
//
//    //Topic 3 Activity 2
//
//    public String[] t3Act2Questions = {
//            "1. A bag contains 10 white balls, 12 black balls, and 8 green balls. One ball is drawn from the bag. What is the probability of getting",
//            "2. If one card is drawn from an ordinary deck of cards, what is the probability of getting",
//            "3. A fair die is rolled. What is the probability of getting",
//            "4. Two dice are rolled. What is the probability of getting",
//            "5. A coin is tossed four times in succession. What is the probability of"
//    };
//
//    public String[] t3Act2SubQuestions = {
//            "(a) either a white ball or a black ball?",
//            "(b) either a black ball or a green ball?",
//            "(c) either a white ball or a black ball or a green ball?",
//            "(d) neither a green ball nor a black ball?",
//            "(e) neither a black ball nor a white ball?",
//            "(a) a king or a queen of hearts",
//            "(b) a club or a heart",
//            "(c) a red card or a black queen",
//            "(d) a number card or a red king",
//            "(e) a 3, 5, or a club",
//            "(a) an even number or an odd number?",
//            "(b) a prime number or a factor of 4?",
//            "(c) a number less than 4 or a number that is multiple of 6?",
//            "(d) a composite number or a number less than 3?",
//            "(e) an odd number or a number that is divisible by 2?",
//            "(a) a total of 3 or 5?",
//            "(b) doubles or a sum of 6?",
//            "(c) a sum less than 5 or equal to 10?",
//            "(d) a total of at most 4 or greater than 11?",
//            "(e) a total of at least 9 or equal to 4?",
//            "(a) getting either all heads or getting exactly three tails?",
//            "(b) getting either all tails or getting at least one head?",
//            "(c) getting either exactly three heads or exactly two tails?",
//            "(d) getting neither all heads nor all tails?",
//            "(e) getting neither exactly one head nor exactly one tail?"
//    };
//
//    public String[] t3Act2Answers1 = {
//            "11/15","2/3","1","1/3","4/15","5/52","1/2","7/13","19/26","21/52","1","1","2/3","2/3","1","1/6","11/36","1/4","7/36","13/36","5/16","1","5/8","7/8","1/2"
//    };
//
//    public String getT3Act2Question(int a) {
//        String question = t3Act2Questions[a];
//        return question;
//    }
//    public String getT3Act2SubQuestion(int a) {
//        String question = t3Act2SubQuestions[a];
//        return question;
//    }
//    public String getT3Act2Ans1(int a) {
//        String answer = t3Act2Answers1[a];
//        return answer;
//    }

    //Topic 3 Activity 3

    public String[] t3ActQuestions = {
            "1. A card is chosen from a well-shuffled deck of 52 cards. What is the probability that the card will be a jack or a queen?",
            "2. If one card is drawn from an ordinary deck of cards, what is the probability of getting a club or a spade?",
            "3. A card is selected at random an ordinary deck of playing cards. What is the probability that the card is either a face card or a jack of diamonds?",
            "4. A spinner number 1-10 is spun. Each number is likely to be spun. What is the probability of spinning a 5 or a number at least 6?",
            "5. Ramcea puts 50 marbles in a box in which 14 are red, 16 are blue, and 20 are yellow. If Ramcea picks one marble at random, what is the probability that he selects a red marble or a blue marble?",
            "6. A bag contains 20 chips numbered 1 to 20. If a chip is drawn randomly from the bag, what is the probability that it is an 8 or a number at most 5?",
            "7. What is the probability of a dice showing a 6 or 1?",
            "8. A single number cube is rolled. What is the probability of rolling a 4 or greater than 4?",
            "9. A die is rolled. What is the probability of rolling a 5 or a number divisible by 2?",
            "10. Each of the numbers from 1 to 10 is written on a card and placed in a bag. If a card is drawn at random, what is the probability that the number is a multiple of 5 or a prime number?",
            "11. A card is drawn at random from a deck of cards. What is the probability of drawing a jack, a queen, or a king?",
            "12. A coin is tossed and a die is rolled. What is the probability of landing on the head side of the coin and rolling a 4 on the die or landing on the tail side of a coin and rolling a 5 on the die?",
            "13. The probabilities of three contestants Ana, Buddy, and Camila of winning the grand prize is 1/3, 1/4, and 1/2, respectively. Assuming that only one contestant can win the grand prize, what is the probability that either Buddy or Camila wins?",
            "14. A pair of dice is tossed. What is the probability of getting a sum of 2 or a sum of 12?",
            "15. A coin is flipped three times. What is the probability of getting either all heads or getting all tails?"
    };

    public String[] t3ActAnswers = {
            "1/26","1/2","1/4","3/5","3/5","3/10","1/3","1/2","2/3","3/5","3/13","1/6","3/4","1/18","1/4"
    };

    public String t3ActChoices[][] = {
            {"2/3","1/26","1/52","1/8"},
            {"2/7","2/13","1/26","1/2"},
            {"1/2","1/4","1/13","1/26"},
            {"3/5","3/7","3/10","3/13"},
            {"1/5","2/5","3/5","4/5"},
            {"3/10","3/7","3/5","3/4"},
            {"1/2","1/3","1/4","1/5"},
            {"1/6","1/5","1/3","1/2"},
            {"1/2","1/3","2/3","1"},
            {"1/2","1/3","1/4","3/5"},
            {"1/2","1/3","2/13","3/13"},
            {"1/6","15","1/3","1/2"},
            {"6/7","5/6","3/4","1/2"},
            {"1/3","1/5","1/13","1/18"},
            {"1/4","2/3","3/4","5/7"}
    };

    public String getT3ActQuestions(int a) {
        String answer = t3ActQuestions[a];
        return answer;
    }

    public String getT3ActChoice1(int a) {
        String choice = t3ActChoices[a][0];
        return choice;
    }

    public String getT3ActChoice2(int a) {
        String choice = t3ActChoices[a][1];
        return choice;
    }

    public String getT3ActChoice3(int a) {
        String choice = t3ActChoices[a][2];
        return choice;
    }

    public String getT3ActChoice4(int a) {
        String choice = t3ActChoices[a][3];
        return choice;
    }

    public String getT3ActAnswers(int a) {
        String answer = t3ActAnswers[a];
        return answer;
    }

//Topic 4 Activity

//    public String[] t4Act1Questions= {
//            "1. A die is rolled. What is the probability of getting",
//            "2. A card is drawn at random from a deck of cards. What is the probability of getting",
//            "3. Each of the numbers 1 to 30 is written on a slip of paper, rolled and put in a box and mixed thoroughly. One number is picked up at random.",
//            "4. The Shoes store has 40 employees, 24 men and 16 women. Two-thirds of the men and half of the women are married."
//    };
//
//    public String[] t4Act1SubQuestions= {
//            "(a) an even number or a 4?",
//            "(b) an odd number or a factor of 3?",
//            "(c) an even number or a prime number?",
//            "(d) an even number or a number less than 5?",
//            "(e) a composite number or a number that is a multiple of 3?",
//            "(a) a diamond or a queen?",
//            "(b) a black jack or a spade?",
//            "(c) an ace or a red card?",
//            "(d) a face card or a king?",
//            "(e)  a 10 or a black card?",
//            "(a) Find the probability that the picked number is an odd number or a 5.",
//            "(b) Find the probability that the picked number is an even number or a factor of 10.",
//            "(c) Find the probability that the picked number is a multiple of 2 or a factor of 4.",
//            "(d) Find the probability that the picked number is a factor of 6 or divisible by 3.",
//            "(e) Find the probability that the picked number is a prime number or an even number.",
//            "(a) Find the probability that one of the employees chosen at random is a man or is married.",
//            "(b) Find the probability that one of the employees chosen at random is a woman or is married.",
//            "(c) Find the probability that one of the employees chosen at random is a man or is single.",
//            "(d) Find the probability that one of the employees chosen at random is a woman or is single.",
//            "(e) Find the probability that one of the employees chosen at random is neither a man nor married.",
//            "5. Twenty-six tiles, each with a letter of the English alphabet, are placed in a bag and one tile is drawn at random. What is the probability of selecting a vowel or a letter from the word SMART?"
//    };
//
//    public String[] t4Act1Answers= {
//            "1/2","2/3","5/6","5/6","1/2","4/13","7/26","7/13","3/13","7/13","1/12","17/30","8/15","2/5","4/5","4/5","4/5","4/5","3/5","2/5","9/26"
//    };
//
//    public String getT4Act1Questions(int a) {
//        String question = t4Act1Questions[a];
//        return question;
//    }
//
//    public String getT4Act1SubQuestions(int a) {
//        String subQuestion = t4Act1SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT4Act1Answers(int a) {
//        String answer = t4Act1Answers[a];
//        return answer;
//    }

//Topic 4 Assessment

    public String[] t4ActQuestions= {
            "1. A card is chosen from a well-shuffled deck of 52 cards. What is the probability that the card will be a diamond or a queen?",
            "2. A card is selected at random from an ordinary deck of playing cards. What is the probability that the card is either a face card or a king of diamonds?",
            "3. A die is rolled. What is the probability of rolling a 5 or an odd number?",
            "4. A single number cube is rolled. What is the probability of rolling an even number or a prime number?",
            "5. A spinner number 1-30 is spun. Each number is likely to be spun. What is the probability of spinning a 28 or a number at least 25?",
            "6. A bag contains 15 chips numbered 1 to 15. If a chip is drawn randomly from the bag, what is the probability that the number is 10 or divisible by 2?",
            "7. A die is rolled. What is the probability of getting an even number or a prime number?",
            "8. Find the probability of turning up an odd number or a number lesser than 3 when rolling a die.",
            "9. A bag contains cards numbered from 1 to 15. One card was drawn at random. What is the probability of selecting a prime number or a number divisible by 3?",
            "10. One card is randomly selected from a deck of cards. What is the probability that it will be a heart or a red queen?",
            "11. A cube with A, B, C, D, E, and F on its faces is rolled. What is the probability of rolling a vowel or a letter in the word BEAR?",
            "12. If there is a 35% chance of rain on Monday, 65% chance of rain on Tuesday, and 40% chance of rain on Monday and Tuesday, what is the probability that it will rain on either Monday or Tuesday?",
            "13. Each of the numbers 1 – 30 is written on a slip of paper, rolled and put in a box, and mixed thoroughly. One number is picked up at random. Find the probability that the picked number is even or a multiple of 3?",
            "14. Twenty-six tiles, each with a letter of the English alphabet, are placed in a bag and one tile is drawn at random. What is the probability of selecting a vowel or a letter from the word ENGLISH?",
            "15. The Adidas Shoes store has 20 employees, 12 men and 8 women. Two-thirds of the men and half of the women are married. Find the probability that one of the employees chosen at random is a man or is married?"
    };

    public String[] t4ActAnswers= {
            "4/13","3/13","1/2","5/6","1/5","7/15","5/6","2/3","2/3","27/52","2/3","60%","7/10","5/26","4/5"
    };

    public String[][] t4ActChoices= {
            {"2/13","3/13","4/13","7/13"},
            {"3/13","5/13","8/13","11/13"},
            {"1","1/2","2/3","3/4"},
            {"2/3","3/4","4/5","5/6"},
            {"1/5","3/10","11/30","23/30"},
            {"14/15","11/15","8/15","7/15"},
            {"5/6","3/4","2/3","1/2"},
            {"1/3","2/3","5/6","3/5"},
            {"6/13","5/11","4/7","2/3"},
            {"27/52","17/52","7/52","3/52"},
            {"1/2","2/3","3/4","5/6"},
            {"70%","60%","50%","40%"},
            {"13/30","11/30","9/10","7/10"},
            {"5/26","3/19","2/13","1/13"},
            {"9/10","7/8","5/6","4/5"}
    };

    public String getT4ActQuestions(int a) {
        String question = t4ActQuestions[a];
        return question;
    }

    public String getT4ActAnswers(int a) {
        String answer = t4ActAnswers[a];
        return answer;
    }

    public String getT4ActChoice1(int a) {
        String choice = t4ActChoices[a][0];
        return choice;
    }

    public String getT4ActChoice2(int a) {
        String choice = t4ActChoices[a][1];
        return choice;
    }

    public String getT4ActChoice3(int a) {
        String choice = t4ActChoices[a][2];
        return choice;
    }

    public String getT4ActChoice4(int a) {
        String choice = t4ActChoices[a][3];
        return choice;
    }

//Topic 5 Activity

//    public String[] t5Act1Questions= {
//            "1. A bag contains 4 red marbles and 2 blue marbles. Mikee draws a marble and then returns it to the bag. She draws a second marble. What is the probability that",
//            "2. A die and a coin are tossed. What is the probability of getting",
//            "3. A die is rolled twice. What is the probability of getting",
//            "4. A card is drawn from a deck of cards. Then the card is replaced, the deck is reshuffled, and a second card is drawn. What is the probability of getting",
//            "5. A die has 1, 2, 3, 4, 5, and 6 on its faces. A cube has A, B, C, D, E, and F on its faces. When the die and cube are rolled, what is the probability of getting"
//    };
//
//    public String[] t5Act1SubQuestions= {
//            "(a) both marbles are red?",
//            "(b) both marbles are blue?",
//            "(c) One marble is red and the other is blue?",
//            "(a) a 3 and a head?",
//            "(b) an even number and a tail?",
//            "(c) an odd number and a head?",
//            "(d) a prime number and a tail?",
//            "(e) a factor of 6 and a head?",
//            "(a) a 2 on the first roll and a 4 on the second roll?",
//            "(b) a 5 on the first and second roll?",
//            "(c) an odd number on the first roll and an even number on the second roll?",
//            "(d) a prime number on the first roll and a multiple of 3 on the second roll?",
//            "(e) a composite number on the first roll and a divisible by 2 on the second roll?",
//            "(a) a jack on the first draw and a king on the second draw?",
//            "(b) an ace on the first draw and a heart on the second draw?",
//            "(c) a red queen on the first draw and a black king on the second draw?",
//            "(d) a diamond on the first draw and a queen of clubs on the second draw?",
//            "(e) a face card on the first draw and a number card on the second draw?",
//            "(a) a vowel and an odd number?",
//            "(b) a consonant and an even number?",
//            "(c) a letter in the word FADE and a prime number?",
//            "(d) the letter B and a factor of 6?",
//            "(e) a consonant in the word FACE and a multiple of 3?"
//    };
//
//    public String[] t5Act1Answers= {
//            "4/9","1/9","2/9","1/12","1/4","1/4","1/4","1/3","1/36","1/36","1/4","1/6","1/6","1/169","1/52","1/676","1/208","30/169","1/6","1/3","1/3","1/9","1/9"
//    };
//
//    public String getT5Act1Questions(int a) {
//        String question = t5Act1Questions[a];
//        return question;
//    }
//
//    public String getT5Act1SubQuestions(int a) {
//        String subQuestion = t5Act1SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT5Act1Answers(int a) {
//        String answer = t5Act1Answers[a];
//        return answer;
//    }

//Topic 5 Assessment

    public String[] t5ActQuestions= {
            "1. A die is rolled four times. What is the probability all results are number greater than 3?",
            "2. A die and coin are tossed. What is the probability of getting a 5 and a head?",
            "3. You roll a fair die twice. What is the probability of rolling a 4 on the first roll and a prime number on the second roll?",
            "4. What is the probability of drawing two kings from a deck of cards if the first card is replaced before the second is drawn?",
            "5. A die is tossed once and a spinner with 10 congruent sectors each of which is numbered from 1 to 10 is spun once. What is the probability of an even number turning up and the spinner stopping at an odd number?",
            "6. From a standard deck of cards, what is the probability of choosing a black and then a diamond with replacement?",
            "7. A black die and a blue die are tossed. What is the probability that a “1” shows on the black die and an “even number” shows on the blue die?",
            "8. You flip a fair coin and pick one card out of a hat containing 15 cards numbered 1 - 15. What is the probability of getting heads on the coin and a number greater than 10 from the hat?",
            "9. You randomly select two marbles from a bag that contains 10 green, 12 blue, and 8 red marbles. What is the probability that the first marble is green and the second marble is not green if you replace the first marble before selecting the second?",
            "10. A spinner at the right is divided into equal parts. Find the probability that you get 100 on your first spin and 10 on the second spin.",
            "11. A card is drawn from a deck of cards. Then the card is replaced, the card is reshuffled, and a second card is drawn. What is the probability of a “7” on the first draw and a “10” on the second?",
            "12. A jar contains 5 red balls and 2 yellow balls. A ball is drawn from the jar and returned before the next draw. What is the probability of drawing 2 red balls?",
            "13. Two dice are rolled. What is the probability that a number “5” is rolled on the first die and a factor of 4 is rolled on the second die?",
            "14. Each of the five congruent sectors of a spinner is labeled with the letters A, B, C, D, and E. What is the probability that the spinner stops at consonants if it spun twice?",
            "15. A die is tossed twice. What is the probability of getting a 1 or 2 on the first toss and a 3, 4, or 5 on the second toss?"
    };

    public String[] t5ActAnswers= {
            "1/16","1/12","1/12","1/169","1/4","1/8","1/12","1/6","2/9","1/32","1/169","25/49","1/12","16/25","5/6"
    };

    public String[][] t5ActChoices= {
            {"1/2","1/4","1/8","1/16"},
            {"1/12","5/12","7/12","11/12"},
            {"5/12","1/12","1/6","1/5"},
            {"8/169","4/169","2/169","1/169"},
            {"1/8","1/6","1/4","1/2"},
            {"1/12","1/8","1/6","1/4"},
            {"1/12","5/12","7/12","11/12"},
            {"1/8","1/6","2/13","3/13"},
            {"8/9","5/9","2/9","1/9"},
            {"1/64","1/32","1/16","1/8"},
            {"1/169","14/169","20/169","38/169"},
            {"36/39","35/49","25/49","30/49"},
            {"5/12","1/12","1/6","1/4"},
            {"21/45","20/35","16/25","4/15"},
            {"8/11","5/6","2/3","1/2"}
    };

    public String[] t5ActSolutions= {
            "\\frac{3}{6} \\times \\frac{3}{6} \\times \\frac{3}{6} = \\frac{1}{16}",
            "\\frac{1}{6} \\times \\frac{1}{2} = \\frac{1}{12}",
            "\\frac{1}{6} \\times \\frac{3}{6} = \\frac{1}{12}",
            "\\frac{4}{52} \\times \\frac{4}{52} = \\frac{1}{169}",
            "\\frac{3}{6} \\times \\frac{5}{10} = \\frac{1}{4}",
            "\\frac{26}{52} \\times \\frac{13}{52} = \\frac{1}{8}",
            "\\frac{1}{6} \\times \\frac{3}{6} = \\frac{1}{12}",
            "\\frac{1}{12} \\times \\frac{5}{15} = \\frac{1}{6}",
            "\\frac{10}{30} \\times \\frac{20}{30} = \\frac{2}{9}",
            "\\frac{1}{8} \\times \\frac{2}{8} = \\frac{1}{32}",
            "\\frac{4}{52} \\times \\frac{4}{52} = \\frac{1}{169}",
            "\\frac{5}{7} \\times \\frac{5}{7} = \\frac{25}{49}",
            "\\frac{1}{6} \\times \\frac{3}{6} = \\frac{1}{12}",
            "\\frac{4}{5} \\times \\frac{4}{5} = \\frac{16}{25}",
            "(\\frac{1}{6} + \\frac{1}{6}) \\times (\\frac{1}{6} + \\frac{1}{6} + \\frac{1}{6}) \\\\ = \\frac{5}{6}"
    };

    public String getT5ActQuestions(int a) {
        String question = t5ActQuestions[a];
        return question;
    }

    public String getT5ActAnswers(int a) {
        String answer = t5ActAnswers[a];
        return answer;
    }

    public String getT5ActSolutions(int a) {
        String answer = t5ActSolutions[a];
        return answer;
    }

    public String getT5ActChoice1(int a) {
        String choice = t5ActChoices[a][0];
        return choice;
    }

    public String getT5ActChoice2(int a) {
        String choice = t5ActChoices[a][1];
        return choice;
    }

    public String getT5ActChoice3(int a) {
        String choice = t5ActChoices[a][2];
        return choice;
    }

    public String getT5ActChoice4(int a) {
        String choice = t5ActChoices[a][3];
        return choice;
    }

//Topic 6 Activity

//    public String[] t6Act1Questions= {
//            "1. A box contains 5 white, 3 brown, and 2 green marbles. Marbles are drawn in succession without replacement. What is the probability of drawing",
//            "2. A card is drawn from a deck of cards. Then the card is not replaced, the deck is reshuffled, and a second card is drawn. What is the probability of getting",
//            "3. A bag has seven red and three green balls. Two balls are drawn in sequence without replacement. What is the probability that",
//            "4. A box of chocolates contains 12 milk chocolates, 10 dark chocolates, and 3 white chocolates. Iya randomly chooses a chocolate, eats it, and then randomly chooses another chocolate. What is the probability that Iya chooses",
//            "5. Suppose a card is selected at random from an ordinary deck of 52 playing cards.\n\nLet A = event a face card is selected\nLet B = event a king is selected\nLet C = event a heart is selected\n\nDetermine the following probabilities."
//    };
//
//    public String[] t6Act1SubQuestions= {
//            "(a) a white marble then a brown marble?",
//            "(b) a brown marble then a green marble?",
//            "(c) both marbles are brown?",
//            "(d) a white marble and then two green marbles?",
//            "(e) a white marble, followed by a green marble, then a brown marble?",
//            "(a) a jack on the first draw and a king on the second draw?",
//            "(b) an ace on the first draw and a heart on the second draw?",
//            "(c) a red queen on the first draw and a black king on the second draw?",
//            "(d) a diamond on the first draw and a queen of clubs on the second draw?",
//            "(e) a face card on the first draw and a number card on the second draw?",
//            "(a) the second ball is green?",
//            "(b) the first and the second ball is red?",
//            "(c) the second ball is green given that the first one is red?",
//            "(d) the second ball is red given that the first one is green?",
//            "(e) the second ball is green given that the first one is green?",
//            "(a) a milk chocolate and a dark chocolate?",
//            "(b) a milk chocolate and a white chocolate?",
//            "(c) a dark chocolate and a white chocolate?",
//            "(d) two dark chocolates?",
//            "(e) two white chocolates?",
//            "(a) P(A|C)",
//            "(b) P(A|B)",
//            "(c) P(B|C)",
//            "(d) P(C|B)",
//            "(e) P(C|A)"
//    };
//
//    public String[] t6Act1Answers= {
//            "1/6","1/15","1/15","1/72","1/24","4/663","4/221","1/663","1/204","40/221","3/10","7/15","3/9","7/9","2/9","1/5","3/50","1/20","3/20","1/100","3/13","1","1/13","1/4","1/4"
//    };
//
//    public String getT6Act1Questions(int a) {
//        String question = t6Act1Questions[a];
//        return question;
//    }
//
//    public String getT6Act1SubQuestions(int a) {
//        String subQuestion = t6Act1SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT6Act1Answers(int a) {
//        String answer = t6Act1Answers[a];
//        return answer;
//    }

//Topic 6 Assessment

    public String[] t6ActQuestions= {
            "1. A box contains 4 yellow marbles and 6 red marbles. What is the probability of drawing 2 yellow marbles and 1 red marble in succession without replacement?",
            "2. Two cards are selected at random from a standard deck. What is the probability that the first card is a 10 and the second card is a jack if the first card is not replaced before the second is selected?",
            "3. There are 15 marbles in the box, 11 are blue and 4 are green. If we randomly selected two marbles from this box, what is the probability of drawing a green marble and then a blue marble without replacement?",
            "4. A class is composed of 15 boys and 10 girls. If two presenters to a poem recital are to be chosen in succession, what is the probability that the first is a boy and the second is a girl?",
            "5. There are four glasses of orange juice and six glasses of red wine on the counter. Allan drinks two of them at random. What is the probability that he drank two glasses of orange juice?",
            "6. From a standard deck of cards, what is the probability of choosing a spade, then a club, then a red card without replacement?",
            "7. A box contains 6 brown marbles and 4 green marbles. What is the probability of drawing 2 green marbles and 1 brown marble without replacement?",
            "8. Mrs. Mamaradlo has to select two students from 30 girls and 10 boys to be part of the Science club. What is the probability that both students are girls?",
            "9. A box contains 12 purple caps and 8 blue caps. A cap is taken, not replaced, and then a second cap is taken. What is the probability of taking out a purple cap followed by a blue cap?",
            "10. There are 4 red shirts and 12 green shirts in a drawer. If one shirt is taken out without looking and then a second is taken out, what is the probability that they both will be green?",
            "11. Two cards are drawn from 52 cards in a deck. What is the probability of drawing an ace first followed by 3 if the first card is not replaced?",
            "12. A jar contains three white balls and five black balls. Two balls are drawn at random from the jar, one at a time without replacement. What is the probability that the first drawn ball is white and the second ball is black?",
            "13. A box of chocolates contains 10 dark chocolates, 6 milk chocolates, and 4 white chocolates. Iya randomly chooses a chocolate, eats it, and then randomly chooses another chocolate. What is the probability that Iya will choose a dark chocolate and a white chocolate?",
            "14. Two cards are drawn at random from an ordinary deck of cards. What is the probability that all cards are diamonds if no replacement is done?",
            "15. On a game show, a contestant is given three distinct digits to arrange in proper order to win a car. What is the probability of winning if the contestant guesses the position of each digit?"
    };

    public String[] t6ActAnswers= {
            "1/10","4/663","22/105","1/4","2/15","169/5100","1/10","24/52","24/95","11/20","4/663","15/56","2/19","1/17","0.06"
    };

    public String[][] t6ActChoices= {
            {"1/10","3/10","7/10","9/10"},
            {"8/241","23/41","8/663","4/663"},
            {"32/105","22/105","14/105","4/105"},
            {"1/12","1/8","1/4","1/2"},
            {"9/22","7/20","5/18","2/15"},
            {"229/5100","169/5100","119/5100","89/5100"},
            {"1/10","3/10","7/10","9/10"},
            {"33/52","31/52","24/52","27/52"},
            {"24/125","27/115","28/105","24/95"},
            {"10/17","11/20","13/21","15/22"},
            {"10/979","8/883","7/863","4/663"},
            {"15/56","13/56","11/56","9/56"},
            {"4/21","3/20","2/19","1/13"},
            {"21/22","5/22","4/17","1/17"},
            {"0.44","0.26","0.14","0.06"}
    };

    public String[] t6ActSolutions= {
            "\\frac{4}{10} \\times \\frac{3}{9} \\times \\frac{6}{8} = \\frac{1}{10}",
            "\\frac{4}{52} \\times \\frac{4}{51} = \\frac{4}{663}",
            "\\frac{4}{15} \\times \\frac{11}{14} = \\frac{22}{105}",
            "\\frac{15}{25} \\times \\frac{10}{24} = \\frac{1}{4}",
            "\\frac{4}{10} \\times \\frac{3}{9} = \\frac{2}{15}",
            "\\frac{13}{52} \\times \\frac{13}{51} \\times \\frac{26}{50} = \\frac{169}{5100}",
            "\\frac{4}{10} \\times \\frac{3}{9} \\times \\frac{6}{8} = \\frac{1}{10}",
            "\\frac{30}{40} \\times \\frac{29}{39} = \\frac{24}{52}",
            "\\frac{12}{20} \\times \\frac{8}{19} = \\frac{24}{95}",
            "\\frac{12}{16} \\times \\frac{11}{15} = \\frac{11}{20}",
            "\\frac{4}{52} \\times \\frac{4}{51} = \\frac{4}{663}",
            "\\frac{3}{8} \\times \\frac{5}{7} = \\frac{15}{56}",
            "\\frac{10}{20} \\times \\frac{4}{19} = \\frac{2}{19}",
            "\\frac{13}{52} \\times \\frac{12}{51} = \\frac{1}{17}",
            "\\frac{1}{3} \\times \\frac{1}{2} \\times \\frac{1}{1} = \\frac{1}{6} = 0.06"
    };

    public String getT6ActQuestions(int a) {
        String question = t6ActQuestions[a];
        return question;
    }

    public String getT6ActAnswers(int a) {
        String answer = t6ActAnswers[a];
        return answer;
    }

    public String getT6ActSolutions(int a) {
        String answer = t6ActSolutions[a];
        return answer;
    }

    public String getT6ActChoice1(int a) {
        String choice = t6ActChoices[a][0];
        return choice;
    }

    public String getT6ActChoice2(int a) {
        String choice = t6ActChoices[a][1];
        return choice;
    }

    public String getT6ActChoice3(int a) {
        String choice = t6ActChoices[a][2];
        return choice;
    }

    public String getT6ActChoice4(int a) {
        String choice = t6ActChoices[a][3];
        return choice;
    }

//Topic 7 Activity 1

//    public String[] t7Act1SubQuestions= {
//            "(a) 9!", "(b) 12!", "(c) <sub>5</sub>P<sub>5</sub>", "(d) 0!", "(e) n!"
//    };
//
//    public String[] t7Act1Answers= {
//            "362880","479001600","120","1",""
//    };
//
//    public String getT7Act1SubQuestions(int a) {
//        String subQuestion = t7Act1SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT7Act1Answers(int a) {
//        String answer = t7Act1Answers[a];
//        return answer;
//    }
//
////Activity 2
//
//    public String[] t7Act2SubQuestions= {
//            "(a) <i>hope</i>", "(b) <i>time</i>", "(c) <i>GENIUS</i>", "(d) <i>RIGHTS</i>", "(e) <i>EDUCATION</i>"
//    };
//
//    public String[] t7Act2Answers= {
//            "4!","4!","6!","6!","9!"
//    };
//
//    public String getT7Act2SubQuestions(int a) {
//        String subQuestion = t7Act2SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT7Act2Answers(int a) {
//        String answer = t7Act2Answers[a];
//        return answer;
//    }
//
////Activity 3
//
//    public String[] t7Act3SubQuestions= {
//            "(a) In how many ways can four different shirts be arranged in a cabinet?",
//            "(b) In how many ways can five winners in a beauty pageant be arranged in a row on the stage?",
//            "(c) In how many ways can six SUVs of different colors be arranged in a parking lot?",
//            "(d) In how many ways can seven students be lined up during the flag ceremony?",
//            "(e) How many arrangements are possible if eight different laptops are to be arranged in a computer laboratory?"
//    };
//
//    public String[] t7Act3Answers= {
//            "24","120","720","5040","40320"
//    };
//
//    public String getT7Act3SubQuestions(int a) {
//        String subQuestion = t7Act3SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT7Act3Answers(int a) {
//        String answer = t7Act3Answers[a];
//        return answer;
//    }
//
////Activity 4
//
//    public String[] t7Act4SubQuestions= {
//            "(a) How many ways can 4 students be seated in a row of 4 chairs for a pictorial?",
//            "(b) How many arrangements can be made for six different books on a shelf that can accommodate exactly these six books",
//            "(c) How many four-letter words can be formed from the letters in the word STAR?",
//            "(d) How many three-digit numbers can be formed using the digits 2,3, and 4?",
//            "(e) How many arrangements are possible for 10 different flags to be hung up in a row on the grandstand?"
//    };
//
//    public String[] t7Act4Answers= {
//            "24","720","24","6","3628800"
//    };
//
//    public String getT7Act4SubQuestions(int a) {
//        String subQuestion = t7Act4SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT7Act4Answers(int a) {
//        String answer = t7Act4Answers[a];
//        return answer;
//    }
//
////Activity 5
//
//    public String[] t7Act5SubQuestions= {
//            "(a) In how many ways can five guests and three usherettes be arranged in a row with eight seats?",
//            "(b) A couple with six children is to pose for a family picture. In how many ways can they be arranged in a row if they can take any position?",
//            "(c) How many possible arrangements can be made for 3 different math books and 4 different science books to be placed on a shelf with 7 spaces available?",
//            "(d) In how many ways can 4 teachers and 5 students be arranged in a row of chairs with 9 available seats?",
//            "(e) How many different codes are possible can be made from the two letters, A and B, and from the three numbers 1,2, and 3 if no restrictions are imposed?"
//    };
//
//    public String[] t7Act5Answers= {
//            "40320","720","5040","362880","6"
//    };
//
//    public String getT7Act5SubQuestions(int a) {
//        String subQuestion = t7Act5SubQuestions[a];
//        return subQuestion;
//    }
//
//    public String getT7Act5Answers(int a) {
//        String answer = t7Act5Answers[a];
//        return answer;
//    }

    //Topic 7 Assessment
    public String[] t7ActQuestions = {
            "1. In how many ways can Aling Marie arrange 5 potted plants in a row",
            "2. In how many ways can 6 Algebra books be arranged on a shelf?",
            "3. A test has 10 questions which a student may answer in any order. In how many different orders can a student answer these questions?",
            "4. How many permutations are there in the letters of the word COURAGE?",
            "5. How different ways can the letters of the word SILVER be arranged?",
            "6. In how many different ways can 5 customers line up to buy a cup of coffee at Starbucks?",
            "7. In how many ways may a school librarian assign 8 students to arrange the books in the library?",
            "8. There are six finalists at Pangasinan Got Talent. In how many ways can they be arranged to perform their talents?",
            "9. In how many ways can 12 different bicycles be arranged in a parking lot?",
            "10. In how many ways can 6 kids be arranged in a picture taking?",
            "11. How many permutations can be made for 4 different books on a shelf that can accommodate exactly these 4 books?",
            "12. How many ways can 5 students be seated in a row of 5 chairs?",
            "13. In how many ways can 4 boys and 2 girls be arranged in a row with no restrictions?",
            "14. In how many ways can 2 different physics books, 3 different mathematics books, and 4 different history books be arranged on a shelf with 9 spaces available?",
            "15. A couple with five children are to pose for a family picture. In how many ways can they be arranged in a row if they can take any position?"
    };

    public String[] t7ActAnswers = {
            "120", "720", "10!", "5,040", "720", "120", "40,320", "720", "12!", "720", "24", "120", "720", "9!", "5,040"
    };

    public String t7ActChoices[][] = {
            {"70","85","120","210"},
            {"450,800","720","23,100","209"},
            {"1","10","10!","1 + 10!"},
            {"120","720","5,040","40,320"},
            {"510","670","720","820"},
            {"340","120","80","60"},
            {"40,320","42,120","42,230","52,120"},
            {"540","720","780","820"},
            {"2 × 12!","2! × 12","12!","12"},
            {"720","640","580","460"},
            {"4","12","16","24"},
            {"10","25","115","120"},
            {"8","48","720","760"},
            {"2 × 3 × 4","2! × 3! × 4!","9!","9"},
            {"5,040","720","120","10"}
    };

    public String t7ActSolutions[] = {
            "{}_5P_5 = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120 \\text{ ways}",
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_{10}P_{10} = 10! = 10 × 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 3,628,800 \\text{ ways}",
            "{}_7P_7 = 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 5,040 \\text{ ways}",
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_5P_5 = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120 \\text{ ways}",
            "{}_8P_8 = 8! = 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 40,320\\text{ ways}",
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_{12}P_{12} = 12! = 12 × 11 × 10 × 9 × 8× 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 479,001,600 \\text{ ways}",
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_4P_4 = 4! = 4 × 3 × 2 × 1\\\\= 24 \\text{ ways}",
            "{}_5P_5 = 5! = 5 × 4 × 3 × 2 × 1\\\\= 120 \\text{ ways}",
            "{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}",
            "{}_9P_9 = 9! = 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 362,880\\text{ ways}",
            "{}_7P_7 = 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 5,040 \\text{ ways}"
    };

    public String getT7ActQuestions(int a) {
        String question = t7ActQuestions[a];
        return question;
    }
    public String getT7ActChoice1(int a) {
        String choice = t7ActChoices[a][0];
        return choice;
    }
    public String getT7ActChoice2(int a) {
        String choice = t7ActChoices[a][1];
        return choice;
    }
    public String getT7ActChoice3(int a) {
        String choice = t7ActChoices[a][2];
        return choice;
    }
    public String getT7ActChoice4(int a) {
        String choice = t7ActChoices[a][3];
        return choice;
    }
    public String getT7ActAnswers(int a) {
        String answer = t7ActAnswers[a];
        return answer;
    }
    public String getT7ActSolutions(int a) {
        String solution = t7ActSolutions[a];
        return solution;
    }

//Topic 8 Activity 1

    public String[] t8Act1SubQuestions= {
            "(a) <sub>10</sub>P<sub>4</sub>", "(b) <sub>6</sub>P<sub>2</sub>", "(c) <sub>5</sub>P<sub>3</sub> × <sub>6</sub>P<sub>1</sub>", "(d) <sub>4</sub>P<sub>3</sub> + <sub>3</sub>P<sub>2</sub>", "(e) <sub>x</sub>P<sub>y</sub>"
    };

    public String[] t8Act1Answers= {
            "5040","30","360","30",""
    };

    public String getT8Act1SubQuestions(int a) {
        String subQuestion = t8Act1SubQuestions[a];
        return subQuestion;
    }

    public String getT8Act1Answers(int a) {
        String answer = t8Act1Answers[a];
        return answer;
    }

//Activity 2

    public String[] t8Act2SubQuestions= {
            "(a) <i>PLANET</i>?", "(b) <i>LAWYER</i>?", "(c) <i>HUSBAND</i>?", "(d) <i>COMPUTER</i>?", "(e) <i>EARTH</i>?"
    };

    public String[] t8Act2Answers= {
            "360","360","840","840","120"
    };

    public String getT8Act2SubQuestions(int a) {
        String subQuestion = t8Act2SubQuestions[a];
        return subQuestion;
    }

    public String getT8Act2Answers(int a) {
        String answer = t8Act2Answers[a];
        return answer;
    }

//Topic 8 Activity 3

    public String[] t8Act3SubQuestions= {
            "(a) If there are 7 students, how many ways can you line up any 3 of them?",
            "(b) How many ways can 5 PTA officers in Grade 10 be elected among 20 parents?",
            "(c) How many two-digit numbers can be formed using the digits 1,2,3,4 and 5 if no digit is repeated in any number?",
            "(d) From 1000 lottery tickets that are sold, 3 tickets are to be selected for first, second, and third prizes. How many possible outcomes are there?",
            "(e) A group has 10 members. In how many ways can 4 officers consisting of president, vice-president, secretary, and treasurer be chosen?"
    };

    public String[] t8Act3Answers= {
            "210","1860480","20","997002000","5040"
    };

    public String getT8Act3SubQuestions(int a) {
        String subQuestion = t8Act3SubQuestions[a];
        return subQuestion;
    }

    public String getT8Act3Answers(int a) {
        String answer = t8Act3Answers[a];
        return answer;
    }

//Topic 8 Activity 4

    public String[] t8Act4SubQuestions= {
            "(a) the shelf is good for five books only?",
            "(b) the shelf is good for six books only?",
            "(c) the shelf is good for 7 books only?",
            "(d) two particular books are grouped together?",
            "(e) books of the same subject are grouped together?"
    };

    public String[] t8Act4Answers= {
            "6720","20160","40320","",""
    };

    public String getT8Act4SubQuestions(int a) {
        String subQuestion = t8Act4SubQuestions[a];
        return subQuestion;
    }

    public String getT8Act4Answers(int a) {
        String answer = t8Act4Answers[a];
        return answer;
    }

//Topic 8 Activity 5

    public String[] t8Act5SubQuestions= {
            "(a) Five out of 8 students are to be seated in a row of chairs. Two particular students must be in the picture. How many ways can this be done?",
            "(b) How many ways can the letters of the word “FRIEND” be arranged so that the vowels come together?",
            "(c) How many different license plate numbers can be made using the letters followed by 2 digits selected from 0 to 9, if letters and digits may not be repeated?",
            "(d) How many ordered codes can be formed using 4 of the digits in 1, 2, 3, and 4 if the digits are not repeated by must begin with 3?",
            "(e) An employee ID number at a large company consists of 3-digit numbers and a letter such as 123A, 367B, and 234Z. How many possible ID numbers are there in which all 3 digits are different?"
    };

    public String[] t8Act5Answers= {
            "120","240","2340","6","18720"
    };

    public String getT8Act5SubQuestions(int a) {
        String subQuestion = t8Act5SubQuestions[a];
        return subQuestion;
    }

    public String getT8Act5Answers(int a) {
        String answer = t8Act5Answers[a];
        return answer;
    }

    //Topic 8 Assessment

    public String[] t8ActQuestions= {
            "1. How many two-digit numbers can be made using the numbers 4, 5, 6, 7, and 8?",
            "2. Pedro has nine shirts he wears to school. How many ways can he choose a different shirt to wear on Monday, Tuesday, Wednesday, Thursday, and Friday?",
            "3. In how many ways can you arrange any three letters from the 26 letters in the alphabet?",
            "4. How many ways can you arrange 5 out of 8 books on a shelf?",
            "5. How many arrangements are there if 5 playing cards are drawn from a deck of 52 cards?",
            "6. What is the number of ways in which a 3-digit code can be formed using the numbers from the digits 2, 3, 4, 7, 8?",
            "7. How many different words with or without meaning can be formed using any 4 letters from a word containing 10 different letters?",
            "8. How many 3-letter permutations can be formed from the letters in the CHOWKING?",
            "9. A group of 12 students must select a president, a vice-president, a treasurer, and a secretary. How many ways can this be done?",
            "10. How many two-digit codes can be made out of the digits 1, 2,3,4, and 5 if no digit is repeated in any number?",
            "11. In how many ways can two different fiction books and four different non-fiction books be arranged on a shelf if the shelf is good for five books only?",
            "12. How many ways can the letters of the word “DESIGN” be arranged so that the vowels come together?",
            "13. In how many ways can 5 children be arranged in a line such that two particulars of them are always together?",
            "14. In how many ways can four different science books and two different math books be arranged on a shelf if books of the same subject are grouped together?",
            "15. In how many ways can 6 children be arranged in a line such that two particular children of them are never together?"
    };

    public String[] t8ActAnswers = {
            "20", "15,120", "15,600", "6,720", "311,875,200", "60", "5,040", "336", "11,880", "20", "840", "240", "48", "96", "480"
    };

    public String t8ActChoices[][] = {
            {"10","20","80","220"},
            {"15,120","62,280","84,100","90,210"},
            {"50,120","34,010","32,120","15,600"},
            {"120","3,400","6,720","8,120"},
            {"311,875,200","242,120","42,200","22,200"},
            {"340","120","80","60"},
            {"1,510","2,060","5,040","7,820"},
            {"224","246","270","336"},
            {"12,020","11,880","10,380","8,420"},
            {"20","60","120","720"},
            {"240","480","720","840"},
            {"120","240","480","960"},
            {"180","120","60","48"},
            {"96","48","36","24"},
            {"620","480","240","120"}
    };

    public String t8ActSolutions[] = {
            "\\text{Fundamental Counting Principle:}\\\\{}_5P_2 = 5 × 4 = 20\\\\\\\\\\text{Formula:}\\\\{}_5P_2 = \\frac{5!}{(5-2)!} = \\frac{5!}{3!} = \\frac{5 × 4 × 3!}{3!}\\\\= 20 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_9P_5 = 9 × 8 × 7 × 6 × 5 = 15,120\\\\\\\\\\text{Formula:}\\\\{}_9P_5 = \\frac{9!}{(9-5)!} = \\frac{9!}{4!} = \\frac{9 × 8 × 7 × 6 × 5 × 4!}{4!}\\\\= 15,120 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_{26}P_3 = 26 × 25 × 24 = 15,600\\\\\\\\\\text{Formula:}\\\\{}_{26}P_3 = \\frac{26!}{(26-3)!} = \\frac{26!}{23!} = \\frac{26 × 25 × 24 × 23!}{23!}\\\\= 15,600 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_8P_5 = 8 × 7 × 6 × 5 × 4 = 6,720\\\\\\\\\\text{Formula:}\\\\{}_8P_5 = \\frac{8!}{(8-5)!} = \\frac{8!}{3!} = \\frac{8 × 7 × 6 × 5 × 4 × 3!}{3!}\\\\= 6,720 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_{52}P_5 = 52 × 51 × 50 × 49 × 48 = 311,875,200\\\\\\\\\\text{Formula:}\\\\{}_{52}P_5 = \\frac{52!}{(52-5)!} = \\frac{52!}{47!} = \\frac{52 × 51 × 50 × 49 × 48 × 47!}{47!}\\\\= 311,875,200 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_5P_3 = 5 × 4 × 3 = 60\\\\\\\\\\text{Formula:}\\\\{}_5P_3 = \\frac{5!}{(5-3)!} = \\frac{5!}{2!} = \\frac{5 × 4 × 3 × 2!}{2!}\\\\= 60 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_{10}P_4 = 10 × 9 × 8 × 7 = 5,040\\\\\\\\\\text{Formula:}\\\\{}_{10}P_4 = \\frac{10!}{(10-4)!} = \\frac{10!}{6!} = \\frac{10 × 9 × 8 × 7 × 6!}{6!}\\\\= 5,040 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_8P_3 = 8 × 7 × 6 = 336\\\\\\\\\\text{Formula:}\\\\{}_8P_3 = \\frac{8!}{(8-3)!} = \\frac{8!}{5!} = \\frac{8 × 7 × 6 × 5!}{5!}\\\\= 336 \\text{ posibble arrangements}",
            "\\text{Fundamental Counting Principle:}\\\\{}_{12}P_4 = 12 × 11 × 10 × 9 = 11,880\\\\\\\\\\text{Formula:}\\\\{}_{12}P_4 = \\frac{12!}{(12-4)!} = \\frac{12!}{8!} = \\frac{12 × 11 × 10 × 9 × 8!}{8!}\\\\= 11,880 \\text{ posibble arrangements}",
            "{}_5P_2 = 20",
            "{}_6P_5 = 840",
            "{}_5P_5 \\times {}_2P_2 = 240",
            "{}_4P_4 \\times {}_2P_2 = 48",
            "({}_4P_4 \\times {}_2P_2) \\times {}_2P_2 = 96",
            "{}_6P_6 - ({}_5P_5 \\times {}_2P_2) = 480"
    };

    public String getT8ActQuestions(int a) {
        String question = t8ActQuestions[a];
        return question;
    }
    public String getT8ActChoice1(int a) {
        String choice = t8ActChoices[a][0];
        return choice;
    }
    public String getT8ActChoice2(int a) {
        String choice = t8ActChoices[a][1];
        return choice;
    }
    public String getT8ActChoice3(int a) {
        String choice = t8ActChoices[a][2];
        return choice;
    }
    public String getT8ActChoice4(int a) {
        String choice = t8ActChoices[a][3];
        return choice;
    }
    public String getT8ActAnswers(int a) {
        String answer = t8ActAnswers[a];
        return answer;
    }
    public String getT8ActSolutions(int a) {
        String solution = t8ActSolutions[a];
        return solution;
    }


    //Topic 9 Assessment

    public String[] t9ActQuestions= {
            "1. In how many ways can 10 different trees be planted in a circle?",
            "2. What is the number of circular permutations of 6 singers?",
            "3. Five different keys are to be placed on a circular key chain. How many different arrangements are there?",
            "4. In how many ways can 10 horses be arranged in a merry-go-round?",
            "5. How many ways in which 10 beads can be arranged to form a necklace?",
            "6. How many ways can eight unique beads be arranged on a chain without a clasp?",
            "7. How many ways can 7 people be seated at a circular table?",
            "8. How many circular permutations are there of the numbers on the face of the clock?",
            "9. In how many ways can 9 ladies be seated in a circle if they can sit anywhere?",
            "10. How many ways can 6 boy scouts and 3 master scouts be seated around a campfire if no restrictions are imposed?",
            "11. In how many ways can 5 students be seated in a circle if two particular students must sit next to each other?",
            "12. At a dinner party, 5 men and 5 women sit at a round table. In how many ways can they sit if Buds and Mikee must sit next to each other?",
            "13. In how many ways can eleven members of a committee sit at a round table if the President and a secretary always sit together?",
            "14. How many ways in which 5 boys and 4 girls sit around a table so that all the boys sit together?",
            "15. How many ways can 6 teachers and 6 students be seated at a round table if the teachers and the students are to occupy alternate seats?"
    };

    public String[] t9ActAnswers = {
            "362,880", "720", "24", "362,880", "362,880", "5040", "720", "11!", "40,320", "40,320", "12", "80,640", "9! × 2", "4!5!", "5! × 6!"
    };

    public String t9ActChoices[][] = {
            {"3,628,800","362,880","352,440","452,440"},
            {"720","4520","5040","6280"},
            {"5","12","24","120"},
            {"3,628,800","3,627,180","382,240","362,880"},
            {"3,628,800","362,880","352,890","325,190"},
            {"4460","4580","5040","40,320"},
            {"920","720","640","520"},
            {"11!","12! × 2","11! × 2","11! - 2!"},
            {"40,140","40,320","362,880","382,820"},
            {"40,320","42,340","342,240","362,880"},
            {"12","24","120","240"},
            {"60,640","70,604","80,640","90,460"},
            {"10! × 2","10!","9! × 2","11!2!"},
            {"9!","5!5!","4!5!","9!5!"},
            {"6! × 6!","12!","5! × 6!","12!5!"}
    };

    public String t9ActSolutions[] = {
            "",
            "",
            "",
            "",
            "",
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

    public String getT9ActQuestions(int a) {
        String question = t9ActQuestions[a];
        return question;
    }
    public String getT9ActChoice1(int a) {
        String choice = t9ActChoices[a][0];
        return choice;
    }
    public String getT9ActChoice2(int a) {
        String choice = t9ActChoices[a][1];
        return choice;
    }
    public String getT9ActChoice3(int a) {
        String choice = t9ActChoices[a][2];
        return choice;
    }
    public String getT9ActChoice4(int a) {
        String choice = t9ActChoices[a][3];
        return choice;
    }
    public String getT9ActAnswers(int a) {
        String answer = t9ActAnswers[a];
        return answer;
    }
    public String getT9ActSolutions(int a) {
        String solution = t9ActSolutions[a];
        return solution;
    }

    //Activity 6

    public String[] t10ActQuestions = {
            "1. Ana has three bags of the same kind and two makeup kits of the same kind. In how many ways can she arrange these items in a line?",
            "2. How many different nine-digit numerals can be written using the digits 2, 3, 4, 4, 5, 5, 5, 7, and 8?",
            "3. What is the number of possible arrangements of nine carbonated drinks on a refrigerator where four are Royal Tru Orange, three are Mountain Dew, and two are Sprite?",
            "4. A women’s boutique has blouses in five sizes: extra-small, small, medium, large, and extra-large. If it has two extra-small, four small, four medium, three large, and one extra-large blouse in stock, in how many ways can these blouses be sold if each is sold one after the other?",
            "5. In how many ways can four identical white shoes, three identical black shoes, and three identical red shoes be arranged in a row?",
            "6. How many arrangements are possible using the numbers 2, 2, 3, 3, 3, 4, 7, and 7?",
            "7. In how many ways the letters of the word “EXCELLENCE” be arranged?",
            "8. There are two identical white flags, three identical red flags, and four identical brown flags. Using all nine flags, how many signals can be made?",
            "9. There are two mangoes, three pineapples, four avocados, and one papaya on a table. How many ways can they be arranged?",
            "10. How many different 7-letter words can be formed from the word FOREVER?"
    };

    public String[] t10ActAnswers = {
            "10", "30,240", "1,260", "900,900", "4,200", "1,680", "37,800", "1,260", "12,600", "1,260"
    };

    public String t10ActChoices[][] = {
            {"10", "20", "11", "9"},
            {"30,440", "30,420", "30,240", "20,040"},
            {"1,660", "1,620", "1,600", "1,260"},
            {"920,900", "900,900", "900,290", "900,220"},
            {"4,200", "2,270", "3,020", "4,360"},
            {"1,880", "1,870", "1,780", "1,680"},
            {"38,780", "37,880", "37,800", "37,080"},
            {"1,620", "1,260", "1,060", "1,020"},
            {"12,600", "1,260", "14,200", "12,060"},
            {"1,860", "1,660", "1,620", "1,260"}
    };

    public String t10ActSolutions[] = {
            "\\frac{5!}{3! 2!} = \\frac{5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 10\\text{ ways} \\\\ \\text{There are 10 different arrangments.}",
            "\\frac{9!}{2! 3!} = \\frac{9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 30,240 \\text{ ways} \\\\ \\text{There are 30,240 different arrangments.}",
            "\\frac{9!}{4! 3! 2!} = \\frac{9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 1,260\\text{ ways} \\\\ \\text{There are 1,260 different arrangments.}",
            "\\frac{13!}{2! 4! 4! 3!} = \\frac{13 \\cdot 12 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 900,900\\text{ ways} \\\\ \\text{There are 900,900 different arrangments.}",
            "\\frac{10!}{4! 3! 3!} = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 4,200\\text{ ways} \\\\ \\text{There are 4,200 different arrangments.}",
            "\\frac{8!}{2! 3! 1!} = \\frac{8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 1,680\\text{ ways} \\\\ \\text{There are 1,680 different arrangments.}",
            "\\frac{10!}{4! 2! 2!} = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 37,800\\text{ ways} \\\\ \\text{There are 37,800 different arrangments.}",
            "\\frac{9!}{2! 3! 4!} = \\frac{9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 1,260\\text{ ways} \\\\ \\text{There are 1,260 different arrangments.}",
            "\\frac{10!}{2! 3! 4!} = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 12,600\\text{ ways} \\\\ \\text{There are 12,600 different arrangments.}",
            "\\frac{7!}{2! 2!} = \\frac{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 1,260\\text{ ways} \\\\ \\text{There are 1,260 different arrangments.}"
    };

    public String getT10ActQuestions(int a) {
        String question = t10ActQuestions[a];
        return question;
    }
    public String getT10ActChoice1(int a) {
        String choice = t10ActChoices[a][0];
        return choice;
    }
    public String getT10ActChoice2(int a) {
        String choice = t10ActChoices[a][1];
        return choice;
    }
    public String getT10ActChoice3(int a) {
        String choice = t10ActChoices[a][2];
        return choice;
    }
    public String getT10ActChoice4(int a) {
        String choice = t10ActChoices[a][3];
        return choice;
    }
    public String getT10ActAnswers(int a) {
        String answer = t10ActAnswers[a];
        return answer;
    }
    public String getT10ActSolutions(int a) {
        String solution = t10ActSolutions[a];
        return solution;
    }

    //Activity 7

    public String[] t11ActQuestions = {
            "1. How many different committees of 5 people can be formed from a pool of 8 people?",
            "2. In how many ways can the first five players of a basketball team be chosen from an 11-member basketball team?",
            "3. How many combinations can be made from S, I, N, G, L, E if the letters are taken four at a time?",
            "4. In a lotto with 42 numbers, how many ways can we select 6 numbers?",
            "5. A teacher requires students to answer 8 out of 10 questions, without regard to order. How many ways can this be done?",
            "6. A chalk box contains 8 green and 4 yellow chalks. In how many ways can we select 5 chalks with three green and two yellow colors?",
            "7. In how many ways can a team consisting of 3 boys and 2 girls be formed if there are 10 boys and 8 girls who qualified to be in a team?",
            "8. In how many ways can a committee consisting of 5 faculty members and 2 students be formed if there are 8 faculty and 6 students asked to be on the committee?",
            "9. A box contains 10 red balls and 4 blue balls. Three balls are drawn at random. In how many ways can the three balls be drawn from the 14 balls if all three balls are blue?",
            "10. A committee of 3 members is to be formed from 8 boys and 4 girls. The committee must include at least 2 girls. In how many ways can this be done?"
    };

    public String[] t11ActAnswers = {
            "56", "462", "15", "42! / 36!6!", "45", "336", "3,360", "840", "4", "52"
    };

    public String t11ActChoices[][] = {
            {"96", "84", "56", "114"},
            {"394", "462", "524", "672"},
            {"96", "74", "48", "15"},
            {"42! / 6!", "42! / 36!6!", "42! /36!", "42! / 36•6!"},
            {"120", "115", "90", "45"},
            {"306", "316", "336", "356"},
            {"3,360", "3,560", "3,760", "3,870"},
            {"840", "890", "960", "980"},
            {"74", "46", "18", "4"},
            {"48", "52", "86", "94"}
    };

    public String t11ActSolutions[] = {
            "n=8\\text{, }r=5 \\\\ {}_8C_5 = \\frac{8!}{(8-5)!5!} = \\frac{8!}{3!5!} \\\\ = 56 \\text{ ways}",
            "n=11\\text{, }r=5 \\\\ {}_{11}C_5 = \\frac{11!}{(11-5)!5!} = \\frac{11!}{6!5!} \\\\ = 462 \\text{ ways}",
            "n=6\\text{, }r=4 \\\\ {}_6C_4 = \\frac{6!}{(6-4)!4!} = \\frac{6!}{2!4!} \\\\ = 15 \\text{ ways}",
            "n=42\\text{, }r=6 \\\\ {}_{42}C_6 = \\frac{42!}{(42-6)!6!} = \\frac{42!}{36!6!} \\\\ = 5,245,786 \\text{ ways}",
            "n=10\\text{, }r = 8 \\\\ {}_{10}C_8 = \\frac{10!}{(10-8)!8!} = \\frac{10!}{2!8!} \\\\ = 45 \\text{ ways}",
            "\\text{Need to select 3 out of 8 green chalks and\\\\2 out of 4 yellow chalks.} \\\\ {}_8C_3 \\cdot {}_4C_2 = (56 \\cdot 6) = 336 \\text{ ways}",
            "\\text{Need to select 3 out of 10 boys and\\\\2 out of 8 girls to form a team.} \\\\ {}_{10}C_3 \\cdot {}_8C_2 = (120 \\cdot 28) = 3,360 \\text{ ways}",
            "\\text{Need to select 5 out of 8 faculty and\\\\3 out of 5 students to form a committee.}\\\\ {}_8C_5 \\cdot {}_6C_2 = (56 \\cdot 15) = 840 \\text{ ways}",
            "\\text{Need to select 3 balls out of 4 blue balls.} \\\\ n=4\\text{, }r=3 \\\\ {}_4C_3 = \\frac{4!}{(4-3)!3!} = \\frac{4!}{1!3!} = 4 \\text{ ways}",
            "\\text{Since the committee needs at least 2\\\\girls to form a committee of 3 members,\\\\then the number of girls needed in the\\\\committee could either be 2 or 3.\\\\So, if there are 2 girls in the committee,\\\\then it needs 1 boy to complete the\\\\members in the committee.} \\\\ {}_4C_2 \\cdot {}_8C_1 \\\\ \\text{- apply the FCP to get the number of ways\\\\to form a committee with 2 girls and 1 boy\\\\While if there are 3 girls in the committee,\\\\then, there is no need from the number of\\\\boys since the members in the committee\\\\are already complete.} \\\\ {}_4C_3 \\cdot {}_8C_0 \\\\ \\text{- apply the FCP to get the number of ways\\\\to form a committee with 3 girls and 0 boy\\\\After which, add the combination results\\\\to get the desired result.} \\\\ {}_4C_2 \\cdot {}_8C_1 + {}_4C_3 \\cdot {}_8C_0 \\\\ = (6 \\cdot 8) + (4 \\cdot 1) = 48 + 4 \\\\ = 52 \\text{ ways} \\\\ \\text{There are 52 different committees.}"
    };

    public String getT11ActQuestions(int a) {
        String question = t11ActQuestions[a];
        return question;
    }
    public String getT11ActChoice1(int a) {
        String choice = t11ActChoices[a][0];
        return choice;
    }
    public String getT11ActChoice2(int a) {
        String choice = t11ActChoices[a][1];
        return choice;
    }
    public String getT11ActChoice3(int a) {
        String choice = t11ActChoices[a][2];
        return choice;
    }
    public String getT11ActChoice4(int a) {
        String choice = t11ActChoices[a][3];
        return choice;
    }
    public String getT11ActAnswers(int a) {
        String answer = t11ActAnswers[a];
        return answer;
    }
    public String getT11ActSolutions(int a) {
        String solution = t11ActSolutions[a];
        return solution;
    }

    //Topic 12

    public String[] t12ActQuestions = {
            "1. How many outfits are possible with 5 pairs of pants, 4 t-shirts, and 3 shoes?",
            "2. The Parent-Teacher Association will be electing new officers. There are 6 candidates for president, 7 candidates for vice-president, and 4 candidates for secretary. How many possible different combinations of officers are possible?",
            "3. The digits 1, 2, 3, 5, 6, and 7, are to be used to form a six-digit number. How many different numbers can be formed such that no digits can be used more than once?",
            "4. A coin is tossed three times. How many different outcomes are possible?",
            "5. How many four-digit numbers can you form using the digits 1, 3, 4, 7, and 9 without repetition?",
            "6. How many numbers greater than 30 000 can be formed from the digits 1,2,3,4, and 5 if repetition is allowed?",
            "7. A coin is tossed, and a die is rolled. How many outcomes are possible?",
            "8. A current license plate format in the Philippines consists of three letters followed by four numbers for a four-wheel car (e.g. ABC 1234). How many different license plates are possible?",
            "9. A multiple choice exam has 5 questions. Each question has three options: A, B, and C. How many different ways to answer the test?",
            "10. Suppose an experiment consists of tossing a coin four times. How many outcomes have at least 3 heads?"
    };

    public String[] g1Act12Answers = {
            "60","90","720","8","120","1,875","12","175,760,000","243","5"
    };

    public String t12ActChoices[][] = {
            {"85","60","36","9"},
            {"14","90","120","150"},
            {"910","720","540","120"},
            {"8","18","32","40"},
            {"18","30","45","120"},
            {"1,645","1,825","1,875","1,965"},
            {"12","18","21","64"},
            {"175,760,000","6,760","700","260"},
            {"523","475","345","243"},
            {"5","12","16","20"}
    };

    public String t12ActSolutions[] = {
            "5 \\cdot 4 \\cdot 3 = 60",
            "6 \\cdot 7 \\cdot 4 = 90",
            "6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1 = 720",
            "2 \\cdot 2 \\cdot 2 \\cdot 2 \\cdot 2 = 32",
            "5 \\cdot 4 \\cdot 3 \\cdot 2 = 120",
            "3 \\cdot 5 \\cdot 5 \\cdot 5 \\cdot 5 = 1,875",
            "2 \\cdot 6 = 12",
            "26 \\cdot 26 \\cdot 26 \\cdot 10 \\cdot 10 \\cdot 10 \\cdot 10 \\\\ =175,760,000",
            "3 \\cdot 3 \\cdot 3 \\cdot 3 \\cdot 3 = 3^5 = 243",
            "\\text{The possible outcomes with at least three heads\\\\are HHHH, HHHT, HHTH, HTHH, and THHH.\\\\Thus, there are 5 possible outcomes.}"
    };

    public String getT12ActQuestions(int a) {
        String question = t12ActQuestions[a];
        return question;
    }

    public String getT12ActChoice1(int a) {
        String choice = t12ActChoices[a][0];
        return choice;
    }

    public String getT12ActChoice2(int a) {
        String choice = t12ActChoices[a][1];
        return choice;
    }

    public String getT12ActChoice3(int a) {
        String choice = t12ActChoices[a][2];
        return choice;
    }

    public String getT12ActChoice4(int a) {
        String choice = t12ActChoices[a][3];
        return choice;
    }

    public String getT12ActAnswers(int a) {
        String answer = g1Act12Answers[a];
        return answer;
    }

    public String getT12ActSolutions(int a) {
        String solution = t12ActSolutions[a];
        return solution;
    }
}
