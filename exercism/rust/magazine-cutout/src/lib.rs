// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

use std::collections::HashMap;

macro_rules! counting_map {
    ($id:ident) => {
        $id.iter().fold(HashMap::new(), |mut m, w| {
            *m.entry(w).or_insert(0) += 1;
            m
        });
    };
}

pub fn can_construct_note(magazine: &[&str], note: &[&str]) -> bool {
    //counting_map_sol(magazine, note)
    func_sol(magazine, note)
}

fn func_sol(magazine: &[&str], note: &[&str]) -> bool {
    let m = counting_map!(magazine);
    let n = counting_map!(note);
    n.iter().all(|(w, c)| m.get(w).unwrap_or(&0) >= c)
}

fn counting_map_sol(magazine: &[&str], note: &[&str]) -> bool {
    let m = get_counting_map(magazine);
    let n = get_counting_map(note);
    for (x, y) in n {
        if m.get(x).unwrap_or(&0) < &y {
            return false;
        }
    }
    true
}
fn get_counting_map<'a>(d: &'a [&'a str]) -> HashMap<&'a str, u32> {
    let mut m = HashMap::new();
    for x in d {
        if let Some(x) = m.get_mut(x) {
            *x += 1;
        } else {
            m.insert(*x, 1);
        }
    }
    m
}
