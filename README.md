# 🛒 SupermercadoMVC  

Proyecto académico en Java con arquitectura MVC y conexión a MySQL.

Este proyecto implementa un módulo para consultar empleados por cargo, utilizando:
- Java SE
- Arquitectura MVC
- JDBC
- MySQL
- NetBeans IDE 28

---

## 📌 Funcionalidad principal

El sistema permite:
- Registrar cargos y empleados en una base de datos MySQL.
- Consultar empleados filtrados por el cargo seleccionado desde un JComboBox.
- Mostrar resultados en una tabla (JTable).
- Manejo de DAO para acceso a datos.
- Controladores con ActionListener para eventos.

---

## 🧱 Arquitectura del proyecto

El proyecto está dividido en las siguientes capas:

src
├── controlador
│ └── EmpleadoControlador.java
│
├── modelo
│ ├── Cargo.java
│ ├── CargoDAO.java
│ ├── ConexionBD.java
│ ├── Empleado.java
│ └── EmpleadoDAO.java
│
├── vista
│ ├── FrmEmpleados.java
│ └── FrmEmpleados.form
│
└── App.java

⚙️ Configuración de la conexión

Archivo: src/modelo/ConexionBD.java

private static final String URL = "jdbc:mysql://localhost:3307/supermercado";
private static final String USER = "root";
private static final String PASSWORD = "Proyecto123*";

Ajusta tu contraseña y puerto según tu instalación.

▶️ Cómo ejecutar el proyecto

Instalar JDK 17 o superior
Instalar MySQL y crear la base de datos
Configurar usuario/contraseña
Abrir el proyecto en NetBeans
Agregar el conector MySQL a las librerías
Ejecutar App.java

👨‍🏫 Autor

Jovanny Ocampo
Proyecto para entrega académica.
