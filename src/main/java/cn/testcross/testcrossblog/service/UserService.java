package cn.testcross.testcrossblog.service;

import cn.testcross.testcrossblog.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id更新用户
     * @param user
     * @param id
     */
    void updateUserById(User user,Integer id);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 批量删除
     * @param user
     */
    //void deleteBatch(User user);

    /**
     * 根据id和条件查询用户
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 根据属性查询用户
     */
    List<User> queryUsersByField(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAllUsers();
}
