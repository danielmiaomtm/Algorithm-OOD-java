
  class Guest {
    private String name;
    Guest (String name) {

    }
    public String getNume () {
      return this.name;
    }
    public void setName () {
      this.name = name;
    }
  }

  class Reservation { 
    long reservationId;
    long start_Time;
    long end_Time;
    Table table;
    Guest guest;
    int numOfGuest;

    boolean isCancelled;
    boolean isWaiting;
    List<Room> allocatedRooms;


    private boolean canFitIntoTable (Table table) {

    }
    public void notifyUserWithDetail () {

    }
  }
  class Table {
    private long tableId;
    private int maxCapacity;
    private boolean isAvailable;

    boolean occupiedHalfHr[48];

    public Table (int tableId, int maxCapacity) {
      this.tableId = tableId;
      this.maxCapacity = maxCapacity;
    }
    public boolean isReserved (long start, long end) {

    }
    public boolean isFitIn (int totalGuest, long start, long end) {

    }

  }
  class Restaurant {
    int resuaurantId;
    long timeOfStarting;
    long timeOfEnding;
    int total Seats;
    ReservationSystem system;
    public void init (long openTime, long closingTime, int seats) {

    }
  }
  class ReservationSystem {
    int numOfRooms;
    long openingTime;
    long closedTime;
    List<Table> tables;
    List<Reservation> reservationList;

    Map<Long, Reservation> reservationMap = new HashMap<>();

    Set<Room> freeSlots[48];

    public ReservationSystem () {

    }
    public boolean cancelReservation (long id) {

    }
    public void contactCustomer (Reservation rId) {

    }
    public boolean closeReservation (long id) {

    }
    public Reservation searchReservation (long id) {

    }
    public int checkAvailablity (int numOfGuest, long start, long end) {

    }
  }








Second Version

mport java.util.ArrayList;
import java.util.HashMap;

public class ReservationSystem {
	Map<Long, Reservation> map;
	//From 10am to 9pm, each hour have a list of tables
	List<Table>[] tables;
	// two hour between each reservation for one table
	int MAX_TIME = 2;

	public Reservation getResrvation(long reservationId) {
		return map.get(reservationId);
	}

	public void makeReservation(Custmer custmer, int startTime, int size) {
		Table newTable = findTable(startTime, size);
		if(newTable != null) {
			Reservation newReservation = new Reservation(newTable,custmer,startTime);
			long custmerId = custmer.getId();
			map.put(custmerId, newReservation);
			removeTable(startTime, newTable);
		} else {
			System.out.println("Can not find table !!");
		}
	}

	public void cancelReservation(Custmer custmer) {
		Reservation newReservation = map.remove(custmer.getId());
		addTable(newReservation.getTime(),newReservation.getTable());
	}

	public Table findTable(int startTime, int size) {
		ArrayList<Table> tableList= tables[startTime - 10];
		for(Table t : tableList) {
			if(t.getSize() >= size) {
				return t;
			}
		}
		return null;
	}

	public void removeTable(int startTime, Table table) {
		int index = startTime-10;
		int period = MAX_TIME;
		while(index + period - 1 < tables.length && period > 0) {
			tables[index + period].remove(table);
			period--;
		}
	}

	public void addTable(int startTime, Table table) {
		int index = startTime-10;
		int period = MAX_TIME;
		while(index+period-1<tables.length && period > 0) {
			tables[index+period].add(table);
			period--;
		}
	}

	public Reservation getReservation(Long custerId) { 
		return map.get(custerId);
	}

}

class Reservation {
	protected long ReservationId;
	protected Table table;
	protected Custmer custmer;
	protected int startTime;

	public Reservation(Table table, Custmer custmer, int startTime) {
		this.table = table;
		this.custmer = custmer;
		this.startTime = startTime;
		}

	public Table getTable() { 
		return table;
	}
	public int getTime() { 
		return startTime;
	}
}


class Table {
	protected long tableId;
	protected int size;

	public Table(int size) { 
		this.size = size;
	}	
	public int getSize() { 
		return size; 
	}
}

class Custmer {
	protected String name;
	protected long custmerId;
	protected String mail;
	protected String phone;

	public long getId() { 
		return custmerId;
	}
}
