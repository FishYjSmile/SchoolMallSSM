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

import yj.Po.OrdersNum;
@Controller
public class OrdersNumCRUD {
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
	@RequestMapping(value = "/SelectOrderNumTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String SelectOrderNumTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String message = "";
		Map<String,Object> map =new HashMap<String,Object>();			//传入多个参数时需要用到map和hashmap
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
		int num = Integer.parseInt(USERNAME);
//		int num1 = Integer.parseInt(ORDER_NUM);
		map.put("USERNAME", num);
//		map.put("ORDER_NUM", num1);
		SqlSession sqlSession = getSesstion();
		List<OrdersNum> list = sqlSession.selectList("yj.Mapper.OrdersNumMapper.findrecomendById1",map);//用列表存储多条数据
		for(OrdersNum order : list) {		
			message += order.toString();		//将每条数据存储拼接
		}
		sqlSession.close();
		System.out.println(message);
		return message;
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/InsertOrderNumTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String InsertOrderNumTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ORDER_NUM = request.getParameter("ORDER_NUM");
		String USERNAME = request.getParameter("USERNAME");
		String TIME = request.getParameter("TIME");
		SqlSession sqlSession = getSesstion();
		OrdersNum order = new OrdersNum();
		order.setORDER_NUM(ORDER_NUM);
		order.setTIME(TIME);
		order.setUSERNAME(Integer.parseInt(USERNAME));
		int rows = sqlSession.insert("yj.Mapper.OrdersNumMapper.addrecomend1",order);
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
	@RequestMapping(value = "/DeleteOrderNumTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String DeleteOrderNumTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ORDER_NUM = request.getParameter("ORDER_NUM");//前端传入的数据GOODS_ID
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
		SqlSession sqlSession = getSesstion();
		OrdersNum order = new OrdersNum();
		order.setORDER_NUM(ORDER_NUM);
		order.setUSERNAME(Integer.parseInt(USERNAME));
		int rows = sqlSession.delete("yj.Mapper.OrdersNumMapper.deleterecomend1",order);
		if(rows >0) {
			System.out.println("成功删除  "+rows+" 条数据");
		}else {
			System.out.println("删除数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功删除一条数据";
	}
	

	
}
