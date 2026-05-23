import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

data ={
       'X' : [1,2,3,4,5,6,7,8,9,10],
       'Y' : [2,4,5,4,5,7,8,9,10,12]
    }

df=pd.DataFrame(data)

print("DATA")
print(df)

print("\n statistical data")
print(df.describe())

print("correlation")
print(df.corr())

plt.scatter(df['X'],df['Y'],color='blue')
plt.xlabel('X')
plt.ylabel('Y')
plt.title("scatter plot of x and y")
plt.show()


X=df[['X']]
Y=df['Y']

model=LinearRegression()
model.fit(X,Y)

y_pred=model.predict(X)

plt.scatter(df['X'],df['Y'],color='green',label='Actual Data')
plt.plot(df['X'],y_pred,color='red',label='Linear Regression line')
plt.xlabel('X')
plt.ylabel('Y')
plt.title("Linear Regreasssion model")
plt.legend()
plt.show()

print("\n Inteception" ,model.intercept_)
print("slope",model.coef_[0])

residual =Y-y_pred

plt.scatter(df['X'],residual,color='green')
plt.axhline(y=0,color='red')

plt.xlabel('x')
plt.ylabel('residual')
plt.title('Residual plot')
plt.show()















