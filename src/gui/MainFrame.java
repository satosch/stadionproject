// MainFrame für die alle Panels
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{
	public String[] PanelNames = {"mp","sp","pp"};
	Mainpanel mp = new Mainpanel(this, PanelNames[0]);
	Loginhome sp = new Loginhome(this,PanelNames[1]);
	Seat pp = new Seat(this,PanelNames[2]);
//	Anmeldung rgst = new Anmeldung(this,PanelNames[2]);
	
	public MainFrame(){
		this.setLayout(new BorderLayout());
		this.add(mp,BorderLayout.NORTH);
		mp.setVisible(true);
		this.add(sp,BorderLayout.CENTER);
		sp.setVisible(false);
		this.add(pp,BorderLayout.SOUTH);
		pp.setVisible(false);
//		this.add(rgst);
//		rgst.setVisible(false);
		this.setSize(1500, 1000);
		
	}
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setVisible(true);
		}
	
	public void PanelChange(JPanel jp, String str){
		
		System.out.println(jp.getName());
		System.out.println(str);
		String name = jp.getName();
		
		if(name==PanelNames[0]){
			mp = (Mainpanel) jp;
			mp.setVisible(false);
		}else if(name==PanelNames[1]){
			sp = (Loginhome)jp;
			sp.setVisible(false);
		}
		else if(name==PanelNames[2]){
			pp = (Seat)jp;
			pp.setVisible(false);
//		else if(name==PanelNames[2]){
//			rgst = (Anmeldung)jp;
//			rgst.setVisible(false);
		}
		if(str==PanelNames[0]){
			mp.setVisible(true);
			System.out.println(PanelNames[0]);
		}
		else if(str==PanelNames[1]){
			sp.setVisible(true);
			System.out.println(PanelNames[1]);
		}
		else if(str==PanelNames[2]){
			pp.setVisible(true);
			System.out.println(PanelNames[2]);
		}
//		else if (str==PanelNames[2]) {
//			rgst.setVisible(true);
//		}
		}
	}
