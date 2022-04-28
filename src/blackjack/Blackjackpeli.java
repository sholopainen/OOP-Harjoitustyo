package blackjack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackjackpeli implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Scanner s;
	private ArrayList<Ihmispelaaja> pelaajat;
	private int pelaajienM‰‰r‰;
	private int pelaajanVuoro;
	private Korttipakka kp;
	private Jakaja jakaja;
	
	public Blackjackpeli(Scanner s) {
		this.s = s;
		this.pelaajat = new ArrayList<Ihmispelaaja>();
		this.kp = new Korttipakka();
		this.pelaajanVuoro = 0;
		this.jakaja = new Jakaja();
	}
	
	public void valmistelePeli() {
		System.out.println("Tervetuloa pelaamaan Blackjackia!");
		System.out.println("T‰h‰n tulee s‰‰nnˆt");
		
		
		//Luodaan pelaajat
		System.out.println("Montako pelaajaa peliin osallistuu (1-6)?");
		pelaajienM‰‰r‰ = s.nextInt();
		for(int i = 0; i < pelaajienM‰‰r‰ ; i++) {
			System.out.print("Anna pelaajan " + (i + 1) + " nimi: ");
			String nimi = s.next();
			pelaajat.add(new Ihmispelaaja(nimi, s));
			
		}
		
		//Luodaan uusi korttipakka ja sekoitetaan se
		kp.luoPakka();
		kp.sekoitaPakka();
		
		
		//Jaetaan pelaajille ja jakajalle 2 aloituskorttia
		for(int i = 0; i < 2 ; i++) {
			for (Ihmispelaaja ip : pelaajat) {
				Kortti k = kp.jaaKortti();
				ip.lisaaKorttiKateen(k);
				
			}
			Kortti kk = kp.jaaKortti();
			jakaja.lisaaKorttiKateen(kk);
		}
	}
		
		
	public void pelaaPeli() {
		
		System.out.println("PELI ALKAA!");
		boolean peliK‰ynniss‰ = true;
		
		//Pelaajien vuorot
		for(int i = pelaajanVuoro ; i < pelaajienM‰‰r‰ ; i++) {
			Ihmispelaaja p = pelaajat.get(i);
			p.pelaaVuoro(kp);
			pelaajanVuoro ++;
			if(p.onkoPeliTallennettu() == true) {
				peliK‰ynniss‰ = false;
				break;
			}	
		}
		
		//Jakajan vuoro
		if(peliK‰ynniss‰ == true) {
			
		jakaja.pelaaVuoro(kp);
		int jakajanTulos = jakaja.annaLopullinenPeliTulos();
		System.out.println("Jakajan lopullinen tulos: " + jakajanTulos + "\n");
		
		
		
		//Tarkistetaan kierroksen voittaja
		
		//Tarkistetaan jokaisen pelaajan tulos jakajan tulosta vastaan ja tulostetaan voittajat
		for(Ihmispelaaja p : pelaajat) {
			int pelaajanTulos = p.annaLopullinenPeliTulos();
			if(pelaajanTulos > 21) {
				System.out.println(p.annaNimi() + " valitettavasti h‰visit t‰m‰n kierroksen :(");
			}else if(jakajanTulos > 21 && pelaajanTulos <= 21) {
				System.out.println("Jakajan tulos meni yli. Onneksi olkoon " +p.annaNimi() + " voitit jakajan");
			}else if(jakajanTulos <= 21) {
				if(jakajanTulos > pelaajanTulos) {
					System.out.println("Jakaja vei t‰m‰n kierroksen, valitettavasti h‰visit" + p.annaNimi());
				}else if(jakajanTulos < pelaajanTulos) {
					System.out.println("Onneksi olkoon " + p.annaNimi() + " voitit jakajan");
				}else if(jakajanTulos == pelaajanTulos) {
					System.out.println(p.annaNimi() +"pelasit tasapelin jakajan kanssa");
				}
			}
		}
		}
		
	}
	
	
	//Scanner-luokka ei ole Serializable, joten peli‰ ladatessa tallennetulle oliolle pit‰‰ asettaa uusi scanneri
	public void asetaSkanneri(Scanner s) {
		this.s = s;
		for(Ihmispelaaja p: pelaajat) {
			p.asetaSkanneri(s);
		}
	}
	
}


