package com.naumen.task.Repository;

import com.naumen.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByDepartmentIdAndUpdateDateBefore(Long id, LocalDateTime localDate);
}
