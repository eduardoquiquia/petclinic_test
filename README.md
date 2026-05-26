# Spring Boot : Application PetClinic

## Features  

### 1.  Unit Test  --> Tag v1.0.0

mvn test -Dspring.profiles.active=h2
## Caso 3 - Pruebas Unitarias de Specialties (Diego)

### Archivos creados
- src/main/java/com/tecsup/petclinic/entities/Specialty.java
- src/main/java/com/tecsup/petclinic/repositories/SpecialtyRepository.java
- src/main/java/com/tecsup/petclinic/services/SpecialtyService.java
- src/main/java/com/tecsup/petclinic/services/SpecialtyServiceImpl.java
- src/test/java/com/tecsup/petclinic/services/SpecialtyServiceTest.java

### Requisitos previos
Antes de correr los tests, configurar Java 17:
export JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home

### Correr todos los tests de Specialties
mvn clean test -Dtest=SpecialtyServiceTest

### Correr cada test por separado
mvn test -Dtest=SpecialtyServiceTest#testFindSpecialtyById
mvn test -Dtest=SpecialtyServiceTest#testFindSpecialtyByName
mvn test -Dtest=SpecialtyServiceTest#testCreateSpecialty
mvn test -Dtest=SpecialtyServiceTest#testUpdateSpecialty
mvn test -Dtest=SpecialtyServiceTest#testDeleteSpecialty

### Resultado esperado
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
