import re
# import sys

class PhoneNumber:
    def __init__(self, number):
        numOnly = re.sub('\\D+','', number)
        if len(numOnly) < 10 or len(numOnly) > 11:
            raise ValueError("Invalid")
        if len(numOnly) == 11 and numOnly[0] != '1':
            raise ValueError("Invalid")
        self.number = numOnly[-10:]
        self.area_code = numOnly[-10:-7]
        # print("area_code=" + self.area_code)
        self.exchange_code = numOnly[-7:]
        # print("exchange_code=" + self.exchange_code)
        if int(self.area_code[0]) < 2:
            raise ValueError("Invalid")
        if int(self.exchange_code[0]) < 2:
            raise ValueError("Invalid")
        
    def pretty(self):
        return f"({self.area_code}) {self.exchange_code[0:3]}-{self.exchange_code[3:]}"

# if __name__ == "__main__":
#     print(PhoneNumber(sys.argv[1]))