package com.futbolproje.futbolproje.services;

import com.futbolproje.futbolproje.model.User;

import java.util.List;

public interface UserService {
    public User getUserById(Integer id);
    public User registerUser(User user);
    public User updateUser(Integer id, User user);
    public User findUserByEmail(String email);
    public List<User> searchUser(String userFindQuery);
}
