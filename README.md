

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







# Caso 4 - Pruebas Unitarias de la tabla visits


# Clase implementada

```text
VisitServiceTest.java
```

Ruta:

```text
src/test/java/com/tecsup/petclinic/services/VisitServiceTest.java
```

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





