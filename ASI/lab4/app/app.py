from flask import Flask, request, jsonify
import joblib
import pandas as pd
import os
import io

app = Flask(__name__)

MODEL_PATH = os.getenv('MODEL_PATH', 'models/model.pkl')

if not os.path.exists(MODEL_PATH):
    raise FileNotFoundError(f"Model file not found at {MODEL_PATH}. Please train the model first.")

model = joblib.load(MODEL_PATH)

@app.route('/predict', methods=['POST'])
def predict():
    try:
        if request.content_type.startswith('application/json'):
            data = request.get_json(force=True)
            input_df = pd.DataFrame([data])
        elif 'text/csv' in request.content_type or 'application/octet-stream' in request.content_type:
            if 'file' in request.files:
                file = request.files['file']
                if file.filename == '':
                    return jsonify({'error': 'No selected file'}), 400
                stream = io.StringIO(file.stream.read().decode("UTF8"), newline=None)
                input_df = pd.read_csv(stream)
            else:
                csv_data = request.get_data(as_text=True)
                input_df = pd.read_csv(io.StringIO(csv_data))
        else:
            return jsonify({'error': 'Unsupported Media Type. Use application/json or text/csv.'}), 415

        required_columns = ['gender', 'ethnicity', 'fcollege', 'mcollege', 'home', 'urban', 'region',
                            'unemp', 'wage', 'distance', 'tuition', 'education', 'income']
        missing_columns = [col for col in required_columns if col not in input_df.columns]
        if missing_columns:
            return jsonify({'error': f'Missing columns: {", ".join(missing_columns)}'}), 400

        input_df['unemp_wage_interaction'] = input_df['unemp'] * input_df['wage']

        prediction = model.predict(input_df)

        return jsonify({'predicted_score': round(prediction[0], 2)}), 200

    except Exception as e:
        return jsonify({'error': str(e)}), 400

@app.route('/')
def home():
    return "Analizator Wyników API. Użyj endpointu /predict do przewidywania."

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
