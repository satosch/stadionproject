package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Anmeldung extends JPanel{

	MainFrame mf;
	String str;
	private JTextField textField;

	public Anmeldung(MainFrame m, String s) {
		mf = m;
		str = s;
		this.setName(s);
		this.setBounds(100, 100, 571, 604);
		
		JLabel label = new JLabel("New User Registration");
		this.add(label, BorderLayout.NORTH);
		
		JPanel apanel = new JPanel();
		this.add(apanel, BorderLayout.CENTER);
		apanel.setLayout(new GridLayout(11,2));
		
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
		anmelden.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pc(mf.PanelNames[1]);
			}
		});
		JButton zuruck = new JButton("Zurück");
		zuruck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pc(mf.PanelNames[0]);
			}
		});
		
		apanel.add(label1);
		apanel.add(txt1);
		apanel.add(label2);
		apanel.add(txt2);
		apanel.add(label3);
		apanel.add(txt3);
		apanel.add(label4);
		apanel.add(txt4);
		apanel.add(label5);
		apanel.add(txt5);
		apanel.add(label6);
		apanel.add(txt6);
		apanel.add(label7);
		apanel.add(txt7);
		apanel.add(label8);
		apanel.add(txt8);
		apanel.add(label9);
		apanel.add(txt9);
		apanel.add(leer1);
		apanel.add(anmelden);
		apanel.add(leer2);
		apanel.add(zuruck);		
	}
	public void pc(String str){
		mf.PanelChange((JPanel)this, str);
}

}
