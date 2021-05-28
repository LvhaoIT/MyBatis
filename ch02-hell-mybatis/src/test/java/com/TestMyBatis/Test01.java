package com.TestMyBatis;

import com.dao.Impl.UsersDaoImpl;
import com.dao.UsersDao;
import com.entity.Users;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/25
 * Time: 13:41
 */
public class Test01 {

    @Test
    public void testSelectUsers() {
        UsersDao dao = new UsersDaoImpl();
        //
        List<Users> UserList = dao.selectUsers();
        for (Users user : UserList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testInsertUsers() {
        int result = new UsersDaoImpl().insertUsers(new Users(7, "xiaoxi", "123", "男", "145@qq.com"));
        System.out.println("result=" + result);

    }


}
