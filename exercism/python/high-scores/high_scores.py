import ast
import sys

# return latest score
def latest(scores):
    return scores[-1]

# return top score
def personal_best(scores):
    return max(scores)

# return top 3 scores
def personal_top_three(scores):
    return sorted(scores, reverse=True)[:3]

# For testing
# if __name__ == "__main__":
#     # python .\high_scores.py "[1,2,3]"
#     inp = ast.literal_eval(sys.argv[1])
#     print(personal_top_three(inp))
