import numpy as np
import matplotlib.pyplot as plt
from sklearn.datasets import make_moons
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.svm import SVC
from sklearn.ensemble import VotingClassifier
from sklearn.metrics import accuracy_score

# Krok 1: Tworzenie zbioru danych
X, y = make_moons(n_samples=10000, noise=0.4)

# Krok 2: Podział danych na zbiory uczący i testowy
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Krok 3: Tworzenie klasyfikatorów
svm_clf = SVC(kernel='rbf', probability=True)
log_reg_clf = LogisticRegression(solver='lbfgs', max_iter=1000)
rf_clf = RandomForestClassifier(n_estimators=100)

# Krok 4: Połączenie klasyfikatorów w VotingClassifier
voting_clf = VotingClassifier(
    estimators=[('lr', log_reg_clf), ('rf', rf_clf), ('svc', svm_clf)],
    voting='soft'
)

# Krok 5: Trenowanie modelu VotingClassifier
voting_clf.fit(X_train, y_train) # Trenuje model VotingClassifier na danych treningowych.

# Krok 6: Ocena modelu
train_accuracy = accuracy_score(y_train, voting_clf.predict(X_train)) # Oblicza dokładność modelu na danych treningowych.
test_accuracy = accuracy_score(y_test, voting_clf.predict(X_test)) # Oblicza dokładność modelu na danych testowych.

# Krok 7: Rysowanie wyników
plt.figure(figsize=(10, 10))  # Ustawia rozmiar wykresu.
plt.scatter(X_train[:, 0], X_train[:, 1], c=y_train, marker='.', label='Train')  # Rysuje punkty danych treningowych.
plt.scatter(X_test[:, 0], X_test[:, 1], c=y_test, marker='x', label='Test')  # Rysuje punkty danych testowych.
xx, yy = np.meshgrid(np.linspace(X[:, 0].min() - 1, X[:, 0].max() + 1, 100),  # Tworzy siatkę dla wykresu konturu decyzji.
                     np.linspace(X[:, 1].min() - 1, X[:, 1].max() + 1, 100))
Z = voting_clf.predict(np.c_[xx.ravel(), yy.ravel()])  # Dokonuje predykcji na całej siatce.
Z = Z.reshape(xx.shape)  # Przekształca wynik predykcji do oryginalnego kształtu siatki.
plt.contourf(xx, yy, Z, alpha=0.3)  # Rysuje kontur decyzji na podstawie predykcji VotingClassifier.
plt.xlabel('Feature 1')  # Ustawia etykietę osi x.
plt.ylabel('Feature 2')  # Ustawia etykietę osi y.
plt.title(f"VotingClassifier\nTrain acc:{train_accuracy:.4f}, Test acc:{test_accuracy:.4f}")  # Ustawia tytuł wykresu.
plt.legend()  # Dodaje legendę.
plt.tight_layout()  # Dostosowuje wygląd wykresu.
plt.show()  # Wyświetla wykres.
plt.savefig("03_voting_classifier.png")  # Zapisuje wykres do pliku.
