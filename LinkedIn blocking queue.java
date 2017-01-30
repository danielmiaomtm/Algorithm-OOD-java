import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<E> {

 private int capacity;
 private Queue<E> queue;
 public Lock lock = new reentrantLock();
 private Lock pushLock = new ReentrantLock();
 private Condition notFull = this.lock.newCondition();
 private Condition notEmpty = this.lock.newCondition();
    
 // only initialize this queue once and throws Exception if the user is
 // trying to initialize it multiple t times.
 public void init(int capacity) throws Exception {
     this.lock.lock();
     try{
         if(this.queue == null){
             this.queue = new LinkedList<>();
             this.capacity = capacity;
         } else {
             throw new Exception();
         }
     }finally{
         this.lock.unlock();
     }
 }

 // throws Exception if the queue is not initialized
 public void push(E obj) throws Exception {
     this.pushLock.lock();
      this.lock.lock();
     try{
         while(this.capacity == this.queue.size())
             this.notFull.wait();
         this.queue.add(obj);
         this.notEmpty.notifyAll();
     }finally{
         this.lock.unlock();
         this.pushLock.lock();
     }
 }

 // throws Exception if the queue is not initialized
 public E pop() throws Exception {
     this.lock.lock();
     try{
         while(this.capacity==0)
             this.notEmpty.wait();
         E result = this.queue.poll();
         notFull.notifyAll();
         return result;
     }finally{
         this.lock.unlock();
     }
 }

 // implement a atomic putList function which can put a list of object
 // atomically. By atomically i mean the objs in the list should next to each
 // other in the queue. The size of the list could be larger than the queue
 // capacity.
 // throws Exception if the queue is not initialized
 public void pushList(List<E> objs) throws Exception {
     this.pushLock.lock();
     this.lock.lock();
     try{
         for(E obj : objs){
             while(this.queue.size() == this.capacity)
                 this.notFull.wait();
             this.queue.add(obj);
             this.notEmpty.notifyAll();
         }
     }finally{
         this.lock.unlock();
         this.pushLock.unlock();
     }
 }
}
