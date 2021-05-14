from sklearn.datasets import load_breast_cancer

# load_breast_caccer is an object defined in sklearn that returns dataset in a collection similar to python dictionary.
dataSet = load_breast_cancer()
# print(dataSet.keys())

# the description of dataset is present in the field named 'DESCR'
# print(dataSet['DESCR'])

# All data is present in:
# print(dataSet['data'])

# to check how many rows and columns are present in data (rows, column)
# print(dataSet['data'].shape)

# Name of all the features:
# print(dataSet['feature_names'])

# target name:
# print(dataSet['target_names'])

# target values:
# print(dataSet['target'])

# With basic understanding of dataset,
# Lets now  fit this data into LR model:

from sklearn.linear_model import LogisticRegression
import pandas as pd

LRModel = LogisticRegression(solver='liblinear')
dataFrame = pd.DataFrame(dataSet['data'], columns=dataSet['feature_names'])
dataFrame['target'] = dataSet['target']
features = dataFrame[dataSet.feature_names].values
LRModel.fit(features, dataFrame['target'].values)
# predict the value:
print("predicted value is: ")
print(LRModel.predict([features[0]]))
