package ddd.repository.db;

import ddd.repository.db.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<Employee, Long> {

    Employee findByLoginName(String loginName);
}
