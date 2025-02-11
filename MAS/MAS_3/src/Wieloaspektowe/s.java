package Wieloaspektowe;

interface Inspection {
    void inspect();
}

interface Transportation {
    void transport();
}

interface Repair {
    void repair();
}

class BasicInspection implements Inspection {
    @Override
    public void inspect() {
        System.out.println("Performing basic inspection.");
    }
}

class BasicTransportation implements Transportation {
    @Override
    public void transport() {
        System.out.println("Transporting items.");
    }
}

class BasicRepair implements Repair {
    @Override
    public void repair() {
        System.out.println("Performing basic repairs.");
    }
}

class Robot {
    private Inspection inspectionCapability;
    private Transportation transportationCapability;
    private Repair repairCapability;

    public Robot(Inspection ins, Transportation trans, Repair rep) {
        this.inspectionCapability = ins;
        this.transportationCapability = trans;
        this.repairCapability = rep;
    }

    void performInspection() {
        inspectionCapability.inspect();
    }

    void performTransportation() {
        transportationCapability.transport();
    }

    void performRepair() {
        repairCapability.repair();
    }
}
