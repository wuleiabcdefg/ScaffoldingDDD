package ddd.repository.db;

import ddd.repository.db.entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<UserRecord, Long> {

}
