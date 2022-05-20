package jdsmall.dao;

import jdsmall.entity.User;

public interface UserDao {

    User selectByPrimaryKey(Integer id);

}