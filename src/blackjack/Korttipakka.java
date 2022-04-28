package blackjack;

import java.io.Serializable;
import java.util.ArrayList;

public class Korttipakka implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<Kortti> pakka;
	
	public Korttipakka() {
		this.pakka = new ArrayList<Kortti>();
	}
	
	public void luoPakka() {
		for(Maa maa : Maa.values()) {
			for (Arvo arvo : Arvo.values()) {
				this.pakka.add(new Kortti(maa, arvo));
			}
		}
	}
	
	public void sekoitaPakka() {
		ArrayList<Kortti> sekoitettu = new ArrayList<>();
		while(pakka.size() > 0) {
			int i = (int) (Math.random() * pakka.size());
			sekoitettu.add(pakka.remove(i));
			
		}
		pakka = sekoitettu;	
	}
	
	public Kortti jaaKortti() {
		return pakka.remove(0);
	}
	
	public Kortti viimeinenKortti() {
		return pakka.get(pakka.size() -1);
	}
	
	public void lisaaKortti(Kortti kortti) {
		this.pakka.add(kortti);
	}
	
	public int annaPakanKoko() {
		return pakka.size();
	}
	
	public int korttienArvo() {
		int kokonaisArvo = 0;
		int ässiä = 0;
		
		for(Kortti k : pakka) {
			switch(k.annaArvo()) {
			case ASSA: ässiä += 1; break;
			case KAKSI: kokonaisArvo += 2; break;
			case KOLME: kokonaisArvo += 3; break;
			case NELJA: kokonaisArvo += 4; break;
			case VIISI: kokonaisArvo += 5; break;
			case KUUSI: kokonaisArvo += 6; break;
			case SEITSEMAN: kokonaisArvo += 7; break;
			case KAHDEKSAN: kokonaisArvo += 8; break;
			case YHDEKSAN: kokonaisArvo += 9; break;
			case KYMMENEN: kokonaisArvo += 10; break;
			case JATKA: kokonaisArvo += 10; break;
			case ROUVA: kokonaisArvo += 10; break;
			case KUNINGAS: kokonaisArvo += 10; break;
			}
		}
		
		for(int i = 0; i < ässiä; i++) {
			if(kokonaisArvo > 10) {
				kokonaisArvo += 1;
			}else {
				kokonaisArvo += 11;
			}
		}
		
		return kokonaisArvo;
	}
	
	
	public String toString() {
		String korttiLista ="";
		for(Kortti kortti : pakka) {
			korttiLista += "\n" + kortti.toString();
		}
		
		return korttiLista;
	}


	

}
