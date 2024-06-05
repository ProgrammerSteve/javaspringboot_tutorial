package com.steven.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service

@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties"),
})
public class MyFirstService {
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    @Value("${my.prop.2}")
    private String customPropertyFromAnotherFile2;
    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    @Value("${my.custom.property}")
    private String customProperty;
    public String getCustomProperty() {
        return customProperty;
    }


    @Value("${my.custom.property.int}")
    private Integer customPropertyInt;
    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }




    //Field Injection
//    @Autowired
//    @Qualifier("mySecondBean")
    private final MyFirstClass myFirstClass;










    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


//    public MyFirstService(
//            //@Qualifier("bean2")MyFirstClass myFirstClass) {
//            MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }
//    @Autowired
//    public void setMyFirstClass(
//            @Qualifier("bean1") MyFirstClass myFirstClass
//    ){
//        this.myFirstClass=myFirstClass;
//    }

    public String tellStory(){
        return "The dependency is saying : "+myFirstClass.sayHello();
    }





    private Environment environment;
    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
    public  String getJavaVersions(){
        return environment.getProperty("java.version");
    }
    public  String getOsName(){
        return environment.getProperty("os.name");
    }
    public String readProp(){
        return environment.getProperty("my.custom.property");
    }



}
