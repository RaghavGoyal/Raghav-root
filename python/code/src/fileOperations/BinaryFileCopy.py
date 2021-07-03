# Binary files are usually the media files like image, video etc.
def main():
    infile = open('../resources/img.jpeg', 'rb')  # open a file in read and binary mode
    outFile = open('../resources/imgCopy.jpeg', 'wb')
    while True:
        buffer = infile.read(10240)
        if buffer:
            outFile.write(buffer)
            print('.', end='', flush=True)
        else:
            break


if __name__ == '__main__':
    main()
