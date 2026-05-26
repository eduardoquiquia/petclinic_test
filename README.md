# PetClinic Test - Pruebas Unitarias

## Caso 2 - Pruebas Unitarias de la tabla owners

### Ejecutar prueba de busqueda por ID
Este comando ejecuta la prueba unitaria que valida la busqueda de un dueno mediante su ID.

```bash
mvn test -Dtest=OwnerServiceTest#testFindOwnerById
```

---

### Ejecutar prueba de busqueda por apellido
Este comando ejecuta la prueba unitaria que valida la busqueda de duenos por apellido.

```bash
mvn test -Dtest=OwnerServiceTest#testFindOwnerByLastName
```

---

### Ejecutar prueba de creacion de dueno
Este comando ejecuta la prueba unitaria que valida el registro de un nuevo dueno en la tabla owners.

```bash
mvn test -Dtest=OwnerServiceTest#testCreateOwner
```

---

### Ejecutar prueba de actualizacion de dueno
Este comando ejecuta la prueba unitaria que valida la modificacion de datos de un dueno existente.

```bash
mvn test -Dtest=OwnerServiceTest#testUpdateOwner
```

---

### Ejecutar prueba de eliminacion de dueno
Este comando ejecuta la prueba unitaria que valida la eliminacion de un dueno de la base de datos.

```bash
mvn test -Dtest=OwnerServiceTest#testDeleteOwner
```

---

### Ejecutar todas las pruebas de OwnerServiceTest
Este comando ejecuta todas las pruebas unitarias del caso 2 correspondientes a la tabla owners.

```bash
mvn test -Dtest=OwnerServiceTest
```

---

## Caso 3 - Pruebas Unitarias de Specialties

**Alumno:** Diego

### Archivos creados

| Archivo | Ubicacion |
|---------|-----------|
| Specialty.java | src/main/java/com/tecsup/petclinic/entities/ |
| SpecialtyRepository.java | src/main/java/com/tecsup/petclinic/repositories/ |
| SpecialtyService.java | src/main/java/com/tecsup/petclinic/services/ |
| SpecialtyServiceImpl.java | src/main/java/com/tecsup/petclinic/services/ |
| SpecialtyServiceTest.java | src/test/java/com/tecsup/petclinic/services/ |

### Requisitos previos

Configurar Java 17 antes de correr los tests:

```bash
export JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home
```

### Correr todos los tests

```bash
mvn clean test -Dtest=SpecialtyServiceTest
```

### Correr cada test por separado

```bash
mvn test -Dtest=SpecialtyServiceTest#testFindSpecialtyById
mvn test -Dtest=SpecialtyServiceTest#testFindSpecialtyByName
mvn test -Dtest=SpecialtyServiceTest#testCreateSpecialty
mvn test -Dtest=SpecialtyServiceTest#testUpdateSpecialty
mvn test -Dtest=SpecialtyServiceTest#testDeleteSpecialty
```

### Resultado esperado

```text
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

## Caso 4 - Pruebas Unitarias de la tabla visits

### Clase implementada

```text
VisitServiceTest.java
```

Ruta:

```text
src/test/java/com/tecsup/petclinic/services/VisitServiceTest.java
```

### 1. Ejecutar prueba de busqueda por ID

Metodo:

```java
testFindVisitById()
```

Descripcion:
Esta prueba unitaria valida la busqueda de una visita mediante su identificador (`ID`) dentro de la tabla `visits`.

Objetivo:
Verificar que el sistema pueda encontrar correctamente una visita registrada en la base de datos.

Comando:

```bash
mvn test -Dtest=VisitServiceTest#testFindVisitById
```

---

### 2. Ejecutar prueba de busqueda por Pet ID

Metodo:

```java
testFindVisitByPetId()
```

Descripcion:
Esta prueba unitaria valida la busqueda de visitas asociadas a una mascota especifica.

Objetivo:
Comprobar que el sistema pueda listar correctamente las visitas relacionadas a una mascota registrada.

Comando:

```bash
mvn test -Dtest=VisitServiceTest#testFindVisitByPetId
```

---

### 3. Ejecutar prueba de creacion de visita

Metodo:

```java
testCreateVisit()
```

Descripcion:
Esta prueba unitaria valida el registro de una nueva visita dentro de la tabla `visits`.

Objetivo:
Verificar que el sistema pueda almacenar correctamente una nueva visita en la base de datos.

Comando:

```bash
mvn test -Dtest=VisitServiceTest#testCreateVisit
```

---

### 4. Ejecutar prueba de actualizacion de visita

Metodo:

```java
testUpdateVisit()
```

Descripcion:
Esta prueba unitaria valida la modificacion de informacion de una visita existente.

Objetivo:
Comprobar que el sistema pueda actualizar correctamente los datos de una visita registrada.

Comando:

```bash
mvn test -Dtest=VisitServiceTest#testUpdateVisit
```

---

### 5. Ejecutar prueba de eliminacion de visita

Metodo:

```java
testDeleteVisit()
```

Descripcion:
Esta prueba unitaria valida la eliminacion de una visita de la base de datos.

Objetivo:
Verificar que el sistema elimine correctamente una visita y que esta no pueda ser encontrada posteriormente.

Comando:

```bash
mvn test -Dtest=VisitServiceTest#testDeleteVisit
```

---

### 6. Ejecutar todas las pruebas de VisitServiceTest

Descripcion:
Este comando ejecuta todas las pruebas unitarias implementadas en la clase `VisitServiceTest`.

Objetivo:
Validar el correcto funcionamiento completo de las operaciones CRUD de la tabla `visits`.

Comando:

```bash
mvn test -Dtest=VisitServiceTest
```
