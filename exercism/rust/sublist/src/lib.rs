use crate::Comparison::Superlist;
use crate::Comparison::{Equal, Sublist, Unequal};

#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

pub fn sublist<T: PartialEq + Ord>(_first_list: &[T], _second_list: &[T]) -> Comparison {
    let a = _first_list;
    let b = _second_list;

    match (a.len(), b.len()) {
        (m, n) if m == n && a == b => Equal,
        (m, 0) => Superlist,
        (0, n) => Sublist,
        (m, n) if m > n && a.windows(n).any(|i| i == b) => Superlist,
        (m, n) if m < n && b.windows(m).any(|i| i == a) => Sublist,
        (_, _) => Unequal,
    }
}
