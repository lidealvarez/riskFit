import joblib

# Función para cargar el modelo
def load_model(model_path):
    """
    Carga un modelo desde un archivo especificado.
    :param model_path: Ruta al archivo del modelo.
    :return: Modelo cargado o None si ocurre un error.
    """
    try:
        model = joblib.load(model_path)
        print(f"Modelo cargado desde {model_path}")
        return model
    except FileNotFoundError:
        print(f"Error: No se encontró el archivo {model_path}.")
    except Exception as e:
        print(f"Error al cargar el modelo: {e}")
    return None

# Función para hacer predicciones
def predict(model, input_data):
    """
    Realiza una predicción utilizando el modelo cargado.
    :param model: Modelo cargado.
    :param input_data: Lista de datos de entrada (características).
    :return: Predicción del modelo o un mensaje de error.
    """
    try:
        prediction = model.predict(input_data)
        return prediction
    except Exception as e:
        return {"error": f"Error al hacer la predicción: {e}"}
