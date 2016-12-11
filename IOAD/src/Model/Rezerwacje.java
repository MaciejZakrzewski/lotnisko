package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "rezerwacje")
public class Rezerwacje {
	@DatabaseField(columnName = "id_rezerwacji", canBeNull = false)
	private int idRezerwacji;
	
	@DatabaseField(columnName = "id_klienta", canBeNull = false)
	private int idKlienta;
	
	@DatabaseField(columnName = "id_lotu", canBeNull = false)
	private int idLotu;

	public Rezerwacje(){
		
	}
	
	public Rezerwacje(int idRezerwacji, int idKlienta, int idLotu) {
		super();
		this.idRezerwacji = idRezerwacji;
		this.idKlienta = idKlienta;
		this.idLotu = idLotu;
	}

	public int getIdRezerwacji() {
		return idRezerwacji;
	}

	public void setIdRezerwacji(int idRezerwacji) {
		this.idRezerwacji = idRezerwacji;
	}

	public int getIdKlienta() {
		return idKlienta;
	}

	public void setIdKlienta(int idKlienta) {
		this.idKlienta = idKlienta;
	}

	public int getIdLotu() {
		return idLotu;
	}

	public void setIdLotu(int idLotu) {
		this.idLotu = idLotu;
	}

  @Override
  public String toString() {
    return "Rezerwacje [idRezerwacji=" + idRezerwacji + ", idKlienta=" + idKlienta + ", idLotu=" + idLotu + "]";
  }

}
