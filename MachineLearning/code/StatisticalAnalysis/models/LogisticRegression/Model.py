# Logistic regression models are build with the help of scikit-learn module.

# install this modele:
# pip install scikit-learn
from sklearn.linear_model import LogisticRegression
import pandas as pd

dataFrame = pd.read_csv('../../resources/titanic.csv')
# the imported package has a class for each kind of model.
# we have initialised a logistic regression model class
model = LogisticRegression()
dataFrame['isMale'] = dataFrame['Sex'] == 'male'
features = dataFrame[['Pclass','isMale','Age','Siblings/Spouses','Parents/Children','Fare']].values
target = dataFrame['Survived'].values

# fit method takes features as 2d numpy array and target as 1d numpy array as the arguments.
# the fit finds the best line that fits the given trainer data.
model.fit(features, target)

# you can access the coefficients of line as:
# print(model.coef_, model.intercept_)

# predict for any ond datapoint/ incomming datapoint.
# print(model.predict([[3, True, 22.0, 1, 0, 7.25]]))


