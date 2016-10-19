public enum VehicleSize {
	Car, 
	Bus, 
	MotoCycle,
}

abstract class Vehicle {
	String plateNumber;
	VehicleSize size;
	int spaceNeed;
	List<ParkingSpot> list = new ArrayList<>();
	public int getSpotsNeed () {
		return spaceNeed;
	}
	public VehicleSize getVehicleSize () {
		return size;
	}

	public void enterIn(ParkingLot spot) {
		list.add(spot);
	}
	public void moveOut (){
		for (int i = 0; i < list.size(); i++){
			list.get(i).removeVehicle();
		}
		list.clear();
	}
	public abstract boolean canFitInSpot (ParkingSpot spot);
}

class Bus extends Vehicle{
	public Bus () {
		spaceNeed = 5;
		size = VehicleSize.Bus;	
	}
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Bus;
	}
}
class Car extends Vehicle {
	public Car () {
		spaceNeed = 1;
		size = VehicleSize.Car;	
	}
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Bus || spot.getSize() == vehicleSize.Car;
	}

}
class MotoCycle extends Vehicle {
	public MotoCycle () {
		spaceNeed = 1;
		size = VehicleSize.MotoCycle;
	}
	public boolean canFitInSpot(){
		return true;
	}
}


public class ParkingSpot {
	Vehicle vehicle;
	VehicleSize size;
	int row;
	Level level;
	int spotNumber;

	Date move_in;
	Date move_out;

	ParkingSpot (Level level, int row, int spotNumber, VehicleSize size) {
		this.level = level;
		this.row = row;
		this.spotNumber = spotNumber;
		this.size = size;
	}

	public VehicleSize getSize () {
		return size;
	}
	public int getrow () {
		return row;
	}
	public int getSpotNumber (){
		return spotNumber;
	}

	public void removeVehicle () {
		level.spotFreed();
		vehicle = null;
	}
	public boolean park (Vehicle vehicle) {
		if (!canFitVehicle(vehicle)) {
			return false;
		}
		vehicle = vehicle;
		vehicle.enterIn(this);
		return true;
	}
	public boolean isAvailable () {
		return vehicle == null;
	}
	public boolean canFitVehicle (Vehicle vehicle) {
		 return isAvailable() && vehicle.canFitInSpot(this);
	}
}


class ParkingLot {
	Level[] levels;
	int num_Levels;

	public ParkingLot (int n, int num_rows, int spots_pre_row) {
		this.num_Levels = n;
		levels = new Level[n];
		for (int i = 0; i < n; i++) {
			levels[i] = new Level(i, num_rows, spots_pre_row);
		}
	}
	public boolean parkVehicle (Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vechile)) {
				return true;
			}
		}
		return false;
	}
	public void unParkVehicle (vehicle) {
		vehicle.moveOut();
	}

}

class Level {
	int floor;
	ParkingSpot[] spots;
	int availableSpot = 0;
	int spots_per_row ;

	public Level (int floor, int num_row, int spots_per_row) {
		this.floor = floor;
		int SPOTS_PER_ROW = spots_per_row;
		int spot_Index = 0;
		spots = new ParkingSpot[num_row * spots_per_row];

		//init size for each spot in array spots
		for (int row = 0; row < num_rows; row++) {
			for (int spot = 0; spot < spots_per_row / 4; spot++) {
				VehicleSize size = VehicleSize.MotoCycle;
				spots[spot_Index] = new ParkingSpot(this, row, spot_Index, size);
				spot_Index += 1;
			}
			for (int spot = spots_per_row / 4; spot < spots_per_row / 4 * 3; ++spot) {
                VehicleSize sz = VehicleSize.Compact;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
            for (int spot = spots_per_row / 4 * 3; spot < spots_per_row; ++spot) {
                VehicleSize sz = VehicleSize.Large;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
		}
		availableSpot = numberSpots;
	
	}
	public int findAvailableSpots (Vehicle vechile) {
		int spotsNeeded = vehicle.getSpotsNeed();
		int lastRow = -1;
		int spotsFound = 0;
		for (int i = 0; i < spts.length; i++) {
			ParkingSpot spot = spots[i];
			if (lastrow != spot.getRow()) {
				spotsFoun = 0;
				lastRow = spot.getRow();
			}
			if (spot.canFitVehicle(vehicle)) {
				spotsFound += 1;
			} else {
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded) {
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}
	public boolean parkStartingAtSpot (int spotNumber, Vehicle vehicle) {

	}
	public void spotFreed () {
		availableSpot += 1;
	}
	public int availableSpot () {
		return availableSpot;
	}
	
}
