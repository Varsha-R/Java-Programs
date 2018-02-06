//Creating a thread by extending Thread

public class ThreadCreationByExtendingThread {
    public static void main(String[] args)
    {
        new NewDemoThread();
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
        System.out.println("Main thread exiting");
    }
}
class NewDemoThread extends Thread
{
    NewDemoThread()
    {
        super("Demo Thread.");
        System.out.println("Child thread: "+this);
        start();
    }
    public void run()
    {
        try
        {
            for(int i=5; i>0; i--)
            {
                System.out.println("Child thread: "+i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Child thread interrupted.");
        }
        System.out.println("Child thread exiting.");
    }
}
