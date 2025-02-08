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
		System.out.println(nom + " pensando");
		esperar(r.nextInt(2000, 3000));
	}
	
	private void menjar() {
		// metemos un if para que si es par, coja los cubiertos en orden, primero izquierdo y luego derecho. Si es impar, al reves, asi evitamos el deadlock
        try {
            if (esParell) {
                esquerre.agafar(); // usando este metodo de la clase Cobert, cogen el cubierto izquierdo
                System.out.println(nom + " ha tomado el cubierto izquierdo");
                dret.agafar(); // y con este el derecho
            } else { // si es impar coge el cubierto derecho primero y hace el proceso al reves
                dret.agafar();
                System.out.println(nom + " ha tomado el cubierto derecho");
                esquerre.agafar();
            }
            
            System.out.println(nom + " esta comiendo");
            esperar(r.nextInt(2000, 3000));
            
            esquerre.deixar(); // usando este metodo de la clase Cobert, dejan el cubierto izquierdo y luego el derecho, asi se liberan para los demas filosofos
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