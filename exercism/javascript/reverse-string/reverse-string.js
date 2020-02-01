export const reverseString = (text) => {
  return [...text].reverse().join("")
};

// For quick testing on cli i.e remove "export" and run node .\reverse-string.js "test"
console.log(reverseString(process.argv[2]));
