package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false, timeout = -1, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)  //默认就是Propagation.REQUIRED，可以不写
public class UserService {

    @Autowired
    private UserDao userDao;

    //转账
    public void accountMoney() {

        //try{
        //
        //    //1.开启事务

            //lucy 少100
            userDao.reduceMoney();

            //模拟异常
            int i = 10 / 0;

            //mary 多100
            userDao.addMoney();

            //如果没有异常，提交事务

        //}catch(Exception e){
        //
        //    //如果出现异常，进行事务回滚
        //}


    }
}
