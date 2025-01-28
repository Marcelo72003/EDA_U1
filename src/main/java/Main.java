public class Main {

  // Función auxiliar para ejecutar y mostrar resultados de cada algoritmo de búsqueda
  private static void ejecutarYMostrarBusqueda(String algoritmo, int[] array, int valor, BusquedaCallback callback) {
    System.out.print(algoritmo + " - Array: ");
    for (int num : array) {
      System.out.print(num + " ");
    }
    System.out.println();

    int comparaciones = callback.buscar(array, valor);
    System.out.println(algoritmo + " - Valor buscado: " + valor);
    System.out.println("Comparaciones realizadas: " + comparaciones);
    System.out.println();
  }

  // Función auxiliar para ejecutar y mostrar resultados de cada algoritmo de ordenación
  private static void ejecutarYMostrarOrdenacion(String algoritmo, int[] array, OrdenacionCallback callback) {
    // Ordenado inicialmente
    System.out.print(algoritmo + " - Arreglo inicial (ordenado): ");
    for (int num : array) {
      System.out.print(num + " ");
    }
    System.out.println();

    int[] arrayOrdenado = array.clone();
    int comparacionesOrdenado = callback.ordenar(arrayOrdenado);

    System.out.print(algoritmo + " - Arreglo ordenado: ");
    for (int num : arrayOrdenado) {
      System.out.print(num + " ");
    }
    System.out.println("\nComparaciones realizadas (ordenado): " + comparacionesOrdenado);

    // Desordenado
    int[] arrayDesordenado = {110, 91, 84, 34, 12, 8, 3}; // Arreglo desordenado
    System.out.print(algoritmo + " - Arreglo inicial (desordenado): ");
    for (int num : arrayDesordenado) {
      System.out.print(num + " ");
    }
    System.out.println();

    int comparacionesDesordenado = callback.ordenar(arrayDesordenado);

    System.out.print(algoritmo + " - Arreglo ordenado desde desordenado: ");
    for (int num : arrayDesordenado) {
      System.out.print(num + " ");
    }
    System.out.println("\nComparaciones realizadas (desordenado): " + comparacionesDesordenado);

    System.out.println();
  }

  public static void main(String[] args) {
    int[] array = {3, 8, 12, 34, 84, 91, 110};

    // === Actividad 1: Algoritmos de Búsqueda ===
    System.out.println("\n=== Comparaciones de Algoritmos de Búsqueda ===");
    ejecutarYMostrarBusqueda("Búsqueda Secuencial", array, 45, Busqueda::busquedaSecuencial);
    ejecutarYMostrarBusqueda("Búsqueda Secuencial", array, 54, Busqueda::busquedaSecuencial);
    ejecutarYMostrarBusqueda("Búsqueda Binaria", array, 45, Busqueda::busquedaBinaria);
    ejecutarYMostrarBusqueda("Búsqueda Binaria", array, 54, Busqueda::busquedaBinaria);
    ejecutarYMostrarBusqueda("Búsqueda por Interpolación", array, 45, Busqueda::busquedaInterpolacion);
    ejecutarYMostrarBusqueda("Búsqueda por Interpolación", array, 54, Busqueda::busquedaInterpolacion);

    // === Actividad 2: Algoritmos de Ordenación ===
    System.out.println("\n=== Comparaciones de Algoritmos de Ordenación ===");
    ejecutarYMostrarOrdenacion("Bubble Sort", array, Ordenacion::bubbleSort);
    ejecutarYMostrarOrdenacion("Insertion Sort", array, Ordenacion::insertionSort);
    ejecutarYMostrarOrdenacion("Selection Sort", array, Ordenacion::selectionSort);
    ejecutarYMostrarOrdenacion("Merge Sort", array, Ordenacion::mergeSort);
    ejecutarYMostrarOrdenacion("Shell Sort", array, Ordenacion::shellSort);
    ejecutarYMostrarOrdenacion("Counting Sort", array, Ordenacion::countingSort);
    ejecutarYMostrarOrdenacion("Radix Sort", array, Ordenacion::radixSort);
  }

  // Interfaz funcional para pasar métodos de búsqueda como parámetros
  @FunctionalInterface
  interface BusquedaCallback {
    int buscar(int[] array, int valor);
  }

  // Interfaz funcional para pasar métodos de ordenación como parámetros
  @FunctionalInterface
  interface OrdenacionCallback {
    int ordenar(int[] array);
  }
}
