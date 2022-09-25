use enum_iterator::{all, cardinality, Sequence};
use int_enum::IntEnum;

#[repr(u32)]
#[derive(Debug, Copy, Clone, PartialEq, Eq, Sequence, IntEnum)]
pub enum ResistorColor {
    Black = 0,
    Brown = 1,
    Red = 2,
    Orange = 3,
    Yellow = 4,
    Green = 5,
    Blue = 6,
    Violet = 7,
    Grey = 8,
    White = 9,
}

pub fn color_to_value(_color: ResistorColor) -> u32 {
    //_color.int_value()
    _color as u32
}

pub fn value_to_color_string(value: u32) -> String {
    //let r = ResistorColor::from_int(value);
    //if let Ok(r) = r {
    //format!("{:?}", r)
    //} else {
    //"value out of range".to_owned()
    //}
    ResistorColor::from_int(value)
        .map(|c| format!("{:?}", c))
        .unwrap_or_else(|_| "value out of range".to_owned())
}

pub fn colors() -> Vec<ResistorColor> {
    all::<ResistorColor>().collect::<Vec<_>>()
}
