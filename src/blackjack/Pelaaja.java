package blackjack;

import java.io.Serializable;

public abstract class Pelaaja implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nimi;
	private Korttipakka k�si;
	private int lopullinenPeliTulos;
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
		this.k�si = new Korttipakka();
		this.lopullinenPeliTulos = 0;
	}
	
	public String annaNimi() {
		return nimi;
	}
	
	public Korttipakka annaKasi() {
		return k�si;
	}
	
	public void lisaaKorttiKateen(Kortti k) {
		this.k�si.lisaaKortti(k);
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
	
	public boolean onkoBlackjack(Korttipakka k�si) {
		if (k�si.korttienArvo() == 21) {
			return true;
		}else {
			return false;
		}
	}
	
	public abstract void pelaaVuoro(Korttipakka kp);
	
}
