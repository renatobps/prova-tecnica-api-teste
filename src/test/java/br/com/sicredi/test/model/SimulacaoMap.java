package br.com.sicredi.test.model;


import org.apache.groovy.json.internal.LazyMap;
import org.json.JSONObject;

import java.math.BigInteger;

import static br.com.sicredi.test.restAssured.UtilsREST.readJsonSimpleDemo;
import static br.com.sicredi.test.utils.Utils.getProperties;


public class SimulacaoMap {

    public SimulacaoMap() throws Exception {
    }
    private static LazyMap json = new LazyMap();
    private static LazyMap header = new LazyMap();

    private static LazyMap params = new LazyMap();
    public static LazyMap getJson() {
        return json;
    }

    public static LazyMap getHeader() {
        return header;
    }

    public static LazyMap getParams() {
        return params;
    }

    public static void initHeader(){
        header.put("Content-Type", "application/json; charset=utf-8");
    }

    //para usar laymap ao inves do objeto json
//    public static void initPayload(){
//
//                json.put("nome", "Fulano de Tal");
//                json.put("cpf", "cpf");
//                json.put("email", "email@email.com");
//                json.put("valor", 0);
//                json.put("parcelas", 0);
//                json.put("seguro", true);
//
//        }



}
