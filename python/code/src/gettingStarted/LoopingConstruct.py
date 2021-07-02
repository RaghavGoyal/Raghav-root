def main():
    # looping in a range.
    for i in range(1, 10):
        print(i)

    # looping in a collection
    days = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
    for d in days:
        print(d)

    #     if you need go access index as well, then use:
    for index, day in enumerate(days):
        print(f"{day} at index: {index}")

    #     while loop:
    x = 0
    while x < 5:
        print(x)
        x = x + 1


if __name__ == '__main__':
    main()
