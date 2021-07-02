def setDemo():
    #     creating set
    s1 = {1, 2, 3, 4, 4, 3, 2, 1, 'h'}
    s2 = set('hello')
    print(f'created set s1: {s1} and s2: {s2}')
    #     set operations are union, intersection, negation etc.
    #   negation
    print(f'negation operation: {s1 - s2}')  # present in s1 but not in s2
    print(f'union operation: {s1 | s2}')  # present in s1 or s2
    print(f'intersection operation: {s1 & s2}')  # present in s1 and s2
    print(f'XOR (Exclusively in A or in B but not in both) operation: {s1 ^ s2}')  # present in s1 but not in s2


if __name__ == '__main__':
    setDemo()
