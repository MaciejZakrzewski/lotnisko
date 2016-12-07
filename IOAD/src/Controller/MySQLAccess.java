package Controller;

import java.sql.SQLException;
import java.util.List;

//import org.jasypt.util.password.StrongPasswordEncryptor;








import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;

import Model.BagazPrzylatujacy;
import Model.Identyfikator;
import Model.Klient;
import Model.Lot;
import Model.Rezerwacje;
import Model.Samolot;

/**
 * Class responsible for the database connection, download and pre-processing of data
 *
 */
public class MySQLAccess {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	static final String DB_URL = "jdbc:mysql://85.128.223.48:3306/szabat94_2"; // bledy z czasem dostepu na nazwa.pl
	static final String DB_URL = "jdbc:mysql://localhost:3306/lotnisko";

	static final String USER = "gizmo";
	static final String PASS = "test123";
	// Model fields

	private ConnectionSource connectionSource;
	
	private Dao<Klient, String> userDao;
	private Dao<Identyfikator, String> idDao;
	private Dao<Rezerwacje, String> reservationDao;
	private Dao<Lot, String> tripDao;
	private Dao<Samolot, String> planeDao;
	private Dao<BagazPrzylatujacy, String> bagDao;

	// Game Model Constructor
	public MySQLAccess() {
		openDatabaseConnection();
		createDAOs();
		closeDatabaseConnection();
	}

	/**
	 * Open database conntection with specific url, user and password
	 */
	private void openDatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionSource = new JdbcConnectionSource(DB_URL, USER, PASS);
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (Exception e){
			
		}
	}

	/**
	 * close existed database connection
	 */
	private void closeDatabaseConnection() {
		try {
			connectionSource.close();
		} catch (SQLException e) {
			//e.printStackTrace();
		} catch (Exception e){
			
		}
	}

	/**
	 * Create all DAOs 
	 */
	private void createDAOs() {
		createIdDAO();
		createUserDAO();
		createReservationDAO();
		createTripDAO();
		createPlaneDAO();
		createBagDAO();
//		createSpeciesDAO();
//		createAnimalDAO();
//		createHistoryDAO();
	}

	private void createIdDAO() {
		try {
			idDao = DaoManager.createDao(connectionSource, Identyfikator.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			System.out.println("zzz");
		}
	}
	
	private void createUserDAO() {
		try {
			userDao = DaoManager.createDao(connectionSource, Klient.class);
		} catch (SQLException e1) {
			System.out.println("asfsaf");
		} catch (Exception e){
			System.out.println("aaaa");
		}
	}

	private void createReservationDAO() {
		try {
			reservationDao = DaoManager.createDao(connectionSource, Rezerwacje.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			System.out.println("zzz");
		}
	}
	
	private void createTripDAO() {
		try {
			tripDao = DaoManager.createDao(connectionSource, Lot.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			System.out.println("zzz");
		}
	}

	private void createPlaneDAO() {
		try {
			planeDao = DaoManager.createDao(connectionSource, Samolot.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			System.out.println("zzz");
		}
	}

	private void createBagDAO() {
		try {
			bagDao = DaoManager.createDao(connectionSource, BagazPrzylatujacy.class);
		} catch (SQLException e1) {
			System.out.println("bbbb");
		} catch (Exception e){
			System.out.println("zzz");
		}
	}

	public List<BagazPrzylatujacy> getBagazPrzylatujacyListFromDatabase() {
		openDatabaseConnection();
		List<BagazPrzylatujacy> bag = null;
		try {
			bag = bagDao.queryForAll();
			return bag;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return bag;
	}
	
	
	public List<Lot> getLotBetweenPlaces(String start, String end){
		openDatabaseConnection();
		List<Lot> loty = null;
		QueryBuilder<Lot, String> q = tripDao.queryBuilder();
		try {
			q.where().eq("miejsce_wylotu", start).and().eq("miejsce_przylotu", end);
			loty = tripDao.query(q.prepare());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return loty;
	}
	
	public List<Klient> getKlientListFromDatabase() {
		openDatabaseConnection();
		List<Klient> users = null;
		try {
			users = userDao.queryForAll();
			for(Klient k : users){
				System.out.println(k);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return users;
	}
	
	public Klient getKlientByIdFromDatabase(int id) {
		openDatabaseConnection();
		Klient k = null;
		QueryBuilder<Klient, String> q = userDao.queryBuilder();
		try {
			q.where().eq("id", id);
			k = userDao.queryForFirst(q.prepare());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return k;
	}

	public Klient getKlientByIdentificatorFromDatabase(Identyfikator identyfikator) {
    openDatabaseConnection();
    Klient k = null;
    QueryBuilder<Klient, String> q = userDao.queryBuilder();
    try {
      q.where().eq("id_identyfikatora", identyfikator.getId());
      k = userDao.queryForFirst(q.prepare());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDatabaseConnection();
    return k;
  }

  public Klient getKlientByNameAndSurnameFromDatabase(String name, String surname) {
    openDatabaseConnection();
    Klient k = null;
    QueryBuilder<Klient, String> q = userDao.queryBuilder();
    try {
      q.where().eq("imie", name).eq("nazwisko", surname);
      k = userDao.queryForFirst(q.prepare());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDatabaseConnection();
    return k;
  }
	
	public List<Samolot> getSamolotyListFromDatabase() {
		openDatabaseConnection();
		List<Samolot> samoloty = null;
		try {
			samoloty = planeDao.queryForAll();
			return samoloty;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return samoloty;
	}
	
}
