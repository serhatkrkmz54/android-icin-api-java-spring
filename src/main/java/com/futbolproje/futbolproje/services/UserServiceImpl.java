package com.futbolproje.futbolproje.services;

import com.futbolproje.futbolproje.model.User;
import com.futbolproje.futbolproje.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepos userRepos;

    @Autowired
    public UserServiceImpl(final UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User registerUser(User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userRepos.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> searchUser(String userFindQuery) {
        return List.of();
    }
}
