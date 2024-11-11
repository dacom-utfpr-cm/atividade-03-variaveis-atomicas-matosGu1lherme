package Atividade_3;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class EstadosBrasil {
    private static final Map<String, String> ESTADOS;
    private static final Map<String, List<String>> REGIOES;

    static {
        Map<String, String> estados = new HashMap<>();
        estados.put("AC", "Acre");
        estados.put("AL", "Alagoas");
        estados.put("AP", "Amapá");
        estados.put("AM", "Amazonas");
        estados.put("BA", "Bahia");
        estados.put("CE", "Ceará");
        estados.put("DF", "Distrito Federal");
        estados.put("ES", "Espírito Santo");
        estados.put("GO", "Goiás");
        estados.put("MA", "Maranhão");
        estados.put("MT", "Mato Grosso");
        estados.put("MS", "Mato Grosso do Sul");
        estados.put("MG", "Minas Gerais");
        estados.put("PA", "Pará");
        estados.put("PB", "Paraíba");
        estados.put("PR", "Paraná");
        estados.put("PE", "Pernambuco");
        estados.put("PI", "Piauí");
        estados.put("RJ", "Rio de Janeiro");
        estados.put("RN", "Rio Grande do Norte");
        estados.put("RS", "Rio Grande do Sul");
        estados.put("RO", "Rondônia");
        estados.put("RR", "Roraima");
        estados.put("SC", "Santa Catarina");
        estados.put("SP", "São Paulo");
        estados.put("SE", "Sergipe");
        estados.put("TO", "Tocantins");

        ESTADOS = Collections.unmodifiableMap(estados);

        REGIOES = Map.of(
                "Norte", List.of("AC", "AP", "AM", "PA", "RO", "RR", "TO"),
                "Nordeste", List.of("AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"),
                "Centro-Oeste", List.of("DF", "GO", "MT", "MS"),
                "Sudeste", List.of("ES", "MG", "RJ", "SP"),
                "Sul", List.of("PR", "RS", "SC")
        );
    }

    private EstadosBrasil() {}

    public static List<String> getEstadosAbreviados() {
        return List.copyOf(ESTADOS.keySet());
    }

    public static List<String> getEstadosCompletos() {
        return List.copyOf(ESTADOS.values());
    }

    public static String getEstadoPorSigla(String sigla) {
        return ESTADOS.getOrDefault(sigla, "Estado não encontrado");
    }

    public static String getSiglaPorEstado(String estado) {
        return ESTADOS.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equalsIgnoreCase(estado))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("Sigla não encontrada");
    }

    public static List<String> getEstadosPorRegiao(String regiao) {
        List<String> siglas = REGIOES.get(regiao);
        return siglas == null
                ? List.of()
                : siglas.stream().map(ESTADOS::get).collect(Collectors.toList());
    }
}
