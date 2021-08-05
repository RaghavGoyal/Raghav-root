from Stack import Stack

def main():
    stack = Stack()
    print(f'Stack without elements: items are: {stack.items}')
    stack.push(10)
    stack.push(20)
    stack.push(15)
    print(f'Stack after pushing 3 elements: items are: {stack.items}')
    stack.pop()
    print(f'Stack after popping 1 element: items are: {stack.items}')


if __name__ == '__main__':
    main()