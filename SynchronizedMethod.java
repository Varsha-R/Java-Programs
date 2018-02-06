//Achieving Synchronization using Synchronized Methods

public class SynchronizedMethod {
    public static void main(String[] args)
    {
        Callme target = new Callme();
        Caller ob1 = new Caller(target , "Hello");
        Caller ob2 = new Caller(target , "Synchronized");
        Caller ob3 = new Caller(target , "World");
        try
        {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
    }
}
class Caller implements Runnable
{
    Thread t;
    Callme target;
    String msg;
    Caller( Callme targ, String m)
    {
        target = targ;
        msg = m;
        t = new Thread(this);
        t.start();
    }
    public void run()
    {
        target.call(msg);
    }
}
class Callme
{
    synchronized void call(String msg)
    {
        System.out.print("[ "+msg);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
        System.out.println(" ]");
    }
}
