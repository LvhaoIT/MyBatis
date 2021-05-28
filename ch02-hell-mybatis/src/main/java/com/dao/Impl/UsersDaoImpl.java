package com.dao.Impl;

import com.dao.UsersDao;
import com.entity.Users;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/25
 * Time: 13:27
 */
public class UsersDaoImpl implements UsersDao {
    @Override
    public List<Users> selectUsers() {
        List<Users> Userlist = null;
        //利用工具类获取
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sql = "com.dao.UsersDao" + "." + "selectUsers";
        Userlist = sqlSession.selectList(sql);
        sqlSession.close();
        return Userlist;
    }

    @Override
    public int insertUsers(Users user) {
        int result = 0;
        String str = "com.dao.UsersDao" + "." + "insertUsers";
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        result = sqlSession.insert(str, user);
        if (result == 1) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
            sqlSession.rollback();
        }
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
