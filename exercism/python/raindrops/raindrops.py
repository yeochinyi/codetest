"""no module docstring"""

import sys

def convert(number):
    """convert -> return raindrop sounds based on input"""

    a_dict = {3:'Pling', 5:'Plang', 7:'Plong'}
    # https://stackoverflow.com/questions/9060653/list-comprehension-without-in-python
    ret = ''.join((v for k, v in a_dict.items() if int(number) % k == 0))
    return ret if ret else str(number)

if __name__ == "__main__":
    print(convert(sys.argv[1]))
