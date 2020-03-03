import re

def is_isogram(string):
    s = set()
    string = re.sub(r'[ -]','',string)
    for e in string:    
        el = e.lower()
        if el in s:
            return False
        s.add(el)
    return True