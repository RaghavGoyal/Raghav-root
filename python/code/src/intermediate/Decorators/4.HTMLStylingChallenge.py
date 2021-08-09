"""
    Challenge is to use decorators to decorate `Fibonacci` as:
    <b> <i> Fibonacci </i> </b>
"""
from functools import wraps

def italicDecorator(func):
    @wraps(func)
    def wrapper():
        result = func()
        return f"<i> {result} </i>"

    return wrapper

def boldDecorator(func):
    @wraps(func)
    def wrapper():
        result = func()
        return f"<b> {result} </b>"

    return wrapper

@boldDecorator
@italicDecorator
def printfib():
    '''return Fibonacci'''
    return 'Fibonacci'

if __name__ == '__main__':
    print(printfib())