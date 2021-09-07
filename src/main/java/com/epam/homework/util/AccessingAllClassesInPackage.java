package main.java.com.epam.homework.util;

import main.java.com.epam.homework.annotation.Cacheable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Cacheable
public class AccessingAllClassesInPackage {

    public Set<Class> findAllClassesInPackage(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    public Set<Class> findAllClasses() {
        Package[] definedPackages = ClassLoader.getSystemClassLoader().getDefinedPackages();
        Set<Class> classes = new HashSet<>();
        for (Package pack : definedPackages) {
            if (pack.getName().contains("com.epam.homework")) {
                Set<Class> allClassesInPackage = findAllClassesInPackage(pack.getName());
                classes.addAll(allClassesInPackage);
            }
        }
        return classes;
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
