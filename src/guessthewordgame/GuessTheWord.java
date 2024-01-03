package guessthewordgame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

private static final List<String> WORDS = Arrays.asList("apple", "dog", "cat", "book");
    

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        String wordToGuess = pickWord();
        char[] inputChars = new char[wordToGuess.length()];
        //Hide the chars in the word with *
        Arrays.fill(inputChars, '*');
        
        //Max attempts
        int lives = 3;
        
        System.out.println("Guess the word: " + String.valueOf(inputChars));
        
        try (Scanner scanner = new Scanner(System.in)) {
        	validateInput( lives,  scanner,  wordToGuess, inputChars);
        }
        
    }
    
    //Randomly pick a word
    private static String pickWord() {
        Random random = new Random();
        return WORDS.get(random.nextInt(WORDS.size()));
    }

    //Validates the input
    private static void validateInput(int lives, Scanner scanner, String wordToGuess, char[] inputChars) {
    while (lives > 0) {
    
    System.out.print("Enter a letter: ");
    char userGuess = scanner.next().charAt(0);

    //Correct input
    if (containsLetter(wordToGuess, userGuess)) {
    updateCorrectlyGuessedLetters(wordToGuess, inputChars, userGuess);
   
    //If all the letters are guessed correctly, stop the execution and show the congrats message
    if (Arrays.equals(wordToGuess.toCharArray(), inputChars)) {
        System.out.println("You have won the game. The word is : " + wordToGuess);
        return;
    } 
    // If the current guess is correct, show current message and continue with the next input
    else {
    System.out.println("Correct. " + String.valueOf(inputChars));
    }
        
    } else { // Incorrect input. Lives decrement.
        lives--;
        System.out.println("Incorrect! 1 life lost. "+ lives + " remaining. The current word is " + String.valueOf(inputChars));
    }

    
    } 
    	return;
    }
    
    //Check if the letter entered is preent in the word.
    private static boolean containsLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }
    
    //Remove the asterisk for the correct guess
    private static void updateCorrectlyGuessedLetters(String word, char[] guessedLetters, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedLetters[i] = letter;
            }
        }
        
    }

}

