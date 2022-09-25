//export function decodedResistorValue(s: Array<string>) {
//const m = {
//black: 0,
//brown: 1,
//red: 2,
//orange: 3,
//yellow: 4,
//green: 5,
//blue: 6,
//violet: 7,
//grey: 8,
//white: 9,
//};
//const v = new Map<string, number>(Object.entries(m));
//const c = s.map((x) => v.get(x));

//let l = "ohms";
//let s_3 = c[2] as number;
//let s_2 = c[1]?.toString();

//if (s_2 == "0") {
//s_3 += 1;
//s_2 = "";
//}
//if (s_3 >= 3) {
//l = "kiloohms";
//s_3 -= 3;
//}
//let s_3t = "0".repeat(s_3);
//return `${c[0]}${s_2}${s_3t} ${l}`;
//}

const ColorAry = [
  `black`,
  `brown`,
  `red`,
  `orange`,
  `yellow`,
  `green`,
  `blue`,
  `violet`,
  `grey`,
  `white`,
] as const; // need "as const" for type Color
// not needed for this exercise, but this will disallow passing e.g. 'pink' to constructor
export type Color = typeof ColorAry[number];
export function decodedResistorValue([band1, band2, band3]: Color[]): string {
  let num =
    (ColorAry.indexOf(band1) * 10 + ColorAry.indexOf(band2)) *
    10 ** ColorAry.indexOf(band3);
  let ohms = "ohms";
  if (num >= 1000) {
    ohms = "kiloohms";
    num = num / 1000;
  }
  return `${num} ${ohms}`;
}
