import numpy as np
import matplotlib.pyplot as plt
from perceptron_mmajew import Perceptron

distance_factor = 0.75

#np.random.seed(0)
size_of_data = 50
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
    for j in range(i + 1, 4):
        perceptron = Perceptron()
        idx = np.where((y_train == i) | (y_train == j))
        X_pair_train = X_train[idx]
        y_pair_train = y_train[idx]
        y_binary_train = np.where(y_pair_train == i, 1, -1)

        perceptron.train(X_pair_train, y_binary_train)
        models.append((i, j, perceptron))

accuracy = 0
for x, true_label in zip(X_test, y_test):
    votes = np.zeros(4)
    for i, j, perceptron in models:
        prediction = perceptron.predict(x)
        if prediction == 1:
            votes[i] += 1
        else:
            votes[j] += 1
    if np.argmax(votes) == true_label:
        accuracy += 1
accuracy /= len(X_test)
print(f'Accuracy: {accuracy * 100:.2f}%')

colors = ['red', 'green', 'blue', 'magenta']
plt.figure(figsize=(10, 6))
for i in range(4):
    plt.scatter(*X_train[y_train == i].T, color=colors[i], label=f'Class {i} Train')
    plt.scatter(*X_test[y_test == i].T, color=colors[i], marker='x', label=f'Class {i} Test')
plt.title(f"One-versus-One Classification with Cluster Distance Factor {distance_factor}")
plt.legend()
plt.show()
