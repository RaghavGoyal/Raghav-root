"""
    This file represents the class implementation of a decorator
"""
from functools import update_wrapper, lru_cache


class Count:
    def __init__(self, func):
        update_wrapper(self, func)
        self.func = func
        self.count = 0

    def __call__(self, *args, **kwargs):
        self.count += 1
        print(f'current count: {self.count}')
        result = self.func(*args, **kwargs)
        return result

# add this decorator to enable caching the fibonacci value of numbers once calculated
# @lru_cache(maxsize=None)
@Count
def fib(n):
    if n < 2:
        return n
    else:
        return fib(n-1) + fib(n-2)

if __name__ == '__main__':
    fib(4)

