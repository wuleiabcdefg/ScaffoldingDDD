package ddd.auth;


import ddd.api.AttendanceRepository;
import ddd.auth.model.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 考勤领域服务
 */
@Component
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<AttendanceRecord> attendancePageQuery(QueryParams request) {
        if (request.getQueryDate()==null) {
            throw new RuntimeException("请输入查询日期，并重新查询");
        }
        if (request.getPage()==null) {
            throw new RuntimeException("请输查询页码");
        }

        List<AttendanceRecord> attendanceRecords = attendanceRepository.findByPage(request);

        if (attendanceRecords.size() > 0) {
            return attendanceRecords;
        } else {
            throw new RuntimeException("查询记录为空");
        }
    }

    public void checkIn(User user) {
        if (user.isAvailable()) {
            final AttendanceRecord attendanceRecord = new AttendanceRecord();
            attendanceRecord.setUserId(user.getUserId());
            attendanceRecord.setCheckInTime(String.valueOf(System.currentTimeMillis()));
            attendanceRepository.save(attendanceRecord);
        } else {
            throw new RuntimeException("用户未登录，无法签到");
        }
    }
}
