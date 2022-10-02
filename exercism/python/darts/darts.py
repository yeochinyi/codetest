import math
def score(x, y):
    d = math.sqrt(x * x+ y*y)
    # match d:
        # case d if d <= 1:
            # return 10
        # case d if d <= 5:
            # return 5
        # case d if d <= 10:
            # return 1
        # case _:
            # return 0
    return (d<=1)*5+(d<=5)*4+(d<=10)*1
