// Returns numerical code of resistor code
export const colorCode = (color) => {
  return COLORS.indexOf(color);
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