# return latest score
def latest(scores):
    return scores[-1]

# return top score
def personal_best(scores):
    return max(scores)

# return top 3 scores
def personal_top_three(scores):
    return sorted(scores, reverse=True)[:3]
