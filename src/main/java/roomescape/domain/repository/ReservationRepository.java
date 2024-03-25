package roomescape.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import roomescape.domain.Reservation;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Reservation> reservationRowMapper = (rs, rowNum) -> {
        return new Reservation(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDate("date").toLocalDate(),
                rs.getTime("time").toLocalTime());
    };

    public List<Reservation> findAll() {
        final String sql = "SELECT id, name, date, time FROM reservation";
        return jdbcTemplate.query(sql, reservationRowMapper);
    }

}
