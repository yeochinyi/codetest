import random
import time

# return random named robot with specified format
class Robot:
    def __init__(self):
        self.random_string()

    def reset(self):
        self.random_string()

    def random_string(self):
        random.seed(time.time())
        alphas = [chr(random.randint(ord('A'), ord('Z'))) for i in range(2)]
        num = str(random.randint(0, 999)).zfill(3)
        self.name = ''.join(alphas) + num
