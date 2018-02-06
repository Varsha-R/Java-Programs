//Creating a thread by implementing Runnable

public class ThreadCreationByImplementingRunnable {
    public static void main(String[] args)
    {
        new NewThread(); //Creates a new thread
        try
        {
            for(int i=5; i>0; i--)
            {
                System.out.println("Main thread: "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Exiting Main Thread.");
    }
}
class NewThread implements Runnable
{
    Thread t;
    NewThread()
    {
        t = new Thread(this , "Demo Thread");
        System.out.println("Child thread: "+t);
        t.start();
    }
    public void run()
    {
        try
        {
            for(int i=5; i>0; i-- )
            {
                System.out.println("Child thread: "+i);
                t.sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Child thread interrupted.");
        }
        System.out.println("Child thread exiting.");
    }
}
