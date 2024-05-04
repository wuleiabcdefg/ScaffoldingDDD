package ddd.api;

import ddd.auth.AttendanceRecord;
import ddd.auth.QueryParams;
import ddd.auth.model.user.User;

import java.util.List;

public interface AttendanceRepository {
    User getUserById(Long userId);

    User findUser(String loginName);

    void save(AttendanceRecord attendanceRecord);

    List<AttendanceRecord> findByPage(QueryParams request);
}
