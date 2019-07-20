package org.lyy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lyy.dao.UserDao;
import org.lyy.entity.User;

import java.io.InputStream;
import java.util.List;

public class DaoTest {

    // 测试 queryAll
    @Test
    public void testQueryAll() throws Exception {
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 创建 sqlSession 对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        UserDao dao = session.getMapper(UserDao.class);
        // 调用 queryAll
        List<User> users = dao.queryAll();
        for (User user : users) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());
        }
        // 释放资源
        session.close();
        is.close();
    }

    // 测试 insert
    @Test
    public void testInsert() throws Exception {
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 创建 sqlSession 对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        UserDao dao = session.getMapper(UserDao.class);

        // 创建 User 对象
        User user = new User();
        user.setName("fff");
        user.setAge(18);
        dao.insertUser(user);

        // 提交事务
        session.commit();

        // 释放资源
        session.close();
        is.close();
    }

}
