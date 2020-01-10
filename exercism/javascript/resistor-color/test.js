"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.COLORS = exports.colorCode = void 0;

const colorCode = color => {
  console.log(color);
  const map = {};
  var i = 0; // https://hacks.mozilla.org/2015/04/es6-in-depth-iterators-and-the-for-of-loop/

  for (var c of COLORS) {
    map[c] = i++;
  }

  return map[color];
};

exports.colorCode = colorCode;
const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
exports.COLORS = COLORS;
colorCode(process.argv.slice(2));

