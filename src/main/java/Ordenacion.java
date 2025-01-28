// Clase Ordenacion
public class Ordenacion {

  // Contador de comparaciones para Merge Sort
  private static int comparaciones;

  // Método Bubble Sort
  public static int bubbleSort(int[] array) {
    int comparaciones = 0; // Contador de comparaciones
    int tamaño = array.length;
    int aux; // Variable auxiliar para intercambio

    for (int i = 0; i < tamaño - 1; i++) {
      for (int j = 0; j < tamaño - i - 1; j++) {
        comparaciones++;
        if (array[j] > array[j + 1]) {
          aux = array[j];
          array[j] = array[j + 1];
          array[j + 1] = aux;
        }
      }
    }
    return comparaciones;
  }

  // Método Insertion Sort
  public static int insertionSort(int[] array) {
    int comparaciones = 0;

    for (int i = 1; i < array.length; i++) {
      int valorActual = array[i];
      int j = i - 1;

      while (j >= 0 && array[j] > valorActual) {
        comparaciones++;
        array[j + 1] = array[j];
        j--;
      }

      if (j >= 0) comparaciones++; // Última comparación que rompe el while
      array[j + 1] = valorActual;
    }
    return comparaciones;
  }

  // Método Selection Sort
  public static int selectionSort(int[] array) {
    int comparaciones = 0;
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
      int minIdx = i;

      for (int j = i + 1; j < n; j++) {
        comparaciones++;
        if (array[j] < array[minIdx]) {
          minIdx = j;
        }
      }

      int temp = array[minIdx];
      array[minIdx] = array[i];
      array[i] = temp;
    }
    return comparaciones;
  }

  // Método Merge Sort
  public static int mergeSort(int[] array) {
    comparaciones = 0; // Reinicia el contador de comparaciones
    mergeSortRecursivo(array);
    return comparaciones;
  }

  private static void mergeSortRecursivo(int[] array) {
    int tamañoArray = array.length;
    if (tamañoArray < 2) return;

    int indexMedio = tamañoArray / 2;
    int[] mitadIzq = new int[indexMedio];
    int[] mitadDer = new int[tamañoArray - indexMedio];

    for (int i = 0; i < indexMedio; i++) {
      mitadIzq[i] = array[i];
    }
    for (int i = indexMedio; i < tamañoArray; i++) {
      mitadDer[i - indexMedio] = array[i];
    }

    mergeSortRecursivo(mitadIzq);
    mergeSortRecursivo(mitadDer);

    merge(array, mitadIzq, mitadDer);
  }

  private static void merge(int[] array, int[] mitadIzq, int[] mitadDer) {
    int i = 0, j = 0, k = 0;

    while (i < mitadIzq.length && j < mitadDer.length) {
      comparaciones++;
      if (mitadIzq[i] <= mitadDer[j]) {
        array[k++] = mitadIzq[i++];
      } else {
        array[k++] = mitadDer[j++];
      }
    }

    while (i < mitadIzq.length) {
      array[k++] = mitadIzq[i++];
    }
    while (j < mitadDer.length) {
      array[k++] = mitadDer[j++];
    }
  }

  // Método Shell Sort
  public static int shellSort(int[] array) {
    int comparaciones = 0;
    int n = array.length;

    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        int temp = array[i];
        int j = i;

        while (j >= gap && array[j - gap] > temp) {
          comparaciones++;
          array[j] = array[j - gap];
          j -= gap;
        }
        if (j >= gap) comparaciones++;
        array[j] = temp;
      }
    }
    return comparaciones;
  }

  // Método Counting Sort
  public static int countingSort(int[] array) {
    int comparaciones = 0;
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      comparaciones++;
      if (array[i] > max) {
        max = array[i];
      }
    }

    int[] conteo = new int[max + 1];
    for (int i = 0; i < array.length; i++) {
      conteo[array[i]]++;
    }

    int index = 0;
    for (int i = 0; i < conteo.length; i++) {
      while (conteo[i] > 0) {
        array[index++] = i;
        conteo[i]--;
      }
    }
    return comparaciones;
  }

  // Método Radix Sort
  public static int radixSort(int[] array) {
    int comparaciones = 0;
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      comparaciones++;
      if (array[i] > max) {
        max = array[i];
      }
    }

    for (int exp = 1; max / exp > 0; exp *= 10) {
      comparaciones += countingSortPorDígitos(array, exp);
    }
    return comparaciones;
  }

  private static int countingSortPorDígitos(int[] array, int exp) {
    int comparaciones = 0;
    int n = array.length;
    int[] salida = new int[n];
    int[] conteo = new int[10];

    for (int i = 0; i < n; i++) {
      int digito = (array[i] / exp) % 10;
      conteo[digito]++;
    }

    for (int i = 1; i < 10; i++) {
      comparaciones++;
      conteo[i] += conteo[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
      int digito = (array[i] / exp) % 10;
      salida[conteo[digito] - 1] = array[i];
      conteo[digito]--;
    }

    for (int i = 0; i < n; i++) {
      array[i] = salida[i];
    }
    return comparaciones;
  }
}

