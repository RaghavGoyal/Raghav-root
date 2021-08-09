"""
    A function may bee defined in such a way that it takes-
     variable number of arguments, or
     variable number of keyword arguments.

   The decorators for such methods can be defined using the below template:

   def decorator(func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            # do something before
            result = func(*args, **kwargs)
            # do something after
            return result
        return wrapper

   @decorator
   def func():
        pass

"""

from functools import wraps


def decorator(func):
    @wraps(func)
    def wrapper(*args, **kwargs):
        print('inside wrapper')
        result = func(args, kwargs)
        return result

    return wrapper


@decorator
def printFib(*args, **kwargs):
    print(args)
    print(kwargs)


if __name__ == '__main__':
    printFib(1, 1, th=2, fo=3, fv=5)
