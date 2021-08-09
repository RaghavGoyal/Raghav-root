#!/usr/bin/env python3

# Working with ZIP files in Python
import zipfile


# Create a new ZIP archive
zfile = zipfile.ZipFile("archive.zip", "w")
zfile.write("file1.txt")
zfile.write("file2.txt")
zfile.write("file3.txt")
zfile.close()

# creating zip file using context manager:
with zipfile.ZipFile('archive2.zip', 'w') as zip:
    zip.write('file1.txt')
    zip.write('file2.txt')
    zip.write('file3.txt')

# Check validity of the file
print(zipfile.is_zipfile("archive.zip"))


# Read the properties of a ZIP archive
zfile = zipfile.ZipFile("archive.zip")
print(zfile.namelist())
print(zfile.infolist())


# Read the properties of ZIP contents
zinfo = zfile.getinfo("file1.txt")
print(zinfo.file_size)
print(zfile.read("file3.txt"))


# Extract ZIP file contents
# zfile.extract("file2.txt")
# zfile.extractall()


# Ensure that the file is closed
zfile.close()
