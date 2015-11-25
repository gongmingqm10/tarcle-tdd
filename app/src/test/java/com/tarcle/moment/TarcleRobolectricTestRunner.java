package com.tarcle.moment;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;

import java.io.File;
import java.util.Properties;

public class TarcleRobolectricTestRunner extends RobolectricTestRunner {
    /**
     * Creates a runner to run {@code testClass}. Looks in your working directory for your AndroidManifest.xml file
     * and res directory by default. Use the {@link Config} annotation to configure.
     *
     * @param testClass the test class to be run
     * @throws org.junit.runners.model.InitializationError if junit says so
     */
    public TarcleRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        String path = "src/main/AndroidManifest.xml";

        // android studio has a different execution root for tests than pure gradle
        // so we avoid here manual effort to get them running inside android studio
        if (!new File(path).exists()) {
            path = "app/" + path;
        }

        config = overwriteConfig(config, "manifest", path);
        return super.getAppManifest(config);
    }

    protected Config.Implementation overwriteConfig(
            Config config, String key, String value) {
        Properties properties = new Properties();
        properties.setProperty(key, value);
        return new Config.Implementation(config,
                Config.Implementation.fromProperties(properties));
    }

    @Override
    protected int pickSdkVersion(Config config, AndroidManifest manifest) {
        config = overwriteConfig(config, "sdk", "18");
        return super.pickSdkVersion(config, manifest);
    }
}
