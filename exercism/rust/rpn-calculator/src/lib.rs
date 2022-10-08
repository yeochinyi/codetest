use CalculatorInput::{Add, Divide, Multiply, Subtract, Value};
#[derive(Debug)]
pub enum CalculatorInput {
    Add,
    Subtract,
    Multiply,
    Divide,
    Value(i32),
}

pub fn evaluate(inputs: &[CalculatorInput]) -> Option<i32> {
    let mut s: Vec<i32> = Vec::new();
    for x in inputs.iter() {
        let c = match x {
            Value(x) => *x,
            _ => {
                let b = s.pop()?;
                let a = s.pop()?;
                match x {
                    Add => a + b,
                    Subtract => a - b,
                    Multiply => a * b,
                    Divide => a / b,
                    _ => panic!(),
                }
            }
        };
        s.push(c);
    }
    if s.len() > 1 {
        return None;
    }
    s.pop()
}
