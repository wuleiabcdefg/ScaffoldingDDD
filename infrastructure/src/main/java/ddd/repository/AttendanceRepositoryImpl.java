package ddd.repository;

import ddd.api.AttendanceRepository;
import ddd.auth.AttendanceRecord;
import ddd.auth.QueryParams;
import ddd.auth.model.user.User;
import jakarta.persistence.criteria.Predicate;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Setter(onMethod = @__(@Autowired))
public class AttendanceRepositoryImpl implements AttendanceRepository {

    @Override
    public List<AttendanceRecord> findByPage(final QueryParams request) {
        Specification<AttendanceRecord> specification = (root, query, criteriaBuilder) -> { //构造条件
            //创建条件集合
            List<Predicate> predicates = new ArrayList<>();
            //创建一个条件的集合，长度为上面满足条件的个数（目的是将predicates列表转为集合）
            Predicate[] pre = new Predicate[predicates.size()];
            return query.where(predicates.toArray(pre)).getRestriction();
        };
        return queryAll(specification);
    }

    List<AttendanceRecord> queryAll(Specification<AttendanceRecord> a) {
        return new ArrayList<>();
    }

    @Override
    public User getUserById(final Long userId) {
        return null;
    }

    @Override
    public User findUser(final String loginName) {
        return null;
    }

    @Override
    public void save(final AttendanceRecord attendanceRecord) {

    }

}
