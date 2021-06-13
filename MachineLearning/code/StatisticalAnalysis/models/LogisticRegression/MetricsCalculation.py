# Scikit-learn has a function built in for each of the metrics that we have introduced.
# We have a separate function for each of the accuracy, precision, recall and F1 score.
# This file shows the example of each Metrics on titanic dataset.

import pandas as pd
from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score, confusion_matrix
from sklearn.linear_model import LogisticRegression

df = pd.read_csv('https://sololearn.com/uploads/files/titanic.csv')
df['male'] = df['Sex'] == 'male'
X = df[['Pclass', 'male', 'Age', 'Siblings/Spouses', 'Parents/Children', 'Fare']].values
y = df['Survived'].values
model = LogisticRegression()
model.fit(X, y)
y_pred = model.predict(X)

print("accuracy:", accuracy_score(y, y_pred))
print("precision:", precision_score(y, y_pred))
print("recall:", recall_score(y, y_pred))
print("f1 score:", f1_score(y, y_pred))

# Confusion matrix example:
print("confusion matrix: ",confusion_matrix(y,y_pred))

# by convention confusion matrix gives:
# [[TP,FP],
#  [FN, TN]]
# but in sklearn, the returned array is flipped in TP and TN.
# Since negative target values correspond to 0 and positive to 1,
# scikit-learn has ordered them in following order.
# [[TN,FP],
#  [FN, TP]]

# It is important to effectively divide the available data into trainning data and test data.
# Ideally, 80% of data should be used to train the system under development and
# 20% of the available data should be used as test data.

# SK-learn has a inbuilt feature to divide the available data in csv into test and training set.
# By default, it does divide the data as 75:25 ratio, where 75% is the training data while 25% is test data.
# Example:
from sklearn.model_selection import train_test_split

features_train, features_test, target_train, target_test = train_test_split(X,y)
# print("whole dataset:", X.shape, y.shape)
# print("training set:", features_train.shape, target_train.shape)
# print("test set:", features_test.shape, target_test.shape)

# with the above method, everytime the code is executed, the different slicing is made on input data.
# that means that training and test data will change on every execution and thus make it difficult to test.
# So, we can fix the randomness by using the attribute called "random_state" and assigning any random number to it.
# Example:
# train_test_split(X,y, random_state= 2)
# this will fix the problem of randomness in test and train data.


