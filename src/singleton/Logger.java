package singleton;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public final class Logger {

    private static volatile Logger instance;

    private final Object lock = new Object();
    private BufferedWriter writer;
    private String fileName = "app.log";

    // Private constructor to prevent external instantiation
    private Logger() {
        openWriter(fileName, /*append=*/true);
        // Ensure the logger is closed when the JVM shuts down
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void write(String message) {
        Objects.requireNonNull(message, "message must not be null");
        synchronized (lock) {
            ensureWriter();
            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                System.err.println("[Logger] Error writing to '" + fileName + "': " + e.getMessage());
            }
        }
    }

    public void setFileName(String newFileName) {
        if (newFileName == null || newFileName.isBlank()) {
            throw new IllegalArgumentException("File name must not be null or blank.");
        }

        synchronized (lock) {
            if (newFileName.equals(this.fileName)) {
                return;
            }

            // Close current writer safely
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    System.err.println("[Logger] Error closing file '" + fileName + "': " + e.getMessage());
                } finally {
                    writer = null;
                }
            }

            // Switch to the new file
            this.fileName = newFileName;
            openWriter(this.fileName, /*append=*/true);
        }
    }

    public void close() {
        synchronized (lock) {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    System.err.println("[Logger] Error closing file '" + fileName + "': " + e.getMessage());
                } finally {
                    writer = null;
                }
            }
        }
    }

    private void ensureWriter() {
        if (writer == null) {
            openWriter(fileName, /*append=*/true);
        }
    }

    private void openWriter(String name, boolean append) {
        Path path = Paths.get(name);
        try {
            if (append) {
                writer = Files.newBufferedWriter(
                        path,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                );
            } else {
                writer = Files.newBufferedWriter(
                        path,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING
                );
            }
        } catch (IOException e) {
            System.err.println("[Logger] Error opening file '" + name + "': " + e.getMessage());
            writer = null;
        }
    }
}
