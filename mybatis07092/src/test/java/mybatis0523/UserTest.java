package mybatis0523;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.bf.mapper.UserMapper;
import com.bf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class UserTest {
	@Test
	public void testFindUserById() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		Object o = session.selectOne("test.findUserById", 1);
		System.out.println(o);
		Object o2 = session.selectOne("test.findUserById", 1);
		System.out.println(o2);
	}

	@Test
	public void testInset() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		User u = new User();
		u.setUsername("x");
		u.setSex("0");
		session.insert("test.insertUser", u);

//		session.commit();
		List<Object> users = session.selectList("test.selectAllUser");
		System.out.println(users);
		session.close();
	}
	@Test
	public void testExecutor() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);

		UserMapper mapper = session.getMapper(UserMapper.class);

		User user = null;

		for (int i = 0; i < 10; i++) {

			user = new User();

			user.setUsername("Name_" + i);

			user.setSex("email");

//			mapper.insertUser(user);

		}

		// 批量插入User

//		session.commit();// 提交事务时批量操作才会写入数据库

		session.close();

	}
}
