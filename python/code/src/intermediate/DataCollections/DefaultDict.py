"""
    Example that shows the use of default dictionary from collections module
"""

from collections import defaultdict

if __name__ == '__main__':
    fruits = ['apple', 'peach', 'banana', 'peach', 'orange', 'orange', 'apple', 'banana', 'grapes', 'apple', 'peach']

    # for counting the each kind of fruit in list:
    # this much of code will be required without using the default dictionary
    count = {}
    for fruit in fruits:
        if fruit in count.keys():
            count[fruit] += 1
        else:
            count[fruit] = 1
    print(count)

    # using default dict:
    count2 = defaultdict(int)   # default dict will use the int constructor to initialize the default values
    for fruit in fruits:
        count2[fruit] += 1

    for key, value in count2.items():
        print(f'{key} : {value}')

    # defaultdict using lambda:
    count3 = defaultdict(lambda : 10)   # default value will be 10 for each element
    for fruit in fruits:
        count3[fruit] += 1

    for key, value in count3.items():
        print(f'{key} : {value}')