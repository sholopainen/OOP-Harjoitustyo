package blackjack;

import java.io.Serializable;

/**
 * Kantaluokka, joka sis‰lt‰‰ pelaajille yhteiset muuttujat ja metodit
 *
 */

public abstract class Pelaaja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nimi;
	private Korttipakka k‰si;
	private int lopullinenPeliTulos;
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
		this.k‰si = new Korttipakka();
		this.lopullinenPeliTulos = 0;
	}
	
	/**
	 * Tarkistaa onko k‰dess‰ olevien korttien arvo 21 eli Blackjack
	 * @param k‰si
	 * @return boolean
	 */
	
	public boolean onkoBlackjack(Korttipakka k‰si) {
		if (k‰si.korttienArvo() == 21) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Uudelleenm‰‰ritelt‰v‰ metodi vuoron pelaamiseksi
	 * @param Korttipakka
	 */
	public abstract void pelaaVuoro(Korttipakka kp);
	
	public String annaNimi() {
		return nimi;
	}
	
	public Korttipakka annaKasi() {
		return k‰si;
	}
	
	public void lisaaKorttiKateen(Kortti k) {
		this.k‰si.lisaaKortti(k);
	}
	
	public void asetaNimi(String nimi) {
		this.nimi = nimi;
	}

	public int annaLopullinenPeliTulos() {
		return lopullinenPeliTulos;
	}
	
	public void asetaLopullinenPeliTulos(int tulos) {
		this.lopullinenPeliTulos = tulos;
	}
	
}
