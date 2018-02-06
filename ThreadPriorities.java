//Demonstration of Thread Priorities

public class ThreadPriorities {
    public static void main(String[] args)
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        clicker lo = new clicker(Thread.NORM_PRIORITY - 2);
        clicker hi = new clicker(Thread.NORM_PRIORITY + 2);
        lo.start();
        hi.start();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        lo.stop();
        hi.stop();
        try
        {
            lo.t.join();
            hi.t.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted Exception caught.");
        }
        System.out.println("Lower priority thread: "+lo.click);
        System.out.println("Higher priority thread: "+hi.click);
    }
}
class clicker implements Runnable
{
    Thread t;
    long click = 0;
    private volatile boolean running = true;
    clicker(int p)
    {
        t = new Thread(this);
        t.setPriority(p);
    }
    public void start()
    {
        t.start();
    }
    public void run()
    {
        while(running)
            click++;
    }
    public void stop()
    {
        running = false;
    }
}