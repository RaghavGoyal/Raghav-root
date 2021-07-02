# Formatting the number with leading and trailing zeros.
def main():
    a = 10
    b = 16
    c = 1.4
    print(f'The value of a is {a:<04}')     # total digits are 4, filler is 0, filler will append at right side
    print(f'The value of b is {b:>04}')     # total digits are 4, filler is 0, filler will append at left side
    print(f'The value of c is {c:<06}')     # for floating point numbers . is included in total digits.
    print(f'The value of c is {c:>06}')


if __name__ == '__main__':
    main()
