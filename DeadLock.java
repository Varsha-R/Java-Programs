//An example of Deadlock

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();
    DeadLock()
    {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread( this , "RacingThread");
        t.start();
        a.foo(b); //Get lock on a in this thread
        System.out.println("Back in main thread");
    }
    public void run()
    {
        b.bar(a); //Get lock on b in another thread
        System.out.println("Back in other thread");
    }
    public static void main(String[] args)
    {
        new DeadLock();
    }
}
class A
{
    synchronized void foo(B b)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name+" entered a.foo");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("A interrupted");
        }
        System.out.println(name+" trying to call b.last()");
        b.last();
    }
    synchronized void last()
    {
        System.out.println("Inside a.last()");
    }
}
class B
{
    synchronized void bar(A a)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name+" entered b.bar");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("B interrupted");
        }

        System.out.println(name+" trying to call a.last()");
        a.last();
    }
    synchronized void last()
    {
        System.out.println("Inside b.last()");
    }
}