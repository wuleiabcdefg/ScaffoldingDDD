package ddd.repository.db.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "EmployeeRole")
@Entity
@Setter
@Getter
@ToString
public class EmployeeRole {

    @Id
    private Long id;

    private Long employeeId;

    private Long roleId;

}
