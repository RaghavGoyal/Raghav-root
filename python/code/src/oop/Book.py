class Book:
    # predefined class level dictionary containing book types
    bookType = ("PAPER-COVER", "HARD-COVER", "E-BOOK")

    # class level method. invoked on class and not on class object
    @classmethod
    def getBookTypes(cls):
        return cls.bookType

    # this method is implicitly called when the object is created
    # called the initializer function
    def __init__(self, title, author, page, price, bookType):
        # instance attributes
        self.title = title
        self.author = author
        self.page = page
        self.price = price
        if bookType not in Book.bookType:
            raise ValueError(f"Invalid book type, expected from {Book.bookType}, found {bookType}")
        else:
            self.bookType = bookType

    def getPrice(self):
        if hasattr(self, '_discount'):
            return self.price - (self.price * self._discount)
        else:
            return self.price

    def setDiscount(self, amount):
        self._discount = amount

    # Magic methods in python:
    # this method is responsible to provide the string representation of the object
    # if this object is not overridden in class, printing the object results in hash code
    # similar to java's toString() method
    # print function internally calls this method to print the string representation of the object
    def __str__(self):
        return f'Book named {self.title}, written by {self.author} costs Rs. {self.price}'

    # this method is used to get the string representation of the object
    def __repr__(self):
        return f'title = {self.title}, author = {self.author}, price = {self.price}, type = {self.bookType}'

    # this method allows the == operator being called for the equality check of two objects.
    # this is implicitly called when == operator is used
    def __eq__(self, other):
        if not isinstance(other, Book):
            raise Exception(f'Can not compare Book type with {type(other)}')
        return (
                self.title == other.title and
                self.author == other.author and
                self.bookType == other.bookType and
                self.price == other.price and
                self.page == other.page
        )


#     similarly, there are magic methods for less than and greater than comparisons and much more.

def main():
    """ creating objects of book class """
    book1 = Book('Brave Prince', 'Author1', 215, 175.00, Book.getBookTypes()[0])
    book2 = Book('War', 'Author2', 510, 200.75, Book.bookType[1])
    book3 = Book('Brave Prince', 'Author1', 215, 175.00, Book.getBookTypes()[0])

    # accessing object and fields
    print(book1)
    print(f'Title of book 1 is: {book1.title}, written by- {book1.author}.')
    print(f'price of book 1 without discount: {book1.getPrice()}')
    book1.setDiscount(0.15)
    print(f'price of book 1 after discount: {book1.getPrice()}')

    print(f'check instance type: {isinstance(book2, Book)}')

    print(f'check type: {type(book1)}')

    print(f'type of book1: {book1.bookType}')
    print(f'type of book2: {book2.bookType}')

    print(f'Equility check: {book1 == book2}')
    print(f'Equility check: {book1 == book3}')


if __name__ == '__main__':
    main()
