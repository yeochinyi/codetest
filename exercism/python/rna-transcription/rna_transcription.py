# m = {
# 'G':'C',
# 'C':'G',
# 'T':'A',
# 'A':'U'
# }
# def to_rna(dna_strand):
    # return ''.join([m[x] for x in dna_strand])
trans = str.maketrans('GCTA','CGAU')
def to_rna(dna):
    return ''.join(dna.translate(trans))
