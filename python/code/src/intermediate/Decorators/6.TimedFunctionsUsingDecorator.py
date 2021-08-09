from functools import wraps
from time import perf_counter


def timer(func):
    @wraps(func)
    def wrapper(n):
        startTime = perf_counter()
        result = func(n)
        endTime = perf_counter()
        duration = endTime - startTime
        print(f'{func} took {duration:.8f}s')
        return result

    return wrapper


@timer
def fib(n):
    fibList = [1, 1]
    if n == 1:
        return 1
    if n == 2:
        return fibList

    while len(fibList) < n:
        fibList.append(fibList[-1] + fibList[-2])

    return fibList

if __name__ == '__main__':
    print(fib(20))
