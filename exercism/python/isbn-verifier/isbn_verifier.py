import re
def is_valid(isbn):
    isbn = isbn.replace('-','')
    reg = re.compile(r'^\d{9}[\dX]$').match(isbn)
    if reg is None:
        return False
    if not len(isbn):
        return False
    isbn = enumerate(isbn[::-1],1)
    s = [ i * (10 if x is 'X' else int(x)) for i,x in isbn] 
    z = sum(s)
    return z % 11 == 0
