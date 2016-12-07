import java.util.List;

import Controller.MySQLAccess;
import Model.*;


public class Main {

	public static void main(String[] args) {

		MySQLAccess db = new MySQLAccess();
		db.getKlientListFromDatabase();
		System.out.println(db.getKlientByIdFromDatabase(1));
		
		List<Lot> loty = db.getLotBetweenPlaces("warszawa", "moskwa");
		for (Lot l : loty){
			System.out.println(l);
		}

		List<Samolot> samoloty = db.getSamolotyListFromDatabase();
		for (Samolot l : samoloty){
			System.out.println(l);
		}
		

		List<BagazPrzylatujacy> bags = db.getBagazPrzylatujacyListFromDatabase();
		for (BagazPrzylatujacy l : bags){
			System.out.println(l);
		}

    System.out.println("KLIENCI DEBUG");

    Klient klient = BazaKlientow.wyszukajKlienta(2);
    System.out.println(klient.toString());

    Identyfikator identyfikator = new Identyfikator(1, "Paszport", "AVK41547815");

    Klient klient2 = BazaKlientow.wyszukajKlienta(identyfikator);
    System.out.println("WYSZUKIWANIE KLIENTA PO ID");
    System.out.println(klient2.toString());

	}

}
