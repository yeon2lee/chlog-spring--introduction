package roomescape.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReservationTime {
    private final Long id;
    @NotNull
    private final String time;
}
