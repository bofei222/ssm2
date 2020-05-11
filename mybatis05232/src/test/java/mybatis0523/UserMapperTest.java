package mybatis0523;

import com.bf.mapper.UserMapper;
import com.bf.pojo.CustomOrders;
import com.bf.pojo.Orders;
import com.bf.pojo.QueryVo;
import com.bf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserMapperTest {
private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findUserById(22);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByUserName() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> user = userMapper.findUserByUserName("王");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByVo() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("王");
		user.setSex("1");
		vo.setUser(user);
		List<User> list = userMapper.findUserByVo(vo);
		System.out.println(list);
	}
	
	@Test
	public void testFindUserCount() throws IOException{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		Integer count = userMapper.findUserCount();
		System.out.println("============" + count);
	}
	
	@Test
	public void findUserByUserNameAndSex() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUsername("王");
		user.setSex("1");
		List<User> list = userMapper.findUserByUserNameAndSex(user);
		System.out.println(list);
		
	}
	
	@Test
	public void findUserByIds() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		QueryVo vo = new QueryVo();
		List<Integer> ids = new ArrayList(Arrays.asList(22, 24, 25));
		vo.setIds(ids);
		List<User> list = userMapper.findUserByIds(vo);
		System.out.println(list);
		
	}
	
	@Test
	public void findOrdersAndUser1() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		List<CustomOrders> list = userMapper.findOrdersAndUser1();
		
		System.out.println(list);
		
	}
	
	@Test
	public void findOrdersAndUser2() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<Orders> list = userMapper.findOrdersAndUser2();
		System.out.println(list); 
	}
	
	@Test
	public void findUserAndOrders() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		List<User> list = userMapper.findUserAndOrders();
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			User u = list.get(i);
			List<Orders> orders = u.getOrders();
			System.out.println(orders.size());
		}
	}
}
