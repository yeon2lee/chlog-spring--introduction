package roomescape.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationTimeReq {
    @NotNull(message = "예약 시간을 입력해주세요.")
    private String time;

    public ReservationTimeReq() {
    }
}
