package yj.Po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推荐POJO类
 */
public class Whole {
	@JsonProperty("GOODS_ID")
	private Integer GOODS_ID; //商品编号
	@JsonProperty("IMG_URL")
	private String IMG_URL;		//商品图片
	@JsonProperty("TITLE")
	private String TITLE;		//商品图片
	@JsonProperty("V_TITLE")
	private String V_TITLE;		//商品图片
	@JsonProperty("PRICE")
	private String PRICE;		//商品图片
	public Integer getGOODS_ID() {
		return GOODS_ID;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getV_TITLE() {
		return V_TITLE;
	}
	public void setV_TITLE(String v_TITLE) {
		V_TITLE = v_TITLE;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
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

	@Override
	public String toString() {
		return "GOODS_ID=" + GOODS_ID + ",IMG_URL=" + IMG_URL + ",TITLE=" + TITLE + ",V_TITLE=" + V_TITLE
				+ ",PRICE=" + PRICE + ",";
	}
} 
