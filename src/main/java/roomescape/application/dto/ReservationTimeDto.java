package roomescape.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import roomescape.domain.ReservationTime;

@Getter
@RequiredArgsConstructor
public class ReservationTimeDto {
    private final String time;

    public ReservationTime toEntity() {
        return new ReservationTime(null, time);
    }
}
