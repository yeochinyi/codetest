import functools 

def distance(strand_a, strand_b):
    if len(strand_a) != len(strand_b):
        raise ValueError(f"strands are not equal")
    # zipped = zip(strand_a, strand_b)

    # return functools.reduce(lambda acc, x : acc + (1 if x[0] != x[1] else 0) , zipped, 0)
    return sum(i!=j for i,j in zip(strand_a, strand_b))


# if __name__ == "__main__":
#     print(distance("GGACGGATTCTG", "AGGACGGATTCT"))
