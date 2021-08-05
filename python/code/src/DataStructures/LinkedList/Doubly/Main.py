from DoublyLinkedList import DoublyLinkedList

def main():
    dll = DoublyLinkedList()
    print(f'DLL head after creation: {dll.head}')
    print(f'empty check: {dll.isEmpty()}')
    print('inserting element1 to dll')
    dll.insertFront('element1')
    print(f'dll head: {dll.head}')
    print('inserting elem2 to front')
    dll.insertFront('elem2')
    print(f'dll head: {dll.head}')
    print(f'inserting elem3 to rear end')
    dll.insertRear('elem3')
    print(f'lastElement = {dll.head.next.next}')
    print(f'size check: {dll.size()}')
    print(f'size of empty list: {DoublyLinkedList().size()}')
    print(f'search: {dll.search("elem1")}')
    print(f'search: {dll.search("elem3")}')
    print(f'Removing elem2')
    dll.remove('elem2')
    print(f'searching for elem2: {dll.search("elem2")}')
    print(f'inserting test at index 1')
    dll.insert('test', 1)
    node = dll.head
    while node is not None:
        print(node.data)
        node = node.next


if __name__ == '__main__':
    main()
