"""
Deque is a Double-Ended Queue.
In a deque, enqueue and dequeue operations can be done from both the ends.
i.e. a queue which additionally allows insertion in the front and deletion from the end is called Deque
"""

class Deque:
    def __init__(self):
        self.items = []

    def addFront(self, item):
        """
        Takes an item and adds it to the front end of the deque
        :param item: element to be inserted
        :return: nothing
        Time Complexity: Linear [O(n)]
        """
        self.items.insert(0, item)

    def addRear(self, item):
        """
        Takes an item and adds it to the rear end of the deque
        :param item: element to be inserted
        :return: nothing
        Time Complexity: Constant [O(1)]
        """
        self.items.append(item)

    def removeFront(self):
        """
        Removes an item from front end of deque
        :return: element removed
        Time Complexity: Linear [O(n)]
        """
        if self.items:
            return self.items.pop(0)
        else:
            raise Exception('can not remove from empty deque')

    def removeRear(self):
        """
        Removes an item from the rear end of deque
        :return: element removed
        Time Complexity: Constant [O(1)]
        """
        if self.items:
            return self.items.pop()
        else:
            raise Exception('can not remove from empty deque')

    def peekFront(self):
        """
        Returns an element from front end of deque, without removing it
        :return: an element at front end
        Time Complexity: Constant [O(1)]
        """
        if self.items:
            return self.items[0]
        else:
            return None

    def peekRear(self):
        """
        Returns an element from rear end of deque, without removing it
        :return: an element at rear end
        Time Complexity: Constant [O(1)]
        """
        if self.items:
            return self.items[-1]
        else:
            return None

    def isEmpty(self):
        """
        Checks if the deque is empty or not
        :return: Boolean value; 'True' if empty and 'False' if non-Empty
        """
        return not bool(self.size())

    def size(self):
        """
        :return: the length of deque
        """
        return len(self.items)
