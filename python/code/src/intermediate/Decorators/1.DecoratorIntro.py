"""Decorator is a callable entity of a program that takes the function as an argument,
   and extends the behaviour of that function without explicitly modifying the function.

   Hence, decorator has the ability to execute additional code before and after executing the function.

   General template of a decorator:

   def decoratorFunction(func):

        def wrapper():
            # do something before executing `function`
            result = function()
            # do something after executing `function`
            return result

        return wrapper

  @decoratorFunction
  def func():
    pass

"""

# a function taking function as an argument and returning the function
def decorator(fun):
    """Decorator function"""
    def wrapper():
        """Wrapper inside a decorator"""
        return "Decorated String"
    return wrapper()

def ordinaryFunction():
    "returns ordinary string"
    return "Ordinary String"

@decorator
def decoratedFunction():
    "returns ordinary string"
    return "Ordinary String"


def main():
    # calling a function like usual.
    print(ordinaryFunction())

#     calling decorator function as:
    fun = decorator(ordinaryFunction)
    print(fun)

#     this 2 step procedure to call a wrapper function is simplified by using the decorator
#     This is depicted by the function named decoratedFunction.
#     decorated function can be directly called like this-
    print(decoratedFunction)

#     However, creating decorators like this has following problem:
    print(f'{ordinaryFunction.__name__}')

    # indicates loss of debugging capability:
    # print(f'{decoratedFunction.__name__}')
    # Fix- discussed in file 3


if __name__ == '__main__':
    main()
