// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

//1 to 4: 100% success rate.
//5 to 8: 90% success rate.
//9 and 10: 77% success rate.
const CAR_HOUR: f64 = 221.0;

pub fn production_rate_per_hour(speed: u8) -> f64 {
    let percent = match speed {
        1..=4 => 1.0,
        5..=8 => 0.9,
        _ => 0.77,
    };
    CAR_HOUR * speed as f64 * percent
}

pub fn working_items_per_minute(speed: u8) -> u32 {
    (production_rate_per_hour(speed) / 60.0) as u32
}
