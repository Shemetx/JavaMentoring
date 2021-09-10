package com.epam.homework.task1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MetaSpaceLoader extends ClassLoader{

  private List<MetaSpaceLoader> metaSpaceLoaders = new ArrayList<>();

    public void generateError() {
        while (true) {
            metaSpaceLoaders.add(new MetaSpaceLoader());
            Class<?> c = null;
            try {
                c = metaSpaceLoaders.get(metaSpaceLoaders.size() - 1).findClass(this.getClass().getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            InputStream resourceAsStream = this.getClass().getResourceAsStream("MapKey.class");
            final byte[] bytes = new byte[resourceAsStream.available()];

            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }
}

