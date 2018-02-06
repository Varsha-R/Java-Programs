//Creating Multiple Threads
public class MultipleThread {
    public static void main(String[] args)
    {
        new NewThread2("One");
        new NewThread2("Two");
        new NewThread2("Three");
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Main Thread interrupted.");
        }
        System.out.println("Main Thread Exiting");
    }
}
class NewThread2 implements Runnable
{
    Thread t;
    String name;
    NewThread2(String threadname)
    {
        name = threadname;
        t = new Thread(this , name);
        System.out.println("New Thread: "+t);
        t.start();
    }
    public void run()
    {
        try
        {
            for(int i=5; i>0; i--)
            {
                System.out.println(name+" : "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(name+" interrupted");
        }
        System.out.println("Thread "+name+" exiting");
    }
}
