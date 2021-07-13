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
import yj.Po.Logistics;
@Controller
public class LogisticsCRUD {
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
	@RequestMapping(value = "/SelectLogisticsTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String SelectLogisticsTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String message = "";
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据GOODS_ID
		int num = Integer.parseInt(USERNAME);
		SqlSession sqlSession = getSesstion();
		List<Logistics> list = sqlSession.selectList("yj.Mapper.LogisticsMapper.findrecomendById1",num);//用列表存储多条数据
		for(Logistics logistics : list) {		
			message += logistics.toString();		//将每条数据存储拼接
		}
		sqlSession.close();
		System.out.println(message);
		return message;
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/InsertLogisticsTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String InsertLogisticsTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String PHONE = request.getParameter("PHONE");//前端传入的数据GOODS_ID
		String ADDRESS = request.getParameter("ADDRESS");//前端传入的数据GOODS_ID
		String NAME = request.getParameter("NAME");//前端传入的数据GOODS_ID
		String USERNAME = request.getParameter("USERNAME");//前端传入的数据IMG_URL
		String ZIP_CODE = request.getParameter("ZIP_CODE");//前端传入的数据IMG_URL
		String ID = request.getParameter("ID");//前端传入的数据IMG_URL
		SqlSession sqlSession = getSesstion();
		Logistics logistics = new Logistics();
		logistics.setADDRESS(ADDRESS);
		logistics.setNAME(NAME);
		logistics.setPHONE(Integer.parseInt(PHONE));
		logistics.setUSERNAME(Integer.parseInt(USERNAME));
		logistics.setZIP_CODE(ZIP_CODE);
		logistics.setID(Integer.parseInt(ID));
		
		int rows = sqlSession.insert("yj.Mapper.LogisticsMapper.addrecomend1",logistics);
		if(rows >0) {
			System.out.println("成功插入  "+rows+" 条数据");
		}else {
			System.out.println("插入数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功插入一条数据";
	}
	@CrossOrigin
	@RequestMapping(value = "/UpdateLogisticsTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String UpdateLogisticsTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String PHONE = request.getParameter("PHONE");
		String ADDRESS = request.getParameter("ADDRESS");
		String NAME = request.getParameter("NAME");
		String USERNAME = request.getParameter("USERNAME");
		String ZIP_CODE = request.getParameter("ZIP_CODE");
		String ID = request.getParameter("ID");
		SqlSession sqlSession = getSesstion();
		Logistics logistics = new Logistics();
		logistics.setADDRESS(ADDRESS);
		logistics.setNAME(NAME);
		logistics.setPHONE(Integer.parseInt(PHONE));
		logistics.setUSERNAME(Integer.parseInt(USERNAME));
		logistics.setZIP_CODE(ZIP_CODE);
		logistics.setID(Integer.parseInt(ID));
		int rows = sqlSession.update("yj.Mapper.LogisticsMapper.updaterecomend1",logistics);
		if(rows >0) {
			System.out.println("成功更改  "+rows+" 条数据");
		}else {
			System.out.println("插入数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功插入一条数据";
	}
	@CrossOrigin
	@RequestMapping(value = "/DeleteLogisticsTest" ,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String DeleteLogisticsTest (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String USERNAME = request.getParameter("USERNAME");
		String ID = request.getParameter("ID");
		Logistics logistics = new Logistics();
		SqlSession sqlSession = getSesstion();
		logistics.setUSERNAME(Integer.parseInt(USERNAME));
		logistics.setID(Integer.parseInt(ID));
		int rows = sqlSession.delete("yj.Mapper.LogisticsMapper.deleterecomend1",logistics);
		if(rows > 0)System.out.println("成功删除一条数据");
		else System.out.println("删除数据失败");
		sqlSession.commit();
		sqlSession.close();
		return "成功删除";
	}
	

	
}
