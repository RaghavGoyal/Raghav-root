def main():
    generator()


# a generator is a function that returns a stream of values rather than a single value or object
def generator():
    # python also allows function defined inside other function
    # this is a generator function because it yields multiple values; one from each iteration of while loop
    def inclusiveRange(number):
        n = 0
        while n <= number:
            yield n
            n += 1

    for n in inclusiveRange(10):
        print(n, end=", ")


if __name__ == '__main__':
    main()
