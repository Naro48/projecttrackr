package dev.nar.projectrackr;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;
import dev.nar.projectrackr.repositories.CostFactorsRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Map;

public class CostFactorRes {
    private final CostFactorsRepository costFactorsRepository;

    public static Map<String, List<Double>> poids = Map.of(
            "Very Low",List.of(0.75, 1.0, 0.70, 1.0, 1.0, 1.0, 1.0, 1.46, 1.29, 1.42, 1.21, 1.14, 1.24, 1.24, 1.23),
            "Low",List.of(0.88, 0.94, 0.85, 1.0, 1.0, 0.87, 0.87, 1.19, 1.13, 1.17, 1.10, 1.07, 1.10, 1.10, 1.08),
            "Nominal", List.of(1.0),
            "High", List.of(1.15, 1.08, 1.15, 1.11, 1.06, 1.15, 1.07, 0.86, 0.91, 0.86, 0.90, 0.95, 0.91, 0.91, 1.04),
            "Very High", List.of(1.40, 1.16, 1.30, 1.30, 1.21, 1.30, 1.15, 0.71, 0.82, 0.70, 1.0, 1.0, 0.82, 0.83, 1.10),
            "Extra High", List.of(1.0, 1.0, 1.65, 0.015, 1.56, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0)
    );
    public static final List<Double> A = List.of(2.4,3.0,3.6);

    public static final List<Double> B = List.of(1.05,1.12,1.20);

    public static final Double C = 2.5;

    public static final List<Double> D = List.of(0.38,0.35,0.32);





    @OneToMany(mappedBy = "CostFactor",cascade = CascadeType.ALL)
    private List<CostEntity> costs;



    static CostFactorsEntity RELY = new CostFactorsEntity("RELY");

    static CostFactorsEntity DATA = new CostFactorsEntity("DATA");

    static CostFactorsEntity CPLX = new CostFactorsEntity("CPLX");

    static CostFactorsEntity TIME = new CostFactorsEntity("TIME");

    static CostFactorsEntity STOR = new CostFactorsEntity("STOR");

    static CostFactorsEntity VIRT = new CostFactorsEntity("VIRT");

    static CostFactorsEntity TURN = new CostFactorsEntity("TURN");

    static CostFactorsEntity ACAP = new CostFactorsEntity("ACAP");

    static CostFactorsEntity AEXP = new CostFactorsEntity("AEXP");

    static CostFactorsEntity PCAP = new CostFactorsEntity("PCAP");

    static CostFactorsEntity VEXP = new CostFactorsEntity("VEXP");

    static CostFactorsEntity LEXP = new CostFactorsEntity("LEXP");

    static CostFactorsEntity MODP = new CostFactorsEntity("MODP");

    static CostFactorsEntity TOOL = new CostFactorsEntity("TOOL");

    static CostFactorsEntity SCED = new CostFactorsEntity("SCED");


    public static List<CostFactorsEntity> costFactorsEntityList = List.of(RELY,DATA,CPLX,TIME,STOR
            ,VIRT,TURN,ACAP,AEXP,PCAP,VEXP
            ,LEXP,MODP,TOOL,SCED);



    public CostFactorRes(CostFactorsRepository costFactorsRepository) {
        this.costFactorsRepository = costFactorsRepository;
    }
}
