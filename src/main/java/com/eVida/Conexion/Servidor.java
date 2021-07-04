package com.eVida.Conexion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Synthesizer;

import com.eVida.Recursos.animal;
import com.eVida.Recursos.persona;

public class Servidor extends conexion {

    private controllerBBDD controller = new controllerBBDD();

    public Servidor() throws IOException {
        super("servidor");
    }

    public boolean done = false;

    public void startOver() {
        while (true) {
            try {

                // System.out.println("Esperando...");
                sc = ss.accept(); // Acepta el socket y se queda a la espera de una conexion
                // System.out.println("Cliente en linea...");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                mensajeServidor = entrada.readLine();
                if(mensajeServidor.isEmpty()) {
                	System.out.println("Mensaje al servidor incorrecto");
                }else {
                	System.out.println("Mensaje correcto, longitud: " + mensajeServidor.length());
                }
                mensajeServidor = mensajeServidor.replaceAll("\\s*", ""); mensajeServidor = mensajeServidor.trim();
                List<String> mensaje = Arrays.asList(mensajeServidor.split("-"));                
                
                String data = mensaje.get(1);
                String cod = mensaje.get(0);
                
                
                System.out.println(cod + data);
                if (cod != "") {
                    cod = cod.replaceAll("\\s*", "");
                    cod = cod.trim();
                    System.out.println("codigo : " +cod);
                    if (!Character.isDigit(cod.charAt(0))) {
                        cod = cod.substring(1);
                        System.out.println("No es digito");
                    }else {
                    	System.out.println("Si es digito");
                    	if(cod.length() >4) {
                    		cod = cod.substring(1);
                    	}
                    }

                    System.out.println(cod);
                    if (cod == "10") {
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        salidaCliente.writeUTF("Tabla Perros \n");
                        salidaCliente.flush();
                        System.out.println(cod + " : " + sc.getInetAddress().getHostName());
                        sc.close();
                    } else if (cod == "20") {
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        salidaCliente.writeUTF("Tabla humanos \n");
                        salidaCliente.flush();
                        System.out.println(cod + " : " + sc.getInetAddress().getHostName());
                        sc.close();
                    } else if (cod == "30") {
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        salidaCliente.writeUTF(consultaPrueba() + "\n");
                        salidaCliente.flush();
                        System.out.println(cod + " : " + sc.getInetAddress().getHostName());
                        sc.close();
                    } else if (cod.equals("1001")) {
                        // TODO
                        System.out.println("Cod-1001");
                        List<String> dataUsuario = Arrays.asList(data.split(","));
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        salidaCliente
                                .writeUTF(controller.verificarUsuario(dataUsuario.get(0), dataUsuario.get(1)) + "\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName() + " --> " + dataUsuario.get(0));
                        sc.close();
                    } else if (cod.equals("1002")) {
                        List<String> dataUsuario = Arrays.asList(data.split(","));
                        System.out.println(Arrays.asList(data.split(",")));
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        persona p = new persona(dataUsuario.get(0), dataUsuario.get(1), dataUsuario.get(2),
                                dataUsuario.get(3), dataUsuario.get(4), dataUsuario.get(5));
                        salidaCliente.writeUTF(controller.grabarUsuario(p) + "\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName() + " --> " + dataUsuario.get(0));
                        sc.close();
                    }else if(cod.equals("1003")) {
                    	List<String> dataUsuario = Arrays.asList(data.split(","));
                        System.out.println(Arrays.asList(data.split(",")));
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        String persona = controller.recuperarUsuario(dataUsuario.get(0), dataUsuario.get(1));
                        salidaCliente.writeUTF(persona+"\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName() + " --> " + persona);
                        sc.close();
                        
                    }else if(cod.equals("1004")) {
                    	String razas = controller.getRazasPerros();
                    	System.out.println(razas);
                    	salidaCliente = new DataOutputStream(sc.getOutputStream());
                    	salidaCliente.writeUTF(razas+"\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName());
                        sc.close();
                    }else if(cod.equals("1005")) {
                    	String tipos = controller.getTiposDeAnimales();
                    	System.out.println(tipos);
                    	salidaCliente = new DataOutputStream(sc.getOutputStream());
                    	salidaCliente.writeUTF(tipos+"\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName());
                        sc.close();
                    }else if(cod.equals("1006")) {
                    	String tipos = controller.getTiposDeSangreAnimales();
                    	System.out.println(tipos);
                    	salidaCliente = new DataOutputStream(sc.getOutputStream());
                    	salidaCliente.writeUTF(tipos+"\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName());
                        sc.close();
                    }else if(cod.equals("1007")) {
                    	List<String> dataUsuario = Arrays.asList(data.split(","));
                        System.out.println(Arrays.asList(data.split(",")));
                    	String tipos = controller.getCellId(dataUsuario.get(0) , dataUsuario.get(1));
                    	System.out.println(tipos);
                    	salidaCliente = new DataOutputStream(sc.getOutputStream());
                    	salidaCliente.writeUTF(tipos+"\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName());
                        sc.close();
                    }else if(cod.equals("1008")) {
                    	List<String> dataUsuario = Arrays.asList(data.split(","));
                        System.out.println(Arrays.asList(data.split(",")));
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        persona p = new persona(dataUsuario.get(0), dataUsuario.get(1), dataUsuario.get(2),
                                dataUsuario.get(3), dataUsuario.get(4), dataUsuario.get(5));
                        
                        animal a = new animal(dataUsuario.get(0), dataUsuario.get(1), dataUsuario.get(2),
                                dataUsuario.get(3), dataUsuario.get(4), dataUsuario.get(5) , Integer.parseInt(dataUsuario.get(6)));
                        salidaCliente.writeUTF(controller.agregarAnimal(a) + "\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName() + " --> " + dataUsuario.get(0));
                        sc.close();
                    }else if(cod.equals("1009")) {
                    	List<String> dataUsuario = Arrays.asList(data.split(","));
                        System.out.println(Arrays.asList(data.split(",")));
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        String animales = controller.recuperarAnimal( Integer.parseInt(dataUsuario.get(0)) );
                        animales = animales.replaceAll("\\s*", "");
                        animales = animales.trim();
                        salidaCliente.writeUTF(animales+"\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName() + " --> " + animales);
                        sc.close();
                    }else if(cod.equals("1010")) {
                    	List<String> dataUsuario = Arrays.asList(data.split(","));
                        System.out.println(Arrays.asList(data.split(",")));
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        String animal = controller.getPerro(dataUsuario.get(0));
                        salidaCliente.writeUTF(animal+"\n");
                        //salidaCliente.writeChars(animal+"\n");
                        salidaCliente.flush();
                        System.out.println(
                                cod + " : " + sc.getInetAddress().getHostName() + " --> " + animal);
                        sc.close();
                    }else if(cod.equals("1011")) {
                    	System.out.println(cod);
                    	List<String> dataUsuario = Arrays.asList(data.split(","));
                        System.out.println(Arrays.asList(data.split(",")));
                        salidaCliente = new DataOutputStream(sc.getOutputStream());
                        String mediciones = controller.getRegistros(dataUsuario.get(0), dataUsuario.get(1));
                        salidaCliente.writeUTF(mediciones + "\n");
                        salidaCliente.flush();
                        System.out.println( cod + " : " + sc.getInetAddress().getHostName() + " --> " + mediciones);
                        sc.close();
                    }
                } else {
                    System.out.println("error de codigo");
                    sc.close();
                }
                // ss.close();

            } catch (Exception e) {
                // System.out.println("El cliente ha cerrado la conexion");
            }
        }
    }

    private String consultaPrueba() {
        // TODO
        String prueba = controller.consultaPrueba();
        return prueba;
    }

}
