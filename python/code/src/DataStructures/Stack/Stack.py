class Stack:

    def __init__(self):
        self.items = []

    def push(self, item):
        """
        Accepts an item as input and adds it to the top of stack
        Returns Nothing
        Time complexity: constant [O(1)]
        """
        self.items.append(item)

    def pop(self):
        """
        Removes an item from the top of stack
        Returns the removed element
        Time Complexity: constant [O(1)]
        """
        if self.isEmpty():
            raise Exception('Can not pop from empty stack')
        else:
            return self.items.pop()

    def peek(self):
        """
        Returns the item on top of stack
        Time Complexity: constant [O(1)]
        """
        if self.isEmpty():
            raise Exception('Can not peek as stack is empty')
        else:
            return self.items[-1]

    def size(self):
        """
        Returns the size of stack
        Time Complexity: constant [O(1)]
        """
        return len(self.items)

    def isEmpty(self):
        """
        :return: True: if stack has no items
        :return: False: if stack has items
        """
        if self.size() > 0:
            return False
        else:
            return True
