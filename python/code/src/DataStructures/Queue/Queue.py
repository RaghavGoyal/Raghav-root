class Queue:

    def __init__(self):
        self.items = []

    def enqueue(self, item):
        """
        Adds the item parameter to the end of queue
        Time Complexity: constant [O(1)]
        """
        self.items.append(item)

    def dequeue(self):
        """
        Removes an item from the front of the queue
        :return: the item removed
        Time Complexity: linear [O(n)]; because each element after front is moved ahead
        """
        if self.isEmpty():
            raise Exception('Can not dequeue from empty queue')
        else:
            return self.items.pop(0)

    def peek(self):
        """
        :return: the item in front of the queue; if queue is non empty
        :return: None; if queue is empty
        Time Complexity: Constant [O(1)]
        """
        if self.isEmpty():
            return None
        else:
            return self.items[0]

    def size(self):
        """
        :return: The size of the queue
        Time Complexity: Constant [O(1)]
        """
        return len(self.items)

    def isEmpty(self):
        """
        :return: True: if queue has no items
        :return: False: if queue has item(s)
        """
        if self.size() > 0:
            return False
        else:
            return True
