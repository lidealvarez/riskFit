from flask import Flask, request, jsonify
import joblib

app = Flask(__name__)

# Carga el modelo al iniciar la aplicación
modelo = joblib.load('decision_tree_model.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    # Extrae las características
    features = [[
        data['age'],
        data['trainingHoursPerWeek'],
        data['trainingIntensity'],
        data['weeklyTrainingVolume'],
        data['loadProgression']
    ]]
    # Realiza la predicción
    prediction = modelo.predict(features)
    return jsonify({'prediction': prediction[0]})

if __name__ == '__main__':
    app.run(debug=True)
