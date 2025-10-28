import java.util.*;

class OrdenacaoComparacao {
    
    static class Resultado {
        String algoritmo;
        int comparacoes;
        int trocas;
        int iteracoes;
        
        Resultado(String alg, int comp, int troc, int iter) {
            algoritmo = alg;
            comparacoes = comp;
            trocas = troc;
            iteracoes = iter;
        }
    }
    
    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        
        System.out.println("=== COMPARAÇÃO DE ALGORITMOS DE ORDENAÇÃO ===");
        System.out.println();
        
        testarVetor(vetor1, "VETOR 1 - Elementos aleatórios");
        testarVetor(vetor2, "VETOR 2 - Elementos quase ordenados"); 
        testarVetor(vetor3, "VETOR 3 - Elementos em ordem decrescente");
    }
    
    static void testarVetor(int[] original, String descricao) {
        System.out.println("\n" + descricao);
        System.out.println("Array original: " + arrayParaString(original));
        System.out.println("-".repeat(60));
        
        Resultado[] resultados = new Resultado[6];
        
        resultados[0] = bubbleSortComFlag(copiarArray(original));
        resultados[1] = selectionSort(copiarArray(original));
        resultados[2] = cocktailSort(copiarArray(original));
        resultados[3] = combSort(copiarArray(original));
        resultados[4] = gnomeSort(copiarArray(original));
        resultados[5] = bucketSortSimples(copiarArray(original));
        
        exibirTabela(resultados);
        rankearAlgoritmos(resultados);
    }
    
    static Resultado bubbleSortComFlag(int[] arr) {
        int comp = 0, troc = 0, iter = 0;
        boolean houveTroca;
        int tamanho = arr.length;
        
        do {
            houveTroca = false;
            for (int i = 0; i < tamanho - 1; i++) {
                comp++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    troc++;
                    houveTroca = true;
                }
            }
            tamanho--;
            iter++;
        } while (houveTroca);
        
        return new Resultado("Bubble c/ Flag", comp, troc, iter);
    }
    
    static Resultado selectionSort(int[] arr) {
        int comp = 0, troc = 0, iter = 0;
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                int temp = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = temp;
                troc++;
            }
            iter++;
        }
        
        return new Resultado("Selection Sort", comp, troc, iter);
    }
    
    static Resultado cocktailSort(int[] arr) {
        int comp = 0, troc = 0, iter = 0;
        boolean trocou = true;
        int inicio = 0;
        int fim = arr.length - 1;
        
        while (trocou) {
            trocou = false;
            
            for (int i = inicio; i < fim; i++) {
                comp++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    troc++;
                    trocou = true;
                }
            }
            
            if (!trocou) break;
            
            trocou = false;
            fim--;
            
            for (int i = fim - 1; i >= inicio; i--) {
                comp++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    troc++;
                    trocou = true;
                }
            }
            
            inicio++;
            iter++;
        }
        
        return new Resultado("Cocktail Sort", comp, troc, iter);
    }
    
    static Resultado combSort(int[] arr) {
        int comp = 0, troc = 0, iter = 0;
        int n = arr.length;
        int gap = n;
        boolean trocou = true;
        double fator = 1.3;
        
        while (gap > 1 || trocou) {
            gap = (int)(gap / fator);
            if (gap < 1) gap = 1;
            
            trocou = false;
            for (int i = 0; i < n - gap; i++) {
                comp++;
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    troc++;
                    trocou = true;
                }
            }
            iter++;
        }
        
        return new Resultado("Comb Sort", comp, troc, iter);
    }
    
    static Resultado gnomeSort(int[] arr) {
        int comp = 0, troc = 0, iter = 0;
        int pos = 0;
        int n = arr.length;
        
        while (pos < n) {
            iter++;
            if (pos == 0 || arr[pos] >= arr[pos - 1]) {
                comp++;
                pos++;
            } else {
                comp++;
                int temp = arr[pos];
                arr[pos] = arr[pos - 1];
                arr[pos - 1] = temp;
                troc++;
                pos--;
            }
        }
        
        return new Resultado("Gnome Sort", comp, troc, iter);
    }
    
    static Resultado bucketSortSimples(int[] arr) {
        int comp = 0, troc = 0, iter = 0;
        
        if (arr.length == 0) {
            return new Resultado("Bucket Sort", 0, 0, 0);
        }
        
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        int numBaldes = 5;
        ArrayList<ArrayList<Integer>> baldes = new ArrayList<>();
        for (int i = 0; i < numBaldes; i++) {
            baldes.add(new ArrayList<>());
        }
        
        for (int num : arr) {
            int indiceBalde = (num - min) * (numBaldes - 1) / (max - min);
            baldes.get(indiceBalde).add(num);
            iter++;
        }
        
        int indice = 0;
        for (ArrayList<Integer> balde : baldes) {
            for (int i = 1; i < balde.size(); i++) {
                int chave = balde.get(i);
                int j = i - 1;
                while (j >= 0) {
                    comp++;
                    if (balde.get(j) > chave) {
                        balde.set(j + 1, balde.get(j));
                        troc++;
                        j--;
                    } else {
                        break;
                    }
                }
                balde.set(j + 1, chave);
                troc++;
                iter++;
            }
            
            for (int num : balde) {
                arr[indice++] = num;
            }
        }
        
        return new Resultado("Bucket Sort", comp, troc, iter);
    }
    
    static int[] copiarArray(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
    
    static String arrayParaString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    static void exibirTabela(Resultado[] resultados) {
        System.out.printf("%-15s | %-12s | %-8s | %-10s%n", 
                         "ALGORITMO", "COMPARAÇÕES", "TROCAS", "ITERAÇÕES");
        System.out.println("-".repeat(55));
        
        for (Resultado res : resultados) {
            if (res != null) {
                System.out.printf("%-15s | %-12d | %-8d | %-10d%n", 
                                 res.algoritmo, res.comparacoes, res.trocas, res.iteracoes);
            }
        }
    }
    
    static void rankearAlgoritmos(Resultado[] resultados) {
        System.out.println("\n>>> RANKING POR TROCAS (menor é melhor):");
        Arrays.sort(resultados, (a, b) -> a.trocas - b.trocas);
        for (int i = 0; i < resultados.length; i++) {
            if (resultados[i] != null) {
                System.out.printf("%dº: %s (%d trocas)%n", 
                                 i + 1, resultados[i].algoritmo, resultados[i].trocas);
            }
        }
        
        System.out.println("\n>>> RANKING POR ITERAÇÕES (menor é melhor):");
        Arrays.sort(resultados, (a, b) -> a.iteracoes - b.iteracoes);
        for (int i = 0; i < resultados.length; i++) {
            if (resultados[i] != null) {
                System.out.printf("%dº: %s (%d iterações)%n", 
                                 i + 1, resultados[i].algoritmo, resultados[i].iteracoes);
            }
        }
        System.out.println("\n" + "=".repeat(60));
    }
}
