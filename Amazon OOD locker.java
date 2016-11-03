
public enum Size {
  SMALL, MIDDLE, LARGE
}

public class Package {
  public long packageId;
  Private Size packageSize;
  Private String zipCode;
  public Package (Long packageId, Size packageSize) {
    this.PackageId = PackageId;
    this.PackageSize = PackageSize;
  }
  public Size getSize() {
  }
  public String getZipCode () {
  }
}
public class Locker {
  Private long lockerId;
  Private String zipCode;
  Private Size lockerSize;
  boolean isAvailable;
  Package package;
  pubic Locker (Long lockerId, String zipCode, Size lockerSize) {
    this.lockerId = lockerId;
    this.zipCode = zipCode;
    this.lockerSize = lockerSize;
  }
  public void storePackage (Package package) {
    this.package = package;
  }
  public void removePackage () {
    
  }
  public bolean isFitIn (Package package) {
    if (lockerSize == LARGE) {
      return true;
    } else if () {
    
    } else {
    
    }
    return false;
  }
}

public class LockerSystem {
  Map<Long, Locker> occupiedLocker = new HashMap<>();
  public void init () {
  
  }
  public boolean checkAvailability (Package package) {
    
  }
  public Locker searchPackage (Package package) {
    if (!occupiedLocker.containsKey(package.packageId)) {
      return null;
    }
    return occupiedLocker.get(package.packageId);
  }
  public Locker removePackage (Package package) {
    if (!occupiedLocker.containsKey(package.packageId)) {
      return null;
    }
    Locker cur = occupiedLocker.remove(package.packageId);
    
  }
  public boolean addpackage (Package package) {
    if (!checkAvailablity(package)) {
      return false;
    }
    
  }
}
