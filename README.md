# **Gestión de Inventario** 🏪

> Aplicación de escritorio en **Java** para gestionar el inventario de una tienda

### Herramientas

- [Apache NetBeans](https://netbeans.apache.org/download/index.html)
- [SQLiteStudio](https://sqlitestudio.pl/)
- [Git](https://git-scm.com/downloads)

### Entorno de Desarrollo

Navegamos hasta el directorio donde se descargara el proyecto usando el explorador de arhivos o mediante comandos de terminal.

Para descargar el proyecto a nuestro ordenador ejecutamos las siguiente instrucción:

```bash
git clone https://github.com/munozrc/java-gestion-inventario.git
```

Como paso siguiente cambiamos al directorio de nuestro proyecto con el comando:

```bash
cd java-gestion-inventario/
```

Este proyecto emplea como base de datos [SQLite](https://github.com/xerial/sqlite-jdbc) es por ello que se debe contar con el controlador respectivo para la conexion.

Las dependencias se importan con el siguiente comando:

```bash
scripts/download_dependencies.sh
```

Completado este paso solo resta abrir el proyecto desde el IDE [Apache NetBeans](https://netbeans.apache.org/download/index.html)