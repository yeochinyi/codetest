use std::{
    collections::HashMap,
    sync::{Arc, Mutex},
};

pub fn frequency(input: &[&str], worker_count: usize) -> HashMap<char, usize> {
    println!("input_len={}, worker_count={}", input.len(), worker_count);
    if input.len() < 1 {
        return HashMap::new();
    }
    let mut s = input.len() / worker_count;
    if s == 0 {
        s = 1;
    }
    // let mut data = Arc::new(Mutex::new(HashMap::new()));
    let ch = input
        .chunks(s)
        .map(|chunk| {
            chunk
                .iter()
                .map(|s| s.to_string().to_ascii_lowercase())
                .collect()
        })
        .collect::<Vec<Vec<_>>>();
    let workers: Vec<_> = ch
        .into_iter()
        .map(|c| 
            // let mut h = data.clone();
             std::thread::spawn(move || {
                 c.iter().flat_map(|x| x.chars())
                     .fold(HashMap::new(), 
                           |mut acc, x|{ 
                                       *acc.entry(x).or_insert(0) +=1;
                                       acc
                     })
             })
        )
        .collect();
    let mut map = workers.into_iter().fold(HashMap::new(), |mut sum, w| {
        let h = w.join().unwrap();
        println!("h={:?}", h);
        h.iter().for_each(|(k, v)| {
            *sum.entry(k.clone()).or_insert(0) += v;
        });
        println!("sum{:?}", sum);
        sum
    });
    // let mut map = Arc::try_unwrap(data).unwrap().into_inner().unwrap();
    (0..9).for_each(|x| {
        let c = char::from_digit(x, 10).unwrap();
        map.remove(&c);
    });
    vec![',', '.', '!'].iter().for_each(|x| {
        map.remove(x);
    });
    map
}
