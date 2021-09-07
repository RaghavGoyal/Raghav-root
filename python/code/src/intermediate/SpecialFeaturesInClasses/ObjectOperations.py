"""
    Python lets developers control the behaviour of a class
     when basic mathematical operations are performed on the objects of that class.

     For example a custom object will lack the capability to perform addition, subtraction, multiplication etc.

     In order to enable these operations on custom objects, you can define following methods:
     1. __add__(self, other)            self + other
     2. __sub__(self, other)            self - other
     3. __mul__(self, other)            self * other
     4. __div__(self, other)            self / other
     5. __floordiv__(self, other)       self // other
     6. __pow__(self, other)            self ** other

     Note: Implementing these methods will also enable short hand operations on the objects.
     However, if only short hand operation is required, then implement following methods:
     1. __iadd__(self, other)           self += other
     2. __isub__(self, other)           self -= other
     3. __imul__(self, other)           self *= other
     4. __itruediv__(self, other)       self /= other
     5. __ifloordiv__(self, other)      self //= other
     6. __ipow__(self, other)           self **= other

     Similarly, for logical and, or implement following methods:
     1. __and__(self, other)            self & other
     2. __or__(self, other)             self | other
     3. __iand__(self, other)           self &= other
     4. __ior__(self, other)            self |= other


     Similarly, for comparison operations, implement following methods:
     1. __ge__(self, other)             self >= other
     2. __gt__(self, other)             self > other
     3. __lt__(self, other)             self < other
     4. __le__(self, other)             self <= other
     5. __eq__(self, other)             self == other
     6. __ne__(self, other)             self != other

     Note: implementing these comparison operations also enables sorting of the objects
"""
class Juice:
    def __init__(self, name, quantity):
        self.name = name
        self.quantity = quantity

    def __repr__(self):
        return f'Juice(name={self.name}, quantity={self.quantity})'

#     enable addition
    def __add__(self, other):
        name = self.name + '&' + other.name
        quantity = self.quantity + other.quantity

        return Juice(name, quantity)

    def __imul__(self, other):
        name = self.name + '*' + other.name
        quantity = self.quantity * other.quantity

        return Juice(name, quantity)
#     Similarly, define other methods to enable other functionalities

if __name__ == '__main__':
    j1 = Juice('orange', 1)
    j2 = Juice('apple', 1)

    # by default, the mathematical operations can not be performed on j1 and j2
    print(j1+j2)
    # following will also work
    # j1 += j2

    j1 *= j2
    print(j1)
    # j1 * j2 will not work
