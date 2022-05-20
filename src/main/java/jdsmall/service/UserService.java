package jdsmall.service;

import jdsmall.entity.User;

public interface UserService{
    public Integer add(User rawUser) throws Exception;

    public boolean isExist(String username) throws Exception;

    public User get(String name, String password);
}