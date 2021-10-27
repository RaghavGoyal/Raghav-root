"""
The objective is to find all the occurrence of a given element in a list of elements.
example:
    input: List(1,2,3,3,4,5,1,3,2,4,5,5,2,1) -> search for all occurrences of 2:
    output: List(1,8,12) -> indices representing where the match occurs
"""

def getAllOccurrences(inputList, element):
    retList = []
    for index, elem in enumerate(inputList):
        if elem == element:
            retList.append(index)
    return retList

if __name__ == '__main__':
