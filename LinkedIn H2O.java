public class H2O {
 
  static final int H = 0;
  static final int O = 1;
  static final Lock LOCK = new ReentrantLock();
  static final Condition ENOUGH[] = {LOCK.newCondition(), LOCK.newCondition()};
  static final int NEEDED[] = {2, 1};
  static final int COUNT[] = {0, 0};
 
  static void run(int index) {
    LOCK.lock();
    try {
      if(COUNT[H] >= NEEDED[H] && COUNT[O] >= NEEDED[O]) {
        for(int i = 0, n = NEEDED[H]; i < n; ++i) {
          ENOUGH[H].signal();
        }
        COUNT[H] -= NEEDED[H];
        for(int i = 0, n = NEEDED[O]; i < n; ++i) {
          ENOUGH[O].signal();
        }
        COUNT[O] -= NEEDED[O];
      }
      ++COUNT[index];
      ENOUGH[index].awaitUninterruptibly();
    } finally {
      LOCK.unlock();
    }
  }
 
  public static void h() {
    run(H);
  }
 
  public static void o() {
    run(O);
  }
}


public class H2O {


    static final Lock LOCK = new ReentrantLock();

    static final Condition ENOUGH_H = LOCK.newCondition();

    static final Condition ENOUGH_O = LOCK.newCondition();

    static int H = 0;

    static int O = 0;


    static void check() {

        if (H >= 2 && O >= 1) {

            ENOUGH_H.signal();

            ENOUGH_H.signal();

            ENOUGH_O.signal();

            H -= 2;

            O -= 1;

        }

    }


    public static void h() {

        LOCK.lock();

        try {

            check();

            ++H;

            ENOUGH_H.awaitUninterruptibly();

        } finally {

            LOCK.unlock();

        }

    }


    public static void o() {

        LOCK.lock();

        try {

            check();

            ++O;

            ENOUGH_O.awaitUninterruptibly();

        } finally {

            LOCK.unlock();

        }

    }

}`
