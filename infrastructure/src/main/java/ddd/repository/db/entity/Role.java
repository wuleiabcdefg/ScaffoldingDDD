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
@Table(name = "Role")
@ToString
public class Role {
    @Id
    private Long roleId;
    private String roleCode;
    private String roleName;
    private String roleDesc;

}
