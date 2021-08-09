"""
    Create a decorator that decorates thee `Fibonacci` as shown below:

    +----------+
    !          !
     Fibonacci
    !          !
    +==========+
"""

def make_posh(func):

    def wrapper():
        """returns a decorated string"""
        print("+----------+")
        print("!          !")
        print(func())
        print("!          !")
        print("+==========+")

    return wrapper


@make_posh
def pfib():
    """Print out Fibonacci"""
    return ' Fibonacci '


if __name__ == '__main__':
    pfib()