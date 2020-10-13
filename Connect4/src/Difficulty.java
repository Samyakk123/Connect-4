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

public class Difficulty extends JFrame {

  private JPanel contentPane;
  private JFrame current;
  private JLabel easyDifficulty, easyDifficultySmall, veryEasyDifficulty, veryHardDifficulty,
      hardDifficulty, mediumDifficulty, mediumDifficultySmall, hardDifficultySmall,
      veryEasyDifficultySmall, veryHardDifficultySmall;


  /**
   * Create the frame.
   */
  public Difficulty() {
    this.current = this;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 551);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    veryHardDifficulty = new JLabel("");
    veryHardDifficulty
        .setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryHardBig.png")));
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

    veryEasyDifficulty = new JLabel("");
    veryEasyDifficulty
        .setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryEasyBig.png")));
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
    easyDifficultySmall
        .setIcon(new ImageIcon(Difficulty.class.getResource("/images/EasySmall.png")));
    easyDifficultySmall.setBounds(95, 207, 137, 61);
    contentPane.add(easyDifficultySmall);
    veryEasyDifficulty.setBounds(201, 322, 137, 111);
    contentPane.add(veryEasyDifficulty);
    veryHardDifficulty.setBounds(412, 322, 150, 111);
    contentPane.add(veryHardDifficulty);
    easyDifficultySmall.setVisible(true);

    hardDifficulty = new JLabel("");
    hardDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/HardBig.png")));
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

    mediumDifficulty = new JLabel("");
    mediumDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/MediumBig.png")));
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

    easyDifficulty = new JLabel("");
    easyDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/EasyBig.png")));
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

    JLabel title = new JLabel("");
    title.setVisible(true);
    title.setIcon(new ImageIcon(Difficulty.class.getResource("/images/ChooseDifficulty.png")));
    title.setBounds(52, 47, 692, 61);
    contentPane.add(title);

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
    mediumDifficultySmall
        .setIcon(new ImageIcon(Difficulty.class.getResource("/images/MediumSmall.png")));
    mediumDifficultySmall.setBounds(278, 207, 218, 61);
    contentPane.add(mediumDifficultySmall);

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
    hardDifficultySmall
        .setIcon(new ImageIcon(Difficulty.class.getResource("/images/HardSmall.png")));
    hardDifficultySmall.setBounds(528, 207, 158, 61);
    contentPane.add(hardDifficultySmall);

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
    veryEasyDifficultySmall
        .setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryEasySmall.png")));
    veryEasyDifficultySmall.setBounds(201, 322, 137, 111);
    contentPane.add(veryEasyDifficultySmall);

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
    veryHardDifficultySmall
        .setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryHardSmall.png")));
    veryHardDifficultySmall.setBounds(412, 322, 150, 111);
    contentPane.add(veryHardDifficultySmall);

    JLabel Background = new JLabel("");
    Background.setIcon(new ImageIcon(Play.class.getResource("/images/BlueBackgronud.jpg")));
    Background.setBounds(0, 0, 784, 512);
    contentPane.add(Background);
  }
}
