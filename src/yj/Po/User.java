package yj.Po;

/**
 * 用户POJO类
 */
public class User {
	private Integer username; //用户名
	private String password;//用户密码
	private String name;
	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUsername() {
		return username;
	}
	public void setUsername(Integer username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
//		return "name=" + name;
		return "username=" + username + ",password=" + password + ",name=" + name + ",img=" + img;
	}
} 
