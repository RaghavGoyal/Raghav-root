def main():
    original = ["hello", "hi", "bye", "see", "sea", "ocean"]
    reversed = []

    for elem in original:
        reversed.insert(0, elem)
        
    print(reversed)

if __name__ == '__main__':
    main()