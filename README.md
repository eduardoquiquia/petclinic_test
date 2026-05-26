# PetClinic Test - Pruebas Unitarias

## Requisitos previos

El proyecto debe ejecutarse con Java 17. Para evitar errores si tu terminal usa Java 25 o Java 26 por defecto, los comandos usan `JAVA_HOME` en la misma linea y el wrapper `./mvnw`.

```bash
JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home ./mvnw test
```

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
