// The code below is a stub. Just enough to satisfy the compiler.
// In order to pass the tests you can add-to or change any of this code.

#[derive(Debug)]
pub struct Duration(f64);

impl From<u64> for Duration {
    fn from(s: u64) -> Self {
        let v = s as f64 / 31557600.0;
        Duration(v)
    }
}

pub trait Planet {
    fn period() -> f64;
    fn years_during(d: &Duration) -> f64 {
        d.0 / Self::period()
    }
}

pub struct Mercury;
pub struct Venus;
pub struct Earth;
pub struct Mars;
pub struct Jupiter;
pub struct Saturn;
pub struct Uranus;
pub struct Neptune;

macro_rules! planet {
    ($i:ident, $e: expr) => {
        impl Planet for $i {
            fn period() -> f64 {
                $e
            }
        }
    };
}

planet!(Mercury, 0.2408467);
planet!(Venus, 0.61519726);
planet!(Earth, 1.0);
planet!(Mars, 1.8808158);
planet!(Jupiter, 11.862615);
planet!(Saturn, 29.447498);
planet!(Uranus, 84.016846);
planet!(Neptune, 164.79132);

//impl Planet for Mercury {
//fn years_during(d: &Duration) -> f64 {
//d.0 / 0.2408467
//}
//}
//impl Planet for Venus {
//fn years_during(d: &Duration) -> f64 {
//d.0 / 0.61519726
//}
//}
//impl Planet for Earth {
//fn years_during(d: &Duration) -> f64 {
//d.0
//}
//}
//impl Planet for Mars {
//fn years_during(d: &Duration) -> f64 {
//d.0 / 1.8808158
//}
//}
//impl Planet for Jupiter {
//fn years_during(d: &Duration) -> f64 {
//d.0 / 11.862615
//}
//}
//impl Planet for Saturn {
//fn years_during(d: &Duration) -> f64 {
//d.0 / 29.447498
//}
//}
//impl Planet for Uranus {
//fn years_during(d: &Duration) -> f64 {
//d.0 / 84.016846
//}
//}
//impl Planet for Neptune {
//fn years_during(d: &Duration) -> f64 {
//d.0 / 164.79132
//}
//}
