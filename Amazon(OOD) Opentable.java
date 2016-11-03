
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
