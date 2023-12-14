package ddd.repository.db;

import ddd.repository.db.entity.UserRoleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleJpa extends JpaRepository<UserRoleRecord, Long> {
    List<UserRoleRecord> findByUserId(Long userId);
}
