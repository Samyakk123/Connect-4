import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Brain of the game Player vs Player or Player vs AI
 * 
 * @author Aryan Patel, Samyak Metha
 *
 */
public class Play extends JFrame {

    private JPanel contentPane;
    private final JLabel gameBoard = new JLabel("");
    private JLabel one, oneb, two, twob, Column1, Column2, Column3, Column4, Column5, Column6, Column7, Star, Star2,
            Tie, playAgain;
    private int colSelected, difficulty;
    private int turn = 1;
    private int winner = 0;
    private JLabel[][] redGrid = new JLabel[6][7];
    private JLabel[][] yellowGrid = new JLabel[6][7];
    private int[][] grid = new int[6][7];
    private Board board;
    private JFrame current;
    private boolean type;
    private HashMap<Integer, JLabel> map;
    private String red = "cRed.png";
    private String yellow = "CYellow.png";
    private String decider = "CYellow.png";

    /**
     * Play's Class Constructor
     * 
     * @param type - boolean type of which of the button "P vs P" or "computer" was selected. If it was
     *        true, the it is player vs player, else its player vs computer
     */
    public Play(boolean type, int difficulty) {

        this.current = this;

        this.board = new Board();
        this.type = type;
        this.difficulty = difficulty;
        this.map = new HashMap<Integer, JLabel>();
        resetBoard(grid);
        Scanner in = new Scanner(System.in);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(main.x, main.y, 800, 550);
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
        // Star.setIcon(new ImageIcon(Play.class.getResource("/images/STAR.png")));
        Star.setIcon(new ImageIcon(getClass().getClassLoader().getResource("STAR.png")));


        Star.setBounds(19, 143, 74, 74);
        Star.setVisible(false);

        // Tie JLabel image displayed if there is a tie
        Tie = new JLabel("");
        Tie.setIcon(new ImageIcon(getClass().getClassLoader().getResource("TIE.png")));
        Tie.setBounds(276, -10, 327, 113);
        Tie.setVisible(false);

        playAgain = new JLabel("Play Again!");
        playAgain.setIcon(new ImageIcon(getClass().getClassLoader().getResource("back40Small.png")));
        playAgain.setBounds(668, 457, 116, 65);
        playAgain.setVisible(true);

        // Each Column is a JLabel and has a arrow image imported which shows the
        // possible places where user can play their turn
        // repeated for each column
        Column1 = new JLabel("");
        Column1.setVerticalAlignment(SwingConstants.TOP);
        Column1.setHorizontalAlignment(SwingConstants.CENTER);
        Column1.setBounds(126, 17, 63, 478);
        contentPane.add(Column1);

        // during a players turn, once a column is selected, calls the takeTurn
        // function.
        // repeated for each of the columns
        Column1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Column1.setIcon(null);
                colSelected = 0;
                takeTurn();
                Column1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));

            }

            public void mouseEntered(MouseEvent e) {
                Column1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseExited(MouseEvent e) {
                Column1.setIcon(null);
            }
        });

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
            public void mouseEntered(MouseEvent arg0) {
                playAgain.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Back40.png")));
            }
            public void mouseExited(MouseEvent arg0) {
                
                playAgain.setIcon(new ImageIcon(getClass().getClassLoader().getResource("back40Small.png")));
            }
        });

        Star2 = new JLabel("");
        Star2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("STAR.png")));
        Star2.setBounds(694, 141, 74, 74);
        Star2.setVisible(false);
        contentPane.add(Star2);
        oneb.setIcon(new ImageIcon(getClass().getClassLoader().getResource("111.png")));
        oneb.setBounds(26, 212, 73, 92);
        contentPane.add(oneb);

        // small number 1 JLabel image
        one = new JLabel("");
        one.setVisible(false);
        one.setIcon(new ImageIcon(getClass().getClassLoader().getResource("11.png")));
        one.setBounds(26, 230, 73, 74);
        contentPane.add(one);

        // small number 2 JLabel image
        two = new JLabel("");
        two.setVisible(true);
        two.setIcon(new ImageIcon(getClass().getClassLoader().getResource("22.png")));
        two.setBounds(695, 212, 66, 99);
        contentPane.add(two);

        // Big number 2 JLabel image
        twob = new JLabel("");
        twob.setVisible(false);
        twob.setIcon(new ImageIcon(getClass().getClassLoader().getResource("222.png")));
        twob.setBounds(695, 212, 73, 92);
        contentPane.add(twob);

        Column2 = new JLabel("");
        Column2.setVerticalAlignment(SwingConstants.TOP);
        Column2.setBounds(202, 17, 63, 478);
        contentPane.add(Column2);


        Column3 = new JLabel("");
        Column3.setVerticalAlignment(SwingConstants.TOP);
        Column3.setBounds(279, 17, 63, 478);
        contentPane.add(Column3);

        Column4 = new JLabel("");
        Column4.setVerticalAlignment(SwingConstants.TOP);
        Column4.setBounds(355, 17, 63, 478);
        contentPane.add(Column4);

        Column5 = new JLabel("");
        Column5.setVerticalAlignment(SwingConstants.TOP);
        Column5.setBounds(430, 17, 63, 478);
        contentPane.add(Column5);

        Column6 = new JLabel("");
        Column6.setVerticalAlignment(SwingConstants.TOP);
        Column6.setBounds(507, 17, 63, 478);
        contentPane.add(Column6);

        Column7 = new JLabel("");
        Column7.setVerticalAlignment(SwingConstants.TOP);
        Column7.setBounds(583, 17, 63, 478);
        contentPane.add(Column7);

        this.setRemoveRowHashmap();

        // creates a 2d array of JLabel yellow pieces
        // filling the board with the pieces
        // set the visibility of each pieces to invisible
        for (int i = 0; i < yellowGrid.length; i++) {
            for (int j = 0; j < yellowGrid[i].length; j++) {
                yellowGrid[i][j] = new JLabel("");
                yellowGrid[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("CYellow.png")));
                yellowGrid[i][j].setBounds(126 + j * 76, 424 - i * 67, 73, 67);
                contentPane.add(yellowGrid[i][j]);
                yellowGrid[i][j].setVisible(false);

                redGrid[i][j] = new JLabel("");
                redGrid[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("cRed.png")));
                redGrid[i][j].setBounds(126 + j * 76, 424 - i * 67, 73, 67);
                contentPane.add(redGrid[i][j]);
                redGrid[i][j].setVisible(false);

            }
        }


        gameBoard.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Connect4Board.png")));
        gameBoard.setBounds(41, 65, 706, 503);
        contentPane.add(gameBoard);
        gameBoard.setVisible(true);

        // set the background image
        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(getClass().getClassLoader().getResource("BlueBackgronud.jpg")));
        Background.setBounds(0, 0, 784, 511);
        contentPane.add(Background);

        Column2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Column2.setIcon(null);
                colSelected = 1;
                takeTurn();
                Column2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseEntered(MouseEvent e) {
                Column2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseExited(MouseEvent e) {
                Column2.setIcon(null);
            }
        });

        Column3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Column3.setIcon(null);
                colSelected = 2;
                takeTurn();
                Column3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseEntered(MouseEvent e) {
                Column3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseExited(MouseEvent e) {
                Column3.setIcon(null);
            }
        });

        Column4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Column4.setIcon(null);
                colSelected = 3;
                takeTurn();
                Column4.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseEntered(MouseEvent e) {
                Column4.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseExited(MouseEvent e) {
                Column4.setIcon(null);
            }
        });
        Column5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Column5.setIcon(null);
                colSelected = 4;
                takeTurn();
                Column5.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseEntered(MouseEvent e) {
                Column5.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseExited(MouseEvent e) {
                Column5.setIcon(null);
            }
        });
        Column6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Column6.setIcon(null);
                colSelected = 5;
                takeTurn();
                Column6.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseEntered(MouseEvent e) {
                Column6.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseExited(MouseEvent e) {
                Column6.setIcon(null);
            }
        });

        Column7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Column7.setIcon(null);
                colSelected = 6;
                takeTurn();
                Column7.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseEntered(MouseEvent e) {
                Column7.setIcon(new ImageIcon(getClass().getClassLoader().getResource(decider)));
            }

            public void mouseExited(MouseEvent e) {
                Column7.setIcon(null);
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                main.x = getBounds().x;
                main.y = getBounds().y;

                main.setValues(getBounds().x, getBounds().y);
            }
        });
    }

    /**
     * Resets Board if player wants to play again
     * 
     * @param board the board
     */
    public void resetBoard(int[][] board) {
      // Once the game is finished return all values to null 
      // If the users want to play again
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * Places piece at the next available row given an available column
     * 
     * @param board the board
     * @param column the column
     * @param player the player piece
     * @return the row number
     */
    public int putAtBottom(int[][] board, int column, int player) {
     // Place the piece in the bottom most row
        int i = this.board.getOpenRow(board, column);
        board[i][column] = player;

        if (player == 1) {
            yellowGrid[5 - i][column].setVisible(true);
        } else if (player == 2) {
            redGrid[5 - i][column].setVisible(true);
        }

        // removes column button if it is full
        if (board[0][column] != 0) {
            this.map.get(column).setVisible(false);
        }
        return i;
    }

    /**
     * Player move
     */
    private void takeTurn() {

        // Check for winner
        winner = this.board.winCheck(grid);

        if (turn % 2 == 1) {
            decider = red;
            turn++;
            putAtBottom(grid, colSelected, 1);

            // function that displays who's turn it is using JLabels (one, oneB, two, twoB)
            whichTurn();
            // if computer button was selected, calls the same function again for computer
            // turn
            if (type == false) {
                takeTurn();
            }

        } else if (turn % 2 == 0) {
            decider = yellow;

            // Player vs Player
            if (type == true) {
                putAtBottom(grid, colSelected, 2);
                turn++;
                whichTurn();

                // Player vs Computer
            } else if (type == false) {

                if (winner != 1) {
                // If playing against the AI use our minimax algorithm
                    colSelected = this.board.miniMax(grid, difficulty, -1000000, 1000000, true)[0];
                    putAtBottom(grid, colSelected, 2);
                    turn++;
                    whichTurn();
                }
            }

        }

        winner = this.board.winCheck(grid);

        if (this.board.Tie(grid, winner) == true) {
            winner = 3;
        }

        // Visuals to display winner
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
                this.map.get(i).setVisible(false);
            }
        }
    }

    // function used to removeRows
    // if a column is filled with pieces, it removes the row not allowing the user
    // to place in that column
    private void setRemoveRowHashmap() {
        this.map.put(0, Column1);
        this.map.put(1, Column2);
        this.map.put(2, Column3);
        this.map.put(3, Column4);
        this.map.put(4, Column5);
        this.map.put(5, Column6);
        this.map.put(6, Column7);

    }

    // Visuals to display player turn
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
}
