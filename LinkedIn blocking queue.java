import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BlockQueue<T> {
   public int capacity;
   public Queue<T> queue;
   final Lock lock = new ReentrantLock();
   final Condition notFull = lock.newCondition();
   final Condition notEmpty = lock.newCondition();

   public BlockQueue(int limit) {
    this.capacity = limit;
    this.queue = new LinkedList<>();
   }

   public void put(T data) throws InterruptedException {
    lock.lock();
    try {
     while (queue.size() == capacity) {
      notFull.await();
     }
     queue.offer(data);
     notEmpty.signal();
    } finally {
     lock.unlock();
    }
   }

   public T get() throws InterruptedException {
    lock.lock();
    try {
     while (queue.size() == 0) {
      notEmpty.await();
     }
     T data = queue.poll();
     notFull.signal();
     return data;
    } finally {
     lock.unlock();
    }
   }

   public static void main(String[] args) {


   }

	
}
