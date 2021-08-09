#!/usr/bin/env python3

# Basic file operations in Python


# open a file for writing data
# "w" means write, "r" means read, "a" means append, "r+" means read and write
fp = open("testfile.txt", "w")
fp.write("This is some text data\n")
fp.close()


# read a file's data
with open("testfile.txt", "r") as fp:
    data = fp.read()
    print(data)


# Add data to an existing file
with open("testfile.txt", "a+") as fp:
    fp.write("This is data added to the file\n")
    fp.seek(0)   # points the cursor to a given index in file
    data = fp.read()
    print(data)
