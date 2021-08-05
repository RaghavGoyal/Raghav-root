class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

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
