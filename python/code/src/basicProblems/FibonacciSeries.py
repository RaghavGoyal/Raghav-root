def main():
    end = int(input('enter the number of elements of Fibonacci series: '))
    fibonacciList = getFibo(end)
    print(fibonacciList)


def getFibo(end):
    list = [0, 1]

    if end == 1:
        return [0]
    if end == 2:
        return list

    while len(list) < end:
        list.append(list[-1]+list[-2])
    return list


if __name__ == '__main__':
    main()
