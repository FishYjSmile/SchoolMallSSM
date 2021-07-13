package yj.Po;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ImgVMayjor {

		@JsonProperty("GOODS_ID")
		private Integer GOODS_ID;
		@JsonProperty("IMG_URL")
		private String IMG_URL;
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
		
}
