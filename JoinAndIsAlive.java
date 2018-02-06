//Using join() to wait for threads to finish and illutration of isAlive()

public class JoinAndIsAlive {
   public static void main(String[] args)
   {
       NewThread3 ob1 = new NewThread3("One");
       NewThread3 ob2 = new NewThread3("Two");
       NewThread3 ob3 = new NewThread3("Three");
       System.out.println("Thread One is alive: "+ob1.t.isAlive());
       System.out.println("Thread Two is alive: "+ob2.t.isAlive());
       System.out.println("Thread Three is alive: "+ob3.t.isAlive());
       try
       {
           System.out.println("Waiting for threads to finish.");
           ob1.t.join();
           ob2.t.join();
           ob3.t.join();
       }
       catch (InterruptedException e)
       {
           System.out.println("Main thread interrupted.");
       }
       System.out.println("Thread One is alive: "+ob1.t.isAlive());
       System.out.println("Thread Two is alive: "+ob2.t.isAlive());
       System.out.println("Thread Three is alive: "+ob3.t.isAlive());
       System.out.println("Main Thread exiting");
   }
}
class NewThread3 implements Runnable
{
    Thread t;
    String name;
    NewThread3(String threadname)
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
