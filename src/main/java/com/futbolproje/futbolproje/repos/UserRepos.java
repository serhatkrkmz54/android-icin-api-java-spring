package com.futbolproje.futbolproje.repos;

import com.futbolproje.futbolproje.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Integer> {
}
