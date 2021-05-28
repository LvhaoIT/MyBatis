package com.Test;

import com.domain.Users;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/25
 * Time: 11:17
 */
public class TestUtil {
    public static void main(String[] args) {

        //1.使用工具类，首先获取一个sqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2.定位要执行的sql语句块
        String sqlId = "com.dao.UsersDao" + "." + "selectUsers";
        //3。执行sql语句块
        List<Users> UserList = sqlSession.selectList(sqlId);
        //4.输出结果
        for (Users user : UserList) {
            System.out.println(user.toString());
        }
        //5.关闭sqlSession对象
        sqlSession.close();

    }

}
