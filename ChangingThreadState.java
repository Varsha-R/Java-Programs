//Suspending and Resuming Thread

public class ChangingThreadState {
    public static void main(String[] args)
    {
        NewThread5 ob1 = new NewThread5("One");
        NewThread5 ob2 = new NewThread5("Two");
        try
        {
            Thread.sleep(1000);
            ob1.t.suspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.t.resume();
            System.out.println("Resuming thread One");
            ob2.t.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ob2.t.resume();
            System.out.println("Resuming thread Two");
        }
        catch (InterruptedException e)
        {
            System.out.println("Main Thread interrupted");
        }
        try
        {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
    }
}
class NewThread5 implements Runnable
{
    Thread t;
    String name;
    NewThread5(String threadname)
    {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New Thread: "+t);
        t.start();
    }
    public void run()
    {
        try
        {
            for(int i=15;i>0;i--)
            {
                System.out.println(name+" : "+i);
                Thread.sleep(200);
            }
        }catch (InterruptedException e){
            System.out.println(name+" interrupted");
        }
        System.out.println(name+" exiting");
    }
}