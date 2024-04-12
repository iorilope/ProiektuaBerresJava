
package Erronka2;

/**
 * Indibiduala Klasea
 */
public class Indibiduala {

	/** Piraguistaren NAN-a. */
	private String piraguistaNan;

	/** Txapelketaren ID-a */
	private String txapelketaId;

	/** Piraguistak Txapelketan egindako denbora */
	private String denbora;

	/**
	 * Indibidual berri bat sortu
	 *
	 * @param piraguistaNan, Piraguistaren NAN-a
	 * @param txapelketaId,  Txapelketaren ID-a
	 * @param denbora,       Piraguistak Txapelketan egindako denbora
	 */
	public Indibiduala(String piraguistaNan, String txapelketaId, String denbora) {
		this.piraguistaNan = piraguistaNan;
		this.txapelketaId = txapelketaId;
		this.denbora = denbora;
	}

	/**
	 * @return Piraguistaren Nan-a
	 */
	public String getPiraguistaNan() {
		return piraguistaNan;
	}

	/**
	 * @return Txapelketaren Id-a
	 */
	public String getTxapelketaId() {
		return txapelketaId;
	}

	/**
	 * @return Piraguistak Txapelketan eegindako denbora
	 */
	public String getDenbora() {
		return denbora;
	}

	/**
	 * @param piraguistaNan, ezarriko den piraguistaren NAN-a
	 */
	public void setPiraguistaNan(String piraguistaNan) {
		this.piraguistaNan = piraguistaNan;
	}

	/**
	 * @param txapelketaId, ezarriko den Txapelketaren ID-a
	 */
	public void setTxapelketaId(String txapelketaId) {
		this.txapelketaId = txapelketaId;
	}

	/**
	 * @param denbora, ezarriko den denbora
	 */
	public void setDenbora(String denbora) {
		this.denbora = denbora;
	}
}