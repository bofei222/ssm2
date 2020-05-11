package mybatis0523;

import com.bf.dao.UserDao;
import com.bf.dao.UserDaoImpl;
import com.bf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws IOException {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(10);
		System.out.println(user);
		User user2 = userDao.findUserById(16);
		System.out.println(user2);
	}
	
	@Test
	public void testFindUserByUserName() throws IOException {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> users = userDao.findUserByUserName("无量光");
		System.out.println(users);
	}

	@Test
	public void testInsert() throws IOException {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("a");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("yyy");

		userDao.insertUser(user);
		userDao.insertUser(user);
	}
}
