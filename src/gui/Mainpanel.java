package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
;

public class Mainpanel extends JPanel {

	MainFrame mf;
	String str;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	public Mainpanel(MainFrame m, String s) {
		mf = m;
		str = s;
		this.setName("mp");
		this.setSize(498,146);
		this.setLayout(new BorderLayout());
		
		JPanel subpanel1 = new JPanel();
		this.add(subpanel1, BorderLayout.NORTH);

		
		JLabel title = new JLabel("FC KASSEL 05 TICKET SERVICE");
		title.setBounds(103, 86, 451, 33);
		title.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		title.setBackground(UIManager.getColor("Button.background"));
		title.setFont(new Font("MS UI Gothic", Font.PLAIN, 32));
		subpanel1.add(title, BorderLayout.NORTH);
		
		JPanel subpanel2 = new JPanel();
		subpanel2.setLayout(new GridLayout(3,2));
		this.add(subpanel2, BorderLayout.CENTER);
		
		
		JLabel userid = new JLabel("Username");
		userid.setBounds(261, 190, 65, 13);
		subpanel2.add(userid);
		
		JTextField idinput = new JTextField(15);
		subpanel2.add(idinput);
		
		JLabel password = new JLabel("Password");
		password.setBounds(261, 230, 50, 13);
		subpanel2.add(password);
		
		JTextField passinput = new JTextField(15);
		subpanel2.add(passinput);
		
		JButton register = new JButton("Register");
		register.setBounds(261, 271, 91, 21);
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pc(mf.PanelNames[4]);
			}
		});
		
		
		subpanel2.add(register);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pc(mf.PanelNames[1]);
			}
		});
//		btnLogIn.setBounds(419, 271, 91, 21);
//		
//		btnLogIn.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				try {
//				File file = new File("userPass.txt");
//				Scanner scan = new Scanner(file);
//				String line = null;
//				FileWriter filewrite = new FileWriter(file, true);
//				
//				String usertxt = " ";
//				String passtxt = " ";
//				String puname = idinput.getText();
//				String ppaswd = passinput.getText();
//				
//				while (scan.hasNext()) {
//					usertxt = scan.nextLine();
//					passtxt = scan.nextLine();
//					}
//				}
//				
//				pc(mf.PanelNames[1]);
//			} catch {
//				
//			}
//				
//		});
		subpanel2.add(btnLogIn);
			}
	
	public void pc(String str){
		mf.PanelChange((JPanel)this, str);
	}
}
