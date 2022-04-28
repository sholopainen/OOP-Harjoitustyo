package blackjack;

import java.util.Scanner;

public class Ihmispelaaja extends Pelaaja {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Scanner s;
	private boolean peliTallennettu;
	
	
	public Ihmispelaaja(String nimi, Scanner s) {
		super(nimi);
		this.s = s;
		this.peliTallennettu = false;
	}
	
	@Override
	public void pelaaVuoro(Korttipakka kp) {
		
		Korttipakka pelaajanKasi = this.annaKasi();
		int tulos = pelaajanKasi.korttienArvo();
		
		System.out.println("Pelaajan " +this.annaNimi() + " kortit ovat: " + pelaajanKasi);
		System.out.println("Korttien arvo on:" + tulos +"\n");
		
		
			do {
				if(onkoBlackjack(pelaajanKasi)) {
					System.out.println("Pelaajalla " + this.annaNimi() + " on blackjack!");
					break;
				}
					
				System.out.println("Valitse (1) jos haluat lisää kortteja, (2) mikäli haluat jäädä tähän tai (3) mikäli haluat tallentaa pelin");
				
				int vastaus = s.nextInt();
				
				if(vastaus == 1) {
					System.out.println("Sait uuden kortin: ");
					this.lisaaKorttiKateen(kp.jaaKortti());
					tulos = pelaajanKasi.korttienArvo();
					System.out.println(pelaajanKasi.viimeinenKortti() +"\n");
					System.out.println("Korttiesi arvo on nyt: " + tulos);
					if(tulos > 21) {
						System.out.println("Oho, nyt kävi köpelösti, tuloksesi on: " + tulos + " hävisit tämän pelin :(");
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
	
	public boolean onkoPeliTallennettu() {
		return peliTallennettu;
	}
	
	public void asetaSkanneri(Scanner s) {
		this.s = s;
	}
	
}
