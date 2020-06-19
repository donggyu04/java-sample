package com.training.jni;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static oshi.util.ExecutingCommand.runNative;

public class HelloJNITest {

    @Test
    public void makeJniCHeaderTest() {
        String resourcePath = "src/main/java/com/training/jni/HelloJNI.java";
        File file = new File(resourcePath);
        Path resourceDirectory = Paths.get("src", "test", "resources");

        String outputDir = resourceDirectory.toAbsolutePath().toString();
        String command = "javac -d " + outputDir + " " + file.getAbsolutePath() + " -h " + outputDir;

        runNative(command);
    }

}
