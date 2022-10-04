def find_anagrams(word, candidates):
    word = word.lower()
    return [x for x in candidates if word != x.lower() and sorted(x.lower()) == sorted(word)]
