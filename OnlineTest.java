package OnlineTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
        JLabel label;
        Container contr;
        

	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
         
	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
            
		super(s);
		label = new JLabel();
                add(label);
                
                //Background Color
                contr= getContentPane();
                contr.setLayout(new FlowLayout());
                setVisible(true);
                setSize(400,250);
                contr.setBackground(Color.green);
                
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
	
                //Size descriptions
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Q1:  What is our College's name?");
			radioButton[0].setText("Kengeri University");
			radioButton[1].setText("St Paul's University");
			radioButton[2].setText("Christ University");
			radioButton[3].setText("Martin University");
		}
		if (current == 1) {
			label.setText("Q2:  What is the vision statement of Christ University?");
			radioButton[0].setText("Excellence & Service");
			radioButton[1].setText("Excellence & Social Service");
			radioButton[2].setText("Academics & Excellence");
			radioButton[3].setText("Computational Excellence and service");
		}
		if (current == 2) {
			label.setText("Q3: At which year was Btech IT started in the University?");
			radioButton[0].setText("2011");
			radioButton[1].setText("2009");
			radioButton[2].setText("2010");
			radioButton[3].setText("2006");
		}
		if (current == 3) {
			label.setText("Q4: What is the CSE Department's Vision and Mission?");
			radioButton[0].setText("Excellence & Service");
			radioButton[1].setText("Excellence & Social Service");
			radioButton[2].setText("To Fortify Ethical Computational Excellence");
			radioButton[3].setText("To Fortify Academic Excellence");
		}
		if (current == 4) {
			label.setText("Q5: At which year was Btech CSE started in the University??");
			radioButton[0].setText("2011");
			radioButton[1].setText("2009");
			radioButton[2].setText("2010");
			radioButton[3].setText("2006");
		}
		if (current == 5) {
			label.setText("Q6: What does PSO stand for??");
			radioButton[0].setText("Program Specific Outcomes");
			radioButton[1].setText("Program Special Outcomes");
			radioButton[2].setText("Program Super Outcomes");
			radioButton[3].setText("Performance Specific Outcomes");
		}
		if (current == 6) {
			label.setText("Q7:  What does NBA stand for?");
			radioButton[0].setText("National Binding Association");
                        radioButton[1].setText("National Board of Accreditation");
			radioButton[2].setText("National Blind Association");
			radioButton[3].setText("National Binding Accreditation");
		}
		if (current == 7) {
			label.setText("Q8:  Which of the following is not a Honour course?");
			radioButton[0].setText("Artificial Intelligence");
			radioButton[1].setText("Data Analytics");
			radioButton[2].setText("Cyber Security");
			radioButton[3].setText("Ethical Hacking");
		}
		if (current == 8) {
			label.setText("Q9: Which of the following is not a Cisco course provided to the University?");
			radioButton[0].setText("CCNA R & S");
			radioButton[1].setText("NDG Linux");
			radioButton[2].setText("Cyber Security");
			radioButton[3].setText("DBMS");
		}
		if (current == 9) {
			label.setText("Q10: Btech comprises of how many semesters?");
			radioButton[0].setText("7");
			radioButton[1].setText("9");
			radioButton[2].setText("8");
			radioButton[3].setText("4");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[2].isSelected());
		if (current == 1)
			return (radioButton[0].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[2].isSelected());
		return false;
	}

	public static void main(String s[]) {
                
		new OnlineTest("Online Test App");
	}

}
