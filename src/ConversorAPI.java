import ClasesJson.JsonResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class ConversorAPI {
    private static final String API_KEY = "API_KEY"; // ¡Reemplaza la clave!
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> codigosMonedas = new HashMap<>();
    private static final List<String> historial = new ArrayList<>(); // Array del historial

    public static void main(String[] args) {
        inicializarCodigosMonedas();
        mostrarMenuDinamico();
    }

    public static void inicializarCodigosMonedas() {
        codigosMonedas.put("USD", "Dólar estadounidense");
        codigosMonedas.put("ARS", "Peso argentino");
        codigosMonedas.put("BRL", "Real brasileño");
        codigosMonedas.put("COP", "Peso colombiano");
        // Añade más monedas aquí...
    }

    public static void mostrarMenuDinamico() {
        while (true) {
            System.out.println("\n=== CONVERSOR DE MONEDAS DINÁMICO ===");

            // Monedas disponibles
            System.out.println("Monedas disponibles:");
            int index = 1;
            List<String> codigos = new ArrayList<>(codigosMonedas.keySet());
            for (String codigo : codigos) {
                System.out.printf("%d) %s (%s)%n", index++, codigosMonedas.get(codigo), codigo);
            }
            System.out.println("0) Salir");

            // Selección de moneda origen
            System.out.print("\nElija la moneda de origen (número): ");
            int opcionOrigen = scanner.nextInt();
            if (opcionOrigen == 0) {
                mostrarHistorial(); // Mostrar historial antes de salir
                break;
            }
            String monedaOrigen = codigos.get(opcionOrigen - 1);

            // Selección de moneda destino
            System.out.print("Elija la moneda de destino (número): ");
            int opcionDestino = scanner.nextInt();
            String monedaDestino = codigos.get(opcionDestino - 1);

            // Cantidad a convertir
            System.out.printf("Ingrese la cantidad en %s: ", codigosMonedas.get(monedaOrigen));
            double cantidad = scanner.nextDouble();

            // Conversión y registro en historial
            JsonResponse response = obtenerTasasDeCambio(monedaOrigen);
            if (response != null && "success".equals(response.result)) {
                double tasaDestino = response.conversion_rates.get(monedaDestino);
                double resultado = cantidad * tasaDestino;
                String operacion = String.format("%.2f %s → %.2f %s",
                        cantidad, monedaOrigen, resultado, monedaDestino);

                historial.add(operacion); // Guardar en historial
                System.out.println("\n Conversión: " + operacion);
            } else {
                System.err.println("Error al obtener las tasas.");
            }
        }
    }

    public static void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("\nNo se realizaron conversiones.");
        } else {
            System.out.println("\n=== HISTORIAL DE CONVERSIONES ===");
            for (String operacion : historial) {
                System.out.println(operacion);
            }
        }
    }

    public static JsonResponse obtenerTasasDeCambio(String monedaBase) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + monedaBase))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), JsonResponse.class);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}