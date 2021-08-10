def main():
    l1 = ["red", "green", "blue"]
    l2 = ["blood", "grass", "sky"]

    # zip method creates a tuple of corresponding elements from both the lists
    for element, color in zip(l2, l1):
        print(f'color of {element} is {color}')

    #      if any list is smaller in length, the zip function will zip the elements up to the elements in smaller list
    l3 = ["blood", "grass"]
    for element, color in zip(l3, l1):
        print(f'color of {element} is {color}')

    #     this default behaviour can be over-ridden as:
    from itertools import zip_longest
    for element, color in zip_longest(l3, l1, fillvalue="Unknown element"):
        print(f'color of {element} is {color}')

    #     you can also zip more than 2 lists together. (Try yourself)

    #   the zip function can be used to unzip elements as well
    #   use * operator to state unzipping operation
    pairs = zip(l1, l2)
    colors, elements = zip(*pairs)
    print(colors)
    print(elements)


if __name__ == '__main__':
    main()
