/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoClassDefFoundError
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Modifier
 *  java.util.Enumeration
 *  java.util.Vector
 */
package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.Vector;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;

public class TestSuite
implements Test {
    private String fName;
    private Vector fTests = new Vector(10);
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$junit$framework$Test;

    public static Test createTest(Class theClass, String name) {
        Object test;
        Constructor constructor;
        try {
            constructor = TestSuite.getTestConstructor(theClass);
        }
        catch (NoSuchMethodException e) {
            return TestSuite.warning("Class " + theClass.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
        try {
            if (constructor.getParameterTypes().length == 0) {
                test = constructor.newInstance(new Object[0]);
                if (test instanceof TestCase) {
                    ((TestCase)test).setName(name);
                }
            } else {
                test = constructor.newInstance(new Object[]{name});
            }
        }
        catch (InstantiationException e) {
            return TestSuite.warning("Cannot instantiate test case: " + name + " (" + TestSuite.exceptionToString(e) + ")");
        }
        catch (InvocationTargetException e) {
            return TestSuite.warning("Exception in constructor: " + name + " (" + TestSuite.exceptionToString(e.getTargetException()) + ")");
        }
        catch (IllegalAccessException e) {
            return TestSuite.warning("Cannot access test case: " + name + " (" + TestSuite.exceptionToString(e) + ")");
        }
        return (Test)test;
    }

    public static Constructor getTestConstructor(Class theClass) throws NoSuchMethodException {
        Class[] args = new Class[]{class$java$lang$String == null ? (class$java$lang$String = TestSuite.class$("java.lang.String")) : class$java$lang$String};
        try {
            return theClass.getConstructor(args);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return theClass.getConstructor(new Class[0]);
        }
    }

    public static Test warning(final String message) {
        return new TestCase("warning"){

            protected void runTest() {
                1.fail(message);
            }
        };
    }

    private static String exceptionToString(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter((Writer)stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();
    }

    public TestSuite() {
    }

    public TestSuite(Class theClass) {
        this.fName = theClass.getName();
        try {
            TestSuite.getTestConstructor(theClass);
        }
        catch (NoSuchMethodException e) {
            this.addTest(TestSuite.warning("Class " + theClass.getName() + " has no public constructor TestCase(String name) or TestCase()"));
            return;
        }
        if (!Modifier.isPublic((int)theClass.getModifiers())) {
            this.addTest(TestSuite.warning("Class " + theClass.getName() + " is not public"));
            return;
        }
        Class superClass = theClass;
        Vector names = new Vector();
        while ((class$junit$framework$Test == null ? TestSuite.class$("junit.framework.Test") : class$junit$framework$Test).isAssignableFrom(superClass)) {
            Method[] methods = superClass.getDeclaredMethods();
            for (int i = 0; i < methods.length; ++i) {
                this.addTestMethod(methods[i], names, theClass);
            }
            superClass = superClass.getSuperclass();
        }
        if (this.fTests.size() == 0) {
            this.addTest(TestSuite.warning("No tests found in " + theClass.getName()));
        }
    }

    public TestSuite(Class theClass, String name) {
        this(theClass);
        this.setName(name);
    }

    public TestSuite(String name) {
        this.setName(name);
    }

    public TestSuite(Class[] classes) {
        for (int i = 0; i < classes.length; ++i) {
            this.addTest(new TestSuite(classes[i]));
        }
    }

    public TestSuite(Class[] classes, String name) {
        this(classes);
        this.setName(name);
    }

    public void addTest(Test test) {
        this.fTests.addElement((Object)test);
    }

    public void addTestSuite(Class testClass) {
        this.addTest(new TestSuite(testClass));
    }

    public int countTestCases() {
        int count = 0;
        Enumeration e = this.tests();
        while (e.hasMoreElements()) {
            Test test = (Test)e.nextElement();
            count += test.countTestCases();
        }
        return count;
    }

    public String getName() {
        return this.fName;
    }

    public void run(TestResult result) {
        Enumeration e = this.tests();
        while (e.hasMoreElements() && !result.shouldStop()) {
            Test test = (Test)e.nextElement();
            this.runTest(test, result);
        }
    }

    public void runTest(Test test, TestResult result) {
        test.run(result);
    }

    public void setName(String name) {
        this.fName = name;
    }

    public Test testAt(int index) {
        return (Test)this.fTests.elementAt(index);
    }

    public int testCount() {
        return this.fTests.size();
    }

    public Enumeration tests() {
        return this.fTests.elements();
    }

    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return super.toString();
    }

    private void addTestMethod(Method m, Vector names, Class theClass) {
        String name = m.getName();
        if (names.contains((Object)name)) {
            return;
        }
        if (!this.isPublicTestMethod(m)) {
            if (this.isTestMethod(m)) {
                this.addTest(TestSuite.warning("Test method isn't public: " + m.getName()));
            }
            return;
        }
        names.addElement((Object)name);
        this.addTest(TestSuite.createTest(theClass, name));
    }

    private boolean isPublicTestMethod(Method m) {
        return this.isTestMethod(m) && Modifier.isPublic((int)m.getModifiers());
    }

    private boolean isTestMethod(Method m) {
        String name = m.getName();
        Class[] parameters = m.getParameterTypes();
        Class returnType = m.getReturnType();
        return parameters.length == 0 && name.startsWith("test") && returnType.equals((Object)Void.TYPE);
    }

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName((String)x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }
}

