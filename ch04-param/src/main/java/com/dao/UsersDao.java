package com.dao;

import com.entity.Users;
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
}

