import sys
from functools import reduce

def is_armstrong_number(number):
    """is_armstrong_number -> return true if is armstrong number"""

    workingNumber=number
    total=0
    digits=[]
    while True:        
        digits.append(workingNumber%10)
        workingNumber=int(workingNumber/10)        
        if workingNumber<1:            
            l=len(digits)            
            total=reduce((lambda x, y: x + pow(y,l)), digits, 0) 
            # print(f'total={total}, digits={digits}')
            break
    return number == total

if __name__ == "__main__":
    print(is_armstrong_number(int(sys.argv[1])))