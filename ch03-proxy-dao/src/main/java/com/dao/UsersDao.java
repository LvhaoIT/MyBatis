package com.dao;

import com.entity.Users;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/25
 * Time: 13:04
 */
public interface UsersDao {
    //  public List<Users> selectUsers();
    public List<Users> selectUsers();


    /**
     * 用来插入一条数据
     *
     * @return
     */
    public int insertUsers(Users user);

}

