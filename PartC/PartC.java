// PROJECT TITLE: Midterm PartC
// AUTHOR NAME: GIORGOS-PANAGIOTIS KATSONIS
// PURPOSE OF PROJECT: To visually express ritualistic suicide
// VERSION or DATE: v 2.3
// AUTHORS: giorgos_katsonis@hotmail.com 
// COPYRIGHT INFORMATION:  Content is copyright © Open Source Guides authors, released under CC-BY-4.0.

//Calculations related libraries
import java.util.ArrayList;
import java.util.List;

//GUI Related libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class PartC extends JFrame implements ActionListener {

  //Declares all needed variables
  private JTextField peopleField;
  private JTextField suicideField;

  private TitledBorder suiNumBorder;
  private TitledBorder peopleFieldBorder;

  private JLabel infoLabel;

  private JButton submitButton;

  private JPanel panelMain;
  private JPanel infoPanel;
  private JPanel inputPanel;

  private int countButton;
  private int peopleNum;
  private int suicideNum;

  List<Integer> excludedKeyList;


  public PartC() {
    suiNumBorder = new TitledBorder("Number of death");
    peopleFieldBorder = new TitledBorder("Number of victims");

    peopleField = new JTextField(15);
    peopleField.setHorizontalAlignment(JTextField.CENTER);
    peopleField.setBorder(peopleFieldBorder);

    suicideField = new JTextField(10);
    suicideField.setHorizontalAlignment(JTextField.CENTER);
    suicideField.setBorder(suiNumBorder);

    infoLabel = new JLabel("Welcome! Please enter a number of people (up to 20) and a suicide number!");

    submitButton = new JButton("Begin");
    submitButton.addActionListener(this);

    panelMain = new JPanel();
    infoPanel = new JPanel();
    inputPanel = new JPanel();

    infoPanel.add(infoLabel);
    infoPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    infoPanel.setLayout(new FlowLayout());

    inputPanel.add(suicideField);
    inputPanel.add(peopleField);
    inputPanel.add(submitButton);
    inputPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    inputPanel.setLayout(new FlowLayout());

    countButton = 0;

    excludedKeyList = new ArrayList<Integer>();
    
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(panelMain, BorderLayout.CENTER);
    getContentPane().add(inputPanel, BorderLayout.NORTH);
    getContentPane().add(infoPanel, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
    try {
      peopleNum = Integer.parseInt(peopleField.getText());
    } catch (Exception d) {
      infoLabel.setText("Please input a valid value.");
      return;
    }

    try {
      suicideNum = Integer.parseInt(suicideField.getText());
    } catch (Exception d) {
      infoLabel.setText("Please input a valid value.");
      return;
    }

    panelMain.setVisible(false);
    panelMain.removeAll();
    peopleField.setEditable(false);
    suicideField.setEditable(false);
    int excludedKey = -1;
    int count = 0;
    SpringLayout layout = new SpringLayout();
    panelMain.setLayout(layout);

    SuicideSelector select = new SuicideSelector();

    if (peopleNum <= 20 || peopleNum >= 0) {
      submitButton.setText("EXTERMINATE");
      Point centre = new Point(200, 200);
      double angle = Math.toRadians(360 / peopleNum);
      int radius = 180;

      //The bracket notation is used to indicate a specific type of object accepted by the list.
      List<Point> points = new ArrayList<Point>();

      //Run the selector to figure out the winning position.
      int survivalPos = select.selector(peopleNum, suicideNum);

      if (e.getActionCommand().equals("Begin")) {

        //Add points
        for (int i = 0; i < peopleNum; i++) {
          double theta = i * angle;
          int dx = (int) (radius * Math.sin(theta));
          int dy = (int) (-radius * Math.cos(theta));
          Point p = new Point(centre.x + dx, centre.y + dy);
          points.add(p);
        }

        //For-each loop. It will repeat for all items in a vector (the points of our list in this case)
        for (Point point : points) {
          //Place a ready made label with the subject's name in the proper positions.
          JLabel label = select.listCreator(peopleNum, count, survivalPos);
          label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
          panelMain.add(label);
          //Since we know the coordinates of each point it is easy to set the constraints for Spring Layout.
          layout.putConstraint(SpringLayout.WEST, label, point.x, SpringLayout.WEST, panelMain);
          layout.putConstraint(SpringLayout.NORTH, label, point.y, SpringLayout.NORTH, panelMain);
          count++;
        }
      }
      else {
        for (int i = 0; i < peopleNum; i++) {
          double theta = i * angle;
          int dx = (int) (radius * Math.sin(theta));
          int dy = (int) (-radius * Math.cos(theta));
          Point p = new Point(centre.x + dx, centre.y + dy);
          points.add(p);
        }


        excludedKey = select.stepSelector(peopleNum, suicideNum, survivalPos, countButton);
        if (excludedKey != survivalPos) {
          excludedKeyList.add(excludedKey);
        }

        //For-each loop. It will repeat for all items in a vector (the points of our list in this case)
        for (Point point : points) {
          //Place a ready made label with the subject's name in the proper positions.
          JLabel label = select.listCreator(peopleNum, count, survivalPos);
          
          infoLabel.setText(select.listAnalyze.first.nameArray[excludedKeyList.get(countButton - 1)] + " is gone");
          
          if (excludedKeyList.contains(select.listAnalyze.first.getKey(label.getText()))) {
            label.setText("DEAD");
          }
          
          if (countButton == peopleNum - 1) {
            infoLabel.setText("Kitsos remains alive!");
            submitButton.removeActionListener(this);
          }
 
          label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
          panelMain.add(label);

          //Since we know the coordinates of each point it is easy to set the constraints for Spring Layout.
          layout.putConstraint(SpringLayout.WEST, label, point.x, SpringLayout.WEST, panelMain);
          layout.putConstraint(SpringLayout.NORTH, label, point.y, SpringLayout.NORTH, panelMain);
          
          count++;
        }
      }
      countButton++;
      panelMain.setVisible(true);
    } else {
      infoLabel.setText("Please enter a valid number (Integer smaller or equal to 20)");
    }
  }
  
  public static void main(String[] args) {
    PartC frame = new PartC();
    frame.setSize(520, 540);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

}