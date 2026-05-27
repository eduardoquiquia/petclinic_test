# PetClinic Test - Pruebas Unitarias

## Requisitos previos

El proyecto debe ejecutarse con Java 17. Para evitar errores si tu terminal usa Java 25 o Java 26 por defecto, los comandos usan `JAVA_HOME` en la misma linea y el wrapper `./mvnw`.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test
```

---

## Caso 1 - Pruebas Unitarias de la tabla pets

### Ejecutar prueba de busqueda por ID
Este comando ejecuta la prueba unitaria que valida la busqueda de una mascota mediante su ID.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest#testFindPetById
```

---

### Ejecutar prueba de busqueda por nombre
Este comando ejecuta la prueba unitaria que valida la busqueda de mascotas por nombre.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest#testFindPetByName
```

---

### Ejecutar prueba de busqueda por tipo
Este comando ejecuta la prueba unitaria que valida la busqueda de mascotas por tipo.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest#testFindPetByTypeId
```

---

### Ejecutar prueba de busqueda por Owner ID
Este comando ejecuta la prueba unitaria que valida la busqueda de mascotas por dueno.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest#testFindPetByOwnerId
```

---

### Ejecutar prueba de creacion de mascota
Este comando ejecuta la prueba unitaria que valida el registro de una nueva mascota.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest#testCreatePet
```

---

### Ejecutar prueba de actualizacion de mascota
Este comando ejecuta la prueba unitaria que valida la modificacion de datos de una mascota existente.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest#testUpdatePet
```

---

### Ejecutar prueba de eliminacion de mascota
Este comando ejecuta la prueba unitaria que valida la eliminacion de una mascota.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest#testDeletePet
```

---

### Ejecutar todas las pruebas de PetServiceTest
Este comando ejecuta todas las pruebas unitarias del caso 1 correspondientes a la tabla pets.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=PetServiceTest
```

---
# Caso 2 - Pruebas Unitarias de la tabla owners

## Ejecutar prueba de búsqueda por ID
Este comando ejecuta la prueba unitaria que valida la búsqueda de un dueño mediante su ID.

```bash
mvn test -Dtest=OwnerServiceTest#testFindOwnerById
```

---

## Ejecutar prueba de búsqueda por apellido
Este comando ejecuta la prueba unitaria que valida la búsqueda de dueños por apellido.

```bash
mvn test -Dtest=OwnerServiceTest#testFindOwnerByLastName
```

---

## Ejecutar prueba de creación de dueño
Este comando ejecuta la prueba unitaria que valida el registro de un nuevo dueño en la tabla owners.

```bash
mvn test -Dtest=OwnerServiceTest#testCreateOwner
```

---

## Ejecutar prueba de actualización de dueño
Este comando ejecuta la prueba unitaria que valida la modificación de datos de un dueño existente.

```bash
mvn test -Dtest=OwnerServiceTest#testUpdateOwner
```

---

## Ejecutar prueba de eliminación de dueño
Este comando ejecuta la prueba unitaria que valida la eliminación de un dueño de la base de datos.

```bash
mvn test -Dtest=OwnerServiceTest#testDeleteOwner
```

---

## Ejecutar todas las pruebas de OwnerServiceTest
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

### Correr todos los tests

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw clean test -Dtest=SpecialtyServiceTest
```

### Correr cada test por separado

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=SpecialtyServiceTest#testFindSpecialtyById
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=SpecialtyServiceTest#testFindSpecialtyByName
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=SpecialtyServiceTest#testCreateSpecialty
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=SpecialtyServiceTest#testUpdateSpecialty
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test -Dtest=SpecialtyServiceTest#testDeleteSpecialty
```

### Resultado esperado

```text
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

# Caso 4 - Pruebas Unitarias de la tabla visits

## Descripción

En este caso se desarrollaron pruebas unitarias para validar las operaciones CRUD de la tabla `visits` del sistema PetClinic utilizando Spring Boot, JUnit y Maven.

Las pruebas implementadas permiten verificar el correcto funcionamiento de:

- Búsqueda de visitas por ID
- Búsqueda de visitas por mascota
- Registro de nuevas visitas
- Actualización de visitas
- Eliminación de visitas

---

# Ejecución de Pruebas Unitarias

## 1. Ejecutar prueba de búsqueda por ID

Método

```java
testFindVisitById()
```

Descripción  
Esta prueba unitaria valida la búsqueda de una visita mediante su identificador (`ID`) dentro de la tabla `visits`.

Objetivo  
Verificar que el sistema pueda encontrar correctamente una visita registrada en la base de datos.

Comando

```bash
mvn test -Dtest=VisitServiceTest#testFindVisitById
```

---

## 2. Ejecutar prueba de búsqueda por Pet ID

Método

```java
testFindVisitByPetId()
```

Descripción  
Esta prueba unitaria valida la búsqueda de visitas asociadas a una mascota específica.

Objetivo  
Comprobar que el sistema pueda listar correctamente las visitas relacionadas a una mascota registrada.

Comando

```bash
mvn test -Dtest=VisitServiceTest#testFindVisitByPetId
```

---

## 3. Ejecutar prueba de creación de visita

Método

```java
testCreateVisit()
```

Descripción  
Esta prueba unitaria valida el registro de una nueva visita dentro de la tabla `visits`.

Objetivo  
Verificar que el sistema pueda almacenar correctamente una nueva visita en la base de datos.

Comando

```bash
mvn test -Dtest=VisitServiceTest#testCreateVisit
```

---

## 4. Ejecutar prueba de actualización de visita

Método

```java
testUpdateVisit()
```

Descripción  
Esta prueba unitaria valida la modificación de información de una visita existente.

Objetivo  
Comprobar que el sistema pueda actualizar correctamente los datos de una visita registrada.

Comando

```bash
mvn test -Dtest=VisitServiceTest#testUpdateVisit
```

---

## 5. Ejecutar prueba de eliminación de visita

Método

```java
testDeleteVisit()
```

Descripción  
Esta prueba unitaria valida la eliminación de una visita de la base de datos.

Objetivo  
Verificar que el sistema elimine correctamente una visita y que esta no pueda ser encontrada posteriormente.

Comando

```bash
mvn test -Dtest=VisitServiceTest#testDeleteVisit
```

---

## 6. Ejecutar todas las pruebas de VisitServiceTest

Descripción  
Este comando ejecuta todas las pruebas unitarias implementadas en la clase `VisitServiceTest`.

Objetivo  
Validar el correcto funcionamiento completo de las operaciones CRUD de la tabla `visits`.

Comando

```bash
mvn test -Dtest=VisitServiceTest
```



