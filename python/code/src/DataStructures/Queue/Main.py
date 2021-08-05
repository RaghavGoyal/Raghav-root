from Queue import Queue

def main():
    q = Queue()
    print(f'q after creation: {q.items}')
    q.enqueue(10)
    q.enqueue(15)
    q.enqueue(30)
    print(f'q after inserting 3 items: {q.items}')
    q.dequeue()
    print(f'q after removing 1 item: {q.items}')
    q.dequeue()
    print(f'q after removing 1 item: {q.items}')

if __name__ == '__main__':
    main()