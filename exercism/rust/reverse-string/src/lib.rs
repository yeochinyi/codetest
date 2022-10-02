use unicode_segmentation::UnicodeSegmentation;

pub fn reverse(input: &str) -> String {
    //format!("{}", input.chars().rev().collect::<String>())
    input.graphemes(true).rev().collect()
}
