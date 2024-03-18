package roomescape.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    @GetMapping("/reservation")
    public String reservation() {
        return "reservation";
    }
}
