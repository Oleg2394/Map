package ru.netology.manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileOpenManager {

    private Map<String, String> applications = new HashMap<>();

    public void add(String extension, String name) {
        applications.put(extension, name);
    }

    public String getByExtension(String extension) {
        return applications.get(extension);
    }

    public void remove(String extension) {
        applications.remove(extension);
    }

    public Set<String> getAllExtensions() {
        return applications.keySet();
    }

    public Collection<String> getAllApplications() {
        return applications.values();
    }
}