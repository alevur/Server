package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestServlet;


public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestServlet allRequestsServlet = new AllRequestServlet(); //сервлет, обрабатывает все запросы

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS); //хендлер
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");//кладем сервлет в хендлер; слушает всё

        Server server = new Server(8080); //создание сервера(jetty) и сообщаем на каком порту ему работать
        server.setHandler(context);//передаем в сервер хендлео

        server.start();//запуск сервера
        server.join(); //присоединение основного потока к jetty
    }
}
