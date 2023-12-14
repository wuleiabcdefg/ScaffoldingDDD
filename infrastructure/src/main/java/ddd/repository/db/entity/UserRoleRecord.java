package ddd.repository.db.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "USER_ROLE")
@Entity
@Setter
@Getter
@ToString
public class UserRoleRecord {

    @Id
    private Long id;

    private Long userId;

    private Long roleId;

}
