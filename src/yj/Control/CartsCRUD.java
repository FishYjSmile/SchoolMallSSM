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

import yj.Po.Carts;
@Controller
public class CartsCRUD {
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
	@RequestMapping(value = "/SelectCartTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String SelectCartTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String message = "";
//		Carts cart = null;
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
		int num = Integer.parseInt(USERNAME);
		SqlSession sqlSession = getSesstion();
		List<Carts> list = sqlSession.selectList("yj.Mapper.CartsMapper.findrecomendById1",num);//用列表存储多条数据
		for(Carts cart : list) {		
			message += cart.toString();		//将每条数据存储拼接
		}
		sqlSession.close();
		System.out.println(message);
		return message;
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/InsertCartTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String InsertCartTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		String IMG_URL = request.getParameter("IMG_URL");//前端传入的数据IMG_URL
		String TITLE = request.getParameter("TITLE");
		String PRICE = request.getParameter("PRICE");
		String USERNAME = request.getParameter("USERNAME");
		String REPLACE_NUM = request.getParameter("REPLACE_NUM");
		SqlSession sqlSession = getSesstion();
		Carts cart = new Carts();
		cart.setGOODS_ID(Integer.parseInt(GOODS_ID));
		cart.setIMG_URL(IMG_URL);
		cart.setTITLE(TITLE);
		cart.setPRICE(PRICE);
		cart.setUSERNAME(Integer.parseInt(USERNAME));
		cart.setREPLACE_NUM(Integer.parseInt(REPLACE_NUM));
//		cart.setREPLACE_NUM(Integer.parseInt(REPLACE_NUM));
		int rows = sqlSession.insert("yj.Mapper.CartsMapper.addrecomend1",cart);
		if(rows >0) {
			System.out.println("成功插入  "+rows+" 条数据");
		}else {
			System.out.println("插入数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功插入一条数据";
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/DeleteCartTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String DeleteCartTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
		SqlSession sqlSession = getSesstion();
		Carts cart = new Carts();
		cart.setGOODS_ID(Integer.parseInt(GOODS_ID));
		cart.setUSERNAME(Integer.parseInt(USERNAME));
		int rows = sqlSession.delete("yj.Mapper.CartsMapper.deleterecomend1",cart);
		if(rows >0) {
			System.out.println("成功删除  "+rows+" 条数据");
		}else {
			System.out.println("删除数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功删除一条数据";
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/DeleteCartAllTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String DeleteCartAllTest(HttpServletRequest request, HttpServletResponse response) throws Exception{

		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
		SqlSession sqlSession = getSesstion();
		Carts cart = new Carts();
		cart.setUSERNAME(Integer.parseInt(USERNAME));
		int rows = sqlSession.delete("yj.Mapper.CartsMapper.deleterecomend2",cart);
		if(rows >0) {
			System.out.println("成功删除  "+rows+" 条数据");
		}else {
			System.out.println("删除数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功删除一条数据";
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/UpdateCartTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String UpdateCartTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String REPLACE_NUM = request.getParameter("REPLACE_NUM");//前端传入的数据GOODS_ID
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据USERNAME
		SqlSession sqlSession = getSesstion();
		Carts cart = new Carts();
		cart.setREPLACE_NUM(Integer.parseInt(REPLACE_NUM));
		cart.setGOODS_ID(Integer.parseInt(GOODS_ID));
		cart.setUSERNAME(Integer.parseInt(USERNAME));
		int rows = sqlSession.update("yj.Mapper.CartsMapper.updaterecomend1",cart);
		if(rows >0) {
			System.out.println("成功更改  "+rows+" 条数据");
		}else {
			System.out.println("更改数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功更改一条数据";
	}

	
}
