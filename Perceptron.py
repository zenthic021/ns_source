import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import Perceptron
from sklearn.datasets import load_iris
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split

iris=load_iris()

df=pd.DataFrame(iris.data,columns=iris.feature_names)

df['target']=iris.target

df=df[df['target'] != 2]

X=df[['sepal length (cm)','sepal width (cm)']]
Y=df['target']

X_train,X_test,Y_train,Y_test = train_test_split(X,Y,test_size=0.3,random_state=1)

model_bias=Perceptron(fit_intercept=True)
model_bias.fit(X_train,Y_train)

y_pred_with_bias=model_bias.predict(X_test)

accuracy_score_bias=accuracy_score(Y_test,y_pred_with_bias)


model_nobias=Perceptron(fit_intercept=False)
model_nobias.fit(X_train,Y_train)

y_pred_without_bias=model_nobias.predict(X_test)

accuracy_score_nobias=accuracy_score(Y_test,y_pred_without_bias)

print("Acurracy for bias",accuracy_score_bias)
print("Acurracy for without bias",accuracy_score_nobias)


plt.scatter(X['sepal length (cm)'],X['sepal width (cm)'],c=Y)
plt.xlabel('X')
plt.ylabel('Y')
plt.title('preceptron')
plt.show()










