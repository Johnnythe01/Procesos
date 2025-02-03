public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] noms = { "Aristoteles", "Platon", "Socrates", "Epicur"};
		
		Cobert [] coberts = new Cobert [noms.length];
				
		for (int i = 0; i < coberts.length; i++) {
			coberts[i] = new Cobert ();
		}
		
		Filosof[] filosofs = new Filosof[noms.length];
				
		for (int i=0; i < filosofs.length; i++) {
					
			Cobert esquerra = coberts[i % coberts.length];
							
			Cobert dreta = coberts[(i + 1) % coberts.length];
				
			filosofs[i] = new Filosof (noms[i], esquerra, dreta);
			
		}

		for (Filosof f: filosofs) {
					f.start();				
		}
				
	}

}