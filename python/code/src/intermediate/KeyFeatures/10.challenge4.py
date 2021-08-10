"""
    In this challenge the task is to return the word that has highest score from the given string input.
    The scores are defined in a dictionary as:

    letter_scores = {
                    'a': 1, 'b': 3, 'c': 3, 'd': 2, 'e': 1, 'f': 4, 'g': 2, 'h': 4,
                    'i': 1, 'j': 8, 'k': 5, 'l': 1, 'm': 3, 'n': 1, 'o': 1, 'p': 3,
                    'q': 10, 'r': 1, 's': 1, 't': 1, 'u': 1, 'v': 4, 'w': 4, 'x': 8,
                    'y': 4, 'z': 10
                }

"""

def main():

    # method that accepts a character and returns the score corresponding to it
    def getScore(char):
        # if the character exists in this dictionary, the corresponding score is returned;
        # if it does not exist in the dictionary, then return 0
        letter_scores = {
            'a': 1, 'b': 3, 'c': 3, 'd': 2, 'e': 1, 'f': 4, 'g': 2, 'h': 4,
            'i': 1, 'j': 8, 'k': 5, 'l': 1, 'm': 3, 'n': 1, 'o': 1, 'p': 3,
            'q': 10, 'r': 1, 's': 1, 't': 1, 'u': 1, 'v': 4, 'w': 4, 'x': 8,
            'y': 4, 'z': 10
        }
        if char in letter_scores.keys():
            return letter_scores.get(char)
        else:
            return 0

    # accepts a word and returns its score
    def getWordScore(word):
        return sum(getScore(char) for char in word)

    # accepts multiple words separated by space and returns the word with maximum score
    def getWordWithMaxScore(input):
        words = input.split(" ")
        scores = []
        for word in words:
            scores.append(getWordScore(word))

        pairs = zip(words, scores)
        return max(pairs, key=lambda pair: pair[1])

    # list containing the test lines
    inputList = [
        "Readability counts.",
        "Errors should never pass silently",
        "If the implementation is hard to explain, it\'s a bad idea.",
        "There should be one-- and preferably only one --obvious way to do it.",
        "Simple is better than complex"
    ]

    # for each line in list, find the word with max score, and print the word along with score
    for inputLine in inputList:
        print(getWordWithMaxScore(inputLine))


if __name__ == '__main__':
    main()
