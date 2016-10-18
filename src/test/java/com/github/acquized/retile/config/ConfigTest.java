package com.github.acquized.retile.config;

import com.github.acquized.retile.test.TestFailException;

import net.cubespace.Yamler.Config.InvalidConfigurationException;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ConfigTest {

    public static final File DIRECTORY = new File("build" + File.separator + "test-output" + File.separator + "config");
    public Config file;

    @Before
    public void createDir() throws TestFailException {
        if((!DIRECTORY.exists()) && (!DIRECTORY.mkdirs())) {
            System.err.println("< TEST FAILED! >");
            System.err.println("Couldn't create Test Output/Config Directory. Are you running this Test in the Main Repository Tree?");
            throw new TestFailException();
        }
    }

    @Test
    public void testCreation() throws InvalidConfigurationException {
        file = new Config(new File(DIRECTORY, "config.yml"));
        file.init();
    }

}