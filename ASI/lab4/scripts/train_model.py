import os
import pandas as pd
import numpy as np
import joblib
import argparse
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.preprocessing import OneHotEncoder, StandardScaler
from sklearn.ensemble import RandomForestRegressor
from sklearn.pipeline import Pipeline
from sklearn.compose import ColumnTransformer

def main():
    parser = argparse.ArgumentParser(description='Train the predictive model.')
    parser.add_argument('--data_path', type=str, default='data/CollegeDistance.csv', help='Path to the CSV data file.')
    parser.add_argument('--model_path', type=str, default='models/model.pkl', help='Path to save the trained model.')
    args = parser.parse_args()
   
    df = pd.read_csv(args.data_path)
    
    df.replace([np.inf, -np.inf], np.nan, inplace=True)
    df = df.dropna(thresh=len(df.columns) - 1, axis=0) 
    numerical_columns = df.select_dtypes(include=[np.number]).columns.tolist()
    categorical_columns = df.select_dtypes(include=['object']).columns.tolist()
    df[numerical_columns] = df[numerical_columns].fillna(df[numerical_columns].mean())
    df[categorical_columns] = df[categorical_columns].fillna(df[categorical_columns].mode().iloc[0])
    
    df['unemp_wage_interaction'] = df['unemp'] * df['wage']
    
    X = df.drop(['score', 'rownames'], axis=1)
    y = df['score']
    
    preprocessor = ColumnTransformer(
        transformers=[
            ('num', StandardScaler(), ['unemp', 'wage', 'distance', 'tuition', 'education', 'unemp_wage_interaction']),
            ('cat', OneHotEncoder(handle_unknown='ignore'), ['gender', 'ethnicity', 'fcollege', 'mcollege', 'home', 'urban', 'income', 'region'])
        ])
    
    pipeline = Pipeline(steps=[
        ('preprocessor', preprocessor),
        ('regressor', RandomForestRegressor(random_state=42))
    ])
    
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
    
    param_grid = {
        'regressor__n_estimators': [100, 200],
        'regressor__max_depth': [None, 5, 10],
        'regressor__min_samples_split': [2, 5]
    }
    
    grid_search = GridSearchCV(pipeline, param_grid, cv=5, scoring='r2', n_jobs=-1)
    grid_search.fit(X_train, y_train)
    
    print(f"Best Parameters: {grid_search.best_params_}")
    print(f"Best CV R² Score: {grid_search.best_score_:.4f}")
    
    os.makedirs(os.path.dirname(args.model_path), exist_ok=True)
    joblib.dump(grid_search.best_estimator_, args.model_path)
    print(f"Model saved to {args.model_path}")

if __name__ == '__main__':
    main()
