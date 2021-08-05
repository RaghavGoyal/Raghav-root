class Node:
    def __init__(self, data):
        self.previous = None
        self.data = data
        self.next = None

    def getPrevious(self):
        """Returns the previous node"""
        return self.previous

    def setPrevious(self, newPrevious):
        """Replaces the existing previous node with the new Previous node"""
        self.previous = newPrevious

    def getData(self):
        """Returns the data stored in a node"""
        return self.data

    def setData(self, newData):
        """Replaces the existing data in a node with the data provided in parameter"""
        self.data = newData

    def getNext(self):
        """Returns the pointer to the next node"""
        return self.next

    def setNext(self, newNext):
        """Replaces the existing next pointer of a node with the given node"""
        self.next = newNext

    def __repr__(self):
        return f'Node Data = {self.data}'
