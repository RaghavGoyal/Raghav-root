from Deque import Deque

def main():
    dq = Deque()
    print(f'isEmpty check: {dq.isEmpty()}')
    print(f'items before any operation {dq.items}')
    dq.addRear('hello')
    dq.addRear('hi')
    dq.addFront('High')
    print(f'isEmpty check: {dq.isEmpty()}')
    print(f'items after 2 X addRear and addFront operation {dq.items}')
    dq.removeFront()
    print(f'items after removeFront operation {dq.items}')
    dq.removeRear()
    print(f'items after removeRear operation {dq.items}')
    dq.addFront('High Again')
    dq.addRear('Low')
    print(f'items for Peek operations {dq.items}')
    print(f'peek Rear: {dq.peekRear()}')
    print(f'peek Front: {dq.peekFront()}')


if __name__ == '__main__':
    main()