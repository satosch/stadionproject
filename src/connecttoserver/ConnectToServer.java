package connecttoserver;

import java.sql.*;

public class ConnectToServer {
	
	private Statement st;
	private String connectstring = "jdbc:mysql://localhost/stadionprojekt";
	private String username = "root";
	private String password = "";
	
	public ConnectToServer() {
	
		try {
			Connection conn = DriverManager.getConnection(connectstring,username,password);
			st = conn.createStatement();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
		public Ticket leseTicket(int ticket_id) {
			Ticket t = null;
			String sql = "SELECT * FROM ticket "
					+ "WHERE ticket_id = "+ ticket_id  +";";
			System.out.println(sql);
		try {
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				int seat_id = rs.getInt("seat_id");
				int match_id = rs.getInt("match_id");
				t = new Ticket(ticket_id, seat_id, match_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
			return t;
		}
	
		
	public int findSeatid(int block_id, int seat_nr ) {
		int seat_id = 0;
		String sql = "SELECT seat_id FROM seat "
				+ "WHERE block="+block_id+" AND seat_nr="+ seat_nr +";";
		System.out.println(sql);
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				seat_id =rs.getInt("seat_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(seat_id);
		return seat_id;
	}
		
	public Ticket bookTicket(int match_id, int seat_id) {
		Ticket t = null;
		String sql1 = "INSERT INTO ticket(match_id,seat_id) values(" 
					+ match_id +"," +seat_id +");";
		String sql2 = "SELECT * FROM ticket WHERE seat_id="+seat_id+" AND match_id="+match_id+";";
		
		System.out.println(sql1);
		System.out.println(sql2);
		
		try {
			st.executeUpdate(sql1);
			ResultSet rs = st.executeQuery(sql2);
			if(rs.next()) {
				int ticket_id = rs.getInt("ticket_id");
				int match_nr = rs.getInt("match_id");
				int seat_nr = rs.getInt("seat_id");
				t = new Ticket(ticket_id, match_nr, seat_nr);
				System.out.println(t);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
			
			return t;
		}
	}

	
		

