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


import yj.Po.Swiper;
@Controller
public class SwiperCRUD {
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
	@RequestMapping(value = "/SelectSwiperTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String SelectSwiperTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String message = "";
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		int num = Integer.parseInt(GOODS_ID);
		SqlSession sqlSession = getSesstion();
		List<Swiper> list = sqlSession.selectList("yj.Mapper.SwiperMapper.findrecomendById1");
		for(Swiper swiper : list) {		
			message += swiper.toString();		//将每条数据存储拼接
		}

		sqlSession.close();
		return message;
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/InsertSwiperTest" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public String InsertSwiperTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		String IMG_URL = request.getParameter("IMG_URL");//前端传入的数据IMG_URL
		SqlSession sqlSession = getSesstion();
		Swiper swiper = new Swiper();
		swiper.setGOODS_ID(Integer.parseInt(GOODS_ID));
		swiper.setIMG_URL(IMG_URL);
		int rows = sqlSession.insert("yj.Mapper.recomendMapper.addrecomend1",swiper);
		if(rows >0) {
			System.out.println("成功插入  "+rows+" 条数据");
		}else {
			System.out.println("插入数据失败");
		}
		sqlSession.commit();//提交事务
		sqlSession.close();
		return "成功插入一条数据";
	}

	
}
