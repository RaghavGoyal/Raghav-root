"""
    Accept thee number (n) as input,
    for number 1 to n,
        return the sum of numbers that conform to the given condition

    Given condition:
        Number should be multiple of 3 or 5
"""

def getConditionalSumUpto(n: int, condition):
    return sum(filter(condition, range(1, n+1)))

if __name__ == '__main__':
    limit = int(input("Enter the number: "))
    print(getConditionalSumUpto(limit, lambda x: x % 3 == 0 or x % 5 == 0))