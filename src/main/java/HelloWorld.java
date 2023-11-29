// HelloWorld.java
import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloWorld extends NanoHTTPD {

    public HelloWorld() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Open http://localhost:8080/ in your browser.");
    }

    public static void main(String[] args) {
        try {
            new HelloWorld();
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
        String htmlContent;
        try {
            // Read the content of index.html
            htmlContent = new String(Files.readAllBytes(Paths.get("index.html")));
        } catch (IOException e) {
            htmlContent = "Error reading index.html";
        }

        return newFixedLengthResponse(htmlContent);
    }
}
