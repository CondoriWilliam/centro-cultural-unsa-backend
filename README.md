# 🎨 Centro Cultural UNSA API

Backend RESTful desarrollado con Spring Boot para la gestión de obras artísticas, autores y exposiciones del Centro Cultural UNSA.

## 🚀 Descripción

Este proyecto consiste en una API RESTful diseñada para centralizar la gestión de obras artísticas, autores y exposiciones culturales. La aplicación implementa mecanismos de autenticación y autorización mediante JWT, persistencia de datos con PostgreSQL y migraciones controladas con Flyway.

---

## ✨ Características

- API RESTful desarrollada con Spring Boot.
- Autenticación y autorización mediante JWT y Spring Security.
- Persistencia de datos con PostgreSQL.
- Migraciones de base de datos con Flyway.
- Arquitectura en capas (Controller, Service y Repository).
- Manejo centralizado de excepciones.
- Documentación automática con OpenAPI/Swagger.
- Pruebas unitarias con Mockito.
- Reportes de cobertura con JaCoCo.

---

## 🏗️ Arquitectura

```text
    Android App
         │
         ▼
    Spring Boot REST API
         │
 ┌───────────────┐
 │ Controllers   │
 ├───────────────┤
 │ Services      │
 ├───────────────┤
 │ Repositories  │
 └───────────────┘
         │
         ▼
     PostgreSQL
```

---

## 🔐 Seguridad

La aplicación implementa autenticación basada en JSON Web Tokens (JWT) utilizando Spring Security.

### Flujo de autenticación

```text
Usuario
   │
   ▼
POST /user/ (crear usuario y contraseña con docTypeId=1 que es de admin)
   │
   ▼
POST /user/authenticate
   │
   ▼
JWT Token
   │
   ▼
Authorization: Bearer <token>
   │
   ▼
Endpoints protegidos
```

---

## 🗄️ Modelo de Datos

### Principales entidades

- Obra
- Autor
- Exposición
- Galería

### Relación simplificada


---

## 📚 Documentación API

### Swagger UI

```bash
http://localhost:3001/swagger-ui/index.html
```
---

## 🧪 Testing

El proyecto incluye:

- Pruebas unitarias con Mockito.
- Cobertura de código mediante JaCoCo.

### Generar reporte

```bash
mvn clean verify
```

### Reporte de cobertura

```bash
target/site/jacoco/index.html
```
---

## 🛠️ Stack Tecnológico

| Tecnología | Descripción |
|------------|-------------|
| Java 17 | Lenguaje principal |
| Spring Boot | Framework Backend |
| Spring Security | Seguridad |
| JWT | Autenticación |
| PostgreSQL | Base de datos |
| Flyway | Migraciones |
| JPA/Hibernate | Persistencia |
| Mockito | Testing |
| JaCoCo | Cobertura |
| OpenAPI/Swagger | Documentación |
| Maven | Gestión de dependencias |
| Git | Control de versiones |

---

## 📸 Capturas

### Swagger UI

<img width="644" height="454" alt="Image" src="https://github.com/user-attachments/assets/5ec9938b-9d1f-424a-b013-b633ca71e0bd" />

### Reporte JaCoCo

<img width="644" height="451" alt="Image" src="https://github.com/user-attachments/assets/60933fe0-f979-4983-b34e-fc0b5aa8e3da" />

---


## 👨‍💻 Mi Contribución

- Diseñé y desarrollé la API RESTful utilizando Spring Boot.
- Implementé autenticación y autorización mediante JWT y Spring Security.
- Modele la persistencia de datos con PostgreSQL y gestioné migraciones mediante Flyway.
- Implementé una arquitectura en capas orientada a bajo acoplamiento y alta cohesión.
- Desarrollé pruebas automatizadas con Mockito y cobertura de código con JaCoCo.
- Documenté los endpoints utilizando OpenAPI/Swagger.

---

## 📄 Licencia

Proyecto desarrollado con fines académicos para el Centro Cultural de la Universidad Nacional de San Agustín (UNSA).
