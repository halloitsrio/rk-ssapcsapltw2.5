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
      //get player
      Player currPlayer = (currentPlayer == 1) ? player1 : player2;
      System.out.println("--------------------------------------");

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

      //check user guess
      correct = board.guessLetter(guess);
      //System.out.println(correct);
      solved = board.isSolved(guess);
      //System.out.println(solved);

      //assign points
      if (correct) {
        currPlayer.setPoints(currPlayer.getPoints() + letterValue);
      } else if (solved) {
        partiallySolvedPhrase = guess;
        currPlayer.setPoints(currPlayer.getPoints() + letterValue);
        System.out.println("Congrats! You found the secret phrase: " + partiallySolvedPhrase);
      }
      
      // tell user current score
      System.out.println("Current points of player " + currentPlayerName + ": " + currPlayer.getPoints());

      //change player if wrong guess
      if (!correct && !solved) {
        if (currentPlayer == 1) {
          currentPlayer = 2;
        } else {
          currentPlayer = 1;
        }
      }
      
      /* your code here - determine how game ends */
      solved = board.isSolved(partiallySolvedPhrase);
    } 

    //declare winner
    Player currPlayer;

    if (player1.getPoints() > player2.getPoints()) {
      currPlayer = player1;
    } else {
      currPlayer = player2;
    }

    System.out.println("The winner is player " + currPlayer.getName() + " with  " + currPlayer.getPoints() + "!!!");

    input.close();
  }
  
}
