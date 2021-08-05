from Node import Node

class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def __repr__(self):
        return f'Singly Linked List with Head: {self.head}'

    def isEmpty(self):
        """ Returns 'True' if LinkedList is empty;
            Returns 'False' if LinkedList is non-empty
        """
        return self.head is None

    def addFront(self, data):
        """Adds the given data to the front of the LinkedList and updates the head
           Time Complexity: Constant [O(1)]
        """
        node = Node(data)
        node.setNext(self.head)
        self.head = node

    def addRear(self, data):
        """Adds the given data to the end of the LinkedList and updates tail
           Time Complexity: Linear [O(n)]
        """
        node = Node(data)
        current = self.head
        while current.next is not None:
            current = current.next
        current.next = node

    def size(self):
        """Returns the number of nodes in the LinkedList
           Time Complexity: Linear [O(n)]
        """
        count = 0
        current = self.head
        while current is not None:
            count += 1
            current = current.next
        return count

    def search(self, data):
        """
        Searches for the given data in a linked list
        :param data: data to be searched
        :return: 'True' if found; 'False' if not found
        """
        if self.head is None:
            return 'Linked List is empty. No nodes to search'

        current = self.head
        while current is not None:
            if current.data is data:
                return True
            else:
                current = current.next
        return False

    def remove(self, data):
        """Removes the first occurrence of node  containing the 'data'
           Time Complexity: Linear [O(n)]
        """
        if self.head is None:
            return 'The Linked List is empty; Nothing to remove'

        current = self.head
        previous = None
        found = False

        while not found:
            if current.data == data:
                found = True
                if previous is None:
                    self.head = self.head.next
                else:
                    previous.next = current.next
            else:
                previous = current
                current = current.next

        if not found:
            return f'No match found for {data}'
