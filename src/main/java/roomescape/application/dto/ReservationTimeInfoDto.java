package roomescape.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import roomescape.domain.ReservationTime;

@Getter
@RequiredArgsConstructor
public class ReservationTimeInfoDto {

    private final Long id;
    private final String time;

    public static ReservationTimeInfoDto from(final ReservationTime reservationTime) {
        return new ReservationTimeInfoDto(
                reservationTime.getId(),
                reservationTime.getTime()
        );
    }


}
