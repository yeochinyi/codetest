def matchingIndices(list, total):
    map = {}
    for i, l in enumerate(list):
        map[l] = i
    print(map)
    for i, l in enumerate(list):
        if total - i in map:
            j = map[total - i]
            return (i, j)
    return (-1, -1)

if __name__ == "__main__":
    print(matchingIndices([1,3,4,5,10],7))