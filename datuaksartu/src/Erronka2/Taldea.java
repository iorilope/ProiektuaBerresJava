
package Erronka2;

/**
 * Taldea klasea
 */
public class Taldea {

	/** Txapelketaren ID-a */
	private String txapelketaId;

	/** Taldearen Kodea */
	private String taldeKod;

	/** Taldearen Txapelketa denbora */
	private String taldetxapDenbora;

	/**
	 * Talde berri bat hasieratzen du
	 *
	 * @param txapelketaId,     Txapelketaren ID-a
	 * @param taldeKod,         Taldearen Kodea
	 * @param taldetxapDenbora, Taldearen denbora Txapelketan
	 */
	public Taldea(String txapelketaId, String taldeKod, String taldetxapDenbora) {
		this.txapelketaId = txapelketaId;
		this.taldeKod = taldeKod;
		this.taldetxapDenbora = taldetxapDenbora;
	}

	/**
	 * @return Taldearen Txapelketa_ID
	 */
	public String getTxapelketaId() {
		return txapelketaId;
	}

	/**
	 * @return Taldearen Kodea
	 */
	public String getTaldeKod() {
		return taldeKod;
	}

	/**
	 * @return the Taldeak Txapelketan egindako denbora
	 */
	public String getTaldetxapDenbora() {
		return taldetxapDenbora;
	}

	/**
	 * @param Taldearen txapelketa_id-a ezarri
	 */
	public void setTxapelketaId(String txapelketaId) {
		this.txapelketaId = txapelketaId;
	}

	/**
	 * @param Taldearen kodea ezarri
	 */
	public void setTaldeKod(String taldeKod) {
		this.taldeKod = taldeKod;
	}

	/**
	 * @param Taldeak txapelketan egindako denbora ezarri
	 */
	public void setTaldetxapDenbora(String taldetxapDenbora) {
		this.taldetxapDenbora = taldetxapDenbora;
	}
}
