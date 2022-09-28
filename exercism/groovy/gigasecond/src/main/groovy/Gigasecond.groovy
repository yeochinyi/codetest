import java.time.*

class Gigasecond {

    // YOUR CODE HERE
    // HINT: methods that don't change the state of an object can be 'static'
    static add(LocalDate date){
        date.atStartOfDay().plusSeconds(1_000_000_000)
    }
    static add(LocalDateTime date){
        date.plusSeconds(1_000_000_000)
    }

}
