use std::fmt::Display;

#[derive(Debug, PartialEq, Eq)]
pub struct Clock(i32, i32);

impl Display for Clock {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:02}:{:02}", self.0, self.1)
    }
}
impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let mut new_hr = hours + minutes / 60;
        let mut new_min = minutes % 60;
        if new_min < 0 {
            new_min += 60;
            new_hr -= 1;
        }
        new_hr %= 24;
        if new_hr < 0 {
            new_hr += 24;
        }
        let c = Clock(new_hr, new_min);
        //println!("{hours},{minutes}, {c}");
        c
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let new_min = self.1 + minutes;
        Clock::new(self.0, new_min)
    }
}
