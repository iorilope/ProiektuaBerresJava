
package Erronka2;

/**
 * Piraguista baten klasea.
 */

public class Piraguista {

	/** Piraguistaren NAN */
	private String nan;

	/** Piraguistaren Izena */
	private String izena;

	/** TPiraguistaren Abizena */
	private String abizena;

	/** Piraguistaren Generoa */
	private String generoa;

	/** Piraguistaren Telefonoa */
	private String telefonoa;

	/** Piraguistaren Herria */
	private String herria;

	/** Piraguistaren Talde Kodea */
	private String talde_kodea;

	/** Piraguistak jokatutako Txapelketa kopurua */
	private String txapelketak;

	/**
	 * Piraguista klasearen eraikitzailea.
	 *
	 * @param nan         piraguistaren identifikazio-zenbakia (NAN).
	 * @param izena       Piraguistaren izena.
	 * @param abizena     Piraguistaren abizena.
	 * @param generoa     Piraguistaren generoa.
	 * @param telefonoa   Piraguistaren telefono-zenbakia.
	 * @param herria      Piraguistaren hiria edo herria.
	 * @param talde_kodea Piraguistaren talde-kodea.
	 * @param txapelketak Piraguistak parte hartu duen txapelketa kopurua.
	 */

	public Piraguista(String nan, String izena, String abizena, String generoa, String telefonoa, String herria,
			String talde_kodea, String txapelketak) {
		this.nan = nan;
		this.izena = izena;
		this.abizena = abizena;
		this.generoa = generoa;
		this.telefonoa = telefonoa;
		this.herria = herria;
		this.talde_kodea = talde_kodea;
		this.txapelketak = txapelketak;
	}

	/**
	 * @return Piraguistaren NAN-a
	 */
	public String getNan() {
		return nan;
	}

	/**
	 * @return Piraguistaren Izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * @return Piraguistaren Abizena
	 */
	public String getAbizena() {
		return abizena;
	}

	/**
	 * @return Piraguistaren Generoa
	 */
	public String getGeneroa() {
		return generoa;
	}

	/**
	 * @return Piraguistaren Telefonoa
	 */
	public String getTelefonoa() {
		return telefonoa;
	}

	/**
	 * @return Piraguistaren herria
	 */
	public String getHerria() {
		return herria;
	}

	/**
	 * @return Piraguistaren Talde Kodea
	 */
	public String getTalde_kodea() {
		return talde_kodea;
	}

	/**
	 * @return Piraguistak Jokatutao Txapelketa Kopurua
	 */
	public String getTxapelketak() {
		return txapelketak;
	}

	/**
	 * @param nan, piraguistaren nan
	 */
	public void setNan(String nan) {
		this.nan = nan;
	}

	/**
	 * @param izena, piraguistaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * @param abizena, piraguistaren abizena
	 */
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	/**
	 * @param generoa, piraguistaren generoa
	 */
	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}

	/**
	 * @param telefonoa, piraguistaren telefonoa
	 */
	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	/**
	 * @param herria, piraguistaren herria
	 */
	public void setHerria(String herria) {
		this.herria = herria;
	}

	/**
	 * @param talde_kodea, Piraguistaren talde kodea
	 */
	public void setTalde_kodea(String talde_kodea) {
		this.talde_kodea = talde_kodea;
	}

	/**
	 * @param txapelketak, Piraguistaren Txapelketa Kop
	 */
	public void setTxapelketak(String txapelketak) {
		this.txapelketak = txapelketak;
	}

}
