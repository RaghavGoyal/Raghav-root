def main():
    l1 = [1, 2, 3, 4, 5, 6]
    # reverses the list in place;
    # very efficient in memory
    l1.reverse()
    print(l1)

    # returns an iterable of reversed input;
    # actual list remains unchanged
    for elem in reversed(l1):
        print(elem)

#     reversing using slicing:
    var = l1[::-1]
    print(var)

if __name__ == '__main__':
    main()
