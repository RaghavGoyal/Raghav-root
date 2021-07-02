# list comprehension is creating the list using other collection
def main():
    seq = range(11)
    #     creating list of squares of numbers in seq
    l1 = [x * x for x in seq]
    print(f'list of square is {l1}')
    #     creating list of tuple from range above
    t1 = [(x, x ** 2) for x in seq]  # power operator in python
    print(f'list of tuple(number, square) is {t1}')
    #     creating map using seq
    m1 = {x: x ** 2 for x in seq}
    print(f'map (number,square) is {m1}')


if __name__ == '__main__':
    main()
