package gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
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
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(82, 44, 347, 147);
		panel.setLayout(new BorderLayout());
		this.add(panel);
	
		JPanel subpanel = new JPanel();
		panel.add(subpanel, BorderLayout.NORTH);
	
		JPanel subpanel2 = new JPanel();
		panel.add(subpanel2, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("SELECT MATCH");
		lblNewLabel.setBounds(53, 21, 287, 13);
		subpanel.add(lblNewLabel);
		
		JRadioButton testmatch =  new JRadioButton("testmatch 2021-12-31 Japan vs Germany");
		subpanel.add(testmatch);
		
		JPanel pricelist = new JPanel(new GridLayout(7,1));
		subpanel2.add(pricelist);
		
		JLabel pricecategory1 = new JLabel("Haupttrib\u00FCne West Block 7 / 8 / 9 / 10 (Mitte) \t\tTageskarte 18,00 \u20AC");
		pricecategory1.setBounds(92, 229, 467, 21);
		pricelist.add(pricecategory1);
		
		JLabel pricecategory2 = new JLabel("Haupttrib\u00FCne West Block 5 / 6 / 11 / 12 (Seite) \t\tTageskarte 15,00 \u20AC");
		pricecategory2.setBounds(92, 252, 417, 21);
		pricelist.add(pricecategory2);
		
		JLabel pricecategory3 = new JLabel("Osttrib\u00FCne (Block 23-29) \t\t\t\t\tTageskarte 12,00 \u20AC");
		pricecategory3.setBounds(92, 275, 381, 21);
		pricelist.add(pricecategory3);
		
		JLabel pricecategory4 = new JLabel("Stehplatz Haupttrib\u00FCne (Block 1-4 und Block 13-16) \tTageskarte 10,00 \u20AC");
		pricecategory4.setBounds(92, 309, 405, 21);
		pricelist.add(pricecategory4);
		
		JLabel pricecategory5 = new JLabel("Stehplatz Nord (Block 30-36) und S\u00FCd (Block 17-22) \tTageskarte 8,00 \u20AC");
		pricecategory5.setBounds(92, 332, 405, 21);
		pricelist.add(pricecategory5);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/stadionplan.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(82,363,911,559);
		subpanel2.add(label);
		
		JButton chooseseat = new JButton("Choose Seat");
		chooseseat.setBounds(537, 951, 280, 21);
		chooseseat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc(mf.PanelNames[2]);
			}
		});
		subpanel2.add(chooseseat);
		
		JButton cancel = new JButton("Cancel / Close the program");
		cancel.setBounds(537, 951, 280, 21);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pc(mf.PanelNames[0]);
			}
		});
		subpanel2.add(cancel);
	}
	
	public void pc(String str){
			mf.PanelChange((JPanel)this, str);
	}
	
}
