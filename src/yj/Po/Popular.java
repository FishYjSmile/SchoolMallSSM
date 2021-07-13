package yj.Po;

/**
 * 推荐POJO类
 */
public class Popular {
	private Integer GOODS_ID; //商品编号
	private String IMG_URL;		//商品图片
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

	@Override
	public String toString() {
		return "GOODS_ID=" + GOODS_ID + ",IMG_URL=" + IMG_URL+",";
	}
} 
