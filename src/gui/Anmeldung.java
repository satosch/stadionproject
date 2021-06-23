package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Anmeldung extends JPanel{

	MainFrame mf;
	String str;
	private JTextField textField;

	public Anmeldung(MainFrame m, String s) {
		mf = m;
		str = s;
		this.setBounds(100, 100, 571, 604);
		
		JLabel label = new JLabel("New User Registration");
		this.add(label, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(11,2));
		
		JLabel label1 = new JLabel("Anrede");
		JLabel label2 = new JLabel("Vorname");
		JLabel label3 = new JLabel("Nachname");
		JLabel label4 = new JLabel("Straße und Hausnummer");
		JLabel label5 = new JLabel("PLZ");
		JLabel label6 = new JLabel("Email-adresse");
		JLabel label7 = new JLabel("Tel");
		JLabel label8 = new JLabel("Username");
		JLabel label9 = new JLabel("Password");
		JLabel leer1 = new JLabel("");
		JLabel leer2 = new JLabel("");
		
		JTextField txt1 = new JTextField();
		JTextField txt2 = new JTextField();
		JTextField txt3 = new JTextField();
		JTextField txt4 = new JTextField();
		JTextField txt5 = new JTextField();
		JTextField txt6 = new JTextField();
		JTextField txt7 = new JTextField();
		JTextField txt8 = new JTextField();
		JTextField txt9 = new JTextField();
		
		txt1.setColumns(10);
		txt2.setColumns(10);
		txt3.setColumns(10);
		txt4.setColumns(10);
		txt5.setColumns(10);
		txt6.setColumns(10);
		txt7.setColumns(10);
		txt8.setColumns(10);
		txt9.setColumns(10);
		
		JButton anmelden = new JButton("anmelden");
		JButton zuruck = new JButton("Zurück");
		
		panel.add(label1);
		panel.add(txt1);
		panel.add(label2);
		panel.add(txt2);
		panel.add(label3);
		panel.add(txt3);
		panel.add(label4);
		panel.add(txt4);
		panel.add(label5);
		panel.add(txt5);
		panel.add(label6);
		panel.add(txt6);
		panel.add(label7);
		panel.add(txt7);
		panel.add(label8);
		panel.add(txt8);
		panel.add(label9);
		panel.add(txt9);
		panel.add(leer1);
		panel.add(anmelden);
		panel.add(leer2);
		panel.add(zuruck);
		
		
				
		
	}

}
