package blackjack;

import java.io.Serializable;

public abstract class Pelaaja implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nimi;
	private Korttipakka käsi;
	private int lopullinenPeliTulos;
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
		this.käsi = new Korttipakka();
		this.lopullinenPeliTulos = 0;
	}
	
	public String annaNimi() {
		return nimi;
	}
	
	public Korttipakka annaKasi() {
		return käsi;
	}
	
	public void lisaaKorttiKateen(Kortti k) {
		this.käsi.lisaaKortti(k);
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
	
	public boolean onkoBlackjack(Korttipakka käsi) {
		if (käsi.korttienArvo() == 21) {
			return true;
		}else {
			return false;
		}
	}
	
	public abstract void pelaaVuoro(Korttipakka kp);
	
}
