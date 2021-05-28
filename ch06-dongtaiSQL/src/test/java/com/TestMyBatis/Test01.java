package com.TestMyBatis;

import com.dao.UsersDao;
import com.entity.Users;
import com.github.pagehelper.PageHelper;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/25
 * Time: 13:41
 */
public class Test01 {

    @Test
    public void testSelectUsersIf() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Users user = new Users();
        user.setUserName("朱方成");
        user.setSex("男");
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        List<Users> usersList = dao.SelectUsersIf(user);
        for (Users u : usersList) {
            System.out.println(u.toString());
        }

    }

    @Test
    public void testSelectUsersWhere() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Users user = new Users();
        user.setUserName("朱方成");
        user.setSex("男");
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        List<Users> usersList = dao.SelectUsersWhere(user);
        for (Users u : usersList) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void testSelectUsersForeachOne() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Integer> idlist = new ArrayList<>();
        idlist.add(1);
        idlist.add(2);
        idlist.add(3);
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        List<Users> usersList = dao.SelectUsersForeachOne(idlist);
        for (Users user : usersList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testSelectUsersForeachTwo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Users> idlist = new ArrayList<>();
        idlist.add(new Users(1));
        idlist.add(new Users(2));
        idlist.add(new Users(3));
        UsersDao dao = sqlSession.getMapper(UsersDao.class);
        List<Users> usersList = dao.SelectUsersForeachTwo(idlist);
        for (Users user : usersList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testSelectUsersAllPageHelper() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //加入pageHelper分页的方法
        PageHelper.startPage(1, 3);
        //pageNum:第几页，从1开始
        //pageSize：一页中有多少行数据
        List<Users> usersList = sqlSession.getMapper(UsersDao.class).SelectUsersAll();
        for (Users user : usersList) {
            System.out.println(user.toString());
        }
    }

}
