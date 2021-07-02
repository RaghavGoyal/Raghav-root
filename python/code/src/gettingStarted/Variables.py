def variables():
    a = 10
    print(a)
    b = 10.2
    print(b)
    c = "hello world"
    print(c)
    print('a.class is: ', a.__class__)
    print('b.class is: ', b.__class__)
    print('c.class is: ', c.__class__)

#   this will throw error because un-compatible types are used in + operator:
#     print('this is a string' + 123)

#   this is correct way:
#   casting int to string
    print('this is a string' + str(123))


# python has automatic type inference
# no need to add type before variable

if __name__ == '__main__':
    variables()
