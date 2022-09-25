def is_triangle(sides):
    if len(sides) != 3:
        return False
    for x in range(0,3):
        if sides[x] <= 0:
            return False
        y = x+ 1
        if y == 3:
            y = 0
        z = y+1
        if z == 3:
            z = 0
        if sides[x] + sides[y] < sides[z]:
            return False
    return True

def get_equals_sides(sides):
    # print("sides=",sides)
    equals_sides = 0
    for x in range(0,3):
        y = 0 if x == 2 else x + 1
        # print( sides[x],sides[y])
        if sides[x] == sides[y]:
            equals_sides += 1
    return equals_sides

def equilateral(sides):
    return get_equals_sides(sides) == 3 and is_triangle(sides)

def isosceles(sides):
    return  get_equals_sides(sides) >= 1 and is_triangle(sides)

def scalene(sides):
    return sides[0] != sides[1] and sides[1] != sides[2] and sides[0] != sides[2] and is_triangle(sides)
