# Usamos una imagen oficial de Python como base
FROM python:3.10-slim

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo app.py al contenedor
COPY app.py /app

# Instalamos Flask
RUN pip install flask

# Exponemos el puerto en el que Flask va a correr
EXPOSE 5000

# Definimos el comando para correr la aplicación
CMD ["python", "app.py"]