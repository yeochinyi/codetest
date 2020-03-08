// export 
const meetupDay = (year, month, day, desc) =>  {

  let extraWeek=0
  let startFrom = 1
  let subtract = false
  switch(desc) {
    case "1st":
      break
    case "2nd":
      extraWeek=1
      break
    case "3rd":
      extraWeek=2
      break
    case "4th":
      extraWeek=3
      break
    case "5th":
      extraWeek=3
      break
    case "last":
      startFrom=0
      subtract = true
      month++
      break
    default:
      startFrom=10
  }
  const DAYS = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
  const dayNumOfInput = DAYS.indexOf(day)
  console.log("dayNumOfInput=" + dayNumOfInput)
  
  let d = new Date(year, month, startFrom)
  const dayNumOfStartFrom = d.getDay()
  console.log("dayNumOfStartFrom=" + dayNumOfStartFrom)
  let diff = dayNumOfInput - dayNumOfStartFrom
  if(diff < 0){
    diff+=7
  }

  if(subtract){
    diff=-diff
  }

  console.log("diff=" + diff)
  console.log("startFrom=" + startFrom)
  let dayOfMonth = startFrom + diff + (7*extraWeek)
  console.log("dayOfMonth=" + dayOfMonth)
  return new Date(year, month, dayOfMonth)
}

// console.log(meetupDay(2013, 1, 'Saturday', 'teenth')) //new Date(2013, 1, 16)
// console.log(meetupDay(2013, 1, 'Saturday', 'last').toLocaleDateString()) //new Date(2013, 1, 16)
// console.log(meetupDay(2013, 9, 'Thursday', 'last').toLocaleDateString())   //).toEqual(new Date(2013, 9, 31));
console.log(meetupDay(2015, 1, 'Sunday', 'last').toLocaleDateString()) //).toEqual(new Date(2015, 1, 22));

// console.log(new Date(2013,0,0).toLocaleString())
// console.log(new Date(2013,0,1).toLocaleString())
// console.log(new Date(2013,1,1).toLocaleString())
// console.log(new Date(2013,1,0).toLocaleString())