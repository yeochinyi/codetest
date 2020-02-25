export class Clock {
  constructor(h, m=0) {
    this.setTime(h,m)    
  }

  setTime(h,m){
    var minToHour = parseInt( m / 60 )
    this.min = m % 60
    if(this.min < 0){
      this.min += 60
      minToHour -= 1
    }

    this.hour = (h + minToHour) % 24
    if(this.hour < 0){
      this.hour = 24 + this.hour
    }
  }

  getNumberDisplay(number){
    // if(number < 10){
    //   return  "0" + number
    // }

    // return "" + number
    return number.toString().padStart(2, '0')
  }

  toString() {
    var hourString = this.getNumberDisplay(this.hour)
    var minString = this.getNumberDisplay(this.min)
    return `${hourString}:${minString}`
  }

  plus(m) {
    this.setTime(this.hour, this.min + m)
    return this
  }

  minus(m) {
    this.setTime(this.hour, this.min - m)
    return this
  }

  equals(clock) {
    return clock.hour === this.hour && clock.min === this.min
  }
}
