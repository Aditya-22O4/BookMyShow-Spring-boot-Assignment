package com.bookmyshow.BMS.repository;

import com.bookmyshow.BMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User,Long> {
}
