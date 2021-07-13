package yj.Control;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import yj.Po.Orders;
@Controller
public class OrdersCRUD {
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
	@RequestMapping(value = "/SelectOrderTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String SelectorderTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String message = "";
		Map<String,Object> map =new HashMap<String,Object>();			//传入多个参数时需要用到map和hashmap
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
//		String ORDER_NUM = request.getParameter("ORDER_NUM");//前端传入的数据ORDER_NUM
		int num = Integer.parseInt(USERNAME);
//		int num1 = Integer.parseInt(ORDER_NUM);
		map.put("USERNAME", num);
//		map.put("ORDER_NUM", num1);
		SqlSession sqlSession = getSesstion();
		List<Orders> list = sqlSession.selectList("yj.Mapper.OrdersMapper.findrecomendById1",map);//用列表存储多条数据
		for(Orders order : list) {		
			message += order.toString();		//将每条数据存储拼接
		}
		sqlSession.close();
		System.out.println(message);
		return message;
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/InsertOrderTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String InsertorderTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		String IMG_URL = request.getParameter("IMG_URL");//前端传入的数据IMG_URL
		String REPLACE_NUM = request.getParameter("REPLACE_NUM");
		String TITLE = request.getParameter("TITLE");
		String ORDER_NUM = request.getParameter("ORDER_NUM");
		String TIME = request.getParameter("TIME");
		String PRICE = request.getParameter("PRICE");
		String USERNAME = request.getParameter("USERNAME");
		SqlSession sqlSession = getSesstion();
		Orders order = new Orders();
		order.setGOODS_ID(Integer.parseInt(GOODS_ID));
		order.setREPLACE_NUM(Integer.parseInt(REPLACE_NUM));
		order.setIMG_URL(IMG_URL);
		order.setTITLE(TITLE);
		order.setTIME(TIME);
		order.setORDER_NUM(ORDER_NUM);
		order.setPRICE(PRICE);
		order.setUSERNAME(Integer.parseInt(USERNAME));
//		order.setREPLACE_NUM(Integer.parseInt(REPLACE_NUM));
		int rows = sqlSession.insert("yj.Mapper.OrdersMapper.addrecomend1",order);
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
	@RequestMapping(value = "/DeleteOrderTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String DeleteorderTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ORDER_NUM = request.getParameter("ORDER_NUM");//前端传入的数据GOODS_ID
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
		SqlSession sqlSession = getSesstion();
		Orders order = new Orders();
		order.setORDER_NUM(ORDER_NUM);
		order.setUSERNAME(Integer.parseInt(USERNAME));
		int rows = sqlSession.delete("yj.Mapper.OrdersMapper.deleterecomend1",order);
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
	@RequestMapping(value = "/UpdateOrderTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String UpdateorderTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String REPLACE_NUM = request.getParameter("REPLACE_NUM");//前端传入的数据GOODS_ID
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据USERNAME
		SqlSession sqlSession = getSesstion();
		Orders order = new Orders();
		order.setREPLACE_NUM(Integer.parseInt(REPLACE_NUM));
		order.setGOODS_ID(Integer.parseInt(GOODS_ID));
		order.setUSERNAME(Integer.parseInt(USERNAME));
		int rows = sqlSession.update("yj.Mapper.OrdersMapper.updaterecomend1",order);
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
