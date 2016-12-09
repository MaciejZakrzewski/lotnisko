package KlientPack;

import Model.Rezerwacje;

import java.util.List;

/**
 * Created by Maciej on 09.12.2016.
 */
public class HistoriaRezerwacji {
  private List<Rezerwacje> listaAnRezerwacji;
  private List<Rezerwacje> listaZrealRezerwacji;

  HistoriaRezerwacji() {

  }

  public List<Rezerwacje> getListaAnRezerwacji() {
    return listaAnRezerwacji;
  }

  public void setListaAnRezerwacji(List<Rezerwacje> listaAnRezerwacji) {
    this.listaAnRezerwacji = listaAnRezerwacji;
  }

  public List<Rezerwacje> getListaZrealRezerwacji() {
    return listaZrealRezerwacji;
  }

  public void setListaZrealRezerwacji(List<Rezerwacje> listaZrealRezerwacji) {
    this.listaZrealRezerwacji = listaZrealRezerwacji;
  }

  public List<Rezerwacje> dodajDoAnRez(Rezerwacje rezerwacja) {
    this.listaAnRezerwacji.add(rezerwacja);
    return this.listaAnRezerwacji;
  }

  public List<Rezerwacje> dodajDoZrealRez(Rezerwacje rezerwacja) {
    this.listaZrealRezerwacji.add(rezerwacja);
    return this.listaZrealRezerwacji;
  }
}
