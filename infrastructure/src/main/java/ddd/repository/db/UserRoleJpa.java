package ddd.repository.db;

import ddd.repository.db.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleJpa extends JpaRepository<EmployeeRole, Long> {
    List<EmployeeRole> findByEmployeeId(Long userId);
}
