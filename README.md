
# 🚀 **API REST Cálculo de Porcentaje con Caché y Historial** 🧮

¡Bienvenido! Este proyecto es una API REST desarrollada en **Spring Boot** (Java 21) con **Docker** para calcular porcentajes dinámicos, almacenar resultados en caché y mantener un historial de llamadas. Todo esto sigue una **arquitectura hexagonal** para un diseño limpio y escalable. 🛠️

---

## 📋 **Requerimientos Técnicos y Funcionalidades**

### 1. **Cálculo con Porcentaje Dinámico**  
Un endpoint que recibe dos números, los suma y aplica un porcentaje adicional obtenido de un **servicio externo** (mock con valor fijo si no se puede conectar). ✨

### 2. **Caché del Porcentaje**  
El porcentaje obtenido se guarda en **Redis** durante **30 minutos**. Si el servicio externo falla, se utiliza el valor almacenado en caché. Si no hay valor, se devuelve un error. 🔄

### 3. **Historial de Llamadas**  
Se guarda un **historial de llamadas** (fecha, endpoint, parámetros, respuesta/error) de manera **asíncrona** para no afectar el rendimiento. 🗂️

### 4. **Base de Datos PostgreSQL**  
Utilizamos **PostgreSQL** para almacenar el historial de llamadas, corriendo dentro de un contenedor Docker. 📦

### 5. **Swagger para Documentación**  
La API está completamente documentada en **Swagger** para facilitar la interacción con los endpoints. 📖

---

## 🛠 **¿Cómo Correrlo?**

### Paso 1: Clona el Repositorio

```bash
git clone https://github.com/jefersonapaza/ms-ux-tenpo-calculation.git
cd calculation-service
```

### Paso 2: Levanta los Contenedores con Docker Compose

```bash
docker-compose up --build
```

Esto levantará todos los contenedores necesarios 🎉

### Paso 3: Accede a la API

- **API**: [http://localhost:8080](http://localhost:8080) 🌐
- **Redis**: En el puerto `6379` 🔥

---

## 🏗 **Arquitectura Hexagonal** 🏛️

Este proyecto sigue una **arquitectura hexagonal**, lo que permite separar las distintas responsabilidades en capas bien definidas:

1. **Capa de Aplicación**: Contiene la lógica del negocio, incluyendo la parte que maneja los cálculos y el acceso a la caché de Redis. ⚙️
2. **Capa de Infraestructura**: Donde configuramos **Redis** y **PostgreSQL**. Aquí están los detalles de cómo conectar con las bases de datos y otros servicios. 🖥️
3. **Capa de Dominio**: Aquí viven los modelos, como el cálculo del porcentaje y los detalles del historial. 🧠

El diseño sigue el principio de **Separación de Responsabilidades**, asegurando que cada capa tenga una única razón para cambiar. 🙌

---

## 📜 **Kanban en Jira** 📋

El flujo de trabajo del proyecto está gestionado a través de **Kanban** en **Jira**. Los estados del trabajo son:

- **Backlog** ⏳: Tareas por hacer.
- **En Proceso** 🔨: Tareas en ejecución.
- **Revisión** 🔍: Tareas que necesitan ser revisadas.
- **Hecho** ✅: Tareas completadas.


---

## 🔧 **Comandos Útiles**

- **Levantar los contenedores**:  
  ```bash
  docker-compose up --build
  ```

- **Ver los logs**:  
  ```bash
  docker-compose logs -f
  ```

- **Parar los contenedores**:  
  ```bash
  docker-compose down
  ```

---

## 🔍 **Pruebas y Calidad del Código** 🔍

- **Pruebas Unitarias**: Implementadas con **JUnit 5** y **Mockito** para garantizar que todo funcione correctamente.
- **Gestión de Errores**: Manejo adecuado de excepciones con `@ExceptionHandler` y respuestas HTTP correctas. ⚠️

---

**¡Listo para usar!** 🎉🚀 Ahora puedes disfrutar de la API para calcular porcentajes con caché y manejar el historial de llamadas, todo en Docker. ¡Gracias por revisar el proyecto! 😄



## Autor
Jeferson Apaza
