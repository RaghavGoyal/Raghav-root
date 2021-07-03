def main():
    infile = open('../resources/Dummy.txt', 'r')
    outFile = open('../resources/DummyCopy.txt', 'w')
    for line in infile:
        outFile.write(line)
    infile.close()
    outFile.close()


if __name__ == '__main__':
    main()
