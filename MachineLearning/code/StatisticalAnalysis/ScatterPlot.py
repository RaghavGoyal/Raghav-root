# in Scatter Plot, we will be creating a plot from the data.
# this plot will be used to draw inferences from the data.
# Scatter plot can be drawn using the library called: matplotlib

# pip install matplotlib.
import matplotlib.pyplot as plot
import pandas as pd

# Plotting the simple dataFrame:
dataFrame = pd.read_csv('./resources/titanic.csv')
# plots Age on 'x' axis and Fare on 'y' axis
plot.scatter(dataFrame['Age'], dataFrame['Fare'])

# Adding labels for 'x' and 'y' axis
plot.xLabel('Age')
plot.yLabel('Fare')