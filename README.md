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

## **Acceso**

La aplicación estará disponible en la nuve en railway usando los endpoints para la ruta:

```plaintext
https://abundant-imagination-production.up.railway.app/
```

O usando la documentacion en Swagger:

https://abundant-imagination-production.up.railway.app/swagger-ui/index.html#/


## **Configuración de la Base de Datos MySQL**

### **1. Base de datos MYSQL AWS**

La base de datos mySQL se encuentra en un servicio de AWS:

```
ruta = "franquicias-db.crcmek2yaec6.us-east-2.rds.amazonaws.com:3306/franquicias_db"
```

### **2. Crear la base de datos local**

Ejecuta el siguiente comando para crear la base de datos en tu servidor MySQL:

```sql
CREATE DATABASE franquicias_db;
```

### **3. Configurar Spring Boot**

Edita el archivo `src/main/resources/application.properties` para incluir las credenciales:

```properties
server.port = 8080
spring.datasource.url=jdbc:mysql://localhost:3306/franquicias_db
spring.datasource.username=root
spring.datasource.password={configurada por el usuario}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
o suar el acceso de a la base de datos en AWS
```properties
server.port = 8080
spring.datasource.url=jdbc:mysql://franquicias-db.crcmek2yaec6.us-east-2.rds.amazonaws.com:3306/franquicias_db
spring.datasource.username=root
spring.datasource.password=root1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
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

La documentacion en Swagger tambien estará disponible en:

```plaintext
ttp://localhost:8080/swagger-ui/index.html#/
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
    "nombre": "franquicia ABC"
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
    "idSucursal": 2,
    "nombre": "Franquicia ABC SUR",
    "franquicia": {
        "idFranquicia": 1,
        "nombre": "franquicia abc"
    }
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
**URL:** `sucursales/{idSucursal}/productos/{idProducto}`  

**Respuesta esperada:**
```json
{
  "mensaje": "Producto eliminado exitosamente"
}
```

---

### **6. Modificar Stock de un producto**
**Método:** `PUT`  
**URL:** `/productos/{id}/stock`  

**Respuesta esperada:**
```json
{
    "idProducto": 2,
    "nombre": "arroz huila",
    "stock": 30
}
```

---

### **7. Consulta productos con más stock por sucursal para una franquicia**
**Método:** `GET`  
**URL:** `/franquicias/{id}/mayor-stock`  

**Respuesta esperada:**
```json
[
    {
        "idProducto": 8,
        "nombre": "arroz casa",
        "stock": 30,
        "nombreSucursal": "FRANQUISIA LUKE CENTRO",
        "sucursal_id": 1
    },
    {
        "idProducto": 9,
        "nombre": "arroz casa",
        "stock": 16,
        "nombreSucursal": "Franquicia ABC NORTE",
        "sucursal_id": 2
    },
    {
        "idProducto": 10,
        "nombre": "arroz casa",
        "stock": 17,
        "nombreSucursal": "Franquicia ABC SUR",
        "sucursal_id": 3
    }
]
```

---

### **8. (PLUS) Modificar nombre franquicia**
**Método:** `PUT`  
**URL:** `/franquicias/{id}/nombre`  

**Respuesta esperada:**
```json
{
    "idFranquicia": 1,
    "nombre": "franquicia abc"
}
```

---

### **9. (PLUS) Modificar nombre sucursal**
**Método:** `PUT`  
**URL:** `/sucursales/{id}/nombre`  

**Respuesta esperada:**
```json
{
    "idSucursal": 1,
    "nombre": "franquicia abc",
    "franquicia": {
        "idFranquicia": 1,
        "nombre": "FRANQUISIA LUKE NORTE"
    }
}
```

---

### **10. (PLUS) Modificar nombre producto**
**Método:** `PUT`  
**URL:** `/productos/{id}/nombre`  

**Respuesta esperada:**
```json
{
    "idProducto": 11,
    "nombre": "Jabon",
    "stock": 2
}
```

---
