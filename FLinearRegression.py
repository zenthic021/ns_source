import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

df=pd.read_csv('final_dataset.csv')

print(df.head())

X=df[['size']]
Y=df['price']

plt.scatter(X,Y,color='green')
plt.xlabel('X')
plt.ylabel('Y')
plt.title("scatter plot of x and y")
plt.show()

model=LinearRegression()
model.fit(X,Y)

y_pred=model.predict(X)

plt.scatter(X,Y,label='Actual data')
plt.plot(X,y_pred,label='LinerLine')
plt.xlabel('X')
plt.ylabel('Y')
plt.title("Linear Regression Model")
plt.show()





