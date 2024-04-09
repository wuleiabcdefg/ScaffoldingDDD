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
@Table(name = "Employee")
@ToString
public class Employee {
    @Id
    private Long employeeID;
    private String name;
    private String employeeNumber;
    private String loginName;
    private String password;
}
