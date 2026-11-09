# TDD Workshop

## ¿Qué es TDD?

**Test-Driven Development (TDD)** es una forma de desarrollar en la que **primero escribes el test y después el código** que lo hace pasar. Se trabaja en ciclos muy cortos de tres pasos:

1. 🔴 **Red** – Escribe un test pequeño que describa el siguiente comportamiento. Ejecútalo y comprueba que **falla**.
2. 🟢 **Green** – Escribe el código **mínimo** necesario para que el test pase. Nada más.
3. 🔵 **Refactor** – Mejora el código (nombres, duplicados, estructura) manteniendo todos los tests en verde.

Y vuelta a empezar con el siguiente test. Así el diseño va creciendo poco a poco, guiado por los tests.

### **Beneficios de Test-Driven Development (TDD)**

1. **Código más confiable** – Detecta errores temprano y reduce bugs en producción.
2. **Mejor diseño y arquitectura** – Fomenta un código modular, desacoplado y mantenible.
3. **Facilita el refactoring** – Permite mejorar el código sin miedo a romper funcionalidades.
4. **Documentación viva** – Los tests sirven como especificación del comportamiento del sistema.
5. **Menos necesidad de depuración** – Se reducen las pruebas manuales y la necesidad de usar el debugger.
6. **Desarrollo más rápido a largo plazo** – Aunque al principio es más lento, evita problemas costosos en el futuro.
7. **Mejor cobertura de pruebas** – Se garantiza que cada unidad de código tenga al menos un test.
8. **Mayor confianza en el código** – Facilita cambios y nuevas funcionalidades sin introducir errores inesperados.
9. **Código más simple y limpio** – Evita escribir código innecesario al centrarse solo en lo que es probado.
10. **Fomenta el pensamiento crítico** – Obliga a definir bien los requisitos antes de escribir código.

## Kata: FizzBuzz

Esta rama contiene la **kata de FizzBuzz**. Tienes que implementar el método `calculateResponse` de la clase `FizzBuzz` aplicando TDD.

Dado un número entero:

- Si es múltiplo de 3, devuelve `"Fizz"`.
- Si es múltiplo de 5, devuelve `"Buzz"`.
- Si es múltiplo de 3 y 5, devuelve `"FizzBuzz"`.
- En cualquier otro caso, devuelve el número como string.

### Tests que puedes hacer

Escríbelos en `FizzBuzzTest` **de uno en uno**, siguiendo el ciclo Red → Green → Refactor:

- ✅ `testNumberOne_ShouldReturnOne()` → `calculateResponse(1) == "1"`
- ✅ `testNumberTwo_ShouldReturnTwo()` → `calculateResponse(2) == "2"`
- ✅ `testNumberThree_ShouldReturnFizz()` → `calculateResponse(3) == "Fizz"`
- ✅ `testNumberFive_ShouldReturnBuzz()` → `calculateResponse(5) == "Buzz"`
- ✅ `testNumberSix_ShouldReturnFizz()` → `calculateResponse(6) == "Fizz"` (múltiplo de 3)
- ✅ `testNumberTen_ShouldReturnBuzz()` → `calculateResponse(10) == "Buzz"` (múltiplo de 5)
- ✅ `testNumberFifteen_ShouldReturnFizzBuzz()` → `calculateResponse(15) == "FizzBuzz"` (múltiplo de 3 y 5)
- ✅ `testNumberThirty_ShouldReturnFizzBuzz()` → `calculateResponse(30) == "FizzBuzz"`

### Cómo ejecutarlo

- **Tests:** `mvn test`, o el ▶ junto a `FizzBuzzTest` en IntelliJ.
- **Probarlo por consola:** ejecuta la configuración **FizzBuzzConsole** en IntelliJ (o el ▶ junto al `main` de `FizzBuzzConsole`), escribe un número y pulsa Enter.
