# this is a global variable:
f = 10


# functions are declared using def keyword:
def myFunction():
    f = 1
    # it prints 1;
    # local reference takes precedence over global.
    print('local:', f)


# this prints 10;
# only global variable is in scope
print('global:', f)


def functionUsingGlobalVariable():
    global f
    # f = 15
    print('local:', f)


print('global:', f)


# to delete a variable:
# del f
# print(f)

# parameterised functions:
def paramFunction(param1, param2, param3='default'):
    print('param1 is:', param1)
    print('param2 is:', param2)
    print('param3 is:', param3)


# variable arguments list in function:
def varArgFun(*args):
    print('accessing argument 1:', args[0])
    # null check in python:
    if args[1] is not None:
        print('accessing argument 2:', args[1])


def keywordsArgsFun(**kwargs):
    if len(kwargs):
        for arg in kwargs:
            print(f'the keyword is {arg} and the value is {kwargs[arg]}')


# Note that the code outside any method is executed before the methods are executed.
# this is because the contents of class becomes the part of class constructor.

# Note: function and classes define the scope of the variable but the block does not
if True:
    test = 10
    print(f'test inside if block is: {test}')

print(f'test outside if block is: {test}')  # accessible here

if __name__ == '__main__':
    myFunction()
    functionUsingGlobalVariable()
    paramFunction(10, "hello")
    paramFunction(10, "hello", 'test')
    # calling method with named parameters:
    paramFunction(param2=1, param1="hi")
    # varArgFun(10)
    varArgFun(10, 20, 30)
    keywordsArgsFun(test=10, key="hello", key2="Bye")
