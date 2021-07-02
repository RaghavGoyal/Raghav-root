def conditionalConstruct(param):
    if param is not None:
        print('param is not null')
        if param < 0:
            print('param is negative')
        elif param == 0:
            print('param is 0')
        else:
            print('param is positive')
    else:
        print('param is empty')


# python does not have a switch case

# conditional assignment:
hungry = True
feed = 'true assignemnt' if hungry else 'false assignment'
print(f'feed is: {feed}')

if __name__ == '__main__':
    conditionalConstruct(10)
