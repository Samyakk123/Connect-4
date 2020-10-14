import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * List out the difficulty JFrame and the list of difficulty the user can choose
 * 
 * @author Aryan Patel, Samyak Metha
 *
 */
public class Difficulty extends JFrame {

    private JPanel contentPane;
    private JFrame current;
    private JLabel easyDifficulty, easyDifficultySmall, veryEasyDifficulty, veryHardDifficulty, hardDifficulty,
            mediumDifficulty, mediumDifficultySmall, hardDifficultySmall, veryEasyDifficultySmall,
            veryHardDifficultySmall, playAgain;

    /**
     * Create the frame
     */
    public Difficulty() {

        this.current = this;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(main.x, main.y, 800, 551);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // VeryHard Buttom
        veryHardDifficulty = new JLabel("");
        veryHardDifficulty.setIcon(new ImageIcon(getClass().getClassLoader().getResource("VeryHardBig.png")));
        veryHardDifficulty.setVisible(false);
        veryHardDifficulty.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                Play frame = new Play(false, 6);
                frame.setVisible(true);
                current.setVisible(false);
                current.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                veryHardDifficulty.setVisible(true);
                veryHardDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                veryHardDifficulty.setVisible(false);
                veryHardDifficultySmall.setVisible(true);
            }
        });

        // VeryEasy Buttom
        veryEasyDifficulty = new JLabel("");
        veryEasyDifficulty.setIcon(new ImageIcon(getClass().getClassLoader().getResource("VeryEasyBig.png")));
        veryEasyDifficulty.setVisible(false);
        veryEasyDifficulty.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Play frame = new Play(false, 2);
                frame.setVisible(true);
                current.setVisible(false);
                current.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                veryEasyDifficulty.setVisible(true);
                veryEasyDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                veryEasyDifficulty.setVisible(false);
                veryEasyDifficultySmall.setVisible(true);
            }
        });

        // Easy Button
        easyDifficultySmall = new JLabel("");
        easyDifficultySmall.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                easyDifficulty.setVisible(true);
                easyDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                easyDifficulty.setVisible(false);
                easyDifficultySmall.setVisible(true);
            }
        });

        // PlayAgain Button
        playAgain = new JLabel("Play Again!");
        playAgain.setIcon(new ImageIcon(getClass().getClassLoader().getResource("back40Small.png")));
        playAgain.setBounds(668, 457, 116, 65);
        playAgain.setVisible(true);
        contentPane.add(playAgain);

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

        // Animation
        easyDifficultySmall.setIcon(new ImageIcon(getClass().getClassLoader().getResource("EasySmall.png")));
        easyDifficultySmall.setBounds(95, 207, 137, 61);
        contentPane.add(easyDifficultySmall);
        veryEasyDifficulty.setBounds(201, 322, 137, 111);
        contentPane.add(veryEasyDifficulty);
        veryHardDifficulty.setBounds(412, 322, 150, 111);
        contentPane.add(veryHardDifficulty);
        easyDifficultySmall.setVisible(true);

        // Hard Button
        hardDifficulty = new JLabel("");
        hardDifficulty.setIcon(new ImageIcon(getClass().getClassLoader().getResource("HardBig.png")));
        hardDifficulty.setVisible(false);
        hardDifficulty.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                Play frame = new Play(false, 5);
                frame.setVisible(true);
                current.setVisible(false);
                current.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                hardDifficulty.setVisible(true);
                hardDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                hardDifficulty.setVisible(false);
                hardDifficultySmall.setVisible(true);
            }
        });
        hardDifficulty.setBounds(528, 207, 158, 61);
        contentPane.add(hardDifficulty);

        // Medium Button
        mediumDifficulty = new JLabel("");
        mediumDifficulty.setIcon(new ImageIcon(getClass().getClassLoader().getResource("MediumBig.png")));
        mediumDifficulty.setVisible(false);
        mediumDifficulty.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                Play frame = new Play(false, 4);
                frame.setVisible(true);
                current.setVisible(false);
                current.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                mediumDifficulty.setVisible(true);
                mediumDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                mediumDifficulty.setVisible(false);
                mediumDifficultySmall.setVisible(true);
            }
        });
        mediumDifficulty.setBounds(278, 207, 218, 61);
        contentPane.add(mediumDifficulty);

        // Easy Button
        easyDifficulty = new JLabel("");
        easyDifficulty.setIcon(new ImageIcon(getClass().getClassLoader().getResource("EasyBig.png")));
        easyDifficulty.setVisible(false);
        easyDifficulty.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                Play frame = new Play(false, 3);
                frame.setVisible(true);
                current.setVisible(false);
                current.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                easyDifficulty.setVisible(true);
                easyDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                easyDifficulty.setVisible(false);
                easyDifficultySmall.setVisible(true);
            }
        });
        easyDifficulty.setBounds(95, 207, 137, 61);
        contentPane.add(easyDifficulty);

        // Title
        JLabel title = new JLabel("");
        title.setVisible(true);
        title.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ChooseDifficulty.png")));
        title.setBounds(51, 69, 692, 61);
        contentPane.add(title);

        // Animation
        mediumDifficultySmall = new JLabel("");
        mediumDifficultySmall.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                mediumDifficulty.setVisible(true);
                mediumDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                mediumDifficulty.setVisible(false);
                mediumDifficultySmall.setVisible(true);
            }
        });
        mediumDifficultySmall.setIcon(new ImageIcon(getClass().getClassLoader().getResource("MediumSmall.png")));
        mediumDifficultySmall.setBounds(278, 207, 218, 61);
        contentPane.add(mediumDifficultySmall);

        // Animation
        hardDifficultySmall = new JLabel("");
        hardDifficultySmall.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                hardDifficulty.setVisible(true);
                hardDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                hardDifficulty.setVisible(false);
                hardDifficultySmall.setVisible(true);
            }
        });
        hardDifficultySmall.setIcon(new ImageIcon(getClass().getClassLoader().getResource("HardSmall.png")));
        hardDifficultySmall.setBounds(528, 207, 158, 61);
        contentPane.add(hardDifficultySmall);

        // Animation
        veryEasyDifficultySmall = new JLabel("");
        veryEasyDifficultySmall.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                veryEasyDifficulty.setVisible(true);
                veryEasyDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                veryEasyDifficulty.setVisible(false);
                veryEasyDifficultySmall.setVisible(true);
            }
        });
        veryEasyDifficultySmall.setIcon(new ImageIcon(getClass().getClassLoader().getResource("VeryEasySmall.png")));
        veryEasyDifficultySmall.setBounds(201, 322, 137, 111);
        contentPane.add(veryEasyDifficultySmall);

        // Animation
        veryHardDifficultySmall = new JLabel("");
        veryHardDifficultySmall.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                veryHardDifficulty.setVisible(true);
                veryHardDifficultySmall.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                veryHardDifficulty.setVisible(false);
                veryHardDifficultySmall.setVisible(true);
            }
        });
        veryHardDifficultySmall.setIcon(new ImageIcon(getClass().getClassLoader().getResource("VeryHardSmall.png")));
        veryHardDifficultySmall.setBounds(412, 322, 150, 111);
        contentPane.add(veryHardDifficultySmall);

        // Background
        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(getClass().getClassLoader().getResource("BackImage.jpg")));
        Background.setBounds(0, 0, 784, 512);
        contentPane.add(Background);

        // Check if application moved
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                main.x = getBounds().x;
                main.y = getBounds().y;

                main.setValues(getBounds().x, getBounds().y);
            }
        });
    }
}
