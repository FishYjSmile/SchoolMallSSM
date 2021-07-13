package yj.Control;
import java.util.List;
import java.io.InputStream;
import java.io.Reader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;


import yj.Po.User;
@Controller
public class CustomerCRUD {
	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static SqlSession getSesstion() {
		return sqlSessionFactory.openSession();
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/LoginTest" ,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String LoginTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int num = Integer.parseInt(username);
		SqlSession sqlSession = getSesstion();
		User customer = sqlSession.selectOne("yj.Mapper.CustomerMapper.findCustomerById1",num);
		sqlSession.close();
		if(customer == null)
			return "用户名或密码错误请重新输入";
		else {
			if(username.equals(Integer.toString(customer.getUsername())) && password.equals(customer.getPassword()))	
				return customer.toString();
			else
				return "0";
		}
//		customer.getUsername();
//		customer.getPassword();
//		System.out.println(username.equals(Integer.toString(customer.getUsername())));
		
		
	}
	@CrossOrigin
	@RequestMapping(value = "/FileImg" ,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String FileImg(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		缺少jar包
		String username = request.getParameter("username");
		String usersFile = request.getParameter("usersFile");
		System.out.println(usersFile);
		System.out.println(username);
		int num = Integer.parseInt(username);
		SqlSession sqlSession = getSesstion();
		User customer = sqlSession.selectOne("yj.Mapper.CustomerMapper.findCustomerById1",num);
		sqlSession.close();
		return "";
//		if(customer == null)
//			return "用户名或密码错误请重新输入";
//		else {
//			if(username.equals(Integer.toString(customer.getUsername())) && password.equals(customer.getPassword()))	
//				return customer.toString();
//			else
//				return "0";
//		}
//		customer.getUsername();
//		customer.getPassword();
//		System.out.println(username.equals(Integer.toString(customer.getUsername())));
		
		
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/RegisterTest" ,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String RegisterTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		SqlSession sqlSession = getSesstion();
		User customer = new User();
		customer.setUsername(Integer.parseInt(username));
		customer.setPassword(password);
		customer.setName(name);
		int rows = sqlSession.insert("yj.Mapper.CustomerMapper.addCustomer1",customer);
		sqlSession.commit();//提交事务
		sqlSession.close();
		if(rows >0) {
			System.out.println("成功插入  "+rows+" 条数据");
			return "1";
		}else {
			System.out.println("插入数据失败");
			return "0";
		}
		
		
		
	}
	@Test
	@CrossOrigin
	@RequestMapping("/UserCRUD")
	@ResponseBody
	public String findCustomerByIdTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");	
		String username = request.getParameter("username");//前端传入的数据username
		int num = Integer.parseInt(username);
		SqlSession sqlSession = getSesstion();
		User customer = sqlSession.selectOne("yj.Mapper.CustomerMapper.findCustomerById1",num);
		System.out.println(customer.toString());
		sqlSession.close();
		String message = customer.toString();
		return message;
	}
	@Test
	public void addCustomerTest() throws Exception{
		SqlSession sqlSession = getSesstion();
		User customer = new User();
		
		customer.setUsername(123);
		customer.setPassword("123");
		int rows = sqlSession.insert("yj.Mapper.CustomerMapper.addCustomer1",customer);
		if(rows >0) {
			System.out.println("成功插入  "+rows+" 条数据");
		}else {
			System.out.println("插入数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
	}
}
