package io.spotar.helloworld.resource;

/**
 * @author Viktor Gottfried
 */
public class AboutResource {

    private final String version;

    private final String name;

    public AboutResource(String version, String name) {
        this.version = version;
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }
}
