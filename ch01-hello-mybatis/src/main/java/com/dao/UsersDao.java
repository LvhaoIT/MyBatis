package com.dao;

import com.domain.Users;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/24
 * Time: 9:49
 */
//一个dao接口，他用来定义方法
public interface UsersDao {

    //查询users表中所有数据
    public List<Users> selectUsers();


    /**
     * 插入一个users对象
     *
     * @param user 表示要插入的数据
     * @return 返回一个影响数据行数
     */
    public int insertUsers(Users user);
}
