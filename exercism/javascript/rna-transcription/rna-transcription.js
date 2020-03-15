//
// This is only a SKELETON file for the 'RNA Transcription' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

const map = Array.prototype.map

const m = {
'G' : 'C',
'C' : 'G',
'T' : 'A',
'A' : 'U',
}

export const toRna = (text) => {
  //https://www.digitalocean.com/community/tutorials/4-uses-of-javascripts-arraymap-you-should-know
  // return map.call(text, it=>m[it]).join("")
  // return text.split("").map(it=>m[it]).join("")
  // return text.split("").map(it=>m[it]).join("")
  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax
  return [...text].map(it=>m[it]).join("")
};
