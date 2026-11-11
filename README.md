# Tarea evaluable: Registro de pedidos de tienda 📦

Esta rama es el **esqueleto de la entrega**. Tiene la estructura de paquetes, clases vacías con pistas (`TODO`) y el `pom.xml` ya configurado con todo lo que vas a necesitar. El resto lo construyes tú **con TDD**.

## Enunciado

Queremos desarrollar una tienda que procese pedidos de usuarios (diapositiva 91).

- **Usuarios:** id, nombre y apellidos.
- **Pedidos:** id de pedido, id de usuario, estado y precio.
- **Estados:** `DRAFT` → `PROCESSED` → `DISPATCHED` → `DELIVERED`.

## Requisitos mínimos

### Usuarios
- Se puede dar de alta un usuario con id, nombre y apellidos.
- El nombre y los apellidos son obligatorios: ni nulos ni vacíos.
- No se pueden dar de alta dos usuarios con el mismo id.

### Crear pedidos
- Un pedido nuevo empieza en estado `DRAFT`.
- Solo se puede crear un pedido para un usuario que exista.
- El precio tiene que ser mayor que 0.

### Flujo de estados
- Un pedido avanza siempre al estado siguiente: `DRAFT` → `PROCESSED` → `DISPATCHED` → `DELIVERED`.
- No se puede saltar un estado ni retroceder.
- `DELIVERED` es el estado final: un pedido entregado no puede cambiar de estado.

Cuando no se cumpla una regla, se lanza una excepción con un mensaje claro.

## Qué entregar

1. Un registro de pedidos sencillo desarrollado con TDD:
   - Las pruebas se escriben antes que el código.
   - Se recorre el ciclo Red → Green → Refactor.
   - Pruebas unitarias.
   - Al menos una prueba de integración o end-to-end.
   - Todo en verde después de refactorizar.
2. Análisis con SonarQube en local con al menos un **80 % de cobertura**. Incluye una captura de pantalla en este README al entregar.
3. Tests con JUnit 5 y Mockito.
4. Respetar los principios para hacer buenos tests: FIRST, patrón AAA, un comportamiento por test y nombres descriptivos.
5. **[Opcional]** Un ejemplo de test con Cucumber y otro con Testcontainers.

**Obligatorio:** haz un commit en cada fase (rojo, verde, refactor) para que el ciclo se vea en el historial. Como mínimo, al principio, a mitad y al final del desarrollo. Te recomendamos empezar el mensaje del commit por la fase:

```
red: shouldStartInDraftStatus
green: shouldStartInDraftStatus
refactor: extract status transition to OrderStatus
```

## Estructura del esqueleto

| Fichero | Qué tienes que hacer |
|---|---|
| `domain/OrderStatus.java` | Ya tiene los 4 estados. Tú decides dónde vive la regla de transición. |
| `domain/User.java`, `domain/Order.java` | Datos y validaciones del dominio. |
| `repository/UserRepository.java`, `repository/OrderRepository.java` | Interfaces: son las dependencias que vas a mockear. |
| `service/UserService.java`, `service/OrderService.java` | Lógica de negocio. Reciben los repositorios por constructor. |
| `test/.../domain/OrderTest.java`, `UserTest.java` | Tests unitarios del dominio, sin mocks. **Empieza por aquí.** |
| `test/.../service/UserServiceTest.java`, `OrderServiceTest.java` | Tests unitarios de los servicios, con Mockito. |
| `test/.../OrderRegistryIT.java` | Prueba de integración: piezas reales y sin mocks. |
| `test/.../cucumber/RunCucumberTest.java` y `resources/features/orders.feature` | Extra opcional: Cucumber. |

Cada clase tiene comentarios con los requisitos que le tocan e ideas de tests. **Puedes cambiar la estructura** si tu diseño lo pide: las pistas son una guía, no una obligación.

## Cómo ejecutarlo

| Comando | Qué ejecuta | ¿Necesita Docker? |
|---|---|---|
| `mvn test` | Tests unitarios y escenarios de Cucumber | No |
| `mvn verify` | Lo anterior y las pruebas de integración (`*IT`, con `maven-failsafe-plugin`) | Solo si usas Testcontainers |
| `mvn clean verify sonar:sonar -Dsonar.token=TU_TOKEN` | Análisis en SonarQube con la cobertura de JaCoCo | Sí (SonarQube con `docker-compose up`) |

SonarQube estará en http://localhost:9000 y el proyecto aparecerá como **kata-store**. Si `docker-compose up` falla con `vm.max_map_count`, ejecuta `sudo sysctl -w vm.max_map_count=262144` (diapositivas 55–64)

## Criterios de evaluación

| Criterio | Qué se mira | Puntos |
|---|---|---|
| Ciclo TDD visible en el historial | Commits rojo → verde → refactor. Los tests aparecen antes que el código que los hace pasar. | 2,5 |
| Calidad de los tests | AAA, FIRST, un comportamiento por test, nombres descriptivos y casos límite (precio 0, usuario inexistente, transiciones inválidas…). | 2 |
| Uso correcto de Mockito | Mocks y stubs solo para las dependencias (repositorios), nunca para la clase que se prueba. `verify` cuando se comprueba un comportamiento, no por costumbre. | 1,5 |
| Funcionalidad y requisitos | Se cumplen los requisitos mínimos de usuarios, pedidos y flujo de estados. | 1,5 |
| Prueba de integración o end-to-end | Al menos una, que conecte piezas reales sin mocks. | 1 |
| SonarQube | Cobertura ≥ 80 % y captura de pantalla en el README. | 1 |
| Código limpio | Refactor real, nombres claros, sin duplicados ni números mágicos, principios SOLID. | 0,5 |
| **Total** | | **10** |
| Extra: Cucumber | Al menos un escenario ejecutándose con sus steps. | +0,5 |
| Extra: Testcontainers | Una prueba de integración con PostgreSQL en Testcontainers. | +1,0 |

La nota máxima es 10 y para aprobar hace falta un 5.

**Suspenso directo:** el proyecto no compila, hay tests en rojo o el historial no muestra el ciclo TDD.

## Antes de entregar

- [ ] `mvn clean verify` termina en `BUILD SUCCESS`.
- [ ] El historial de commits muestra las fases rojo, verde y refactor.
- [ ] La cobertura en SonarQube es ≥ 80 % y la captura está en este README.
- [ ] No hay ningún token ni contraseña en el repositorio.
- [ ] Los tests siguen el patrón AAA y tienen nombres que explican el comportamiento.

## Material de referencia del taller

| Tema | Diapositivas |
|---|---|
| Tipos de pruebas (unitarias, integración…) | 18 |
| Principios FIRST y patrón AAA | 20–22 |
| Ciclo TDD, dificultades y refactor | 23–29 |
| JUnit 5 (`@ParameterizedTest`, `assertThrows`…) | 40–53 |
| SonarQube y JaCoCo | 55–64 |
| Mockito y test doubles | 67–79 |
| Cucumber y Testcontainers | 80–89 |
| Enunciado y tarea evaluable | 90–92 |

Tienes ejemplos resueltos de Mockito, Cucumber y Testcontainers en la rama `feat/tennis` de este repositorio.

## Mi captura de SonarQube

<!-- Sustituye esta línea por tu captura: ![Cobertura en SonarQube](docs/sonar.png) -->
