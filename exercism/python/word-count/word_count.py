import re
from collections import Counter


def count_words(sentence):
    return Counter(re.findall(r"[a-z0-9]+'?[a-z]*(?<!')", sentence.casefold()))
# def count_words(sentence):
#     m = {}
#     for w in re.split(r'[.;:,\s_!&@$%^]+', sentence.lower()):
#         if not w:
#             continue
#         while w[0] == "'" and w[-1] == "'":
#             w = w[1:-1]
#         if w in m:
#             m[w]=m[w]+1
#         else:
#             m[w]=1
#     return m
