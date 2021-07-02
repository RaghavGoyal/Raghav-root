def dictionaryDemo():
    #     creating dictionary
    d1 = {'key1': 1, 'key2': 2, 'key3': 3, 'key4': 4, 'key5': 4}
    d2 = dict(key1=1, key2='value2', key3=True)
    print(f'created dictionary: {d1} and {d2}')

    #     iterating over dictionary
    for key, value in d1.items():
        print(f'key is {key} and value is {value}')
    #     iterating over keys only:
    for key in d1.keys():
        print(f'key is {key} and value is {d1[key]}')
    #     iterating over keys only:
    for value in d1.values():
        print(f'value is {value}')  # value is not accessible here
    #     dictionary is mutable
    d1['newKey'] = 'new value'
    print(f'after adding d1: {d1}')


if __name__ == '__main__':
    dictionaryDemo()
