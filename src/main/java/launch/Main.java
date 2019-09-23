package launch;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.tomcat.util.scan.StandardJarScanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        String port = System.getenv("PORT"); //Til Heroku
        if (port==null){
            port="8080";
        }

        tomcat.setPort(Integer.parseInt(port));
        tomcat.getConnector();

        Context context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
// ---For Servlets
//        File additionWebInfClasses = new File("target/classes");
//        WebResourceRoot resources = new StandardRoot(context);
//        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
//        context.setResources(resources);

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        tomcat.getServer().await();

    }
}
