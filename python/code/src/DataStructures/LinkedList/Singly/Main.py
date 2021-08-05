def main():
    from SinglyLinkedList import SinglyLinkedList

    sll = SinglyLinkedList()
    print(f'empty check: {sll.isEmpty()}')
    sll.addFront('element 1')
    print(f'LinkedList Head: {sll.head}')
    sll.addFront('elem2')
    print(f'LinkedList Head: {sll.head}')
    print(f'next element {sll.head.next}')
    sll.addRear('Last')
    print(sll.head.next.next)
    print(f'size: {sll.size()}')
    print(f'search: {sll.search("Last")}')
    print(f'search: {sll.search("Max")}')
    sll.remove('Last')


if __name__ == '__main__':
    main()