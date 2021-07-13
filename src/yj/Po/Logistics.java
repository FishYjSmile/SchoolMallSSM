package yj.Po;

public class Logistics {
	private Integer USERNAME;
	private Integer PHONE;
	private String NAME;
	private String ZIP_CODE;
	private String ADDRESS;
	private Integer ID;
	public Integer getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(Integer uSERNAME) {
		USERNAME = uSERNAME;
	}
	public Integer getPHONE() {
		return PHONE;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public void setPHONE(Integer pHONE) {
		PHONE = pHONE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getZIP_CODE() {
		return ZIP_CODE;
	}
	public void setZIP_CODE(String zIP_CODE) {
		ZIP_CODE = zIP_CODE;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	@Override
	public String toString() {
		return "USERNAME=" + USERNAME + ",ID=" + ID +",PHONE=" + PHONE + ",NAME=" + NAME + ",ZIP_CODE=" + ZIP_CODE
				+ ",ADDRESS=" + ADDRESS + ",";
	}
	
}
