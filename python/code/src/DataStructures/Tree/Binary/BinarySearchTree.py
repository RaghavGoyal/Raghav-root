from Node import Node

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        """
        Inserting into tree is done basis the following:
            - if the data to be inserted is smaller than root:
                it is inserted recursively in left child
            - if the data to be inserted is greater than root:
                it is inserted recursively in right child
        :param data: takes the value that is to be inserted in tree
        """
        def _insertRec(node: Node, root):
            if node.data < root.data:
                if root.left:
                    _insertRec(node, root.left)
                else:
                    root.left = node
            if node.data > root.data:
                if root.right:
                    _insertRec(node, root.right)
                else:
                    root.right = node
        nodeToInsert = Node(data)
        if self.root is None:
            self.root = nodeToInsert
        else:
            _insertRec(nodeToInsert, self.root)

    def search(self, target):
        """
        Searching a tree is similar to binary search as:
            - if the target is smaller than root:
                search recursively in left child
            - if the target is greater than root:
                search recursively in right child
        :param target: the data to be searched
        :return: Boolean:
                    `True` if data is found
                    `False` if data is not found
        """
        def _searchRec(target, root):
            if root.data == target:
                return True
            elif target < root.data and root.left:
                return _searchRec(target, root.left)
            elif target > root.data and root.right:
                return _searchRec(target, root.right)
            else:
                return False
        _searchRec(target, self.root)

    def inOrderTraverse(self):
        """
            traverse order as follow:-
                1. recursively traverse left child
                2. traverse parent
                3. recursively traverse right child
        """
        def _inorder(root):
            if root.left:
                _inorder(root.left)

            print(root.data)

            if root.right:
                _inorder(root.right)

        _inorder(self.root)

    def preOrderTraverse(self):
        """
            Traverse order as follow:
                1. traverse parent
                2. recursively traverse left child
                3. recursively traverse right child
        """
        def _preOrder(root):
            print(root.data)
            if root.left:
                _preOrder(root.left)
            if root.right:
                _preOrder(root.right)

        _preOrder(self.root)

    def postOrderTraverse(self):
        """
            Traverse as follow:
                1. recursively traverse left child
                2. recursively traverse right child
                3. traverse Parent
        """

        def _postOrder(root):
            if root.left:
                _postOrder(root.left)
            if root.right:
                _postOrder(root.right)
            print(root.data)

        _postOrder(self.root)

    def height(self):
        """
        the number of nodes from the root to the deepest leaf node is called height of tree.
        the height of tree is the maximum of height of right child and height of left child
        :return: `int` representing the height of the tree.
        """
        def _getHeightRec(root, accumulator=0):
            return max(
                _getHeightRec(root.left, accumulator+1) if root.left else accumulator,
                _getHeightRec(root.right, accumulator+1) if root.right else accumulator
            )

        return _getHeightRec(self.root)

    def getNodesAtDepth(self, depth):
        def _getNodesAtDepthRec(root, depth, nodes=[]):
            if depth == 0:
                nodes.append(root.data)
                return nodes
            else:
                _getNodesAtDepthRec(root.left, depth-1) if root.left else nodes.extend([None])
                _getNodesAtDepthRec(root.right, depth-1) if root.right else nodes.extend([None])
                return nodes

        return _getNodesAtDepthRec(self.root, depth)

    def getMin(self):
        """
        Finds the minimum node of the tree
        :return: The minimum data from the tree
        """
        def _getMinRec(root):
            if root.left:
                _getMinRec(root.left)
            else:
                return root.data
        _getMinRec(self.root)

    def delete(self, target):
        """
            The basic idea of deleting a node from tree is as follows:
                - if the node to be deleted has no child:
                    simply delete the node
                - if the node to be deleted has one child:
                    delete the node and add the child node in its place
                - if the node to be deleted has 2 children:
                    perform RTFM (Right Tree Find Minimum)
                    then, add the minimum in place of the node to be deleted
        :param target: Takes the data value to be deleted from the node
        """
        def _deleteRec(root, target):
            if root.data == target:
                if root.left and root.right:
                    "rtfm"
                    minValue = root.getMin()
                #     To complete
                elif root.left:
                    root = root.left
                    del root.left
                elif root.right:
                    root = root.right
                    del root.right
            if target < root.data and root.left:
                _deleteRec(root.left, target)
            if target > root.data and root.right:
                _deleteRec(root.right, target)

        _deleteRec(self.root, target)