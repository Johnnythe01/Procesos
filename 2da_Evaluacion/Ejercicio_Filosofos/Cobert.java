
class Cobert {
    private boolean enUso = false;
    
    public synchronized void agafar() throws InterruptedException {
        while (enUso) {
            wait();
        }
        enUso = true;
    }
    
    public synchronized void deixar() {
        enUso = false;
        notifyAll();
    }
}

/*
 * En esta clase Implementamos métodos agafar() y deixar(), usando synchronized, wait() y notifyAll(), con esto conseguimos 
 * que los cubiertos sean tomados solo cuando estén disponibles.
 */