use std::collections::{HashMap, HashSet};

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let mut h = HashSet::new();
    let word = &word.to_lowercase()[..];
    let m1 = char_count(word);
    for p in possible_anagrams {
        let p1 = &p.to_lowercase()[..];
        let m2 = char_count(p1);
        //print!("{:?}", m1);
        if word != p1 && m1 == m2 {
            h.insert(p.to_owned());
        }
    }
    h
}
fn char_count(word: &str) -> HashMap<char, i32> {
    let mut m1 = HashMap::<char, i32>::new();
    for k in word.chars() {
        m1.entry(k).or_insert(0);
        m1.insert(k, 1 + m1[&k]);
    }
    m1
}
