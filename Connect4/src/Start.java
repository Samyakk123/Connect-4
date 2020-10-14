import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;

/**
 * Create main page
 * 
 * @author Aryan Patel, Samyak Metha
 *
 */
public class Start extends JFrame {

    private JPanel contentPane;
    private JFrame current;

    /**
     * Start's Class Constructor. Requires no parameters.
     */
    public Start() {
        // current JFrame variable required to return back to this JFrame once you enter
        // other JFrames
        this.current = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(main.x, main.y, 800, 550);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // button that takes user to the "Play" JFrame which displays the game board and
        // where the game is played.
        // Player plays against a computer
        JLabel Computer = new JLabel("");
        Computer.setHorizontalAlignment(SwingConstants.RIGHT);
        Computer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Difficulty frame = new Difficulty();
                frame.setVisible(true);
                current.setVisible(false);
                current.dispose();
            }
            public void mouseEntered(MouseEvent arg0) {
                Computer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Computer.png")));
            }
            public void mouseExited(MouseEvent arg0) {
                
                Computer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("computerSmall.png")));
            }
        });
        Computer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("computerSmall.png")));
        Computer.setBounds(522, 449, 264, 64);
        contentPane.add(Computer);

        // Check if application has moved
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                main.x = getBounds().x;
                main.y = getBounds().y;

                main.setValues(getBounds().x, getBounds().y);
            }
        });

        // JLabel button that takes users to the "gameInstruction" JFrame.
        JLabel Instruction = new JLabel("");
        Instruction.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                GameInstructions newFrame = new GameInstructions(current);
                current.setVisible(false);
                newFrame.setVisible(true);
            }
            public void mouseEntered(MouseEvent arg0) {
                Instruction.setIcon(new ImageIcon(getClass().getClassLoader().getResource("cooltext325036038343695.png")));
            }
            public void mouseExited(MouseEvent arg0) {
                
                Instruction.setIcon(new ImageIcon(getClass().getClassLoader().getResource("guide.png")));
            }
        });

        Instruction.setIcon(new ImageIcon(getClass().getClassLoader().getResource("guide.png")));
        Instruction.setBounds(3, 449, 161, 69);
        contentPane.add(Instruction);

        // JLabel button that takes users to the "Play" JFrame which displayers the game
        // board and where the game is played.
        // PLayer will play against another player
        JLabel player = new JLabel("");
        player.setHorizontalAlignment(SwingConstants.RIGHT);
        player.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                Play frame = new Play(true, 0);

                frame.setVisible(true);
                current.dispose();
            }
            public void mouseEntered(MouseEvent arg0) {
                player.setIcon(new ImageIcon(getClass().getClassLoader().getResource("P vs p.png")));
            }
            public void mouseExited(MouseEvent arg0) {
                
                player.setIcon(new ImageIcon(getClass().getClassLoader().getResource("pvsp.png")));
            }
        });
        player.setIcon(new ImageIcon(getClass().getClassLoader().getResource("pvsp.png")));
        player.setBounds(614, 394, 169, 57);
        contentPane.add(player);

        // sets the background image
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("MainBoard.jpg")));
        label.setBounds(-100, 0, 1032, 511);
        contentPane.add(label);
    }

    // when the program starts, it calls this method which creates a "Start" Window
    // builder JFrame and makes it visible to the user
    public void makeFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Start frame = new Start();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
