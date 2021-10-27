"""
Here the objective is to sort the input string by words.
example:
    input: string of words
    output: of string words
"""

def sortedString(string):
    return ' '.join(sorted(string.split(' ')))

if __name__ == '__main__':
    input = "hello from python codebase"
    print(sortedString(input))