package roomescape.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roomescape.domain.Reservation;
import roomescape.domain.repository.ReservationRepository;

import java.util.List;


@Transactional
@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Long save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public int delete(Long id) {
        return reservationRepository.delete(id);
    }
}
