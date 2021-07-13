package yj.Po;

/**
 * 推荐POJO类
 */
public class Carts {
	private Integer GOODS_ID; //商品编号
	private String IMG_URL;		//商品图片
	private Integer USERNAME;		//用户名
	private String PRICE;		//商品价格
	private String TITLE;		//商品标题
	private Integer REPLACE_NUM;
	public Integer getREPLACE_NUM() {
		return REPLACE_NUM;
	}
	public void setREPLACE_NUM(Integer rEPLACE_NUM) {
		REPLACE_NUM = rEPLACE_NUM;
	}
	public Integer getGOODS_ID() {
		return GOODS_ID;
	}
	public Integer getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(Integer uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
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
		return "GOODS_ID=" + GOODS_ID + ",IMG_URL=" + IMG_URL + ",USERNAME=" + USERNAME + ",PRICE=" + PRICE
				+ ",TITLE=" + TITLE + ",REPLACE_NUM=" + REPLACE_NUM +",";
	}
} 
