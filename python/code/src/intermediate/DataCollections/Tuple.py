def tupleDemo():
    #     creating tuple
    t1 = ("hello", "hi", "bye", "bye")
    print(f'tuple is: {t1}')
    print(f'type of tuple: {type(t1)}')
    print(f'type of tuple element: {type(t1[0])}')

#     tuples do not have append method since it is immutable
#   map over tuple elements
    print(tuple(map(lambda element: element.capitalize(), t1)))


if __name__ == '__main__':
    tupleDemo()
