"""
    Python lets developers control the string representation of the complex objects/ classes by 4 ways:
        1. __str__ function
        2. __repr__ function
        3. __format__ function
        4. __bytes__ function
"""

class Person:
    def __init__(self, firstName, lastName, age):
        self.firstName = firstName
        self.lastName = lastName
        self.age = age

    def __repr__(self):
        return f'<Person {self.firstName} {self.lastName}, age {self.age}>'

    def __str__(self):
        return f'||Person {self.firstName} {self.lastName}, age {self.age}||'

    def __bytes__(self):
        val = f'Person {self.firstName} {self.lastName}, age {self.age}'
        return bytes(val.encode('utf-8'))

if __name__ == '__main__':
    person = Person('Me', 'My', 10)

    print(person)

    print(bytes(person))