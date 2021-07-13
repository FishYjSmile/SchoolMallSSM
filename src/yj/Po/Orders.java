package yj.Po;

public class Orders {
	private Integer USERNAME;
	private Integer REPLACE_NUM;
	private Integer GOODS_ID;
	private String IMG_URL;
	private String TITLE;
	private String PRICE;
	private String ORDER_NUM;
	private String TIME;
	public Integer getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(Integer uSERNAME) {
		USERNAME = uSERNAME;
	}
	public Integer getREPLACE_NUM() {
		return REPLACE_NUM;
	}
	public void setREPLACE_NUM(Integer rEPLACE_NUM) {
		REPLACE_NUM = rEPLACE_NUM;
	}
	public Integer getGOODS_ID() {
		return GOODS_ID;
	}
	public void setGOODS_ID(Integer gOODS_ID) {
		GOODS_ID = gOODS_ID;
	}
	public String getIMG_URL() {
		return IMG_URL;
	}
	public void setIMG_URL(String iMG_URL) {
		IMG_URL = iMG_URL;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}
	public String getORDER_NUM() {
		return ORDER_NUM;
	}
	public void setORDER_NUM(String oRDER_NUM) {
		ORDER_NUM = oRDER_NUM;
	}
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	@Override
	public String toString() {
		return "USERNAME=" + USERNAME + ",REPLACE_NUM=" + REPLACE_NUM + ",GOODS_ID=" + GOODS_ID + ",IMG_URL="
				+ IMG_URL + ",TITLE=" + TITLE + ",PRICE=" + PRICE + ",ORDER_NUM=" + ORDER_NUM + ",TIME=" + TIME
				+ ",";
	}
	
	
}
