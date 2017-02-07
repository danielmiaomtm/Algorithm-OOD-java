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
