import sys

def classify(number):
    ''' return perfect, abundant, or deficient if number is matching aliquot sum '''
    
    num = int(number)
    if num < 1:
        raise ValueError("number is invalid")
    aliquot = sum([i for i in range(1,num) if num%i==0])
    if aliquot == number:
        return "perfect"
    elif aliquot > number:
        return "abundant"
    else:
        return "deficient"


if __name__ == "__main__":
    print(classify(sys.argv[1]))