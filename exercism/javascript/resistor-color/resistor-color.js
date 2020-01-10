export const colorCode = (color) => {
  const map ={}
  var i=0

  // https://hacks.mozilla.org/2015/04/es6-in-depth-iterators-and-the-for-of-loop/
  for(var c of COLORS){
    map[c]=i++
  }
  return map[color]
};

export const COLORS = [
  'black',
  'brown',
  'red',
  'orange',
  'yellow',
  'green',
  'blue',
  'violet',
  'grey',
  'white'
];

// https://flaviocopes.com/node-cli-args/
colorCode(process.argv.slice(2))