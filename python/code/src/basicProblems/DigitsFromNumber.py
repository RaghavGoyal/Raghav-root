"""
    Accept a number as input and return a list of all the digits in the number.
    (Repeated digits in number should repeat in list as well)
"""

def getListOfDigits(num: int):
    if num is not None:
        ret_list = []
        while num > 0:
            last = num % 10
            ret_list.insert(0, last)
            num = num // 10

        return ret_list

if __name__ == '__main__':
    number = int(input("Enter a number: "))
    print(getListOfDigits(number))