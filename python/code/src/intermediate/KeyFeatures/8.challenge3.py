"""
    this challenge requires to develop a palindrome check for the input string
    Note:
        a string is palindrome if it spells same when read from either end
        Punctuations are not allowed
        case is ignored
"""
import string


def main():
    input = "shagahs!"
    # make the case consistent
    input.lower()

    # remove punctuations
    for char in input:
        if char in string.punctuation:
            input.replace(char, '')
    print(input)

    if ''.join(reversed(input)) == input:
        print("true")
    else:
        print("false")


if __name__ == '__main__':
    main()