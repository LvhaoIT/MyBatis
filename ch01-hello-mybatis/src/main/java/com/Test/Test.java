package com.Test;

import com.domain.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/24
 * Time: 11:06
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始
        String config = "mybatis.xml";
        //2.读取这个comfing表示文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.【重要】 获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.【重要】指定哟啊执行的sql语句的标识， sql映射文件中的namesapce+“。”+标签id值
        String sqlId = "com.dao.UsersDao" + "." + "selectUsers";
        //7.执行sql语句 通过sqlid来执行
        List<Users> UserList = sqlSession.selectList(sqlId);
        //8.输出结果集
        for (Users user : UserList) {
            System.out.println(user);
        }
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
