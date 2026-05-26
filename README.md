# Spring Boot : Application PetClinic

## Features  

### 1.  Unit Test  --> Tag v1.0.0

mvn test -Dspring.profiles.active=h2


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
