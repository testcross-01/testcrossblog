package cn.testcross.testcrossblog.service.impl;

import cn.testcross.testcrossblog.bean.User;
import cn.testcross.testcrossblog.bean.UserExample;
import cn.testcross.testcrossblog.mapper.UserMapper;
import cn.testcross.testcrossblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        try{
            userMapper.insert(user);
        }catch (Exception e){
            System.err.println("addUser:error");
            throw  e;
        }
    }

    @Override
    public void updateUserById(User user, Integer id) {
        try{
            if(id==null)return;
            userMapper.updateByPrimaryKey(user);
        }catch (Exception e){
            System.err.println("updateUserById:error");
            throw  e;
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        try{
            if(id==null)return;
            userMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            System.err.println("deleteUserById:error");
            throw  e;
        }
    }

//    @Override
//    public void deleteBatch(User user) {
//        try{
//            UserExample example=new UserExample();
//            UserExample.Criteria criteria= example.createCriteria();
//            if(user.getUserAvatar()!=null){
//
//            }
//            userMapper.deleteByExample(example);
//        }catch (Exception e){
//            System.err.println("deleteBatch:error");
//            throw  e;
//        }
//    }

    @Override
    public User queryUserById(Integer id) {
        try{
            if(id==null)return null;
            return  userMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            System.err.println("queryUserById:err");
            throw  e;
        }
    }

    @Override
    public List<User> queryUsersByField(User user) {
        try{
            UserExample example=new UserExample();
            UserExample.Criteria criteria= example.createCriteria();
            if(user.getUserId()!=null){
                criteria.andUserIdEqualTo(user.getUserId());
            }
            if(user.getUserName()!=null&&user.getUserName().trim()!=""){
                criteria.andUserNameEqualTo(user.getUserName());
            }
            return  userMapper.selectByExample(example);
        }catch (Exception e){
            System.err.println("queryUsersByField:err");
            throw  e;
        }finally {

        }
    }

    @Override
    public List<User> queryAllUsers() {
        return userMapper.selectByExample(null);
    }
}
