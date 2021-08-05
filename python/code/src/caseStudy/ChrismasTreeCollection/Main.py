"""In this case study,
   we create a console based application that
   keeps the track of how many christmas trees are to be picked up from the sector.
   The dictionary is such that the sector is key and no of trees is value
"""


def main():
    dictionary = {'256': 2, '234': 1, '345': 2, '555': 11}
    welcomeMessage = "Welcome to the Christmas Tree Collection Application"
    askForSector = "Please enter the sector from which we should pick up: "
    askForTrees = "How may trees will be picked up? "
    print(welcomeMessage)
    sector = input(askForSector)
    trees = int(input(askForTrees))
    if dictionary.keys().__contains__(sector):
        totalTrees = dictionary.get(sector) + trees
        dictionary[sector] = totalTrees
    else:
        dictionary[sector] = trees
    print(exitMessage(sector, trees))
    print(len(dictionary))
    for sector in dictionary:
        print(f'sector: {sector}, trees: {dictionary[sector]}')

    dict10 = {k: v for k, v in dictionary.items() if v >= 10}
    print(dict10)


def exitMessage(sector, trees):
    return f'Request Registered! {trees} Christmas trees will be picked from Sector: {sector}'


if __name__ == '__main__':
    main()
