package blackjack;

import java.io.Serializable;

/**
 * Luokasta voidaan luoda pelikortti-olioita
 *
 */

public class Kortti implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Maa maa;
	private Arvo arvo;
	
	public Kortti(Maa maa, Arvo arvo) {
		this.maa = maa;
		this.arvo = arvo;
	}
	
	public Kortti() {
		this.maa = null;
		this.arvo = null;
	}
	
	
	public String toString() {
		return this.maa.toString() + " - " + this.arvo.toString();
	}
	
	public Arvo annaArvo() {
		return this.arvo;
	}
	
	public Maa annaMaa() {
		return this.maa;
	}
	
}
