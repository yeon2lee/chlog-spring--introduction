package roomescape.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import roomescape.application.ReservationService;
import roomescape.domain.Reservation;
import roomescape.domain.repository.ReservationRepository;
import roomescape.exception.NotFoundReservationException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class ReservationApiController {

    private final List<Reservation> reservations = new ArrayList<>();
    private final AtomicLong index = new AtomicLong(1);
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> read() {
        return ResponseEntity.ok().body(reservationService.findAll());
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> create(@Valid @RequestBody Reservation reservation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new IllegalArgumentException("입력값이 잘못되었습니다");
        }
        Reservation newReservation = Reservation.toEntity(reservation, index.getAndIncrement());
        Long savedId = reservationService.save(newReservation);
        return ResponseEntity.created(URI.create("/reservations/" + savedId)).body(newReservation);
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        Reservation reservation = reservations.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElseThrow(NotFoundReservationException::new);

        reservations.remove(reservation);

        return ResponseEntity.noContent().build();
    }
}
