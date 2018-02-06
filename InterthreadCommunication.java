//Producer-Consumer problem in Inter-thread Communication

public class InterthreadCommunication {
    public static void main(String[] args)
    {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press CTRL+C to stop");
    }
}
class Producer implements Runnable
{
    Q q;
    Producer( Q q)
    {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run()
    {
        int i = 0;
        while(true)
        {
            q.put(i++);
        }
    }
}
class Consumer implements Runnable
{
    Q q;
    Consumer(Q q)
    {
        this.q = q;
        new Thread(this , "Consumer").start();
    }
    public void run()
    {
        while(true)
        {
            q.get();
        }
    }
}
class Q
{
    int n;
    boolean value = false;;
    synchronized void put(int n)
    {
        while(value)
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Interrupted Exception caught");
            }
        this.n = n;
        value = true;
        System.out.println("Put: "+n);
        notify();
    }
    synchronized int get()
    {
        while(!value)
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Interrupted Exception caught.");
            }
        value = false;
        System.out.println("Got: "+n);
        notify();
        return n;
    }
}