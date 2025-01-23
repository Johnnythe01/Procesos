
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Timbre {

    private final Lock lock = new ReentrantLock();

    public void timbre() {
        lock.lock();  // Bloqueamos la ejecución de otros hilos
        System.out.print("Ding...");

        try {
            Thread.sleep(2000); // Simulamos un proceso que dura 2 segundos
            System.out.println("Dong");

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            lock.unlock(); // Desbloqueamos la ejecución de otros hilos
        }
    }

}


/*
public class Timbre {

    public void timbre() {
        synchronized (this) {
            System.out.print("Ding...");
            try {
                Thread.sleep(2000);
                System.out.println("Dong");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
*/