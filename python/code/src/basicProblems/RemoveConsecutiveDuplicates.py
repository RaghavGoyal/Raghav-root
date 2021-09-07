"""
    Program to remove only consecutive duplicates from a list
"""
from itertools import groupby


def removeConsecutiveDuplicates(inputList: list):
    return [i[0] for i in groupby(inputList)]


if __name__ == '__main__':
    list_input = [1, 1, 2, 2, 2, 3, 3, 4, 1, 2, 3, 4]
    print(removeConsecutiveDuplicates(list_input))
