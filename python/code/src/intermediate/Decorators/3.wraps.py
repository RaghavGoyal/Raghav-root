"""
    As seen, creating the decorators (as discussed in file 1) compromise with the debugging capability.
    hence, there is a better way to achieve the same.
    Thee wrapper function can be created using `@wraps` decorator as shown below:
"""

# import wraps decorator:
from functools import wraps

def make_posh(func):

    @wraps(func)
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
    print(f'{pfib.__name__}')
    print(f'{pfib.__doc__}')