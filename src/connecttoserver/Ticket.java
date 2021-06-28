package connecttoserver;

public class Ticket {
	private int ticket_id;
	private int seat_id;
	private int match_id;
	
	public Ticket(int ticket_id,  int seat_id, int match_id) {
		this.ticket_id = ticket_id;
		this.seat_id = seat_id;
		this.match_id = match_id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public int getSeatnr() {
		return seat_id;
	}

	public void setSeatnr(int seatnr) {
		this.seat_id = seat_id;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	
	@Override
	public String toString() {
		return "ticket_id: " + ticket_id + " seat_id: " + seat_id + " match_id: " + match_id; 
	}
	
}
