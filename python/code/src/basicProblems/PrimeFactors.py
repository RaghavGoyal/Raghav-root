"""
    For a given input number, get a list of all the prime factors.
    Example: For input 630, output should be [2,3,3,5,7]
"""
import math


def isPrime(number):
    if number < 2:
        return False
    for num in range(2, number):
        if number % num == 0:
            return False
    return True

def getPrimeFactors(n):
    retList = []

    while n % 2 == 0:
        retList.append(2)
        n = n / 2

    # n must be odd now
    # so a skip of 2 ( i = i + 2) can be used
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        # while i divides n , append i in retList and divide n by i
        while n % i == 0:
            retList.append(i)
            n = n / i

    # Condition if n is a prime number greater than 2
    if n > 2:
        retList.append(n)

    return retList


if __name__ == '__main__':
    inputNumber = int(input("Enter a number:"))
    print(getPrimeFactors(inputNumber))