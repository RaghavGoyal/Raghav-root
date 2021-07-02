# There are 4 kinds of sequence types that python has built-in
def main():
    sequenceList()
    sequenceTuple()
    sequenceRange()
    sequenceDictionary()


# list : mutable
def sequenceList():
    print('list')
    # creating the list
    l = [1, 2, 3, 4, 5]
    # access elements with index, starting is 0
    print(l[2])
    # mutable
    l[3] = 10
    print(l)


# tuple : immutable
def sequenceTuple():
    print('tuple')
    # creating tuple
    t = (1, 2, 3, 4, 5)
    #     print tuple
    print(t)
    #     access elements with index, starting 0
    print(t[2])
    # immutable
    # error
    # t[4] = 100


# Range : immutable
def sequenceRange():
    # range with only end specified
    # Creates range from 0 to 9
    r1 = range(10)
    for num in r1:
        print(num, end=", ")
    # range with custom starting point:
    r2 = range(5, 10)
    print()
    for num in r2:
        print(num, end=", ")
    #     range with custom start and non-unit step
    # creates range from 10 to 100(exclusive) with step of 5 for each element
    r3 = range(10, 100, 5)
    print()
    for num in r3:
        print(num, end=", ")
    print()


# Dictionary : Like map : Mutable
def sequenceDictionary():
    # creating list
    # syntax is
    # { key : value, key2 : value2 }
    d = {'key1': 1, 'key2': 2, 'key3': 3}
    print(d)
#     access using key
    print(d['key2'])
#     loop like:
    for x in d:
        print(f'key: {x}  value: {d[x]}')
    # or loop like this
    for k,v in d.items():
        print(f'key: {k}  value: {v}')
#     mutate using keys
    d['key1'] = 10
    print(d)


if __name__ == '__main__':
    main()
