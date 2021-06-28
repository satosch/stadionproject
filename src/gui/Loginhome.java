package gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginhome extends JPanel {

	MainFrame mf;
	String str;

	public Loginhome(MainFrame m, String s) {
		mf = m;
		str = s;
		this.setName(s);
		this.setLayout(new BorderLayout());
		
		JPanel subpanel = new JPanel();
		subpanel.setLayout(new GridLayout(2,1));
		JPanel subpanel2 = new JPanel();
		this.add(subpanel, BorderLayout.PAGE_START);
		
		JLabel selectmatch = new JLabel("SELECT MATCH");
		subpanel.add(selectmatch, BorderLayout.PAGE_START);		
		JRadioButton testmatch =  new JRadioButton("testmatch 2021-12-31 Japan vs Germany");
		subpanel.add(testmatch);
		
		this.add(subpanel2, BorderLayout.CENTER);
		JPanel subpanel3 = new JPanel();
		subpanel2.add(subpanel3, BorderLayout.NORTH);
		JPanel subpanel5 =  new JPanel();
		subpanel2.add(subpanel5, BorderLayout.WEST);
		
	
		JPanel pricelist = new JPanel();
		pricelist.setLayout(new GridLayout(5,1));
		subpanel3.add(pricelist);
		
		JLabel pricecategory1 = new JLabel("Haupttrib\u00FCne West Block 7 / 8 / 9 / 10 (Mitte) \t\tTageskarte 18,00 \u20AC");
		pricelist.add(pricecategory1);
		
		JLabel pricecategory2 = new JLabel("Haupttrib\u00FCne West Block 5 / 6 / 11 / 12 (Seite) \t\tTageskarte 15,00 \u20AC");
		pricelist.add(pricecategory2);
		
		JLabel pricecategory3 = new JLabel("Osttrib\u00FCne (Block 23-29) \t\t\t\t\tTageskarte 12,00 \u20AC");
		pricelist.add(pricecategory3);
		
		JLabel pricecategory4 = new JLabel("Stehplatz Haupttrib\u00FCne (Block 1-4 und Block 13-16) \tTageskarte 10,00 \u20AC");
		pricelist.add(pricecategory4);
		
		JLabel pricecategory5 = new JLabel("Stehplatz Nord (Block 30-36) und S\u00FCd (Block 17-22) \tTageskarte 8,00 \u20AC");
		pricelist.add(pricecategory5);
				
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/stadionplan.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		subpanel5.setLayout(new BorderLayout());
		subpanel5.add(label,BorderLayout.NORTH);
		
		JButton chooseseat = new JButton("Choose Seat");
		chooseseat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc(mf.PanelNames[2]);
			}
		});
		subpanel5.add(chooseseat,BorderLayout.CENTER);
		
		JButton cancel = new JButton("Cancel / Close the program");
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pc(mf.PanelNames[0]);
			}
		});
		subpanel5.add(cancel,BorderLayout.SOUTH);
	}
	
	public void pc(String str){
			mf.PanelChange((JPanel)this, str);
	}
	
}
