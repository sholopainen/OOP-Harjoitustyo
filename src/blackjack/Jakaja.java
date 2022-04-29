package blackjack;

/**
 * Luokasta voidaan muodostaa uusia Jakaja-instansseja
 *
 */

public class Jakaja extends Pelaaja {
	
	private static final long serialVersionUID = 1L;

	public Jakaja(){
		super("Jakaja");
	}
	
	/**
	 * Jakajan vuoron pelaus. Tulostaa jakajan k‰den ja ottaa lis‰‰ kortteja mik‰li yhteistulos on alle 17
	 */

	@Override
	public void pelaaVuoro(Korttipakka kp) {
		
		Korttipakka jakajanKasi = this.annaKasi();
		int tulos = jakajanKasi.korttienArvo();
		
		System.out.println("Jakajan kortit: " + jakajanKasi);
		System.out.println("Jakajan korttien arvo on:" + tulos +"\n");
		
		do {
			if(onkoBlackjack(jakajanKasi)) {
				System.out.println("Jakajalla on blackjack!");
				break;
			}
			if(tulos < 17) {
				System.out.println("Jakaja ottaa uuden kortin:");
				this.lisaaKorttiKateen(kp.jaaKortti());
				tulos = jakajanKasi.korttienArvo();
				System.out.println(jakajanKasi.viimeinenKortti() +"\n");
				System.out.println("Jakajan korttien arvo on nyt: " + tulos +"\n");
				if(tulos > 21) {
					System.out.println("Jakajalla meni yli niin ett‰ heilahti");
					break;
				}
			}else {
				System.out.println("Jakajan tulos on: " +tulos +" ,jakaja j‰‰ t‰h‰n.");
				break;
			}
			
		}while(true);
		
		this.asetaLopullinenPeliTulos(tulos);
		
		
	}

}
