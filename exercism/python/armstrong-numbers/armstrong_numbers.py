import sys
from functools import reduce

def is_armstrong_number(number):
    """is_armstrong_number -> return true if is armstrong number"""

    digits=[int(i) for i in str(number)]
    l=len(digits)            
    # total=reduce((lambda x, y: x + pow(y,l)), digits, 0) 
    total=sum(d ** l for d in digits)
    return number == total

if __name__ == "__main__":
    print(is_armstrong_number(int(sys.argv[1])))