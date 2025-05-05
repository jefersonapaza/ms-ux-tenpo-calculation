import random
from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/percentage', methods=['GET'])
def get_percentage():
    # Generamos un porcentaje aleatorio entre 0 y 100
    percentage = random.randint(0, 100)

    # Devolvemos el porcentaje en formato JSON
    return jsonify({"percentage": percentage})

if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=5000)