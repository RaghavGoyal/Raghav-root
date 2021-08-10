if __name__ == '__main__':
    l1 = [2, 4, 6, 0, 1]
    # sorted function to sort int
    print(sorted(l1))

    l2 = ['Hello', 'hi', 'Bye', 'see', 'sea', 'C', 'Ocean']
    # Sorted method on non int:
    print(sorted(l2))

    # sorting in reverse order:
    print(sorted(l1, reverse=True))
    print(sorted(l2, reverse=True))

    # sorting on custom objects:
    class Student:
        def __init__(self,name,age):
            self.name = name
            self.age = age

        def __repr__(self):
            return f'Student {self.name} is {self.age} yrs old.'

    studentsList = [
        Student('Name1', 12),
        Student('Ram', 30),
        Student('Rgh', 20),
        Student('Abh', 22),
        Student('Sam', 15),
        Student('Zan', 10),
        Student('Ram', 26),
        Student('Das', 28)
    ]
    # Direct attempt to sort custom objects throws error
    # print(sorted(studentsList))

    # sorting student object by age:
    print(sorted(studentsList, key=lambda st: st.age))

    # sorting student objects by name:
    print(sorted(studentsList, key=lambda st: st.name))

    # if some object has same name, by default, it is kept in the order of insertion.
    # this default behaviour can be changed by sorting as:
    print(sorted(studentsList, key=lambda st: (st.name, st.age)))
