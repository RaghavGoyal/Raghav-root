"""
    Program to calculate the factorial of an input number:
"""

def getFactorial(num:int):
    if num == 1:
        return 1
    else:
        return num * getFactorial(num - 1)

if __name__ == '__main__':
    num = int(input("Enter a number: "))
    factorial = getFactorial(num)
    print(factorial)