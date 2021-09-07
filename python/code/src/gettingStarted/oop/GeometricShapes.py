""" In python abstract class is created by inheriting ABC (Abstract base class) """
from abc import ABC, abstractmethod


class GeometricShape(ABC):
    def __init__(self):
        super().__init__()

    @abstractmethod
    def area(self):
        pass


class Circle(GeometricShape):
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return 3.14 * self.radius ** 2

class Square(GeometricShape):
    def __init__(self, edge):
        self.edge = edge

    def area(self):
        return self.edge ** 2


