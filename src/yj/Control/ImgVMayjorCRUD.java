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
import yj.Po.ImgVMayjor;

@Controller
public class ImgVMayjorCRUD {
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
	@RequestMapping(value = "/SelectImgVMayjor" ,produces = "application/json; charset=utf-8")//此处为解决中文输出前端出现？？的情况
	@ResponseBody
	public List SelectImgVMayjor(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> map =new HashMap<String,Object>();
		String GOODS_ID = request.getParameter("GOODS_ID");//前端传入的数据GOODS_ID
		SqlSession sqlSession = getSesstion();
		Integer num = Integer.parseInt(GOODS_ID);
		map.put("GOODS_ID",num);
		List<ImgVMayjor> list = sqlSession.selectList("yj.Mapper.ImgVMayjorMapper.findrecomendById1", map);
		System.out.println(list);
		return list;
	}

	
}
