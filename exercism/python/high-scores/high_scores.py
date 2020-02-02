import functools 
import ast
import sys

def latest(scores):
    return scores[-1]

def personal_best(scores):
    return functools.reduce(lambda a,b: a if a > b else b, scores)

def personal_top_three(scores):
    return sorted(scores, reverse=True)[:3]

if __name__ == "__main__":
    # python .\high_scores.py "[1,2,3]"
    inp = ast.literal_eval(sys.argv[1])
    print(personal_top_three(inp))
