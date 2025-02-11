import os
import pandas as pd
import numpy as np
import joblib
import argparse

def main():
    parser = argparse.ArgumentParser(description='Predict score using the trained model.')
    parser.add_argument('--model_path', type=str, default='models/model.pkl', help='Path to the trained model.')
    parser.add_argument('--input_data', type=str, required=True, help='Input data as a JSON string or CSV file path.')
    args = parser.parse_args()
    
    if not os.path.exists(args.model_path):
        print(f"Model file not found at {args.model_path}. Please train the model first.")
        return
    model = joblib.load(args.model_path)
    
    if args.input_data.endswith('.csv'):
        input_df = pd.read_csv(args.input_data)
    else:
        import json
        try:
            input_dict = json.loads(args.input_data)
            input_df = pd.DataFrame([input_dict])
        except json.JSONDecodeError:
            print("Input data is neither a valid CSV file nor a valid JSON string.")
            return
    
    input_df['unemp_wage_interaction'] = input_df['unemp'] * input_df['wage']
    
    prediction = model.predict(input_df)
    
    print(f"Predicted score: {prediction[0]:.2f}")

if __name__ == '__main__':
    main()
