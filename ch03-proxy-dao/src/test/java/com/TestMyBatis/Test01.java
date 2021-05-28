package com.TestMyBatis;

import com.dao.UsersDao;
import com.entity.Users;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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


}
