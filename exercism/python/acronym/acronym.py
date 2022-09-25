import re
def abbreviate1(words):
    sp = re.split(r'[ \-_]', words)
    return "".join([ w[0].upper() for w in sp if len(w) > 0 ] )


def abbreviate(words):
    r = re.findall(r'\b\_?([a-zA-Z])[\w\']*', words)
    return "".join(r).upper()

# if __name__ == "__main__":
#     print(abbreviate("Aa_Bb-Cc Dd"))

