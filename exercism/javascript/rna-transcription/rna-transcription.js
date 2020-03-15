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

//https://www.digitalocean.com/community/tutorials/4-uses-of-javascripts-arraymap-you-should-know
export const toRna = (text) => {
  // return text.map(it=>m[it])  
  // return map.call(text, it=>m[it]).join("")
  return text.split("").map(it=>m[it]).join("")
};
