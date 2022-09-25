from enum import unique
import re

def is_isogram(string):
    s = re.sub(r'[ -]','',string).lower()
    set_len = len(set(s))
    return set_len == len(s)
