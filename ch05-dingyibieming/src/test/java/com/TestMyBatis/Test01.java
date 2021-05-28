package com.TestMyBatis;

import com.dao.UsersDao;
import com.entity.Users;
import com.entity.myUsers;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/25
 * Time: 13:41
 */
public class Test01 {

    @Test
    public void testSelectUsers() {
        /**
         * 使用mybatis的动态代理机制，使用SqlSession。getMapper（dao接口）
         * getMapper能获取dao接口对应的实现类对象
         *
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        //dao=com.sun.proxy.$Proxy2 JDK的动态代理
        System.out.println("dao=" + dao.getClass().getName());
        //调用dao的方法，执行数据库操作
        List<Users> usersList = dao.selectUsers();
        for (Users user : usersList) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUsers() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        int result = dao.insertUsers(new Users(7, "xiaoxi", "123", "男", "145@qq.com"));
        sqlSession.commit();
    }

    @Test
    public void testSelectUserById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Users user = sqlSession.getMapper(UsersDao.class).selectUserById(9);
        if (user != null) {
            System.out.println("查询成功！ user=" + user);
        } else {
            System.out.println("查询失败");
        }

    }

    @Test
    public void testSelectMutilUsers() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Users user = sqlSession.getMapper(UsersDao.class).selectMutilUsers("朱方成", "男");
        if (user != null) {
            System.out.println("查询成功！ user=" + user);
        } else {
            System.out.println("查询失败");
        }
    }

    @Test
    public void testSelectMutilUsers_01() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Users u1 = new Users();
        u1.setPassword("123");
        u1.setSex("男");
        List<Users> UsersList = sqlSession.getMapper(UsersDao.class).selectMutilUsers_01(u1);

        if (UsersList != null) {
            System.out.println("查询成功！");
            for (Users users : UsersList) {
                System.out.println(users);
            }
        } else {
            System.out.println("没有查询到数据");
        }
    }

    @Test
    public void testSelectMutilUsers_Map() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Map userMap = new HashMap();
        userMap.put("MapPassword", "123");
        userMap.put("MapSex", "男");
        List<Users> UsersList = sqlSession.getMapper(UsersDao.class).selectMutilUsers_Map(userMap);

        if (UsersList != null) {
            System.out.println("查询成功！");
            for (Users users : UsersList) {
                System.out.println(users);
            }
        } else {
            System.out.println("没有查询到数据");
        }
    }

    @Test
    public void testSelectMapById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Map userMap = sqlSession.getMapper(UsersDao.class).selectMapById(1);

        if (userMap != null) {
            System.out.println("查询成功！" + userMap);

        } else {
            System.out.println("没有查询到数据");
        }

    }

    @Test
    public void testSelectAllUsers() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        //调用dao的方法，执行数据库操作
        List<Users> usersList = dao.selectAllUsers();
        for (Users user : usersList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectAllMyUsers() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        //调用dao的方法，执行数据库操作
        List<myUsers> usersList = dao.selectAllMyUsers();
        for (myUsers user : usersList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectLikeOne() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        //调用dao的方法，执行数据库操作
        List<Users> usersList = dao.selectLikeOne("小%");
        for (Users user : usersList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectLikeTwo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        //调用dao的方法，执行数据库操作
        List<Users> usersList = dao.selectLikeTwo("小");
        for (Users user : usersList) {
            System.out.println(user);
        }
    }

}
