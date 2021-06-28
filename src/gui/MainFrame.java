// MainFrame für die alle Panels
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{
	public String[] PanelNames = {"mp","sp","pp","cp","rgst"};
	Mainpanel mp = new Mainpanel(this, PanelNames[0]);
	Loginhome sp = new Loginhome(this,PanelNames[1]);
	Seat pp = new Seat(this,PanelNames[2]);
	Confirmation cp = new Confirmation(this,PanelNames[3]);
	Anmeldung rgst = new Anmeldung(this,PanelNames[4]);
	
	public MainFrame(){
		this.setLayout(new BorderLayout());
		this.add(mp,BorderLayout.NORTH);
		mp.setVisible(true);
		this.add(sp,BorderLayout.LINE_START);
		sp.setVisible(false);
		this.add(pp,BorderLayout.CENTER);
		pp.setVisible(false);
		this.add(cp,BorderLayout.PAGE_START);
		cp.setVisible(false);
		this.add(rgst,BorderLayout.WEST);
		rgst.setVisible(false);
		
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
		}
		else if(name==PanelNames[1]){
			sp = (Loginhome)jp;
			sp.setVisible(false);
		}
		else if(name==PanelNames[2]){
			pp = (Seat)jp;
			pp.setVisible(false);
		}
		else if(name==PanelNames[3]) {
			cp = (Confirmation)jp;
			cp.setVisible(false);
		} 		
		else if(name==PanelNames[4]){
			rgst = (Anmeldung)jp;
			rgst.setVisible(false);
		}
		
		if(str==PanelNames[0]){
			mp.setVisible(true);
		}
		else if(str==PanelNames[1]){
			sp.setVisible(true);
		}
		else if(str==PanelNames[2]){
			pp.setVisible(true);
		}
		else if(str==PanelNames[3]) {
			cp.setVisible(true);
			}
		else if(str==PanelNames[4]) {
			rgst.setVisible(true);
		}
		
		
	}
}
	

