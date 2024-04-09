package ddd.repository.db.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "LeaveRecord")
public class LeaveRecord {
    @Id
    private Long recordId;
    private Long employeeId;
    private String startTime;
    private String endTime;
    private String leaveType;
}
