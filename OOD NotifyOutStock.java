/*
customers want to buy some products but products are out of stock, design a system to notify them when those products are again available?
*/

class User {
	String name;
	String email;
}

class Product {
	String name;
	int       id;
	int       amount;
	double price;
}

class Store {
	ArrayList<Product> inStock;
	ArrayList<Product> outStock;
	
	void add(Product) {...}       //adds new product to inStock
	void remove(Product) {...} //removes product from inStock and outStock
	void update(Product) {...}  //updates the product information such as 
                                                        //price/amount and sends notification when amount 
                                                        //change
}

class NotificationMgr {
	Hashmap<int, LinkedList<User>> waitingList;
	void register(User, Products[]);      //user registers for notifications
	void unregister(User, Products[]);  //user deregisters for notifications
               
              /*
	Use the Observer design pattern to receive the notifications when a product
               is moved from the outStock to inStock and send the notification to all registered
               users
              */
}
