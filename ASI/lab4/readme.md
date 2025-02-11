# Asi4

### **a) Sklonowanie Repozytorium** 
1. **Klonowanie Repozytorium GitHub:** 

    ```bash
    git clone https://github.com/PJATK-ASI-2024/ASI_s24471
    cd ASI_s24471
    ``` 
	
### b) Uruchomienie Aplikacji Lokalnie
1. **Instalacja zależności:**
    ```bash
    pip install -r app/requirements.txt
    ```
2. **Trenowanie Modelu:**
    ```bash
    python scripts/train_model.py --data_path data/CollegeDistance.csv --model_path models/model.pkl
    ```
3. **Uruchomienie aplikacji Flask:**
    ```bash
    python app/app.py
    ```

###  **c) Uruchomienie Aplikacji z Wykorzystaniem Dockera**

1. **Budowanie obrazu:** 

    uruchom w katalogu głównym projektu:
    ```bash
    docker build -t s24471/asi4:latest .
    ```
2. **Uruchamianie Dockera:**
    ```bash
    docker run -d -p 5000:5000 --name asi4 s24471/asi4:latest
    ```
3. **Zatrzymanie Dockera:**
    ```bash
    docker stop asi4
    ```

###  **d) Korzystanie z Obrazu Docker z Docker Huba**

1. **Pobranie Obrazu z Docker Huba:**

    ```bash
    docker pull s24471/asi4:latest
    ```
2. **Uruchomienie Kontenera z Pobranego Obrazu:**
    ```bash
    docker run -d -p 5000:5000 --name asi4 s24471/asi4:latest
    ```
3. **Zatrzymanie Dockera:**
    ```bash
    docker stop asi4
    ```

# **Użycie endpointu /predict:**

Przykład z użyciem Postman:

- Ustaw typ na "**Post**"
- Ustaw url na "**http://localhost:5000/predict**"
- Ustaw Header na:
    - Key: Content-Type
    - Value: 
        - "text/csv" w przypadku wyslania pliku .csv
        - "application/json" w przypadku wysyłania json
- Ustaw body na raw, json, w przypadku json-a, binary w przypadku pliku csv

odpowiedź powinna być w formie predykcji wyniku

przykład json:

```json
{
  "gender": "male",
  "ethnicity": "other",
  "fcollege": "no",
  "mcollege": "no",
  "home": "yes",
  "urban": "yes",
  "region": "other",
  "unemp": 6.2,
  "wage": 8.09,
  "distance": 0.2,
  "tuition": 0.88915,
  "education": 12,
  "income": "high"
}
```

przykładowa odpowiedź:
```json
{
    "predicted_score": 48.16
}
```