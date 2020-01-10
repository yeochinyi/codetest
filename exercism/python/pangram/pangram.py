import re

# returns True if sentence is pangram
def is_pangram(sentence):
    
    # s = set()
    # for e in sentence:
    #     s.add(e.lower())
    # for x in range(ord('a'), ord('z')+1):
    #     if chr(x) not in s:
    #         return False
    # return True
    return len(set(re.sub('[^a-z]', '', sentence.lower()))) == 26

