package model;

public class TestModel {
    private String numberOfInstances;
    private String machineType;
    private String expectedResult;
    private String numberGPU;
    private String GPUType;
    private String localSSD;
    private String committedUsage;


    public TestModel(String numberOfInstances, String machineType, String expectedResult, String numberGPU,
                     String GPUType, String localSSD, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.machineType = machineType;
        this.expectedResult = expectedResult;
        this.numberGPU = numberGPU;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getNumberGPU() {
        return numberGPU;
    }

    public String getGPUType() {
        return GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }
}
