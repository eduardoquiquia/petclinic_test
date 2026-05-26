cat > README.md << 'ENDOFFILE'
# PetClinic Test - Pruebas Unitarias

## Caso 3 - Pruebas Unitarias de Specialties
**Alumno:** Diego

---

### Archivos creados

| Archivo | Ubicacion |
|---------|-----------|
| Specialty.java | src/main/java/com/tecsup/petclinic/entities/ |
| SpecialtyRepository.java | src/main/java/com/tecsup/petclinic/repositories/ |
| SpecialtyService.java | src/main/java/com/tecsup/petclinic/services/ |
| SpecialtyServiceImpl.java | src/main/java/com/tecsup/petclinic/services/ |
| SpecialtyServiceTest.java | src/test/java/com/tecsup/petclinic/services/ |

---

### Requisitos previos

Configurar Java 17 antes de correr los tests:

```bash
export JAVA_HOME=/Users/diego/Library/Java/JavaVirtualMachines/corretto-17.0.18/Contents/Home
```

---

### Correr todos los tests

```bash
mvn clean test -Dtest=SpecialtyServiceTest
```

---

### Correr cada test por separado

```bash
mvn test -Dtest=SpecialtyServiceTest#testFindSpecialtyById
```

```bash
mvn test -Dtest=SpecialtyServiceTest#testFindSpecialtyByName
```

```bash
mvn test -Dtest=SpecialtyServiceTest#testCreateSpecialty
```

```bash
mvn test -Dtest=SpecialtyServiceTest#testUpdateSpecialty
```

```bash
mvn test -Dtest=SpecialtyServiceTest#testDeleteSpecialty
```

---

### Resultado esperado
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS