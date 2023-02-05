public class Introduction extends Thread {

    public static void main(String[] args) {

        Runnable task1 = new DefaultRunnable();
        Thread t1 = new Thread(task1);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New thread Created! Name of thread is: " + Thread.currentThread().getName());
            }
        });

        // not recommended
        Thread t3 = new Introduction();

        // using lambda expressions to create thread
        Thread t4 = new Thread(() -> System.out.println("Another thread created! Name of thread is : " +
                Thread.currentThread().getName()));
        Thread t5 = new Thread(Introduction::execute);

        System.out.println("Current thread name is " + Thread.currentThread().getName());
        t1.run(); // will also be executed in main thread
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
    public static void execute() {
        System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName());
    }
}

class  DefaultRunnable implements Runnable{

    private String externalString;

    public DefaultRunnable(){

    }

    public DefaultRunnable(String externalString){
        this.externalString = externalString;
    }

    @Override
    public void run(){
        System.out.println("New Thread Created! Name of the thread is: " + Thread.currentThread().getName());
    }
}
