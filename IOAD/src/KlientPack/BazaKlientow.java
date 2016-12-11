package KlientPack;

import java.util.List;

import Controller.MySQLAccess;
import Model.Lot;

public class BazaKlientow {
  private static MySQLAccess db = new MySQLAccess();
  
  public static List<Klient> pobierzListeKlientow() {
    return db.getKlientListFromDatabase();
  }

  public static Klient wyszukajKlienta(int id) {
    return db.getKlientByIdFromDatabase(id);
  }

  public static Klient wyszukajKlienta(Identyfikator identyfikator) {
    return db.getKlientByIdentificatorFromDatabase(identyfikator);
  }

  public static Klient wyszukajKlienta(String imie, String nazwisko) {
    return db.getKlientByNameAndSurnameFromDatabase(imie, nazwisko);
  }

  public static Klient zarejestrujKlienta(Klient klient) {
    return db.zarejestrujKlienta(klient);
  }

  public static Klient modyfikujDaneKlienta(Klient klient) {
    return db.modyfikujKlienta(klient);
  }

  public static Klient usunKlienta(Klient klient) {
    return db.usunKlienta(klient);
  }

  public static Klient pobierzListeRezerwacji(Klient klient) {
    return db.pobierzListeRezerwacji(klient);
  }

  public static Identyfikator dodajIdentyfikator(Identyfikator identyfikator) {
    return db.dodajIdentyfikator(identyfikator);
  }

  public static Identyfikator wyszukajIdentyfikator(String value) {
    return db.getIdentyfikatorByValue(value);
  }

  public static Identyfikator wyszukajIdentyfikator(int idIdentyfikatora) {
    return db.getIdentyfikatorById(idIdentyfikatora);
  }
  
  public static Identyfikator wyszukajIdentyfikator(String typ, String value) {
    return db.getIdentyfikatorByTypeAndValue(typ, value);
  }

  public static Lot wyszukajLot(int idLotu) {
    return db.getLotById(idLotu);
  }


}
