
  public enum Size {
    SMALL, MIDDLE, LARGE
  }

  public class Package {
    public long packageId;
    Private Size packageSize;
    Private String zipCode;
    public Package (Long packageId, Size packageSize, String zipCode) {
      this.PackageId = PackageId;
      this.PackageSize = PackageSize;
      this.zipCode = zipCode;
    }
    public Size getSize() {
      return packageSize;
    }
    public String getZipCode () {
      return zipCode;
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
    Stack<Locker> smallStack = new Stack<>();
    Stack<Locker> middleStack = new Stack<>();
    Stack<Locker> largeStack = new Stack<>();
    Map<Long, Locker> occupiedLocker = new HashMap<>();
    public void init () {
     //build stacks
      Locker locker1 = new Locker(1, "96085", Size.SMALL);
      Locker locker2 = new Locker(1, "26085", Size.SMALL);
      smallStack.push(locker1);
      smallStack.push(locker2);

    }
    public static void main (Stirng[] args) {
      LockerSystem lockerSystem = new LockerSystem();
      lockerSystem.init();
      Package package = new Package(100, Size.SMALL, "98445");
      Locker locker = lockerSystem.getTheLocker(package);
      addPackage(package, locker);

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
      Size curSize = package.getSize();
      if (curSize == Size.SMALL) {
        smallStack.push(cur);
      } else if () {
      } else {
      }
      return cur;
    }
    public boolean addpackage (Package package, Locker locker) {
      if (!checkAvailablity(package)) {
        return false;
      }
      if (package.getSize() == Small.SIZE) {
        occupiedLocker.put(package.getId(), locker);
      } else if () {
      } else {
      }
      return true;
    }
  }
