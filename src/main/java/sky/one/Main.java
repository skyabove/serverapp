package sky.one;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sky.one.servlet.MainServlet;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

public class Main {

    private static final int JETTY_PORT = 8080;

    public static void main(String [] args) throws Exception {
        final Server server = new Server(JETTY_PORT);

        final ServletContextHandler servletContextHandler = new ServletContextHandler(SESSIONS);

        server.setHandler(servletContextHandler);

        servletContextHandler.addServlet(new ServletHolder(new MainServlet()), "/authform");

        server.start();

        server.join();
    }
}
