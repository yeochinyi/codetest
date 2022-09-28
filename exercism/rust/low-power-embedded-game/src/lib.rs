// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

pub fn divmod(dividend: i16, divisor: i16) -> (i16, i16) {
    (dividend / divisor, dividend % divisor)
}

struct Evens<T> {
    iter: Box<dyn Iterator<Item = T>>,
    is_first: bool,
}
impl<T> Iterator for Evens<T> {
    type Item = T;
    fn next(&mut self) -> Option<Self::Item> {
        if !self.is_first {
            match self.iter.next() {
                Some(x) => (),
                None => return None,
            }
        }
        self.is_first = false;
        return match self.iter.next() {
            Some(x) => Some(x),
            None => return None,
        };
    }
}
pub fn evens<T>(iter: impl Iterator<Item = T> + 'static) -> impl Iterator<Item = T> {
    //std::iter::empty()
    //Evens {
    //iter: Box::new(iter),
    //is_first: true,
    //}
    //
    //iter.step_by(2)
    //
    iter.enumerate().filter(|(i, _)| i % 2 == 0).map(|(_, e)| e)
}

pub struct Position(pub i16, pub i16);
impl Position {
    pub fn manhattan(&self) -> i16 {
        self.0.abs() + self.1.abs()
    }
}
