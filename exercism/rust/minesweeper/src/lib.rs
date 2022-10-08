use std::collections::HashMap;

pub fn annotate(minefield: &[&str]) -> Vec<String> {
    let mut m: HashMap<(isize, isize), usize> = HashMap::new();
    (0..minefield.len()).for_each(|x| {
        (0..minefield[x].len()).for_each(|y| {
            count(&mut m, minefield, x, y);
        })
    });
    //println!("{:?}", m);

    (0..minefield.len())
        .map(|x| {
            (0..minefield[x].len())
                .map(|y| repr(minefield[x].chars().nth(y).unwrap(), &m, x, y))
                .collect()
        })
        .collect()
}
fn repr(c: char, map: &HashMap<(isize, isize), usize>, x: usize, y: usize) -> String {
    match c {
        '*' => "*".to_string(),
        _ => {
            return match map.get(&(x as isize, y as isize)) {
                None => " ".to_owned(),
                Some(x) => x.to_string(),
            };
        }
    }
}
fn count(map: &mut HashMap<(isize, isize), usize>, minefield: &[&str], x: usize, y: usize) {
    if minefield[x].chars().nth(y) != Some('*') {
        return;
    }
    let x = x as isize;
    let y = y as isize;
    (-1..=1).map(|i| i as isize).for_each(|m| {
        (-1..=1).map(|i| i as isize).for_each(|n| {
            let c = ((x + m), (y + n));
            let _ = *map.entry(c).and_modify(|x| *x += 1).or_insert(1);
        })
    });
}
