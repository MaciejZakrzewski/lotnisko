package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "bagaz_przylatujacy")
public class BagazPrzylatujacy {
	@DatabaseField(columnName = "id_bagazu", canBeNull = false)
	private int idBazau;
	
	@DatabaseField(columnName = "id_rezerwacji", canBeNull = false)
	private int idRezerwacji;
	
	@DatabaseField(columnName = "waga", canBeNull = false)
	private float waga;
	
	@DatabaseField(columnName = "status_bagazu", foreign = true, foreignAutoRefresh = true)
	private StatusBagazu status;
	
	
	public BagazPrzylatujacy(){
		
	}


	public BagazPrzylatujacy(int idBazau, int idRezerwacji, float waga,
			StatusBagazu status) {
		super();
		this.idBazau = idBazau;
		this.idRezerwacji = idRezerwacji;
		this.waga = waga;
		this.status = status;
	}


	public int getIdBazau() {
		return idBazau;
	}


	public void setIdBazau(int idBazau) {
		this.idBazau = idBazau;
	}


	public int getIdRezerwacji() {
		return idRezerwacji;
	}


	public void setIdRezerwacji(int idRezerwacji) {
		this.idRezerwacji = idRezerwacji;
	}


	public float getWaga() {
		return waga;
	}


	public void setWaga(float waga) {
		this.waga = waga;
	}


	public StatusBagazu getStatus() {
		return status;
	}


	public void setStatus(StatusBagazu status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "BagazPrzylatujacy [idBazau=" + idBazau + ", idRezerwacji="
				+ idRezerwacji + ", waga=" + waga + ", status=" + status + "]";
	}

	
	
}
