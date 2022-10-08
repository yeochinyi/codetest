import re
import operator

# def answer(question):
    # err = 'syntax error'
    # err1 = 'unknown operation'
    # if re.compile(r'(Who|cubed)').findall(question):
        # raise ValueError(err1)
    # if not re.compile(r'^([A-Za-z]+\s((is|by)\s)?\-?\d+\s?)+\?$').match(question):
        # raise ValueError(err)
    # g =re.compile(r'(?:[A-Za-z]+\s)+\-?\d+').findall(question) 
    # r = 0
    # m = { 
         # 'What' : operator.__add__ ,
         # 'plus' : operator.__add__ ,
         # 'minus' : operator.__sub__ ,
         # 'multiplied' : operator.__mul__ ,
         # 'divided' : operator.__truediv__ ,
         # }

    # for x in g:
        # x = x.split(' ')
        # # print(f'{x=} {r=} {x[0]=}')
        # f = m.get(x[0])
        # if f is None: 
            # raise ValueError(err1)
        # n = int(x[-1])
        # if n is None:
            # raise ValueError(err)
        # r = f(r,int(x[-1])) 
    # return r
 
OPS = {
    "plus": "__add__", "minus": "__sub__",
    "multiplied by": "__mul__", "divided by": "__truediv__"
}
def answer(question):
    question = question.removeprefix("What is").removesuffix("?").strip()
    # question = question.strip("What is").strip("?").strip()
    if not question: raise ValueError("syntax error")   
    # if only a digit, return it
    if question.isdigit(): return int(question)
    # translate supported operations. raise error if none found.
    foundOp = False
    for name, op in OPS.items():
        if name in question:
            question = question.replace(name, op)
            foundOp = True
    if not foundOp: raise ValueError("unknown operation") 
    # process one or more operations        
    ret = question.split()
    while len(ret) > 1:
        try:
            x, op, y, *tail = ret
            if op not in OPS.values(): raise ValueError("syntax error")
            # put result as first element and append what remains
            ret = [int(x).__getattribute__(op)(int(y)), *tail]
        except: raise ValueError("syntax error")
    return ret[0]
