package ddd.auth;

import ddd.auth.model.user.EmployeeID;
import lombok.Data;

@Data
public class AttendanceRecord {
    private EmployeeID userId;
    private String checkInTime;
}
