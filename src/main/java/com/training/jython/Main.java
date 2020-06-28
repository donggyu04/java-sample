package com.training.jython;

import org.apache.commons.io.IOUtils;
import org.python.core.PyClass;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.net.URL;

import static java.nio.charset.Charset.defaultCharset;

public class Main {

    private static final String TEST_RUNNER_CALLABLE_NAME = "TestRunner";

    public static void main(String[] args) throws IOException {
        new Main().runWithClass();
//        new Main().run();
    }

    private void runWithClass() throws IOException {
        PySystemState pySystemState = new PySystemState();
        PythonInterpreter pythonInterpreter = new PythonInterpreter(null, pySystemState);

//        pythonInterpreter.exec("class ___DieQuietly___: pass");
//        PyClass dieQuietly = (PyClass) pythonInterpreter.get("___DieQuietly___");

        String scriptPath = getClass().getResource("/jython/sample2.py").getPath();
        pySystemState.path.insert(0, new PyString(scriptPath));
        pythonInterpreter.execfile(scriptPath);

        PyObject testRunnerFactory = pythonInterpreter.get(TEST_RUNNER_CALLABLE_NAME);
        PyObject callable = testRunnerFactory.__call__();
        callable.__call__();
    }

    private void run() throws IOException {
        PySystemState pySystemState = new PySystemState();
        PythonInterpreter pythonInterpreter = new PythonInterpreter();

//        pythonInterpreter.get()
        String jythonFileStr = IOUtils.toString(getClass().getResourceAsStream("/jython/sample.py"), defaultCharset());
//        System.out.println("File content\n\n" + jythonFileStr);

        for (int i = 0; i < 2; i++) {
            pythonInterpreter.exec(jythonFileStr);
        }

//        pythonInterpreter.execfile(getClass().getResourceAsStream("/jython/sample.py"));
    }

}
