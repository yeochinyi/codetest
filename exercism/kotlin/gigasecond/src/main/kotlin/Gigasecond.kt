import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(val dt: LocalDateTime) {

    constructor(dt: LocalDate) : this(dt.atTime(0, 0)) {
    }

    val date: LocalDateTime = dt.plusSeconds(1_000_000_000)
}
