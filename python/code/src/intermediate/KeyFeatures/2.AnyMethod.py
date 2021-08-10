def main():
    # default behaviour of any function in python
    # returns boolean output depending upon whether on not the condition evaluates to true or false for any of the input
    a = [1, 2, 3, 4, 5, 0]
    print(any(a))
    b = [0, False, ""]
    print(any(b))

    #     can also provide some condition to check
    c = [2, 4, 6, 8, 10, 24, 54, 100]
    d = [2, 4, 6, 8, 10, 24, 54, 100, 101]
    print(any(
        num % 2 != 0
        for num in c
    ))
    print(any(
        num % 2 != 0
        for num in d
    ))

#     check if any element of list ends with e
    e = ['teste', 'dumm', 'ey', 'teey', 'reahdver']
    print(
        any(
            elem.endswith('e')
            for elem in e
        )
    )

#     check if any name in list have the first letter capitalised
    names = ['name1', 'raju', 'pokemon', 'doormen']
    print(
        any(
            name.istitle()
            for name in names
        )
    )


if __name__ == '__main__':
    main()
