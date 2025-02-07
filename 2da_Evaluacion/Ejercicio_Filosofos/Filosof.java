import java.util.Random;

public class Filosof extends Thread {
	private static Random r = new Random();
	private final Cobert esquerre, dret;
	private final boolean esParell;
	String nom;

	public Filosof(String nom, Cobert esquerra, Cobert dreta, boolean esParell) {
		this.nom = nom;
		this.esquerre = esquerra;
		this.dret = dreta;
		this.esParell = esParell;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			pensar();
			menjar();
		}
	}
	
	private void pensar() {
		System.out.println(nom + " pensant");
		esperar(r.nextInt(2000, 3000));
	}
	
	private void menjar() {
		// metemos un if para que si es par, coja el cubierto izquierdo primero
        try {
            if (esParell) { 
                esquerre.agafar();
                System.out.println(nom + " ha tomado el cubierto izquierdo");
                dret.agafar();
            } else {
                dret.agafar();
                System.out.println(nom + " ha tomado el cubierto derecho");
                esquerre.agafar();
            }
            
            System.out.println(nom + " está comiendo");
            esperar(r.nextInt(2000, 3000));
            
            esquerre.deixar();
            dret.deixar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	private void esperar(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}