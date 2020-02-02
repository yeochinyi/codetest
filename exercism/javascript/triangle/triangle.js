//
// This is only a SKELETON file for the 'Triangle' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export class Triangle {
  constructor(x,y,z) {
    this.equaty = [x===y,y===z,z===x];
    this.isTriangle = x + y > z && x + z > y && z + y > x
  }

  isEquilateral() {    
    return this.isTriangle && this.equaty.every(v => v);
  }

  isIsosceles() {
    return this.isTriangle && this.equaty.some(v => v);
  }

  isScalene() {
    return this.isTriangle && !this.equaty.some(v => v);
  }
}


// For quick testing on cli 
// console.log(new Triangle(...process.argv.slice(2)));