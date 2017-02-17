/*
Write a multi threaded C code with one thread printing all even numbers and the other all odd numbers. 
The output should always be in sequence 
ie. 0,1,2,3,4....etc


*/

public class OddEvenVolatile {
    public volatile boolean printOdd = false;
    public volatile boolean printEven = false;


    public static void main (String [] args) {
        OddEvenVolatile oev = new OddEvenVolatile();
        PrintEven e = oev.new PrintEven();
        PrintOdd o = oev.new PrintOdd();

        Thread to = new Thread(o);
        Thread te = new Thread(e);


        te.start();
        to.start();

        oev.printEven = true;
    }

    private class PrintEven implements Runnable {

        public void run() {

            for(int i = 0; i <= 10; i += 2) {
                while(!printEven) try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);

                synchronized(this) {
                    printEven = false;
                    printOdd = true;
                }
            }
        }

    }


    private class PrintOdd implements Runnable {

        public void run() {
            for(int i = 1; i <= 10; i += 2) {
                while(!printOdd) try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
                synchronized(this) {
                    printOdd = false;
                    printEven = true;
                }
            }
        }

    }

}
