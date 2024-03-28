package roomescape.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roomescape.application.dto.ReservationDto;
import roomescape.application.dto.ReservationInfoDto;
import roomescape.domain.Reservation;
import roomescape.domain.repository.ReservationRepository;

import java.util.List;


@Transactional
@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Transactional(readOnly = true)
    public List<ReservationInfoDto> findAll() {
        final List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(ReservationInfoDto::from)
                .toList();
    }

    public ReservationInfoDto save(final ReservationDto reservationDto) {
        final Reservation newReservation = reservationDto.toEntity();
        Reservation reservation = reservationRepository.save(newReservation);
        return ReservationInfoDto.from(reservation);
    }

    public int delete(Long id) {
        return reservationRepository.delete(id);
    }
}
