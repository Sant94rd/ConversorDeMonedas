Conversor de Monedas con API en Java

Aplicación de consola en Java que convierte entre múltiples monedas utilizando tasas de cambio en tiempo real desde [ExchangeRate-API](https://www.exchangerate-api.com/). Incluye historial de conversiones y menú interactivo.

1. Tecnologías Utilizadas
- Java 11
- Gson (para manejo de JSON)
- HttpClient (Java 11+ para solicitudes HTTP)
- ExchangeRate-API (API gratuita de tasas de cambio)

2. Requisitos Previos
- JDK 11 o superior.
- Clave API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/).
- IDE como IntelliJ IDEA o VS Code.

3. Configuración
- Clona el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/conversor-monedas-java.git

-Añade tu API Key:

-Reemplaza TU_API_KEY en la clase ConversorMoneda.java por tu clave obtenida de ExchangeRate-API.

-Biblioteca Gson:
Si usas Maven, añade en pom.xml: xml


4. Uso
✅ Ejecuta el programa:
bash
cd src/
javac ConversorMoneda.java
java ConversorMoneda

✅ Menú Interactivo:

=== CONVERSOR DE MONEDAS DINÁMICO ===
Monedas disponibles:
1) Dólar estadounidense (USD)
2) Peso argentino (ARS)
3) Real brasileño (BRL)
4) Peso colombiano (COP)
0) Salir

✅ Elija la moneda de origen (número): 1
Elija la moneda de destino (número): 3
Ingrese la cantidad en Dólar estadounidense: 100

✅ Conversión: 100.00 USD → 500.00 BRL
Historial:
Al salir, se mostrarán todas las conversiones realizadas.

5. Estructura del Proyecto
src/
├── ClasesJson/
│   ├── JsonResponse.java      // Modelo para la respuesta JSON
│   
├── ConversorMoneda.java       // Lógica principal y menú
lib/
└── gson-2.10.1.jar            // Biblioteca Gson (si no usas Maven)

6. Características
- Conversión en tiempo real con API.

- Historial de operaciones.

- Soporte para múltiples monedas (USD, ARS, BRL, COP, EUR, etc.).

- Interfaz de consola intuitiva.


📸 Capturas de Pantalla (Opcional)
Menú Principal	

![image](https://github.com/user-attachments/assets/a2f7c727-99bf-42ef-9231-65abafca52b3)

![image](https://github.com/user-attachments/assets/0d35fa6d-2ca5-4294-a8cb-e17e598c335d)

Menú	Historial

![image](https://github.com/user-attachments/assets/fe0fb8e7-7cd9-4b6f-8487-2064efc53ea3)
