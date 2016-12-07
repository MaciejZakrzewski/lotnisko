package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "bagaz_przylatujacy")
public class BagazWylatujacy {
	@DatabaseField(columnName = "id_bagazu", canBeNull = false)
	private int idBazau;
	
	@DatabaseField(columnName = "id_rezerwacji", canBeNull = false)
	private int idRezerwacji;
	
	@DatabaseField(columnName = "waga", canBeNull = false)
	private float waga;
	
	@DatabaseField(columnName = "status_bagazu", foreign = true, foreignAutoRefresh = true)
	private StatusBagazu status;

	@DatabaseField(columnName = "czy_potrzebna_doplata", canBeNull = false)
	private boolean czyPotrzebnaDoplata;

	@DatabaseField(columnName = "doplata", canBeNull = false)
	private int doplata;

	@DatabaseField(columnName = "cena_za_kg", canBeNull = false)
	private int cenaZaKg;

	@DatabaseField(columnName = "czy_przeszedl_odprawe", canBeNull = false)
	private boolean czyPrzeszedlOdprawe;

	@DatabaseField(columnName = "czy_oplacono_bagaz", canBeNull = false)
	private boolean czyOplaconoBagaz;
	
	public BagazWylatujacy(){
		
	}

	public BagazWylatujacy(int idBazau, int idRezerwacji, float waga,
			StatusBagazu status, boolean czyPotrzebnaDoplata, int doplata,
			int cenaZaKg, boolean czyPrzeszedlOdprawe, boolean czyOplaconoBagaz) {
		super();
		this.idBazau = idBazau;
		this.idRezerwacji = idRezerwacji;
		this.waga = waga;
		this.status = status;
		this.czyPotrzebnaDoplata = czyPotrzebnaDoplata;
		this.doplata = doplata;
		this.cenaZaKg = cenaZaKg;
		this.czyPrzeszedlOdprawe = czyPrzeszedlOdprawe;
		this.czyOplaconoBagaz = czyOplaconoBagaz;
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

	public boolean isCzyPotrzebnaDoplata() {
		return czyPotrzebnaDoplata;
	}

	public void setCzyPotrzebnaDoplata(boolean czyPotrzebnaDoplata) {
		this.czyPotrzebnaDoplata = czyPotrzebnaDoplata;
	}

	public int getDoplata() {
		return doplata;
	}

	public void setDoplata(int doplata) {
		this.doplata = doplata;
	}

	public int getCenaZaKg() {
		return cenaZaKg;
	}

	public void setCenaZaKg(int cenaZaKg) {
		this.cenaZaKg = cenaZaKg;
	}

	public boolean isCzyPrzeszedlOdprawe() {
		return czyPrzeszedlOdprawe;
	}

	public void setCzyPrzeszedlOdprawe(boolean czyPrzeszedlOdprawe) {
		this.czyPrzeszedlOdprawe = czyPrzeszedlOdprawe;
	}

	public boolean isCzyOplaconoBagaz() {
		return czyOplaconoBagaz;
	}

	public void setCzyOplaconoBagaz(boolean czyOplaconoBagaz) {
		this.czyOplaconoBagaz = czyOplaconoBagaz;
	}

	@Override
	public String toString() {
		return "BagazWylatujacy [idBazau=" + idBazau + ", idRezerwacji="
				+ idRezerwacji + ", waga=" + waga + ", status=" + status
				+ ", czyPotrzebnaDoplata=" + czyPotrzebnaDoplata + ", doplata="
				+ doplata + ", cenaZaKg=" + cenaZaKg + ", czyPrzeszedlOdprawe="
				+ czyPrzeszedlOdprawe + ", czyOplaconoBagaz="
				+ czyOplaconoBagaz + "]";
	}

	
	
}
