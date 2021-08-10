def main():
    l1 = ["hello", "hi", "bye", "see you", "sea", "ocean"]
    # use enumerate function to get the index of elements while looping:
    for index, element in enumerate(l1):
        print(f'{index}. {element}')

    # enumerate can also take the starting index as:
    for index, element in enumerate(l1, start=1):
        print(f'{index}. {element}')

    # enumerate over dictionary
    dictionary = {"key1": "value1", "key2": "value2", "key3": "value3", "key4": "value4"}
    for index, elem in enumerate(dictionary):
        print(f'{index}. {elem}')
        
    # dictionary.items()  returns the tuple of key, value
    for index, (key, value) in enumerate(dictionary.items()):
        print(f'{index}. {key} -> {value}')


if __name__ == '__main__':
    main()
