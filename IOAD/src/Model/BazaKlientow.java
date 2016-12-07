package Model;

import Controller.MySQLAccess;

/**
 * Created by Maciej on 05.12.2016.
 */
public class BazaKlientow {
  private static MySQLAccess db = new MySQLAccess();

  public static Klient wyszukajKlienta(int id) {
    Klient klient = db.getKlientByIdFromDatabase(id);
    return klient;
  }

  public static Klient wyszukajKlienta(Identyfikator identyfikator) {
    Klient klient = db.getKlientByIdentificatorFromDatabase(identyfikator);
    return klient;
  }

  public static Klient wyszukajKlienta(String imie, String nazwisko) {
    Klient klient = db.getKlientByNameAndSurnameFromDatabase(imie, nazwisko);
    return klient;
  }
}
