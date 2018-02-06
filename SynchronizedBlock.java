// Sychronization using synchronized block

public class SynchronizedBlock {
    public static void main(String[] args)
    {
        Callme1 target = new Callme1();
        Caller1 ob1 = new Caller1(target , "Hello");
        Caller1 ob2 = new Caller1(target , "Synchronized");
        Caller1 ob3 = new Caller1(target , "World");
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
class Caller1 implements Runnable
{
    Thread t;
    Callme1 target;
    String msg;
    Caller1( Callme1 targ, String m)
    {
        target = targ;
        msg = m;
        t = new Thread(this);
        t.start();
    }
    public void run()
    {
        synchronized (target)
        {
            target.call(msg);
        }
    }
}
class Callme1
{
    void call(String msg)
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
