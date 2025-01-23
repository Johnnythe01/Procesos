
public class Visitant extends Thread{
    
	Timbre t;

	public Visitant(Timbre t) {
		this.t = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		t.timbre();
	}
	
}