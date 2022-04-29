package blackjack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * P��luokka, josta peli� pelataan
 * @author holopainen
 *
 */

public class Main implements Serializable {
	
	private static final long serialVersionUID = 1L;
	static Blackjackpeli bj;
	
	/**
	 * Aloitetaan uusi peli tai ladataan edellinen tallennettu peli
	 * 
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException {
		
		Scanner ss = new Scanner(System.in);
		bj = new Blackjackpeli(ss);
		int valinta = 0;
		
		System.out.println("(1) aloita uusi peli");
		System.out.println("(2) lataa edellinen peli");
		
		valinta = testaaSyote(1, 2, ss);
		
		if (valinta == 1) {
			bj.valmistelePeli();
			bj.pelaaPeli();
		}else if(valinta == 2) {
			lataaPeli();
			bj.asetaSkanneri(ss);
			bj.pelaaPeli();
		}
			
			ss.close();
		
	}

	/**
	 * Tallentaa pelin
	 */
	
	// Metodi on julkinen ja  staattinen, jotta sit� voidaan kutsua Ihmispelaaja-luokasta
	public static void tallennaPeli() {
		try {
			FileOutputStream fos = new FileOutputStream("bj.sav");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bj);
			oos.flush();
			oos.close();
			System.out.println("Peli tallennettu!\n");	
		}catch (Exception e) {
			System.out.println("Tallentaminen ei onnistunut");
			System.out.println(e.getMessage());
			e.getStackTrace();
		}	
	}
	
	/**
	 * Lataa tallennetun pelin
	 */
	
	private static void lataaPeli() {
		try {
			FileInputStream fis = new FileInputStream("bj.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);
			bj = (Blackjackpeli) ois.readObject();
			ois.close();
			System.out.println("Peli ladattu!\n");	
		}catch (Exception e) {
			System.out.println("Lataaminen ei onnistunut");
			e.getStackTrace();
		}
	}
	
	/**
	 * Testaa, ett� k�ytt�j�n antama sy�te on oikeanlaista ja virhetilanteissa yritet��n uudestaan
	 * @param alku m��ritt�� sallittujen kokonaislukujen ensimm�isen sallitun arvon
	 * @param loppu m��ritt�� sallittujen kokonaislukujen viimeisen sallitun arvon
	 * @param s skanneri
	 * @return k�ytt�j�n antaman validin sy�tteen
	 */
	
		public static int testaaSyote(int alku, int loppu, Scanner s) {
			int valinta = 0;
			boolean onkoKelvollinen = false;
			
			while(!onkoKelvollinen) {
				try {
					String rivi = s.nextLine();
					valinta = Integer.parseInt(rivi);
					if(valinta >= alku && valinta <= loppu) {
						onkoKelvollinen = true;
					}else {
						System.out.println("V��r� sy�te, kokeile uudestaan");
					}
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println(e);
					System.out.println("Jotain meni pieleen, yrit� uudestaan");
				}
			}
			
			return valinta;
		}

}
