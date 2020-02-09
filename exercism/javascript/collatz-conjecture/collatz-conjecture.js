 export const steps = (input) => {
   input = parseInt(input)
   if(input < 1){
     throw new Error('Only positive numbers are allowed')
   }
  let step = 0;
  while(input !== 1){    
    input = input % 2 === 0 ? input / 2 : input * 3 + 1
    step++
  }
  return step
};

// For cli testing. to be remove during npm test or it will run weird
// console.log(steps(process.argv.slice(2)))