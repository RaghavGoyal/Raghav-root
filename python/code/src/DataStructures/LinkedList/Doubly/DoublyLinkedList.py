from Node import Node

class DoublyLinkedList:

    def __init__(self):
        self.head = None

    def __repr__(self):
        return f'Doubly Linked List: Head = {self.head}'

    def isEmpty(self):
        return self.head is None

    def insertFront(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node

    def insertRear(self, data):
        node = Node(data)
        current = self.head

        while current.next is not None:
            current = current.next

        current.next = node
        node.previous = current

    def insert(self, data, index):
        node = Node(data)
        currentIndex = 0
        currentNode = self.head
        while currentIndex < index:
            currentIndex += 1
            currentNode = currentNode.next
        previousNode = currentNode.previous
        previousNode.next = node
        node.previous = previousNode
        node.next = currentNode
        currentNode.previous = node

    def size(self):
        count = 0
        current = self.head
        while current is not None:
            count += 1
            current = current.next
        return count

    def search(self, data):
        current = self.head
        while current is not None:
            if current.data == data:
                return True
            else:
                current = current.next
        return False

    def remove(self, data):
        current = self.head
        while current is not None:
            if current.data == data and current.previous is None:
                current.next.previous = None
                self.head = current.next
                break

            elif current.data == data:
                previousNode = current.previous
                nextNode = current.next
                nextNode.previous = previousNode
                previousNode.next = nextNode
                break

            else:
                current = current.next
