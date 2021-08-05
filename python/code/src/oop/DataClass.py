# refer Book.py class
# classes are basically used to store data of the objects.
# so python 3.7 and above introduces the new concept of data classes
# dataclasses can reduce the code for creating the class fields
# the boo   k class created in Book.py ca be created using dataclass as follows:

from dataclasses import dataclass, field


# annotation directs python to treat following class as a dataclass

# immutable dataclass can be created as:
# @dataclass(frozen=True)

# mutable dataclass
@dataclass
class Book:
    # assign name and type fields
    title: str
    page: int
    price: float
    # default parameter of class field called author
    # there are multiple ways to provide default value to a field in dataclass

    # method 1:
    # author: str = 'Unknown'

    # method 2:
    author: str = field(default='Unknown')

    # method 3:
    # here u can call a custom method that would provide the default value
    # author: str = field(default_factory=methodName)

#   dataclass has a special magic method called __post_init__
#   this method will be called after the fields defined in constructor above have been initialized
    def __post_init__(self):
        self.description = f'{self.title} by {self.author}'


def main():
    book1 = Book('Test Title', 100, 200.80, 'Myself')
    book2 = Book('Another Test Title', 280, 1285.80, 'Myself')
    book3 = Book('Another Test Title', 280, 1285.80, 'Myself')
    book4 = Book('Another Test Title', 280, 1285.80)

    #     with dataclass, repr and eq methods are also implicitly defined;
    print(f'created book object B1, {book1}')
    print(f'created book object B2, {book2}')
    print(f'created book object B4, {book4}')

    print(f'comparison: {book1 == book2}')
    print(f'comparison: {book3 == book2}')

    print(f'Getting description: {book1.description}')
    print(f'Getting description: {book2.description}')


if __name__ == '__main__':
    main()

