package ddd.repository.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "AttendanceRule")
public class AttendanceRule {

    @Id
    private Long ruleId;
    private String startTime;
    private String endTime;
    private String workHours;
}
