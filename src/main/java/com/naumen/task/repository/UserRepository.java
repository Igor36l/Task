package com.naumen.task.repository;

import com.naumen.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.department.id = :id AND u.updateDate < :localDate")
    List<User> findByDepartmentIdAndUpdateDateBefore(@Param("id") Long id, @Param("localDate") LocalDateTime localDate);
}

