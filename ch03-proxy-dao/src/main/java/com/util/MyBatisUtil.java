package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/25
 * Time: 11:01
 */
public class MyBatisUtil {
    //调用就自动执行一次
    public static SqlSessionFactory factory = null;


    /**
     * 静态代码块在类初始化阶段就会自动执行
     */
    static {
        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);//为了下面获取sqlSession对象
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态方法：静态方法在类加载的使用使用，即当其他类中调用或new的时候，他将执行
     *
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession();//获取一个sqlSession对象,(非自动提交事务)
        }
        return sqlSession;
    }

    public static SqlSession getSqlSession(boolean flag) {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession(flag);//获取一个sqlSession对象,(根据结果判断是否自动提交)
        }
        return sqlSession;
    }

}
