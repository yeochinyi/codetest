/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {
    let code = code.replace(" ", "");
    if code.len() < 2 || code.chars().any(|x| !x.is_digit(10)) {
        return false;
    }
    let sum = code
        .chars()
        .map(|c| c.to_digit(10).unwrap())
        .rev()
        .enumerate()
        .map(|x| process(x))
        .sum::<u32>();
    sum % 10 == 0
}

fn process((i, x): (usize, u32)) -> u32 {
    if i % 2 == 1 {
        let x = x * 2;
        if x > 9 {
            return x - 9;
        }
        return x;
    }
    x
}
