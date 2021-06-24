package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Seat extends JPanel {
	MainFrame mf;
	String str;
    
	private JToggleButton[] seats = new JToggleButton[500];
    private JTextArea selectedSeats = new JTextArea(3, 40);
	
    public Seat(MainFrame m, String s) {
    	mf = m;
    	str = s;
    	String block = "0";
    	this.setName(s);
    	this.setLayout(new BorderLayout());
    	
        JPanel ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));
        this.add(ui);
    	
        selectedSeats.setLineWrap(true);
        selectedSeats.setWrapStyleWord(true);
        selectedSeats.setEditable(false);
        ui.add(new JScrollPane(selectedSeats), BorderLayout.PAGE_END);
        
		JPanel seatdetails = new JPanel();
		ui.add(seatdetails, BorderLayout.NORTH);
		JLabel testdetail = new JLabel("Gewünschte Block Nr");
		seatdetails.add(testdetail);
		
		String[] blockdata = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
		JComboBox blockBox = new JComboBox(blockdata);
		seatdetails.add(blockBox);
		int selectedBlock = blockBox.getSelectedIndex();
		blockBox.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				StringBuilder sb = new StringBuilder();
		        for (int ii=0; ii<seats.length; ii++) {
		            JToggleButton tb = seats[ii];
		            if (tb.isSelected()) {
		                sb.append(tb.getText());
		                sb.append(", ");
		            }
		        }
		        String s = sb.toString();
		        if (s.length()>0) {
		            s = s.substring(0, s.length()-2);
		        }
		        selectedSeats.setText(String.valueOf(selectedBlock)+s);
			}
		});
		
		
        JPanel sitzplatz = new JPanel(new BorderLayout(40, 0));
        sitzplatz.setBorder(new TitledBorder("Available Seats"));
        ui.add(sitzplatz, BorderLayout.CENTER);
        
        JPanel leftStall = new JPanel(new GridLayout(0, 2, 2, 2));
        JPanel centerStall = new JPanel(new GridLayout(25,20));
        JPanel rightStall = new JPanel(new GridLayout(0, 2, 2, 2));
        JPanel upStall = new JPanel(new BorderLayout());
        JPanel downStall = new JPanel();
        
        sitzplatz.add(leftStall, BorderLayout.WEST);
        sitzplatz.add(centerStall, BorderLayout.CENTER);
        sitzplatz.add(rightStall, BorderLayout.EAST);
        sitzplatz.add(upStall, BorderLayout.NORTH);
        sitzplatz.add(downStall, BorderLayout.SOUTH);
	

        ActionListener seatSelectionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSelectedSeats();
            }
        };

        for (int ii=0; ii <seats.length; ii++) {
            JToggleButton tb = new JToggleButton(ii+1+"");
            tb.addActionListener(seatSelectionListener);
            seats[ii] = tb;
            centerStall.add(tb);}
        }

    private void showSelectedSeats() {
        StringBuilder sb = new StringBuilder();
        for (int ii=0; ii<seats.length; ii++) {
            JToggleButton tb = seats[ii];
            if (tb.isSelected()) {
                sb.append(tb.getText());
                sb.append(", ");
            }
        }
        String s = sb.toString();
        if (s.length()>0) {
            s = s.substring(0, s.length()-2);
        }
        selectedSeats.setText(s);
    }
    
    public void pc(String str){
		mf.PanelChange((JPanel)this, str);
}
    
}