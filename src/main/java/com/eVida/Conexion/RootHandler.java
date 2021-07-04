package com.eVida.Conexion;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RootHandler implements HttpHandler{
	
	  public void handle(HttpExchange he) throws IOException {
          String response = "Server start success if you see this message" + " Port: " + 80;
          File file = new File("src/main/java/com/eVida/Conexion/php/Acelerometro/index.php");
          //System.out.println(file.getPath());
          he.sendResponseHeaders(200, file.length());
          OutputStream os = he.getResponseBody();
          Files.copy(file.toPath(), os);
          
          os.write(response.getBytes());
          os.close();
  }

}
