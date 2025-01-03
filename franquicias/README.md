# Proyecto: API de Franquicias

Este proyecto es una API REST desarrollada con **Spring Boot** para gestionar franquicias, sucursales y productos. Permite realizar operaciones CRUD y consultar información específica de manera eficiente.

---

## **Requisitos Previos**

### Software necesario:
- Java 17 o superior
- Maven 3.6+
- Docker (opcional)
- MySQL

---

## **Configuración de la Base de Datos MySQL**

### **1. Crear la base de datos**

Ejecuta el siguiente comando para crear la base de datos en tu servidor MySQL:

```sql
CREATE DATABASE franquicias_db;
```

### **3. Configurar Spring Boot**

Edita el archivo `src/main/resources/application.properties` para incluir las credenciales:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/franquicias_db
spring.datasource.username=franquicias_user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

## **Cómo Ejecutar la Aplicación**

### **1. Clonar el repositorio**

```bash
git clone Franquicias-prueba-app-env
```

### **2. Construir y ejecutar el proyecto**

Compila el proyecto con Maven:

```bash
mvn clean install
```

Ejecuta la aplicación:

```bash
mvn spring-boot:run
```

### **3. Acceso**

La aplicación estará disponible en:

```plaintext
http://localhost:8080
```

---

## **Documentación de Endpoints**

### **1. Agregar una nueva franquicia**
**Método:** `POST`  
**URL:** `/franquicias`  
**Cuerpo de la solicitud:**
```json
{
  "nombre": "Franquicia ABC"
}
```

**Respuesta esperada:**
```json
{
  "idFranquicia": 1,
  "nombre": "Franquicia ABC",
  "sucursales": []
}
```

---

### **2. Agregar una nueva sucursal a una franquicia**
**Método:** `POST`  
**URL:** `/franquicias/{id}/sucursales`  
**Cuerpo de la solicitud:**
```json
{
  "nombre": "Sucursal Norte"
}
```

**Respuesta esperada:**
```json
{
  "idSucursal": 1,
  "nombre": "Sucursal Norte",
  "productos": []
}
```

---

### **3. Agregar un nuevo producto a una sucursal**
**Método:** `POST`  
**URL:** `/sucursales/{id}/productos`  
**Cuerpo de la solicitud:**
```json
{
  "nombre": "Producto A",
  "stock": 100
}
```

**Respuesta esperada:**
```json
{
  "idProducto": 1,
  "nombre": "Producto A",
  "stock": 100
}
```

---

### **4. Modificar el stock de un producto**
**Método:** `PUT`  
**URL:** `/productos/{id}/stock`  
**Cuerpo de la solicitud:**
```json
{
  "nuevoStock": 50
}
```

**Respuesta esperada:**
```json
{
  "idProducto": 1,
  "nombre": "Producto A",
  "stock": 50
}
```

---

### **5. Eliminar un producto de una sucursal**
**Método:** `DELETE`  
**URL:** `/productos/{id}`  

**Respuesta esperada:**
```json
{
  "mensaje": "Producto eliminado exitosamente"
}
```

---

### **6. Consultar el producto con mayor stock por sucursal**
**Método:** `GET`  
**URL:** `/franquicias/{id}/productos/mayor-stock`  

**Respuesta esperada:**
```json
[
  {
    "idProducto": 1,
    "nombre": "Producto A",
    "stock": 100,
    "sucursal": "Sucursal Norte"
  }
]
```

---

## **Contribución**

Si deseas contribuir:
1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m "Agregar nueva funcionalidad"`).
4. Envía un pull request.

---

## **Licencia**

Este proyecto está licenciado bajo [tu tipo de licencia, e.g., MIT, Apache 2.0].

