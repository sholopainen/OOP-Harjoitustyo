package blackjack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
 

public class Main implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Blackjackpeli bj;
	
	//pelin tallennusmetodi. Metodi on julkinen ja  staattinen, jotta sitä voidaan kutsua Ihmispelaaja-luokasta
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
	
	//pelin latausmetodi
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
	

	public static void main(String[] args) throws IOException {
		
		Scanner ss = new Scanner(System.in);
		bj = new Blackjackpeli(ss);
		
		try {
			
			System.out.println("(1) aloita uusi peli");
			System.out.println("(2) lataa edellinen peli");
			int valinta = ss.nextInt();
			
			if (valinta == 1) {
				bj.valmistelePeli();
			}else if(valinta == 2) {
				lataaPeli();
				bj.asetaSkanneri(ss);
			}
			
			bj.pelaaPeli();
			
			ss.close();
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
		}
		
		
		
		
		
		
		

	}
	
	

}
