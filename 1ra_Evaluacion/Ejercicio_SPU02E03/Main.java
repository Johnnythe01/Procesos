public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Timbre t = new Timbre();
		
		Visitant v1 = new Visitant(t);
		Visitant v2 = new Visitant(t);
		v1.start();
		v2.start();
		v1.join();
		v2.join();
	}

}