# for creating enum, import module as:
from enum import Enum, unique, auto

# decorator for disallowing the duplicate values
@unique
# creating an enum class:
class Fruits(Enum):
    APPLE = 1
    MANGO = 2
    BANANA = 3
    GRAPES = 4
    ORANGE = 5
#     automatically populate the value of names:
    BERRY = auto()  # 6
#     Duplicate values are allowed in enum
#     BERRY = 5
#     enum can not have duplicate names
#     APPLE = 7


if __name__ == '__main__':
    print(Fruits.APPLE)
    print(type(Fruits.APPLE))
    print(repr(Fruits.APPLE))
    print(f'{Fruits.MANGO.name}::{Fruits.MANGO.value}')
