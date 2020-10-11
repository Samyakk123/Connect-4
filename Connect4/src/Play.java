
/**
 * this is the main board where the game is played. JFrame is created as soon as user clicks either
 * "Player vs Player" button or "Computer button".
 * 
 * @author Aryan, Adarsh
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Play extends JFrame {

  // global variables used to access them in different functions
  private JPanel contentPane;
  private final JLabel gameBoard = new JLabel("");
  private JLabel one, oneb, two,twob, Column1, Column2, Column3, Column4, Column5, Column6, Column7, Star, Star2, Tie, playAgain;
  private int colSelected, difficulty;
  private int turn = 1;
  private int winner = 0;
  private JLabel[][] redGrid = new JLabel[6][7];
  private JLabel[][] yellowGrid = new JLabel[6][7];
  private int[][] grid = new int[6][7];
  private JFrame current, main;
  private boolean type;


  /**
   * Play's Class Constructor
   * 
   * @param type - boolean type of which of the button "P vs P" or "computer" was selected. If it
   *        was true, the it is player vs player, else its player vs computer
   */
  public Play(boolean type, int difficulty) {
    resetBoard(grid);
    this.current = this;
    this.type = type;
    this.difficulty = difficulty;



    Scanner in = new Scanner(System.in);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 550);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    // JLables with pictures imported
    // repeated with different images until line 145
    // large number 1 JLabel image
    oneb = new JLabel("");
    oneb.setVisible(true);

    // Star JLabel image displayed for the player one
    Star = new JLabel("");
    Star.setIcon(new ImageIcon(Play.class.getResource("/images/STAR.png")));
    Star.setBounds(19, 143, 74, 74);
    Star.setVisible(false);

    // Tie JLabel image displayed if there is a tie
    Tie = new JLabel("");
    Tie.setIcon(new ImageIcon(Play.class.getResource("/images/TIE.png")));
    Tie.setBounds(276, -11, 327, 113);
    Tie.setVisible(false);

    playAgain = new JLabel("Play Again!");
    playAgain.setBounds(681, 419, 93, 81);
    playAgain.setVisible(false);
    contentPane.add(playAgain);
    contentPane.add(Tie);
    contentPane.add(Star);

    playAgain.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent arg0) {
        Start Start = new Start();
        Start.setVisible(true);
        current.dispose();

      }
    });



    Star2 = new JLabel("");
    Star2.setIcon(new ImageIcon(Play.class.getResource("/images/STAR.png")));
    Star2.setBounds(694, 141, 74, 74);
    Star2.setVisible(false);
    contentPane.add(Star2);
    oneb.setIcon(new ImageIcon(Play.class.getResource("/images/111.png")));
    oneb.setBounds(26, 212, 73, 92);
    contentPane.add(oneb);

    // small number 1 JLabel image
    one = new JLabel("");
    one.setVisible(false);
    one.setIcon(new ImageIcon(Play.class.getResource("/images/11.png")));
    one.setBounds(26, 230, 73, 74);
    contentPane.add(one);

    // small number 2 JLabel image
    two = new JLabel("");
    two.setVisible(true);
    two.setIcon(new ImageIcon(Play.class.getResource("/images/22.png")));
    two.setBounds(695, 212, 66, 99);
    contentPane.add(two);

    // Big number 2 JLabel image
    twob = new JLabel("");
    twob.setVisible(false);
    twob.setIcon(new ImageIcon(Play.class.getResource("/images/222.png")));
    twob.setBounds(695, 212, 73, 92);
    contentPane.add(twob);

    // Each Column is a JLabel and has a arrow image imported which shows the
    // possible places where user can play their turn
    // repeated for each column
    Column1 = new JLabel("");
    Column1.setIcon(new ImageIcon(Play.class.getResource("/images/down35.png")));
    Column1.setBounds(139, 32, 35, 42);
    contentPane.add(Column1);

    Column2 = new JLabel("");
    Column2.setIcon(new ImageIcon(Play.class.getResource("/images/down35.png")));
    Column2.setBounds(215, 32, 35, 42);
    contentPane.add(Column2);

    Column3 = new JLabel("");
    Column3.setIcon(new ImageIcon(Play.class.getResource("/images/down35.png")));
    Column3.setBounds(292, 32, 35, 42);
    contentPane.add(Column3);

    Column4 = new JLabel("");
    Column4.setIcon(new ImageIcon(Play.class.getResource("/images/down35.png")));
    Column4.setBounds(368, 32, 35, 42);
    contentPane.add(Column4);

    Column5 = new JLabel("");
    Column5.setIcon(new ImageIcon(Play.class.getResource("/images/down35.png")));
    Column5.setBounds(442, 32, 35, 42);
    contentPane.add(Column5);

    Column6 = new JLabel("");
    Column6.setIcon(new ImageIcon(Play.class.getResource("/images/down35.png")));
    Column6.setBounds(518, 32, 35, 42);
    contentPane.add(Column6);

    Column7 = new JLabel("");
    Column7.setIcon(new ImageIcon(Play.class.getResource("/images/down35.png")));
    Column7.setBounds(594, 32, 35, 42);
    contentPane.add(Column7);

    // creates a 2d array of JLabel yellow pieces
    // filling the board with the pieces
    // set the visibility of each pieces to invisible
    for (int i = 0; i < yellowGrid.length; i++) {
      for (int j = 0; j < yellowGrid[i].length; j++) {
        yellowGrid[i][j] = new JLabel("");
        yellowGrid[i][j].setIcon(new ImageIcon(Play.class.getResource("/images/cYellow.png")));
        yellowGrid[i][j].setBounds(126 + j * 76, 424 - i * 67, 73, 67);
        contentPane.add(yellowGrid[i][j]);
        yellowGrid[i][j].setVisible(false);
        // Filling in all the red spots
        redGrid[i][j] = new JLabel("");
        redGrid[i][j].setIcon(new ImageIcon(Play.class.getResource("/images/cRed.png")));
        redGrid[i][j].setBounds(126 + j * 76, 424 - i * 67, 73, 67);
        contentPane.add(redGrid[i][j]);
        redGrid[i][j].setVisible(false);
        
      }
    }


    gameBoard.setIcon(new ImageIcon(Play.class.getResource("/images/Connect4Board.png")));
    gameBoard.setBounds(41, 65, 706, 503);
    contentPane.add(gameBoard);
    gameBoard.setVisible(true);

    // set the background image
    JLabel Background = new JLabel("");
    Background.setIcon(new ImageIcon(Play.class.getResource("/images/BlueBackgronud.jpg")));
    Background.setBounds(0, 0, 784, 511);
    contentPane.add(Background);

    // during a players turn, once a column is selected, calls the takeTurn
    // function.
    // repeated for each of the columns
    Column1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        colSelected = 0;
        takeTurn();
      }
    });
    Column2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        colSelected = 1;
        takeTurn();
      }
    });
    Column3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        colSelected = 2;
        takeTurn();
      }
    });
    Column4.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        colSelected = 3;
        takeTurn();
      }
    });
    Column5.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        colSelected = 4;
        takeTurn();
      }
    });
    Column6.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        colSelected = 5;
        takeTurn();
      }
    });
    Column7.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        colSelected = 6;
        takeTurn();
      }
    });

  }
  public void resetBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = 0;
      }
    }
  }

  // function that is called once a column is selected
  private void takeTurn() {
    // winCheck() determines if there 4 in a row for either players, if there is,
    // returns either 1 or 2
    winner = winCheck(grid);
    // turn variable starts at int 0. After each players turn, it adds 1
    // allowing to differentiate between the players turn
    if (turn % 2 == 1) {
      // places the player 1 piece as the very bottom of the column selected
      putAtBottom(grid, colSelected, 1);
      turn++;
      // function that displays who's turn it is using JLabels (one, oneB, two, twoB)
      whichTurn();
      // if computer button was selected, calls the same function again for computer
      // turn
      if (type == false) {
        takeTurn();
      }
    } else if (turn % 2 == 0) {
      // dependent on the gamemode the user chooses
      if (type == true) {
        // player vs player
        putAtBottom(grid, colSelected, 2);
        turn++;
        whichTurn();
      } else if (type == false) {
        // Player vs computer
        if (winner != 1) {
          colSelected = miniMax(grid, difficulty, -1000000, 1000000, true)[0];
          putAtBottom(grid, colSelected, 2);
          turn++;
          whichTurn();
        }
      }

    }
    winner = winCheck(grid);
    // checks for ties
    if (Tie() == true) {
      winner = 3;
    }
    // displays the winner with JLabels
    if (winner != 0) {
      // if player one won
      playAgain.setVisible(true);
      if (winner == 1) {
        two.setVisible(false);
        twob.setVisible(false);
        oneb.setVisible(true);
        one.setVisible(false);
        Star.setVisible(true);
        // if player two won
      } else if (winner == 2) {
        one.setVisible(false);
        oneb.setVisible(false);
        twob.setVisible(true);
        two.setVisible(false);
        Star2.setVisible(true);
        // if there is a tie
      } else if (winner == 3) {
        one.setVisible(false);
        oneb.setVisible(false);
        twob.setVisible(false);
        two.setVisible(false);
        Star2.setVisible(false);
        Tie.setVisible(true);
      }
      // one there is a winner, calls removeRow where it makes all columns invisible
      for (int i = 0; i < 7; i++) {
        removeRow(i);
      }
    }
  }

  /**
   * checks for ties depending on if the top row is filled
   * 
   * @return a boolean type if there is a tie or not
   */
  public boolean Tie() {
    int count = 0;
    // looping through the top row, if the index does not equal 0 (meaning that
    // there is a piece), adds one to count
    for (int i = 0; i < grid[0].length; i++) {
      if (grid[0][i] != 0) {
        count++;
      }
    }
    // if there is no current winner on the last piece placed and all of the pieces
    // at top row are full, returns true as in there is a tie
    if (count == 7 && winner == 0) {
      return true;
    }
    // else there is no tie, and returns false
    return false;

  }

  // Gets possible rows
  public ArrayList<Integer> getValidLocation(int[][] board) {
    ArrayList<Integer> validLocations = new ArrayList<>();

    for (int i = 0; i < board[0].length; i++) {
      if (board[0][i] == 0) {
        validLocations.add(i);
      }
    }
    return validLocations;
  }

  // function used to removeRows
  // if a column is filled with pieces, it removes the row not allowing the user
  // to place in that column
  public void removeRow(int col) {
    if (col == 0) {
      Column1.setVisible(false);
    } else if (col == 1) {
      Column2.setVisible(false);
    } else if (col == 2) {
      Column3.setVisible(false);
    }

    else if (col == 3) {
      Column4.setVisible(false);
    }

    else if (col == 4) {
      Column5.setVisible(false);
    }

    else if (col == 5) {
      Column6.setVisible(false);
    } else if (col == 6) {
      Column7.setVisible(false);
    }
  }

  // displays whos turn it is to the user using JLabel
  public void whichTurn() {
    // if its the first player
    if (turn % 2 == 1) {
      oneb.setVisible(true);
      one.setVisible(false);
      two.setVisible(true);
      twob.setVisible(false);
      // if its the second player
    } else if (turn % 2 == 0) {
      oneb.setVisible(false);
      one.setVisible(true);
      two.setVisible(false);
      twob.setVisible(true);
    }

  }

  /**
   * putAtBottom checks if a move is valid, and makes the move if it is
   * 
   * @param column (int) - column selected to place piece
   * @param player (int) - whose turn it is (player 1 or 2)
   */
  public int putAtBottom(int[][] board, int column, int player) {


    int i = getOpenRow(board,column);



    // while loop iterates through the board, checking for empty places
    
    board[i][column] = player;
    // making player pieces visible
    if (player == 1) {
      yellowGrid[5 - i][column].setVisible(true);
    } else if (player == 2) {
      redGrid[5 - i][column].setVisible(true);
    }

    // removes column button if it is full
    if (board[0][column] != 0) {
      removeRow(column);
    }
    
    // Returns the row number from 0-5 inclusive if there is a row available in a column and places
    // the pieces there.

    return i;
  }

  public int getOpenRow(int[][] board, int column) {

    int i = board.length - 1;

    while (i >= 0) {
      if (board[i][column] == 0) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }

  public int evaluateWindow(int[] array, int piece) {
    int score = 0;
    int oppPiece = 1;
    if (piece == 1) {
      oppPiece = 2;
    }

    int pieceCount = 0;
    int emptyCount = 0;
    int oppPieceCount = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] == piece) {
        pieceCount += 1;
      } else if (array[i] == 0) {
        emptyCount += 1;
      } else if (array[i] == oppPiece) {
        oppPieceCount += 1;
      }
    }


    if (pieceCount == 4) {
      score += 100;
    } else if (pieceCount == 3 && emptyCount == 1) {
      score += 5;
    } else if (pieceCount == 2 && emptyCount == 2) {
      score += 3;
    }

    if (oppPieceCount == 3 && emptyCount == 1) {
      score -= 25;
    }



    return score;
  }



  public int scoreCheck(int[][] board, int piece) {

    int score = 0;

    // HORIZONTAL CHECKING
    int[] temp = new int[4];
    for (int ROW = 0; ROW < board.length; ROW++) {
      for (int COLUMN = 0; COLUMN < board[0].length - 3; COLUMN++) {
        for (int k = 0; k < 4; k++) {
          temp[k] = board[ROW][COLUMN + k];
        }
        score += evaluateWindow(temp, piece);
      }
    }

    // VERTICAL CHECKING
    for (int COLUMN = 0; COLUMN < board[0].length; COLUMN++) {
      for (int ROW = 0; ROW < board.length - 3; ROW++) {
        for (int k = 0; k < 4; k++) {
          temp[k] = board[ROW + k][COLUMN];
        }
        score += evaluateWindow(temp, piece);
      }
    }

    // DIAGONAL FROM TOP LEFT to BOTTOM RIGHT
    for (int ROW = 0; ROW <= 2; ROW++) {
      for (int COLUMN = 0; COLUMN <= 3; COLUMN++) {
        for (int k = 0; k < 4; k++) {
          temp[k] = board[ROW + k][COLUMN + k];
        }
        score += evaluateWindow(temp, piece);
      }
    }

    // DIAGONAL FROM TOP RIGHT TO BOTTOM LEFT
    for (int ROW = 0; ROW <= 2; ROW++) {
      for (int COLUMN = 3; COLUMN <= board.length; COLUMN++) {
        for (int k = 0; k < 4; k++) {
          temp[k] = board[ROW + k][COLUMN - k];
        }
        score += evaluateWindow(temp, piece);
      }
    }
    return score;
  }

  public boolean terminal_node(int[][] board) {
    return winCheck(board) == 1 || winCheck(board) == 2 || getValidLocation(board).size() == 0;
  }

  public int[][] cloneBoard(int[][] board) {

    int[][] clone = new int[6][7];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        clone[i][j] = board[i][j];
      }
    }

    return clone;
  }

  // maximizingPlayer is the AI peice
  public int[] miniMax(int[][] board, int depth, int alpha, int beta,
      boolean maximizingPlayer) {
    ArrayList<Integer> validLocations = getValidLocation(board);

    int newCol = 0;
    boolean is_terminal = terminal_node(board);
    if (depth == 0 || is_terminal) {

      if (is_terminal) {
        // 3 conditions (refer to terminal node)
        // First condition: If AI has the winning move
        if (winCheck(board) == 2) {

          return new int[] {-1, 100000000};


        }
        // Second condition: If Player has the winning move
        else if (winCheck(board) == 1) {
          return new int[] {-1, -100000000};

        }
        // Game is over no more valid moves
        else {
          return new int[] {-1, 0};



        }

      }
      // Depth is zero therefore find the heristic value of the board
      // 2 is your AI peice
      else {

        return new int[] {-1, scoreCheck(board, 2)};
      }
    }
    if (maximizingPlayer) {
      int value = -1000000000;
      newCol = validLocations.get(0);
      for (int col : validLocations) {
        int row = getOpenRow(board, col);
        int[][] boardClone = cloneBoard(board);
        boardClone[row][col] = 2;
        int newScore = miniMax(boardClone, depth - 1, alpha, beta, false)[1];
        if (newScore > value) {
          value = newScore;
          newCol = col;
        }

        alpha = Math.max(alpha, value);
        if (alpha >= beta) {
          break;
        }

      }

      return new int[] {newCol, value};

    }
    // Minimizing player
    else {
      int value = 1000000000;
      newCol = validLocations.get(0);
      for (int col : validLocations) {
        int row = getOpenRow(board, col);
        int[][] boardClone = cloneBoard(board);
        boardClone[row][col] = 1;
        int newScore = miniMax(boardClone, depth - 1, alpha, beta, true)[1];
        if (newScore < value) {
          value = newScore;
          newCol = col;
        }

        beta = Math.min(beta, value);
        if (alpha >= beta) {
          break;
        }
      }

      return new int[] {newCol, value};
    }
  }

  /**
   * checks for winner
   * 
   * @return winner
   */
  public int winCheck(int[][] board) {

    // check horizontal
    // nested for loops iterate though board grid (until column 4) to see if there
    // are 4 in a row
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] != 0) {
          // if there are 4 in a row horizontally, returns winner
          if ((board[i][j] == board[i][j + 1]) && (board[i][j + 1] == board[i][j + 2])
              && (board[i][j + 2] == board[i][j + 3])) {
            return board[i][j];
          }
        }
      }
    }

    // check vertical
    // nested for loops iterate though board grid (until row 3) to see if there are
    // 4 in a row
    for (int i = 0; i < board[0].length; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[j][i] != 0) {
          // if there are 4 in a row vertically, returns winner
          if ((board[j][i] == board[j + 1][i]) && (board[j + 1][i] == board[j + 2][i])
              && (board[j + 2][i] == board[j + 3][i])) {
            return board[j][i];
          }
        }
      }
    }

    // check diagonal (left to right)
    // nested for loops iterate though board grid to see if there are 4 in a row
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[j][i] != 0) {
          // if there are 4 in a row diagonally, returns winner
          if ((board[j][i] == board[j + 1][i + 1]) && (board[j + 1][i + 1] == board[j + 2][i + 2])
              && (board[j + 2][i + 2] == board[j + 3][i + 3])) {
            return board[j][i];
          }
        }
      }
    }

    // check diagonal(right to left)
    // nested for loops iterate though board grid to see if there are 4 in a row
    for (int i = 6; i > 2; i -= 1) {
      for (int j = 0; j < 3; j++) {
        if (board[j][i] != 0) {
          // if there are 4 in a row diagonally, returns winner
          if ((board[j][i] == board[j + 1][i - 1]) && (board[j + 1][i - 1] == board[j + 2][i - 2])
              && (board[j + 2][i - 2] == board[j + 3][i - 3])) {
            return board[j][i];
          }
        }
      }
    }

    return 0; // returns 0 if no winner detected
  }

}
