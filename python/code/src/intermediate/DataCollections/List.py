# explore inbuilt list methods on your own
def listDemo():
    #     creating list:
    l1 = [1, 2, 3, 4, 5, 6, 0, 9, 7, 8, 1]
    #     print list:
    print(l1, l2)
    #     loop over elements:
    for elem in l1:
        print(elem)
    #     map operation:
    print(list(map(lambda elem: elem * 2, l1)))
#     accessing multiple elements of list
    print(l1[1:3:2])            # start:stop:step
#     obtain the index of element:
    print(f'index of 0 is: {l1.index(0)}')
#     append the lement to list using append method
    l1.append(10)
    print(f'after appending 10 to list {l1}')
#     insert the element at specific index
    l1.insert(5,11)
    print(f'after inserting 11 at index 5 {l1}')


if __name__ == '__main__':
    listDemo()
