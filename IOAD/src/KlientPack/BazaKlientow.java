package KlientPack;

import Controller.MySQLAccess;

/**
 * Created by Maciej on 05.12.2016.
 */
public class BazaKlientow {
  private static MySQLAccess db = new MySQLAccess();

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

  public static Identyfikator dodajIdentyfikator(Identyfikator identyfikator) {
    return db.dodajIdentyfikator(identyfikator);
  }

}
