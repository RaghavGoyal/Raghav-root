def isPalindrome(string):
    reversed = ''
    for char in string:
        reversed = char + reversed

    return reversed == string

if __name__ == '__main__':
    palindromeInput = "level"
    nonPalindromeInput = "hello"
    print(isPalindrome(palindromeInput))
    print(isPalindrome(nonPalindromeInput))