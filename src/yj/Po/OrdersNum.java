package yj.Po;

/**
 * 推荐POJO类
 */
public class OrdersNum {
	private Integer USERNAME; 
	private String ORDER_NUM;		
	private String TIME;		
	
	public String getTIME() {
		return TIME;
	}

	public void setTIME(String tIME) {
		TIME = tIME;
	}

	public Integer getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(Integer uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getORDER_NUM() {
		return ORDER_NUM;
	}

	public void setORDER_NUM(String oRDER_NUM) {
		ORDER_NUM = oRDER_NUM;
	}

	@Override
	public String toString() {
		return "USERNAME=" + USERNAME + ",ORDER_NUM=" + ORDER_NUM + ",TIME=" + TIME + ",";
	}
	
} 
