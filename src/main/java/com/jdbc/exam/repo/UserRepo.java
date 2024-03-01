package com.jdbc.exam.repo;

import com.jdbc.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
