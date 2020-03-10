import re

def abbreviate(words):
    sp = re.split(r'[ \-_]', words)
    return "".join([ w[0].upper() for w in sp if len(w) > 0 ] )

# if __name__ == "__main__":
#     print(abbreviate("Aa_Bb-Cc Dd"))

