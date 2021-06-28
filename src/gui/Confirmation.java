package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Confirmation extends JPanel {

	MainFrame mf;
	String str;
	
	public Confirmation(MainFrame m, String s) {
		mf = m;
		str = s;
		this.setName(s);
		this.setLayout(new BorderLayout());
		
		JPanel cpanel = new JPanel();
		cpanel.setBackground(Color.WHITE);
		cpanel.setLayout(new BorderLayout());
		cpanel.setBorder(new EmptyBorder(4,4,4,4));
		this.add(cpanel,BorderLayout.PAGE_START);
		
		JLabel test = new JLabel("The Seat(s) is(are) Successfully booked");
		
		JButton close = new JButton("Close the program.");
		close.setBounds(537, 951, 280, 21);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		cpanel.add(test,BorderLayout.NORTH);
		cpanel.add(close,BorderLayout.SOUTH);
	}	
		public void pc(String str){
			mf.PanelChange((JPanel)this, str);
		}
	}
