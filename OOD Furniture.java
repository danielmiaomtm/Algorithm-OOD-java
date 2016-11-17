/*
There are 3 products table,chair and bench. Product can be of wood ,metal and plastic . Design a class structures for this.
*/

public abstract class Furniture {
String color = "";
String price = "";
}
public abstract class PlasticFurniture extends Furniture {


}
public abstract class WoodenFurntiure extends Furniture {

}
public class PlasticChair extends PlasticFurniture {
  public PlasticChair(String col, String p) {
  color = col;
  price = p;
  }
}
public class WoodenChair extends WoodenFurntiure {
  public WoodenChair(String col, String p) {
  color = col;
  price = p;
  }
}

public abstract class FurnitureFactory {
public abstract Furniture createChair();
public abstract Furniture createTable();
}
//
  public class WoodenFurnitureFactory extends FurnitureFactory {

    @Override
    public Furniture createChair() {
    return new WoodenChair("Red","1000");
    }

    @Override
    public Furniture createTable() {
    return new WoodenTable("Red","1000");
    }

  }
//
  public class PlasticFurnitureFactory extends FurnitureFactory {

    @Override
    public Furniture createChair() {
    return new PlasticChair("Red","1000");
    }

    @Override
    public Furniture createTable() {
    return new PlasticTable("Red","1000");
    }

  }
public class FurnitureMakerFactory {

  private static FurnitureFactory factory = null;

    static FurnitureFactory getFactory(String choice) {
      if (choice.equals("wooden")) {//TODO: create a Constant file 
        factory = new WoodenFurnitureFactory();
        } else if (choice.equals("plastic")) {
        factory = new PlasticFurnitureFactory();
        }
      return factory;
    }

}

  //client 
  public class Client {

      public static void main(String[] args) {
      FurnitureFactory pf=FurnitureMakerFactory.getFactory("wooden");
      Furniture product=pf.createChair();
      }

  }

