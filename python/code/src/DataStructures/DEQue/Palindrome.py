def main():
    palindromeString = 'kamayamak'
    nonPalindromeString = 'hello'

    print(checkPalindrome(palindromeString))
    print(checkPalindrome(nonPalindromeString))

def checkPalindrome(string):
    from Deque import Deque
    deque = Deque()
    for char in string:
        deque.addRear(char)
    while deque.size() >= 2:
        if deque.peekRear() == deque.peekFront():
            deque.removeFront()
            deque.removeRear()
        else:
            return False

    return True

if __name__ == '__main__':
    main()
