package com.dao;

import com.entity.Users;
import com.entity.myUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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


    public Users selectUserById(Integer id);


    public Users selectMutilUsers(@Param("userName") String userName,
                                  @Param("sex") String sex);

    /**
     * 使用属性名来调用，传递多个参数
     *
     * @param user
     * @return users
     */
    public List<Users> selectMutilUsers_01(Users user);

    public List<Users> selectMutilUsers_Map(Map map);

    public Map<Object, Object> selectMapById(Integer id);

    /**
     * 第一种方式
     * 使用resultMap定义映射关系
     *
     * @return
     */
    public List<Users> selectAllUsers();

    public List<myUsers> selectAllMyUsers();


    //模糊查询两种方式

    //第一种方式 ，直接在java程序中传递已经拼接好的字符串（推荐）
    public List<Users> selectLikeOne(String name);

    //第二种方式，传递条件 进入xml中进行拼接
    public List<Users> selectLikeTwo(String name);

}

