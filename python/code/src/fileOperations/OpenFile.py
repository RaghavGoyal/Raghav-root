
def main():
    # open the file
    file = open('../resources/Dummy.txt')
#     iterate over lines and print
    for line in file:
        print(line.strip())
#   open method takes an optional  argument that represents the mode.
#   r: (default) for read mode
#   open a file in write mode:
    file2 = open('../resources/test.txt', 'w')
    file2.write('this is a new file created and written by python code')
    # closing a file
    file2.close()
    # opening a file in append mode
    open(file2.name, 'a').write('\nthe file is open in append mode and this text is appended to it')


if __name__ == '__main__':
    main()