package io.spotar.helloworld.resource;

/**
 * @author Viktor Gottfried
 */
public class FileResource {

    private final String name;

    public FileResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
