public class practise {
	

	static int state = 0;
	static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) throws Exception{
		
		final practise sol = new practise();

		Thread A = new Thread (new Runnable() {
			public void run () {
				for (int i = 0; i < 10;) {
					lock.lock();
					if (state % 3 == 0) {
						System.out.println("A");
						state++;
						i++;
					}
					lock.unlock();
					
				}
			}
		});

		Thread B = new Thread (new Runnable() {
			public void run () {
				for (int i = 0; i < 10; ) {
					lock.lock();
					if (state % 3 == 1) {
						System.out.println("B");
						state++;
						i++;
					}
					lock.unlock();					
				}
			}
		});

		Thread C = new Thread (new Runnable() {
			public void run () {
				for (int i = 0; i < 10;) {
					lock.lock();
					if (state % 3 == 2) {
						System.out.println("C");
						state++;
						i++;
					}
					lock.unlock();
					
				}
			}
		});
		
		A.start();
		B.start();
		C.start();


    }	
