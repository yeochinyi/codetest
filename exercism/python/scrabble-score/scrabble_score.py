def score(word):
    word=word.upper()
    initMap = [
        ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'],       1,
        ['D', 'G'],                                               2,
        ['B', 'C', 'M', 'P'],                                     3,
        ['F', 'H', 'V', 'W', 'Y'],                                4,
        ['K'],                                                    5,
        ['J', 'X'],                                               8,
        ['Q', 'Z'],                                              10,
    ]
    map={}
    total=0
    for i in range(0, len(initMap), 2):
        for j in initMap[i]:
            map[j]=initMap[i+1]
    for c in word:
        total+=map[c]
    return total
