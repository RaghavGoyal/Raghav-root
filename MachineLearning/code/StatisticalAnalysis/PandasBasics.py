print("hello from python...")

# pip install pandas
import pandas as pd

dataFrame = pd.read_csv('./resources/titanic.csv')
# head prints the 5 rows by default.
# this behaviour can be modified by changing the property:
# pd.options.diaplay.max_columns = 6
head = dataFrame.head()

# describe is used to provide the statistical analysis of the data in dataframe.
describe = dataFrame.describe()

# selecting a single column from dataframe:
fare = dataFrame['Fare']

# multiple columns from dataframe can be selected as:
# use of [[]] is compulsary
combination = dataFrame[['Fare','Age']].head()

# Adding a new column to the dataset:
# It only adds new column to the dataFrame that gets created by reading the csv.
# NO change in CSV.
dataFrame['isMale'] = dataFrame['Sex'] == 'male'
# print(dataFrame.head())

# values read from pandas are read as dataframe.
# The DataFrame values should be converted to numpy array for performing statistical analysis on them.
# This can be done by using .values attribute on a dataframe.
values = dataFrame['Fare'].values
# print(values)

# Shape attribute applied to any numpy array returns the number of rows and columns in the array.
shape = values.shape
# print(shape)

# For multiple columns, this can be performed as:
# print(dataFrame[['Fare', 'Age']].values.shape)

# Selecting a particular cell value from numpy array:
arr = dataFrame[['Pclass', 'Fare', 'Age']].head().values
cellValue = arr[0,1]  # will give second column of the first row.
# print(cellValue)

# Selecting complete row:
row = arr[0]  # will give first row.
# print(row)

# selecting complete column:
column = arr[:,2]   # will give third column
# print(column)

