# TelcelUsuarios

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

Primera versión del sistema de usuarios de una compañía telefónica ficticia. Contiene dos etapas de aprendizaje de **JDBC con MySQL**: una consulta directa con `Statement` y un CRUD de usuarios basado en una interfaz genérica. La versión completa, con direcciones y teléfonos implementados, está en [telcelusers](https://github.com/Donaldo500/telcelusers).

## Descripción

| Paquete | Contenido |
| --- | --- |
| `com.ebac.modulo33` | Conexión a MySQL con `DriverManager` y listado de la tabla `usuarios` usando `Statement` y `ResultSet`. |
| `com.ebac.modulo34` | Patrón DTO + Model: `UsuarioModel` implementa `OperacionesCRUD<Usuario>` con `PreparedStatement`. Los modelos `DireccionModel` y `TelefonoModel` están definidos como estructura base para la siguiente iteración. |

### Funcionalidades

- Listar todos los usuarios de la base de datos.
- Guardar, consultar por id, actualizar y eliminar usuarios.
- Consultas parametrizadas para evitar inyección SQL.

## Tecnologías utilizadas

- Java 21
- JDBC y MySQL Connector/J 8.0.33
- MySQL 8
- Maven con `exec-maven-plugin`

## Estructura del proyecto

```text
src/main/java/com/ebac/
├── modulo33/
│   ├── Contexto.java          # Listado de usuarios con Statement
│   └── MysqlConnection.java
└── modulo34/
    ├── Contexto.java          # Flujo CRUD de usuarios
    ├── dto/                   # Usuario, Direccion, Telefono
    └── model/                 # OperacionesCRUD<T>, UsuarioModel, DireccionModel, TelefonoModel
```

## Instalación y uso

1. Levanta un servidor MySQL (por ejemplo con Docker):

   ```bash
   docker run --rm --name mysql -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql:8
   ```

2. Crea la base de datos y la tabla:

   ```sql
   CREATE DATABASE modulo33;
   USE modulo33;

   CREATE TABLE usuarios (
       idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       nombre    VARCHAR(100),
       edad      INT
   );
   ```

3. Clona y ejecuta:

   ```bash
   git clone https://github.com/Donaldo500/TelcelUsuarios.git
   cd TelcelUsuarios

   # Listado simple (modulo33)
   mvn compile exec:java -Dexec.mainClass="com.ebac.modulo33.Contexto"

   # CRUD de usuarios (modulo34)
   mvn compile exec:java -Dexec.mainClass="com.ebac.modulo34.Contexto"
   ```

Las credenciales (`root` / `root`) y la URL `jdbc:mysql://localhost:3306/modulo33` se configuran en cada `Contexto.java`.

## Ejemplos de uso

```java
UsuarioModel usuarioModel = new UsuarioModel(connection);

Usuario maria = new Usuario();
maria.setName("Maria");
maria.setEdad(25);
usuarioModel.save(maria);

Usuario encontrado = usuarioModel.getById(1);
System.out.println(encontrado);
// Usuario{idUsuario=1, name=Maria, edad=25}

usuarioModel.deleteById(2);
```

## Contribuciones

Proyecto individual con fines de aprendizaje. Las sugerencias son bienvenidas mediante issues o pull requests.

## Autor

**Donaldo Ibarra** - [@Donaldo500](https://github.com/Donaldo500)
