package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import connecttoserver.ConnectToServer;
import connecttoserver.Ticket;

public class Seat extends JPanel {
	MainFrame mf;
	String str;
	static int block = 0; 
	static int maxseat = 50;
	static int[] selectedseat = new int[maxseat];
    static int x = 0;
    
	private static JToggleButton[] seats = new JToggleButton[500];
    private JTextArea selectedSeats = new JTextArea(3, 40);
  
    public Seat(MainFrame m, String s) {
    	mf = m;
    	str = s;
    	this.setName(s);
    	this.setLayout(new BorderLayout());
    	JLabel title = new JLabel("Please fill the form and choose the seats");
    	this.add(title, BorderLayout.PAGE_START);
    	JPanel ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));
        this.add(ui);
    	
        selectedSeats.setLineWrap(true);
        selectedSeats.setWrapStyleWord(true);
        selectedSeats.setEditable(false);
        
        ui.add(new JScrollPane(selectedSeats), BorderLayout.PAGE_END);
        
		JPanel seatdetails = new JPanel();
		ui.add(seatdetails, BorderLayout.NORTH);
		
		JPanel seatdetailsnorth = new JPanel();
		JPanel seatdetailssouth = new JPanel();
		seatdetails.setLayout(new BorderLayout());
		seatdetails.add(seatdetailsnorth, BorderLayout.NORTH);
		seatdetails.add(seatdetailssouth, BorderLayout.SOUTH);
		
		JLabel blocknr = new JLabel("Gewünschte Block Nr");
//		JLabel vorname = new JLabel("vorname");
//		JTextField vornameinput = new JTextField();
//		vornameinput.setPreferredSize( new Dimension( 200, 24 ) );
//		JLabel nachname = new JLabel("nachname");
//		JTextField nachnameinput = new JTextField();
//		nachnameinput.setPreferredSize( new Dimension( 200, 24 ) );
//		JLabel address = new JLabel("Straße und Hausnummer");
//		JTextField addressinput = new JTextField();
//		addressinput.setPreferredSize( new Dimension( 200, 24 ) );
//		JLabel plz = new JLabel("PLZ");
//		JTextField plzinput = new JTextField();
//		plzinput.setPreferredSize( new Dimension( 200, 24 ) );
//		JLabel telnr = new JLabel("tel");
//		JTextField telnrinput = new JTextField();
//		telnrinput.setPreferredSize( new Dimension( 200, 24 ) );
//		JLabel email = new JLabel("email");
//		JTextField emailinput = new JTextField();
//		emailinput.setPreferredSize(new Dimension( 200,24 ));
		
		JButton confirm = new JButton("confirm");
		
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ConnectToServer cs = new ConnectToServer();
				boolean ifSelected = true;
				
				if (block == 0){
					ifSelected = false;
					} else {
					for (int i =0; i<selectedseat.length;i++) {
						if (selectedseat[i]!=0) {
							{	
								int selectedseatid = cs.findSeatid(block,selectedseat[i]);
								cs.bookTicket(1,selectedseatid);
								selectedseat[i] = 0;
							}
						} else {
							ifSelected = false;
							break;
						}
						if(ifSelected!=true) {
							selectedSeats.setText("choose the correct seat and block");	
							break;
						} else {
							block=0;
							pc(mf.PanelNames[3]);
						}
					}
				}
			}});
		
		seatdetailsnorth.setLayout(new FlowLayout());
//		seatdetailsnorth.add(vorname);
//		seatdetailsnorth.add(vornameinput);
//		seatdetailsnorth.add(nachname);
//		seatdetailsnorth.add(nachnameinput);
//		seatdetailsnorth.add(address);
//		seatdetailsnorth.add(addressinput);
		seatdetailssouth.setLayout(new FlowLayout());
//		seatdetailssouth.add(plz);
//		seatdetailssouth.add(plzinput);
//		seatdetailssouth.add(telnr);
//		seatdetailssouth.add(telnrinput);
//		seatdetailssouth.add(email);
//		seatdetailssouth.add(emailinput);
//		
		seatdetailssouth.add(blocknr);
		final String[] blockdata = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
		final JComboBox<String> blockBox = new JComboBox<String>(blockdata);
		seatdetailssouth.add(blockBox);
		
		blockBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	block = blockBox.getSelectedIndex();
            }
        });
		
		seatdetailssouth.add(confirm);
		
		
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
            	String text = new String(tb.getText());
            	selectedseat [x] =Integer.parseInt(text);
            	x = x + 1;
            	sb.append(text);
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