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

    /**
     * 利用if实现动态sql
     *
     * @param user
     * @return
     */
    public List<Users> SelectUsersIf(Users user);


    /**
     * 利用Where实现动态sql
     *
     * @param user
     * @return
     */
    public List<Users> SelectUsersWhere(Users user);


    /**
     * 利用foreach实现动态sql
     * 方法1
     *
     * @param idlist
     * @return
     */
    public List<Users> SelectUsersForeachOne(List<Integer> idlist);


    /**
     * 利用foreach实现动态sql
     * 方法1
     *
     * @param userlist
     * @return
     */
    public List<Users> SelectUsersForeachTwo(List<Users> userlist);


    public List<Users> SelectUsersAll();
}

