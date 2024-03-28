package roomescape.domain.repository.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReservationQuery {
    FIND_ALL("SELECT id, name, date, time FROM reservation"),
    COUNT("select count(*) from reservation"),
    DELETE("DELETE FROM reservation WHERE id = ?");

    private final String query;
}