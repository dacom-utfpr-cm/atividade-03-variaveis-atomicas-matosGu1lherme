package Atividade_3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Siglas dos Estados: " + EstadosBrasil.getEstadosAbreviados());
        System.out.println("Nomes dos Estados: " + EstadosBrasil.getEstadosCompletos());

        String siglaSP = "SP";
        System.out.println("Nome do Estado '" + siglaSP + "': " + EstadosBrasil.getEstadoPorSigla(siglaSP));

        String estadoSP = "São Paulo";
        System.out.println("Sigla do Estado '" + estadoSP + "': " + EstadosBrasil.getSiglaPorEstado(estadoSP));

        String regiaoSudeste = "Sudeste";
        System.out.println("Estados da Região " + regiaoSudeste + ": " + EstadosBrasil.getEstadosPorRegiao(regiaoSudeste));

        String regiaoNordeste = "Nordeste";
        System.out.println("Estados da Região " + regiaoNordeste + ": " + EstadosBrasil.getEstadosPorRegiao(regiaoNordeste));

        String regiaoInvalida = "Oeste";
        System.out.println("Estados da Região " + regiaoInvalida + ": " + EstadosBrasil.getEstadosPorRegiao(regiaoInvalida));
    }
}
