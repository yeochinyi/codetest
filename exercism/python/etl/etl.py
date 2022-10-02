def transform(legacy_data):
    # m = {}
    # for k,v in legacy_data.items():
        # for i in v:
            # m[i.lower()] = k
    # return m
    return {
            a.lower():k
            for k,v in legacy_data.items()
            for a in v
            }
