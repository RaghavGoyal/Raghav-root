"""
    Counters are the collection types used to count the occurrence of each element in a given input collection
"""

from collections import Counter

if __name__ == '__main__':
    studentsInClass1 = ['Rob', 'Harry', 'Rohan', 'Adam', 'Rob', 'Harry', 'Adas', 'Dale', 'Dale', 'Peter', 'James', 'James']
    studentsInClass2 = ['Ria', 'Hela', 'Rita', 'Eve', 'Rits', 'Hela', 'Adis', 'Daly', 'Daly', 'Kitty', 'James']

    counter1 = Counter(studentsInClass1)
    counter2 = Counter(studentsInClass2)

    print(counter1)
    print(counter2)

#     count Rob in class 1
    print(counter1['Rob'])

#     count total students in class 1
    print(sum(counter1.values()))

#     combine the students in both classes:
    counter1.update(counter2)
    print(counter1)

#     3 most common names in combined class:
    print(counter1.most_common(3))

#     separate the counts of combined classes:
    counter1.subtract(studentsInClass2)

#     common between 2 classes:
#     indicates that 1 James is common in both the class
    print(counter1 & counter2)

