package br.com.check.HealthFazenda.model.Enums;

public enum Autorizador {
    AM(4L, "Amazonas"),
    BA(5L, "Bahia"),
    GO(8L, "Goiás"),
    MT(10L, "Mato Grosso"),
    MS(11L, "Mato Grosso do Sul"),
    MG(12L, "Minas Gerais"),
    PR(15L, "Paraná"),
    PE(16L, "Pernambuco"),
    RS(20L, "Rio Grande do Sul "),
    SP(24L, "São Paulo");

    private final Long id;

    private final String name;

    Autorizador(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public enum SVAN {
        MA(9L, "Maranhão");

        private final Long id;

        private final String name;

        SVAN(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public enum SVRS {
        AC(1L, "Acre"),
        AL(2L, "Alagoas"),
        AP(3L, "Amapá"),
        CE(6L, "Ceará"),
        ES(7L, "Espírito Santo"),
        PA(13L, "Pará"),
        PB(14L, "Paraíba"),
        PI(17L, "Piauí"),
        RJ(18L, "Rio de Janeiro"),
        RN(19L, "Rio Grande do Norte"),
        RO(21L, "Rondônia"),
        RR(22L, "Roraima"),
        SC(23L, "Santa Catarina"),
        SE(25L, "Sergipe"),
        TO(26L, "Tocantins"),
        DF(27L, "Distrito Federal");

        private final Long id;

        private final String name;

        SVRS(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public enum SVRSConsultaCadastro {
        AC(1L),
        ES(7L),
        PB(14L),
        RN(19L),
        SC(23L);

        private final Long id;

        SVRSConsultaCadastro(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }
}
