"""
    Program to accept a number (n) as input and return the sum of numbers 1 to n
"""


def getSumUpto(n: int):
    return sum(range(n+1))


if __name__ == '__main__':
    num = int(input("Enter a number: "))
    print(getSumUpto(num))
