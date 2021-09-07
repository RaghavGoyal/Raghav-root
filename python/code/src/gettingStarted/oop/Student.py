class Student:
    # declaring class variables
    className = 'Student'

    # creating constructor:
    # object variables
    def __init__(self, fName, lName, course, grade):
        self.fName = fName
        self.lName = lName
        self.course = course
        self.grade = grade
        self.subjects = []

    """ creating methods in class """
    """ self represents the current instance of the class """
    """ it is an implicit parameter of each method in class """
    def getClassName(self):
        return self.className

    def getFullName(self):
        return f'{self.fName} {self.lName}'

    def hasHonors(self):
        if self.grade == 'A+':
            return True
        else:
            return False

    def addSubject(self, subjectName):
        self.subjects.append(subjectName)

    def getSubjects(self):
        return self.subjects

    # method for string representation of object
    def __str__(self):
        return f'Student Name: {self.getFullName()}, Course: {self.course}, Grade: {self.grade}, Subjects: {self.getSubjects()} '


# inheritance
class HeadBoy(Student):
    className = 'HeadBoy'

    def __init__(self, fName, lName, course, grade):
        super().__init__(fName, lName, course, grade)

    def getFullName(self):
        return f'Master {super().getFullName()}'


def main():
    """ creating object of class Student """
    studentObj = Student('Raghav', 'Goyal', 'B.Tech', 'A+')
    print(studentObj.getClassName())
    print(studentObj.getFullName())
    print(studentObj.hasHonors())
    studentObj.addSubject('Python')
    print(studentObj.getSubjects())
    studentObj.addSubject('Java')
    print(studentObj.getSubjects())
    print(studentObj.__str__())

    headBoy = HeadBoy('test', 'test', 'B.tech', 'A')
    print(headBoy.getFullName())


if __name__ == '__main__':
    main()
