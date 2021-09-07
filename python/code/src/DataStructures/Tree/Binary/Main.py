"""
    Demo for Binary Search Tree
"""
from BinarySearchTree import BinarySearchTree

if __name__ == '__main__':
    bst = BinarySearchTree()
    bst.insert(10)
    print(f'Root Data: {bst.root.data}')
    print(f'Root.left: {bst.root.left}')
    print(f'Root.right: {bst.root.right}')
    bst.insert(5)
    bst.insert(20)
    print('Inserted 5 and 20')
    print(f'Root Data: {bst.root.data}')
    print(f'Root.left.data: {bst.root.left.data}')
    print(f'Root.right.data: {bst.root.right.data}')
    print(f'Search for 10 {bst.search(10)}')
    print(f'Search for 5 {bst.search(5)}')
    print(f'Search for 20 {bst.search(20)}')
    print(f'Search for 15 {bst.search(15)}')

    bst.insert(3)
    bst.insert(7)
    bst.insert(15)
    bst.insert(17)

    print("Inorder Traversal:")
    bst.inOrderTraverse()

    print("pre-order Traversal:")
    bst.preOrderTraverse()

    print("post-order Traversal:")
    bst.postOrderTraverse()

    print(f'height of tree is: {bst.height()}')

    print(f'getting nodes at depth 3: {bst.getNodesAtDepth(2)}')
