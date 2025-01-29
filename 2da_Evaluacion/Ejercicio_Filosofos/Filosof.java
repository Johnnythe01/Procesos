import java.util.Random;

public class Filosof extends Thread {
	private static Random r = new Random();
	
	private final Cobert esquerre, dret;
	
	String nom;

	public Filosof(String nom, Cobert esquerra, Cobert dreta) {
		this.nom = nom;
		this.esquerre = esquerra;
		this.dret = dreta;
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
		System.out.println(nom + " te fam i vol agafar el cobert esquerre");
		esperar(r.nextInt(400, 600));
		
		synchronized (esquerre) {
			System.out.println(nom + " agafa el cobert esquerre. Ara vol agafar el dret.");
			esperar(r.nextInt(400, 600));
			
			synchronized (dret) {
				System.out.println(nom + " agafa el cobert dret");
				System.out.println(nom + " menjant");
				esperar(r.nextInt(2000, 3000));
			}
			System.out.println(nom + " amolla el cobert dret");			
		}
		System.out.println(nom + " amolla el cobert esquerre");
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