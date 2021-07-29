package com.dadi.j;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                System.out.println(fileName);
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] bytes = null;
                try {
                    bytes = new byte[is.available()];
                    is.read(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return defineClass(name, bytes, 0, bytes.length);
            }
        };

        Object obj = classLoader.loadClass("com.dadi.j.Demo2");
       /* System.out.println(obj.getClass());
        System.out.println(obj instanceof com.dadi.j.Demo2);
        */

    }
}
