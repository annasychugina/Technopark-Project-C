package com.example.ekkert.myapplication.client;

import com.example.ekkert.myapplication.models.City;
import com.example.ekkert.myapplication.models.ServerCmd;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 03.05.2016.
 */
public class JSonClient {
    private String host;
    private int port;


    public JSonClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket connect() {

        Socket soc = new Socket();
        try {
            soc.bind(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            soc.connect(new InetSocketAddress(host, port), 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            soc.setKeepAlive(true);
        } catch (SocketException e) {
            e.printStackTrace();
        }


        return soc;
    }

    public List<City> getCities() throws IOException {
        List<City> cities = null;
        Socket socket = connect();
        try {
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            os.writeUTF(ServerCmd.getCities.name());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream is = new DataInputStream(socket.getInputStream());


        Type listType = new TypeToken<ArrayList<City>>() {
        }.getType();
        String inp = is.readUTF();

        cities = new Gson().fromJson(inp, listType);
        return cities;


    }

}
