""" when a class is derived from more than one class, it is called multiple inheritance """

class A:
    def __init__(self):
        super().__init__()
        self.foo = 'foo'
        self.name = 'class A'


class B:
    def __init__(self):
        super().__init__()
        self.bar = 'bar'
        self.name = 'class B'


# Passing multiple base classes to inherit
class C(A, B):
    def __init__(self):
        super().__init__()


class D(B, A):
    def __init__(self):
        super().__init__()


def main():
    obj = C()
    print(f'foo: {obj.foo}, bar: {obj.bar}')
    """ here Class A is printed because the inheritance rule is applied in sequence"""
    """ Since A is inherited before B is, the common variable 'name' in class A takes precedence over class B """
    """ this is called method resolution order """
    print(f'name in class C: {obj.name}')

    ob = D()
    print(f'name in class D: {ob.name}')


if __name__ == '__main__':
    main()
