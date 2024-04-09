package ddd.repository.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "AttendanceRecord")
public class AttendanceRecord {

    @Id
    private Long recordID;
    private Long employeeID;
    private String date;
    private Boolean late;
    private Boolean early;
    private Integer overTimeHours;
}
