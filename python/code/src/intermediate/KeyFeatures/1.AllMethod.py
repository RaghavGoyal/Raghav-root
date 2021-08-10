def main():
    # default behaviour of all function in python
    # returns boolean output depending upon whether on not the condition evaluates to true or false
    a = [1, 2, 3, 4, 5]
    print(all(a))
    b = [1, 2, 3, 4, 5, 0]
    print(all(b))

    #     can also provide some condition to check
    c = [2, 4, 6, 8, 10, 24, 54, 100]
    d = [2, 4, 6, 8, 10, 24, 54, 100, 101]
    print(all(
        num % 2 == 0
        for num in c
    ))
    print(all(
        num % 2 == 0
        for num in d
    ))

#     check if all the elements of list ends with e
    e = ['teste', 'dumme', 'e', 'teee', 'reahdve']
    print(
        all(
            elem.endswith('e')
            for elem in e
        )
    )

#     check if all the names in list have the first letter capitalised
    names = ['name1', 'Raju', 'Pokemon', 'Doormen']
    print(
        all(
            name.istitle()
            for name in names
        )
    )


if __name__ == '__main__':
    main()
