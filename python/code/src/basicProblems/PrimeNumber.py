def main():
    num = int(input('Enter a number'))
    output = isPrime(num)
    print(f'Prime check for {num} is: {output}')

    print(f'prime mumbers upto {num} are:')
    listPrimeNumbersUpto(num)


def isPrime(number):
    if number <= 1:
        return False
    for num in range(2, number):
        if number % num == 0:
            return False
    else:
        return True


def listPrimeNumbersUpto(number):
    for i in range(1, number):
        if isPrime(i):
            print(i, end=', ')


if __name__ == '__main__':
    main()
