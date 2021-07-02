# a function taking function as an argument and returning the function
def function1(fun):
    print(f'this is before calling {fun}')
    fun()
    print(f'this is afetr calling {fun}')
    return fun


@function1
def decorator():
    print('this is a decorator function')


def main():
    decorator()


if __name__ == '__main__':
    main()
