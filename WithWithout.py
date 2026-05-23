import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
import numpy as np

np.random.seed(0)

X=np.random.rand(100,1)
Y=2+3*X+np.random.rand(100,1)

model_withBias=LinearRegression(fit_intercept=True)
model_withBias.fit(X,Y)

y_bias_pred=model_withBias.predict(X)

model_withoutBias=LinearRegression(fit_intercept=False)
model_withoutBias.fit(X,Y)

y_nobias_pred=model_withoutBias.predict(X)

plt.scatter(X,Y,color='green',label='Actual data')

plt.plot(X,y_bias_pred,color='red',label='with bias')

plt.plot(X,y_nobias_pred,color='blue',label='without bias')

plt.xlabel('X')
plt.ylabel('Y')
plt.legend()
plt.show()


print("slope for with bias",model_withBias.coef_[0])
print("\n Intecept with bias",model_withBias.intercept_)

print("\n slope for without bias",model_withoutBias.coef_[0])
