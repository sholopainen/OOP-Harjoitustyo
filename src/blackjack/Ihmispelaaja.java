package blackjack;

import java.util.Scanner;

/**
 * Luokasta voidaan muodostaa uusia Ihmispelaaja-instansseja
 *
 */

public class Ihmispelaaja extends Pelaaja {
	
	private static final long serialVersionUID = 1L;
	private transient Scanner s;
	private boolean peliTallennettu;
	
	
	public Ihmispelaaja(String nimi, Scanner s) {
		super(nimi);
		this.s = s;
		this.peliTallennettu = false;
	}
	
	/**
	 * Vuoron pelaus. Tulostaa pelaajan aloituskortit ja tarkistaa onko Blackjack. Jos ei, kysyy pelaajalta ottaako tämä lisää kortteja ja arpoo ne.
	 */
	
	@Override
	public void pelaaVuoro(Korttipakka kp) {
		
		Korttipakka pelaajanKasi = this.annaKasi();
		int tulos = pelaajanKasi.korttienArvo();
		
		System.out.println("Pelaajan " +this.annaNimi() + " kortit ovat: " + pelaajanKasi);
		System.out.println("Korttien arvo on:" + tulos +"\n");
		
		
			do {
				if(onkoBlackjack(pelaajanKasi)) {
					System.out.println("Pelaajalla " + this.annaNimi() + " on blackjack!\n");
					break;
				}
				
				System.out.println("Valitse (1) jos haluat lisää kortteja, (2) mikäli haluat jäädä tähän tai (3) mikäli haluat tallentaa pelin");
				
				int vastaus = Main.testaaSyote(1,3,s);
				
				if(vastaus == 1) {
					System.out.println("Sait uuden kortin: ");
					this.lisaaKorttiKateen(kp.jaaKortti());
					tulos = pelaajanKasi.korttienArvo();
					System.out.println(pelaajanKasi.viimeinenKortti() +"\n");
					System.out.println("Korttiesi arvo on nyt: " + tulos +"\n");
					
					if(tulos > 21) {
						System.out.println("Oho, nyt kävi köpelösti, tuloksesi on: " + tulos + "\n");
					}
				}else if (vastaus == 2) {
					System.out.println("Lopputuloksesi on: " + tulos +"\n");
					break;
				}else if (vastaus == 3){
						Main.tallennaPeli();
						peliTallennettu = true;
						break;
				}
				
			
			}while(tulos <= 21);

			
	this.asetaLopullinenPeliTulos(tulos);
		
	}
	
	
	/**
	 * Palauttaa tiedon siitä onko peli tallennettu
	 * @return boolean
	 */
	public boolean onkoPeliTallennettu() {
		return peliTallennettu;
	}
	
	public void asetaSkanneri(Scanner s) {
		this.s = s;
	}
	
}
