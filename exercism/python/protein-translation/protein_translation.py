import sys

#  Returns Protein Translation
def proteins(strand):
    ret = []

    map = dict()

    map['AUG'] = 'Methionine'
    for i in ['UUU', 'UUC']:
        map[i] = 'Phenylalanine'
    for i in ['UUA', 'UUG']:
        map[i] = 'Leucine'
    for i in ['UCU', 'UCC', 'UCA', 'UCG']:
        map[i] = 'Serine'
    for i in ['UAU', 'UAC']:
        map[i] = 'Tyrosine'
    for i in ['UGU', 'UGC']:
        map[i] = 'Cysteine'
    map['UGG'] = 'Tryptophan'
    for i in ['UAA', 'UAG', 'UGA']:
        map[i] = 'STOP'


    for i in range (0,len(strand), 3):
        part = strand[i:i+3]
        value = map.get(part)
        if value:
            if value == 'STOP':
                return ret
            ret.append(value)
    return ret


if __name__ == "__main__":
    print(proteins(sys.argv[1]))