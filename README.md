# 💻 DAM_entregas

Repositorio de **entregas y ejercicios del módulo de Programación** del ciclo formativo de **Desarrollo de Aplicaciones Multiplataforma (DAM)**.

Cada alumno debe crear su **propio fork de este repositorio**, donde subirá sus ejercicios y prácticas.
El objetivo es mantener el repositorio original limpio, sin commits directos de los alumnos, y centralizar la estructura base del proyecto.

---

## 🧩 Estructura del proyecto

```
DAM_entregas/
│
├── pom.xml                     # POM raíz (proyecto padre)
│
├── alumno_1/
│   ├── pom.xml
│   └── src/main/java/
│       ├── Main.java
│       └── Operaciones.java
│
└── alumno_2/
    ├── pom.xml
    └── src/main/java/
        ├── Main.java
        └── Operaciones.java
```

---

## 🧠 Objetivos

* Mantener una **estructura modular** en Maven con un módulo por alumno.
* Permitir a cada alumno **trabajar en su propio fork** sin modificar el repositorio base.
* Evitar conflictos entre proyecto2.proyecto2.clases duplicadas (por ejemplo, `Main.java`, `Operaciones.java`).
* Facilitar la **revisión de entregas** por parte del docente en los forks individuales.

---

## ⚙️ Requisitos

* **Java 17** o superior
* **Maven 3.8+**
* IDE recomendado: **IntelliJ IDEA**, **Eclipse**, o **VSCode con soporte Maven**

---

## 🚀 Instrucciones para los alumnos

### 1. Crear tu propio fork

1. Haz clic en el botón **“Fork”** arriba a la derecha en GitHub.
2. Elige tu cuenta personal como destino del fork.

### 2. Clonar tu fork

```bash
git clone https://github.com/TU_USUARIO/DAM_entregas.git
cd DAM_entregas
```

### 3. Trabajar en tu módulo

* Usa la carpeta `alumno_1` (o crea una nueva con tu nombre).
* Dentro de `src/main/java/`, añade o modifica tus proyecto2.proyecto2.clases (`Main.java`, `Operaciones.java`, etc.).
* No cambies ni borres módulos de otros compañeros.

### 4. Subir tus cambios

```bash
git add .
git commit -m "Entrega Unidad 2 - Nombre Apellido"
git push origin main
```

> 💡 Todos los commits deben hacerse **en tu fork personal**, nunca en el repositorio original.

---

## 🧑‍🏫 Instrucciones para el profesor

El profesor podrá:

* Revisar los forks de los alumnos directamente en GitHub.
* Hacer `git clone` o `git pull` de cada fork para ejecutar los ejercicios localmente.
* Compilar o ejecutar cada módulo de forma independiente, por ejemplo:

  ```bash
  mvn clean install -pl alumno_1
  ```

---

## 📚 Convenciones y buenas prácticas

* **Nombrado de carpeta:** `alumno_nombre`
  (minúsculas, sin espacios ni acentos)
* **Paquete base:**

  ```java
  package alumno.nombre;
  ```
* **Clases comunes:**
  Pueden compartir nombre entre alumnos (`Main`, `Operaciones`, etc.),
  pero deben estar en paquetes distintos para evitar conflictos.
* **Commits claros:**

  ```
  Entrega Unidad 3 - Nombre Apellido
  ```

---

## 🧾 Licencia

Este repositorio se distribuye bajo licencia **MIT**.
Se puede utilizar y clonar libremente con fines educativos.

---

## 👨‍🏫 Autor

**Williams Infanzón Fernández – Ciclo DAM**

📍 *Instituto [PROMETO by ThePower]*

✉️ Contacto: [[williams.infanzon@ext.thepower.education](mailto:williams.infanzon@ext.thepower.education)]
