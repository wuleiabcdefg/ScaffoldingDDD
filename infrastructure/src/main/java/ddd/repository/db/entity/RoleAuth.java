package ddd.repository.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "RoleAuth")
public class RoleAuth {
    @Id
    private Long id;
    private Long roleId;
    private Long authId;
}
