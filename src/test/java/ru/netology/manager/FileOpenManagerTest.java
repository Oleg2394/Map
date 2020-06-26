package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    void shouldSetUp() {
        manager.add(".avi", "Media Player");
        manager.add(".mp3", "Winamp");
        manager.add(".html", "Chrome");
    }

    @Test
    void shouldGetByExtension() {
        final String actual = manager.getByExtension(".mp3");
        assertEquals("Winamp", actual);
    }

    @Test
    void shouldRemove() {
        manager.remove(".avi");
        final Collection<String> expected = Set.of("Chrome", "Winamp");
        final Collection<String> actual = Set.copyOf(manager.getAllApplications());
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllExtensions() {
        final Set<String> actual = manager.getAllExtensions();
        Set<String> expected = Set.of(".avi", ".mp3", ".html");
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllApplications() {
        final Set<String> actual = Set.copyOf(manager.getAllApplications());
        Set<String> expected = Set.of("Media Player", "Winamp", "Chrome");
        assertEquals(expected, actual);
    }
}