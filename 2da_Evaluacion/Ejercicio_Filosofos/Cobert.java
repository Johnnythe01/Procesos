
class Cobert {
    private boolean enUso = false;
    
    public synchronized void agafar() throws InterruptedException {
        while (enUso) { // mientras esta en uso, esperamos
            wait(); // esperamos a que se libere el cubierto
        }
        enUso = true; // con este booleano marcamos que el cubierto esta en uso
    }
    
    public synchronized void deixar() {
        enUso = false; // cuando se deje el cubierto, lo marcamos como no en uso y notificamos a los demas
        notifyAll();
    }
}

/*
 * En esta clase le he metido los métodos agafar() y deixar() usando synchronized, wait() y notifyAll()
 * con esto conseguimos que los cubiertos sean tomados solo cuando estén disponibles.
 */