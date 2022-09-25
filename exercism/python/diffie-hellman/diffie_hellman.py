def private_key(p):
    import random
    return random.randrange(p)


def public_key(p, g, private):
    import math
    return math.pow(g,private) % p


def secret(p, public, private):
    import math
    return math.pow(public,private) % p
