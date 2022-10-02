import re
def response(hey_bob):
    hey_bob = hey_bob.strip()
    if len(hey_bob) == 0:
        return "Fine. Be that way!"
    is_query = re.match(r'.*\?\s*$', hey_bob) != None
    # is_caps = re.match(r'^[A-Z\d\,]+[A-Z\s\'\,]+[\!\?]?$', hey_bob) != None
    is_caps = re.match(r'^[A-Z\d\s\'\,]+[A-Z][A-Z\d\s\?\!\%\^\*\@\#\(\*\$]+$', hey_bob) != None
    print(f'is_q={is_query}, is_caps={is_caps}')
    

    if is_query :
        if is_caps :
            return "Calm down, I know what I'm doing!"
        else:
            return "Sure."
    else:
        if is_caps:
            return "Whoa, chill out!"
        else:
            return "Whatever."
    
