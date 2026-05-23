import pandas as pd

import numpy as np

import matplotlib.pyplot as plt

from sklearn.linear_model import Linear Regressio

np.random.seed (0)

X=np.random.rand(100,1)

y=2+3*X+np.random.randn (100,1)

data-pd.DataFrame (

data=np.hstack((X,y)), columns=['X','y'] )

plt.figure(figsize=(8,6))

plt.scatter (data['X'], data['y'])

plt.title("scatter plot of x,y")

plt.xlabel("x")

plt.ylabel("y")

plt.show()

correlation=data["X"].corr(data["y"])

print (f"correeltaion is: (correlation}")

model-LinearRegression ()

model.fit(X,y)

intercept-model.intercept_[0]

slope-model.coef [0] [0]

print (f"intercept: (intercept)")

print (f"slope: (slope)")

plt.figure(figsize=(8,6))

plt.scatter(data['X'], data['y'])

plt.plot(data['X'], model.predict(X),color='red')

plt.title("LinearRegression model")

plt.xlabel("x")

plt.ylabel("y")

pit.show()
