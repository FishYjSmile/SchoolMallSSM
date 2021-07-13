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

import yj.Po.ImgMayjor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ImgMayjorCRUD {
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
	@RequestMapping(value = "/SelectImgMayjor" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public List SelectImgMayjor(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> map =new HashMap<String,Object>();
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		Integer num = Integer.parseInt(GOODS_ID);
		SqlSession sqlSession = getSesstion();
		map.put("GOODS_ID",num);
		List<ImgMayjor> list = sqlSession.selectList("yj.Mapper.ImgMayjorMapper.findrecomendById1", map);
//		System.out.println(list);
		return list;
	}
	@Test
	@CrossOrigin
	@RequestMapping(value = "/SelectDetailMayjor" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public List SelectDetailMayjor(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> map =new HashMap<String,Object>();
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		Integer num = Integer.parseInt(GOODS_ID);
		SqlSession sqlSession = getSesstion();
		map.put("GOODS_ID",num);
		List<ImgMayjor> list = sqlSession.selectList("yj.Mapper.ImgMayjorMapper.findrecomendById2", map);
//		System.out.println(list);
		return list;
	}
	
	

	
}
