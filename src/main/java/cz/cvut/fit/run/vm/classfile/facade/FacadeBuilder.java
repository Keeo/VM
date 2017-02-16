package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.ClassProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Keo on 22.12.2015.
 */
public class FacadeBuilder {

    private static FacadeBuilder facadeBuilder;

    private Map<String, FMethod> fMethodMap;
    private Map<String, FClass> fClassMap;

    private ClassProvider classProvider;

    private FacadeBuilder() {
        fMethodMap = new HashMap<>();
        fClassMap = new HashMap<>();
    }

    public static FacadeBuilder getInstance() {
        if (facadeBuilder == null) {
            facadeBuilder = new FacadeBuilder();
        }
        return facadeBuilder;
    }

    void setClassProvider(ClassProvider classProvider) {
        this.classProvider = classProvider;
    }

    /*FMethod getFMethod(Method method) {
    }

    FClass getFClass(short classFileIndex) {

        if (fClassMap.containsKey(classFileIndex)){
            return fClassMap.get(classFileIndex);
        } else {

        }
    }*/
}
