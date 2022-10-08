def commands(binary_str):
    a = ['wink','double blink','close your eyes','jump']
    binary_str = binary_str[::-1]
    r = [a[i] for i, x in enumerate(list(binary_str[:4])) if x is '1']
    return r[::-1] if binary_str[4] is '1' else r

