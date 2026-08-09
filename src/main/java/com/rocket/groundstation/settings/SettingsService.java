package com.rocket.groundstation.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SettingsService {
    private static final Path configDir = Paths.get("config");
    private static final Path settingsFile = configDir.resolve("settings.json");

    private static final ObjectMapper om = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static SettingsModel load() throws IOException {
        Files.createDirectories(configDir);
        
        if(Files.notExists(settingsFile)) om.writeValue(settingsFile.toFile(), new SettingsModel());
        
        return om.readValue(settingsFile.toFile(), SettingsModel.class);
    }
    
    public static void save(SettingsModel settings) throws IOException {
        Files.createDirectories(configDir);
        om.writeValue(settingsFile.toFile(), settings);
    }
}
