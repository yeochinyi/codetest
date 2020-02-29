const COLORS =  [
  'black',
  'brown',
  'red',
  'orange',
  'yellow',
  'green',
  'blue',
  'violet',
  'grey',
  'white']

export const decodedValue = (colors) => {
  return parseInt(colors.slice(0,2).map(x=>COLORS.indexOf(x)).join(""))
};
