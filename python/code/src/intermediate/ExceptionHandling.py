def main():
    try:
        # error prone code
        cast = int('ab')
    except ValueError:
        # catching the error and doing stuff when this error occurs
        print('caught the value error')
    except ArithmeticError:
        print('caught ArithmeticError')
    finally:
        print('this block is always executed')

    num = int(input('enter number smaller than 10:'))
    if num > 10:
        raise TypeError(f'expected input smaller than 10, got {num}')
    else:
        print('good job..!')


if __name__ == '__main__':
    main()
