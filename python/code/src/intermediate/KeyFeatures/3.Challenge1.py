"""
    the challenge is to create a function that does the following:
        given a list of strings,
        for all the elements in list,
        check if all the strings contains any punctuation or not
"""
import string


def main():
    def check(inputList):
        return all(
            any(
                char in string.punctuation
                for char in line
            )
            for line in inputList
        )

    inputListFalse = [
        "Readability counts.",
        "Errors should never pass silently",
        "If the implementation is hard to explain, it\'s a bad idea.",
        "There should be one-- and preferably only one --obvious way to do it.",
        "Simple is better than complex"
    ]
    inputListTrue = [
        "Readability counts.",
        "Errors should never pass silently.",
        "If the implementation is hard to explain, it\'s a bad idea.",
        "There should be one-- and preferably only one --obvious way to do it.",
        "Simple is better than complex."
    ]

    print(check(inputListFalse))
    print(check(inputListTrue))


if __name__ == '__main__':
    main()
