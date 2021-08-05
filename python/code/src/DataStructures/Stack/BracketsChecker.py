from Stack import Stack
"""
Checking whether bracket pairs are perfectly matched or not.
Algorithm:
    for a bracket in string of incoming bracket sequence
    if the bracket is opening type; push it on to the stack
    if it is closing type:
        if the stack is empty; return false
        else check that the closing bracket is the equivalent for closing bracket of the top od the stack;
            if so, pop the stack
    after all this, if the stack is empty; it means the pairs are perfectly matched
    if the stack is non empty; the pairs are mismatched
"""
def main():
    balancedBrackets = '{([])}()'
    unbalancedBrackets = '{([])})'

    print(checker(balancedBrackets))
    print(checker(unbalancedBrackets))

def checker(bracketString):
    # dictionary containing mapping of opening and closing brackets
    matchingPairs = {
        '(': ')',
        '[': ']',
        '{': '}',
    }
    openers = matchingPairs.keys()
    stack = Stack()
    for bracket in bracketString:
        if bracket in openers:
            stack.push(bracket)
        else:
            if stack.isEmpty():
                return False
            elif bracket == matchingPairs.get(stack.peek()):
                stack.pop()

    if stack.isEmpty():
        return True
    else:
        return False


if __name__ == '__main__':
    main()
