public class Busqueda {

  // Búsqueda Secuencial
  public static int busquedaSecuencial(int[] array, int valor) {
    int comparaciones = 0;
    for (int i = 0; i < array.length; i++) {
      comparaciones++;
      if (array[i] == valor) {
        return comparaciones;
      }
    }
    return comparaciones;
  }

  // Búsqueda Binaria
  public static int busquedaBinaria(int[] array, int valor) {
    int comparaciones = 0;
    int inicio = 0;
    int fin = array.length - 1;

    while (inicio <= fin) {
      comparaciones++;
      int medio = (inicio + fin) / 2;
      if (array[medio] == valor) {
        return comparaciones;
      } else if (array[medio] < valor) {
        inicio = medio + 1;
      } else {
        fin = medio - 1;
      }
    }
    return comparaciones;
  }

  // Búsqueda por Interpolación
  public static int busquedaInterpolacion(int[] array, int valor) {
    int comparaciones = 0;
    int inicio = 0;
    int fin = array.length - 1;

    while (inicio <= fin && valor >= array[inicio] && valor <= array[fin]) {
      comparaciones++;
      if (inicio == fin) {
        if (array[inicio] == valor) {
          return comparaciones;
        }
        break;
      }

      int pos = inicio + ((valor - array[inicio]) * (fin - inicio)) / (array[fin] - array[inicio]);
      comparaciones++;

      if (array[pos] == valor) {
        return comparaciones;
      }
      if (array[pos] < valor) {
        inicio = pos + 1;
      } else {
        fin = pos - 1;
      }
    }
    return comparaciones;
  }
}
