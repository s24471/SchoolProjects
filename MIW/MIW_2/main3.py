import numpy as np
import matplotlib.pyplot as plt
from logreg_mmajew import LogisticRegression

def softmax(x):
    exp_x = np.exp(x - np.max(x))
    return exp_x / exp_x.sum(axis=0)

# np.random.seed(0)
distance_factor = 0.75
size_of_data = 50

# Data generation
clusters = [
    {'loc': [2 * distance_factor, 2 * distance_factor], 'scale': [1, 0.5]},
    {'loc': [8 * distance_factor, 8 * distance_factor], 'scale': [1, 0.5]},
    {'loc': [2 * distance_factor, 8 * distance_factor], 'scale': [1, 0.5]},
    {'loc': [8 * distance_factor, 2 * distance_factor], 'scale': [1, 0.5]}
]

X = np.vstack([np.random.normal(loc=cluster['loc'], scale=cluster['scale'], size=(size_of_data, 2)) for cluster in clusters])
y = np.concatenate([np.full(size_of_data, fill_value=i) for i in range(4)])

split = int(0.8 * size_of_data)
X_train = np.vstack([X[i * size_of_data:(i * size_of_data + split)] for i in range(4)])
X_test = np.vstack([X[i * size_of_data + split:(i + 1) * size_of_data] for i in range(4)])
y_train = np.concatenate([y[i * size_of_data:(i * size_of_data + split)] for i in range(4)])
y_test = np.concatenate([y[i * size_of_data + split:(i + 1) * size_of_data] for i in range(4)])
models = []
for i in range(4):
    model = LogisticRegression()
    y_train_binary = (y_train == i).astype(int)
    model.train(X_train, y_train_binary)
    models.append(model)

accuracy = 0
predictions = []
logits = []

for xi, yi in zip(X_test, y_test):
    xi_reshaped = xi.reshape(1, -1)
    probs = np.array([model.predict(xi_reshaped) for model in models])
    logits.append(probs)
    probs_softmax = softmax(probs)
    predicted_class = np.argmax(probs_softmax)
    predictions.append(predicted_class)
    if predicted_class == yi:
        accuracy += 1

accuracy /= len(X_test)
print(f"Accuracy: {accuracy:.2f}")


colors = ['red', 'green', 'blue', 'magenta']
plt.figure(figsize=(10, 6))
for i in range(4):
    plt.scatter(*X_train[y_train == i].T, color=colors[i], label=f'Class {i} Train')
    plt.scatter(*X_test[y_test == i].T, color=colors[i], marker='x', label=f'Class {i} Test')
    min_x, max_x = X[:, 0].min() - 1, X[:, 0].max() + 1
    x_values = np.linspace(min_x, max_x, 300)
    weights, bias = models[i].weights, models[i].bias
    y_values = -(weights[0] * x_values + bias) / weights[1]
    plt.plot(x_values, y_values, color=colors[i], label=f'Decision Boundary for Class {i}')

plt.title('Multiclass Classification using One-vs-All Logistic Regression')
plt.legend()
plt.show()

print("Predictions and actual classes:")
for pred, actual in zip(predictions, y_test):
    print(f"Predicted: {pred}, Actual: {actual}")
