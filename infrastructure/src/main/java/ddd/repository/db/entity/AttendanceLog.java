package ddd.repository.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "AttendanceLog")
public class AttendanceLog {
    @Id
    private Long recordId;
    private Long employeeId;
    private String date;
    private String hourSecond;

}
