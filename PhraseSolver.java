/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;

  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */


  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      //display current player name
      String currentPlayerName = (currentPlayer == 1) ? player1.getName() : player2.getName();
      System.out.println("Current Player: " + currentPlayerName);

      // display partially solved phrase
      String partiallySolvedPhrase = board.getPartiallySolvedPhrase();
      System.out.println("Partially Solved Phrase: " + partiallySolvedPhrase);

      //show point value of next letter guess
      int letterValue = board.getCurrentLetterValue();
      System.out.println("Point Value of Next Letter Guess: " + letterValue);

      //get user guess
      System.out.println("Please enter your guess (full phrase or letter): ");
      String guess = input.nextLine();

      if (guess.length() == 1) {
        boolean ifFound;
        ifFound = board.guessLetter(guess);
      } else {
        solved = board.isSolved(guess);
      }

      //change player
      if (currentPlayer == 1) {
        currentPlayer = 2;
      } else {
        currentPlayer = 1;
      }
      
      /* your code here - determine how game ends */
      solved = board.isSolved(partiallySolvedPhrase);
    } 

    input.close();
  }
  
}
