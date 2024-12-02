package ex09;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Ex9 {
  private JFrame frame;
  private JScrollPane imgScrollPane;
  private JScrollPane scrollPane2;
  private JTextField textField;
  private JTextArea textArea;
  private ImagePanel imagePanel;


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ex9 window = new Ex9();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ex9() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(120, 0));
    frame.getContentPane().add(panel, BorderLayout.WEST);
    JLabel lblNewLabel = new JLabel("File Name");
    panel.add(lblNewLabel);
    
    textField = new JTextField();
    panel.add(textField);
    textField.setColumns(10);
    
    
    imgScrollPane = new JScrollPane();
    frame.getContentPane().add(imgScrollPane, BorderLayout.CENTER);
    imagePanel = new ImagePanel();
    imgScrollPane.setViewportView(imagePanel);
    
    scrollPane2 = new JScrollPane();
    frame.getContentPane().add(scrollPane2, BorderLayout.SOUTH);
    
    textArea = new JTextArea();
    scrollPane2.setViewportView(textArea);
    
    JButton btnNewButton = new JButton("Load");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String fileName = textField.getText();
        BufferedImage img;
        try {
          img = ImageIO.read(new File(fileName));
          imagePanel.setImage(img);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
          textArea.append(e1.toString());
        }
      }
    });
    panel.add(btnNewButton);
    
  }
}
