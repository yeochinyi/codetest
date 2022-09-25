def add(moment):
    giga = 1_000_000_000
    from datetime import timedelta
    return moment + timedelta(seconds=giga)
