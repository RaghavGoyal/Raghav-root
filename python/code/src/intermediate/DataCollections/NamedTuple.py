"""
    Named tuples are like ordinary tuple, but they have a meaning assigned to each values in the tuple.
    This makes accessing values easier as the context of values is clearer
"""

# Python module that has named tuple defined
import collections

if __name__ == '__main__':
    #     creating a tuple to represent a point in space:
    point = collections.namedtuple("Point", "x y z")
    p1 = point(10, 5, 3)
    p2 = point(3, 7, 11)

    print(f'points are: {p1} and {p2}')
    print(f'Accessing thee coordinates: p1.x = {p1.x}, p2.z = {p2.z}')

    #     replacing the value of any element in tuple:
    p3 = p1._replace(y=0)   # Replace function returns a tuple, without modifying the existing tuple
    print(p1)
    print(p3)

