def flatten(iterable):
    r = []
    q = []
    # for x in iterable:
        # if isinstance(x, list):
            # r.extend(flatten(x))
        # elif x != None:
            # r.append((x))
    q.extend(iterable)
    while(len(q) != 0):
        x = q.pop()
        if isinstance(x,list) :
            q.extend(x)
        elif x is not None :
            r.insert(0,x)
    return r
