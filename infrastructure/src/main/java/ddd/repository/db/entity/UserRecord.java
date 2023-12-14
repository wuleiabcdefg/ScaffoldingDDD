package ddd.repository.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "USER_RECORD")
@ToString
public class UserRecord {
    @Id
    private Long id;

    private String userName;

}
