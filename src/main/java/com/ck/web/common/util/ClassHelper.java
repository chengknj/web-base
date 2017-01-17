package com.ck.web.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读取文件信息
 * Created by ChengK on 2016/12/8 0008.
 */

public class ClassHelper {

    final static Map<String, Class> FW_CACHES_CLASSES = new HashMap();

    protected final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    protected final static Lock CLASS_WRITE = READWRITELOCK.writeLock();

    public static void putCache(String cacheKey, Class value) {
        CLASS_WRITE.lock();
        try {
            if (value != null) {
                FW_CACHES_CLASSES.put(cacheKey, value);
            }
        } finally {
            CLASS_WRITE.unlock();
        }
    }

    public static URL getResource(final String resourceName) {

        URL url = null;

        url = (URL) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return Thread.currentThread().getContextClassLoader()
                        .getResource(resourceName);
            }
        });

        if (url == null) {
            url = (URL) AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return ClassHelper.class.getClassLoader().getResource(
                            resourceName);
                }
            });

        }

        // if (url == null) {
        // url = (URL) AccessController.doPrivileged(new PrivilegedAction() {
        // public Object run() {
        // return callingClass.getClassLoader().getResource(
        // resourceName);
        // }
        // });
        // }

        return url;
    }

    public static Class loadClass(final String className)
            throws ClassNotFoundException {
        Class clazz = FW_CACHES_CLASSES.get(className);
        if (clazz == null) {
            clazz = (Class) AccessController
                    .doPrivileged(new PrivilegedAction() {
                        public Object run() {
                            try {
                                return Thread.currentThread()
                                        .getContextClassLoader().loadClass(
                                                className);
                            } catch (ClassNotFoundException e) {
                                return null;
                            }
                        }
                    });
        }
        if (clazz == null) {
            clazz = (Class) AccessController
                    .doPrivileged(new PrivilegedAction() {
                        public Object run() {
                            try {
                                return Class.forName(className);
                            } catch (ClassNotFoundException e) {
                                return null;
                            }
                        }
                    });
        }

        if (clazz == null) {
            clazz = (Class) AccessController
                    .doPrivileged(new PrivilegedAction() {
                        public Object run() {
                            try {
                                return ClassHelper.class.getClassLoader()
                                        .loadClass(className);
                            } catch (ClassNotFoundException e) {
                                return null;
                            }
                        }
                    });
        }

        // if (clazz == null) {
        // clazz = (Class) AccessController
        // .doPrivileged(new PrivilegedAction() {
        // public Object run() {
        // try {
        // return callingClass.getClassLoader().loadClass(
        // className);
        // } catch (ClassNotFoundException e) {
        // return null;
        // }
        // }
        // });
        // }
        if (clazz == null) {
            throw new ClassNotFoundException(className);
        }
        putCache(className,clazz);
        return clazz;
    }


    public static String toUNIXpath(String filePath) {
        return filePath.replace('\\', '/');
    }

    public static InputStream getResourceAsStream(final String resourceName) {
        InputStream inputStream = (InputStream) AccessController
                .doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        URL url = getResource(resourceName);
                        // System.out.println("url info = " + url);
                        try {
                            if (url != null) {
                                return url.openStream();
                            } else {
                                return new FileInputStream(resourceName);
                            }
                        } catch (IOException e) {
                            return null;
                        }
                    }
                });
        return inputStream;
    }

    public static ClassLoader getClassLoader() {
        ClassLoader clsLoader = Thread.currentThread().getContextClassLoader();
        if (null == clsLoader) {
            clsLoader = ClassLoader.getSystemClassLoader();
        }
        return clsLoader;
    }
}