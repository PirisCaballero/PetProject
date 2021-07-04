package com.conexion.Conexion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.conexion.Recursos.*;
import com.conexion.Recursos.persona;

public class Cliente extends conexion {
    public String cod;

    public Cliente(String codigo) throws IOException {
        super("cliente");
        this.cod = codigo;
    }

    public boolean verificarUsuario(String apodo, String contrasenia) {
        try {
            apodo = apodo.replaceAll("\\s*", "");
            apodo = apodo.trim();
            contrasenia = contrasenia.replaceAll("\\s*", "");
            contrasenia = contrasenia.trim();

            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + apodo + "," + contrasenia + "\n");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            if (mensaje.equals("true")) {
                sc.close();
                return true;
            } else {
                sc.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e + "cl");
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getRazasPerros() {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + "razasPerros" + "\n");
            salidaServidor.flush();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            // System.out.println(mensaje);
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            List<String> dataUsuario = Arrays.asList(mensaje.split(","));
            return dataUsuario;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getTiposDeAnimales() {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + "tiposDeAnimales" + "\n");
            salidaServidor.flush();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            List<String> dataUsuario = Arrays.asList(mensaje.split(","));
            return dataUsuario;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getTiposDeSangreAnimales() {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + "tiposDeSangreAnimales" + "\n");
            salidaServidor.flush();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            List<String> dataUsuario = Arrays.asList(mensaje.split(","));
            return dataUsuario;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public String getCellId(String tabla, String valor) {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + tabla + "," + valor + "\n");
            salidaServidor.flush();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            String dataUsuario = mensaje;
            return dataUsuario;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public String agregarAnimal(animal a) {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + a.toString() + "\n");
            salidaServidor.flush();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            String dataUsuario = mensaje;
            return dataUsuario;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
            return null;
        }

    }

    public boolean registrarUsuario(persona p) {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + p.getNombre() + "," + p.getApellidos() + "," + p.getDni() + ","
                    + p.getCorreo() + "," + p.getApodo() + "," + p.getContrasenia() + "\n");
            salidaServidor.flush();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            if (mensaje.equals("true")) {
                sc.close();
                return true;
            } else {
                sc.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e + "cl");
            e.printStackTrace();
            try {
                sc.close();
            } catch (IOException e2) {
                System.out.println(e2);
                e.printStackTrace();
            }
            return false;
        }
    }

    public persona getPersona(String apodo, String contrasenia) {
        if (apodo != "" && contrasenia != "") {
            persona p;
            try {
                salidaServidor = new DataOutputStream(sc.getOutputStream());
                salidaServidor = new DataOutputStream(sc.getOutputStream());
                salidaServidor.writeUTF(this.cod + "-" + apodo + "," + contrasenia + "\n");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                String mensaje = entrada.readLine();
                // Si retorna "" meter un if/else
                mensaje = mensaje.replaceAll("\\s*", "");
                mensaje = mensaje.trim();
                List<String> dataUsuario = Arrays.asList(mensaje.split(","));
                p = new persona();
                if (!Character.isDigit(dataUsuario.get(0).charAt(0))) {
                    String id = dataUsuario.get(0).substring(1);
                    p.setId(id);
                } else {
                    p.setId(dataUsuario.get(0));
                }

                p.setNombre(dataUsuario.get(1));
                p.setApellidos(dataUsuario.get(2));
                p.setDni(dataUsuario.get(3));
                p.setCorreo(dataUsuario.get(4));
                p.setApodo(dataUsuario.get(5));
                p.setContrasenia(dataUsuario.get(6));
                sc.close();
                return p;
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
                try {
                    sc.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public String getAnimales(int idUsuario) {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + idUsuario + "\n");
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(sc.getInputStream(), StandardCharsets.UTF_8));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            // mensaje = mensaje.substring(1);
            sc.close();
            return mensaje;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            try {
                sc.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null;
        }
    }

    public ArrayList<String> getMediciones(String idPerro, String idUsuario) {
        System.out.println("IDs: " + idPerro + idUsuario);
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            String salida = this.cod + "-" +idPerro+","+idUsuario+"\n";
            salidaServidor.writeUTF(salida);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(sc.getInputStream(), StandardCharsets.UTF_8));
            String mensaje = entrada.readLine();
            if (mensaje.length() > 0) {
                mensaje = mensaje.replaceAll("\\s*", "");
                mensaje = mensaje.trim();
                System.out.println(mensaje);

                List<String> dataUsuario = Arrays.asList(mensaje.split("|"));
                ArrayList<String> mens = new ArrayList<String>();
                int i = dataUsuario.size();
                String mensajeFinal = "";
                int contador = 0;
                for (int o = 0; o < i; o++) {
                    if (!dataUsuario.get(o).equals("|")) {
                        mensajeFinal += dataUsuario.get(o);
                    } else {
                        String s = mensajeFinal.charAt(0) + "1";
                        try {
                            Integer.parseInt(s);
                            mens.add(mensajeFinal.substring(0, mensajeFinal.length() - 1));
                            mensajeFinal = "";
                            contador++;
                        } catch (Exception e2) {
                            mens.add(mensajeFinal.substring(1, mensajeFinal.length() - 1));
                            mensajeFinal = "";
                            contador++;
                        }

                    }
                }
                sc.close();
                return mens;
            } else {
                System.out.println("Error");
                return null;
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            try {
                sc.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null;
        }
    }

    public animal getAnimal(String id) {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + id + "\n");
            // salidaServidor.writeChars(this.cod + "-" + id + "\n");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream(), "UTF-8"));
            String mensaje = entrada.readLine();
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            mensaje = mensaje.substring(1);
            animal a = new animal();
            List<String> animales;
            animales = Arrays.asList(mensaje.split(","));
            a.setIdAnimal(animales.get(0));
            a.setApodo(animales.get(1));
            a.setTipo(animales.get(2));
            a.setRaza(animales.get(3));
            a.setPeso(animales.get(4));
            a.setTipoSangre(animales.get(5));
            a.setFechaNacimiento(animales.get(6));
            a.setIdUsuario(Integer.parseInt(animales.get(7)));
            a.setFechaFueAgregado(animales.get(8));

            sc.close();
            return a;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            try {
                sc.close();
                return null;
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return null;
            }
        }

    }

}
