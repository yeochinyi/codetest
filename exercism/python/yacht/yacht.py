# Score categories.
# Change the values as you see fit.
YACHT = 0
ONES = 1
TWOS = 2
THREES = 3;
FOURS = 4
FIVES = 5
SIXES = 6
FULL_HOUSE = 7
FOUR_OF_A_KIND = 8
LITTLE_STRAIGHT = 9
BIG_STRAIGHT = 10
CHOICE = 11 


def score(dice, category):
    count = [0] * (len(dice)+ 1)
    for d in dice:
        count[d - 1] += 1
    
    match category:
        case 0: return 50 if max(count) == 5 else 0
        case 1|2|3|4|5|6: return count[category - 1] * category 
        case 7: return sum(dice) if set(count).issuperset([3,2]) else 0
        case 8:
            i = [ i for (i,v) in enumerate(count) if v >= 4 ]
            return (i[0]+1) * 4 if len(i) else 0
            # for x in [4,5]:
                # try:
                    # return (count.index(x) + 1) * 4
                # except:
                    # pass
            # return 0
        case 9: return 30 if max(count) == 1 and count[5] == 0 else 0
        case 10: return 30 if max(count) == 1 and count[0] == 0 else 0
        case 11: return sum(dice) 
        case _: return 0

