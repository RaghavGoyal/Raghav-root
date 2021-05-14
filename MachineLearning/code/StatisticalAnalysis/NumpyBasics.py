# install python in system.
# install numpy using pip in system
# pip install numpy
print(
    "hello from python"
)
import numpy as py

data = [15, 16, 18, 19, 22, 24, 29, 30, 34]

print("mean is: ", py.mean(data))
print("median is: ", py.median(data))
print("50th percenttile is: ", py.percentile(data, 50))
print("25th percenttile is: ", py.percentile(data, 25))
print("75th percenttile is: ", py.percentile(data, 75))
print("standard deviation is: ", py.std(data))
print("variance is: ", py.var(data))
