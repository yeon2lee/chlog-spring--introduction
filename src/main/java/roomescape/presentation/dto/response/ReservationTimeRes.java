package roomescape.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import roomescape.application.dto.ReservationTimeInfoDto;

@Getter
@RequiredArgsConstructor
public class ReservationTimeRes {
    private final Long id;
    private final String time;

    public static ReservationTimeRes from(final ReservationTimeInfoDto reservationTimeInfoDto){
        return new ReservationTimeRes(
                reservationTimeInfoDto.getId(),
                reservationTimeInfoDto.getTime()
        );
    }
}
