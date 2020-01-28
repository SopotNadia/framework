package service;

import model.TestModel;

public class TestModelCreator {
    private static final String NUMBER_OF_INSTANCES = "number.instances";
    private static final String MACHINE_TYPE = "machine.type";
    private static final String EXPECTED_RESULT = "expected.result";
    private static final String NUMBER_GPU = "number.gpu";
    private static final String GPU_TYPE = "gpu.type";
    private static final String LOCAL_SSD = "local.ssd";
    private static final String COMMITTED_USAGE = "committed.usage";

    public static TestModel withCredentialsFromProperty() {
        return new TestModel(ConfigurationReader.getValue(NUMBER_OF_INSTANCES), ConfigurationReader.getValue(MACHINE_TYPE),
                ConfigurationReader.getValue(EXPECTED_RESULT), ConfigurationReader.getValue(NUMBER_GPU),
                ConfigurationReader.getValue(GPU_TYPE), ConfigurationReader.getValue(LOCAL_SSD), ConfigurationReader.getValue(COMMITTED_USAGE));
    }
}
