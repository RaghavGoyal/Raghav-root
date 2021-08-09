from functools import wraps

def munch(start, ofset):
    def doMunch(func):
        @wraps(func)
        def wrapper():
            retList = []
            result = func()
            for index, char in enumerate(result):
                if start <= index < ofset:
                    retList.append('x')
                else:
                    retList.append(char)
            return ''.join(retList)
        return wrapper
    return doMunch

@munch(1, 4)
def fib():
    "returns `FIBONACCI` "
    return "FIBONACCI"

if __name__ == '__main__':
    print(fib())
