//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.sicredi.test.restAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import br.com.sicredi.test.utils.ToReadResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.groovy.json.internal.LazyMap;
import org.json.JSONArray;
import org.json.JSONObject;


public class UtilsREST {
    private static LazyMap camposJson = new LazyMap();
    private static LazyMap headerCustom = new LazyMap();
    private static LazyMap valorArray = new LazyMap();
    private static JSONArray getJsonArrayValor = new JSONArray();
    static ToReadResponse kafkaResponseJSON = new ToReadResponse();
    private static List valorList = new ArrayList();

    public UtilsREST() {
    }

    public static JSONObject carregarJson(JSONObject obj, String parametro, String valorAntigo, String valorNovo, String format) throws Exception {
        new JSONObject();
        Iterator iterator = obj.keys();
        String key = null;

        while(true) {
            do {
                if (!iterator.hasNext()) {
                    return obj;
                }

                key = (String)iterator.next();
                if (obj.optJSONArray(key) == null && obj.optJSONObject(key) == null && key.equals(parametro) && obj.get(key).toString().equals(valorAntigo)) {
                    switch (format) {
                        case "integer":
                            obj.put(key, Integer.parseInt(valorNovo));
                            break;
                        case "bolean":
                            obj.put(key, Boolean.valueOf(valorNovo));
                            break;
                        default:
                            obj.put(key, valorNovo);
                    }

                    return obj;
                }

                if (obj.optJSONObject(key) != null) {
                    carregarJson(obj.getJSONObject(key), parametro, valorAntigo, valorNovo, format);
                }
            } while(obj.optJSONArray(key) == null);

            JSONArray jArray = obj.getJSONArray(key);

            for(int i = 0; i < jArray.length(); ++i) {
                carregarJson(jArray.getJSONObject(i), parametro, valorAntigo, valorNovo, format);
            }
        }
    }

    public static JSONObject carregarListaJson(JSONObject obj, String parametro, String valorAntigo, String[] valorNovo) throws Exception {
        new JSONObject();
        Iterator iterator = obj.keys();
        String key = null;

        while(true) {
            do {
                if (!iterator.hasNext()) {
                    return obj;
                }

                key = (String)iterator.next();
                if (obj.optJSONArray(key) == null && obj.optJSONObject(key) == null && key.equals(parametro) && obj.get(key).toString().equals(valorAntigo)) {
                    obj.put(key, valorNovo);
                    return obj;
                }

                if (obj.optJSONObject(key) != null) {
                    carregarListaJson(obj.getJSONObject(key), parametro, valorAntigo, valorNovo);
                }
            } while(obj.optJSONArray(key) == null);

            JSONArray jArray = obj.getJSONArray(key);

            for(int i = 0; i < jArray.length(); ++i) {
                carregarListaJson(jArray.getJSONObject(i), parametro, valorAntigo, valorNovo);
            }
        }
    }

    public static JSONObject carregarJSONArray(JSONObject obj, String parametro, String valorAntigo, JSONArray valorNovo) throws Exception {
        new JSONObject();
        Iterator iterator = obj.keys();
        String key = null;

        while(true) {
            do {
                if (!iterator.hasNext()) {
                    return obj;
                }

                key = (String)iterator.next();
                if (obj.optJSONArray(key) == null && obj.optJSONObject(key) == null && key.equals(parametro) && obj.get(key).toString().equals(valorAntigo)) {
                    obj.put(key, valorNovo);
                    return obj;
                }

                if (obj.optJSONObject(key) != null) {
                    carregarJSONArray(obj.getJSONObject(key), parametro, valorAntigo, valorNovo);
                }
            } while(obj.optJSONArray(key) == null);

            JSONArray jArray = obj.getJSONArray(key);

            for(int i = 0; i < jArray.length(); ++i) {
                carregarJSONArray(jArray.getJSONObject(i), parametro, valorAntigo, valorNovo);
            }
        }
    }

    public static void preencherValorArray(String campo, String valor) {
        valorArray.put(campo, valor);
    }

    public static void preencherLista(String valor) {
        valorList.add(valor);
    }

    public static List getValorList() {
        return valorList;
    }

    public static LazyMap getValorArray() {
        return valorArray;
    }

    public static JSONArray getJsonArray() {
        getJsonArrayValor.put(getValorArray());
        return getJsonArrayValor;
    }

    public static void preencherCampo(String campo, String valor) {
        camposJson.put(campo, valor);
    }

    public static LazyMap getCampos() {
        return camposJson;
    }

    public static void preencherHeader(String campo, String valor) {
        headerCustom.put(campo, valor);
    }

    public static LazyMap getHeaderCustom() {
        return headerCustom;
    }

    public static JSONObject readJsonSimpleDemo(String filename) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        JSONObject obj = new JSONObject(content.trim());
        return obj;
    }

    public static String encodeFileToBase64Binary(String file) {
        File f = new File(file);
        String encodedfile = null;

        try {
            FileInputStream fileInputStreamReader = new FileInputStream(f);
            byte[] bytes = new byte[(int)f.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return encodedfile;
    }

    public static void readJsonResponse(JSONObject jsonObject, String campo) {
        Iterator key = jsonObject.keys();
        System.out.println(interacaoJson(key, jsonObject, campo));
    }

    public static Object interacaoJson(Iterator iteratorKey, JSONObject jsonObject, String campo) {
        while(true) {
            if (iteratorKey.hasNext()) {
                String key = iteratorKey.next().toString();
                Object value = jsonObject.get(key);
                JSONObject json;
                Iterator keySegundo;
                if (value instanceof JSONObject) {
                    json = new JSONObject(value.toString());
                    keySegundo = json.keys();
                    interacaoJson(keySegundo, json, campo);
                    continue;
                }

                if (value instanceof String) {
                    if (!key.equals(campo)) {
                        continue;
                    }

                    kafkaResponseJSON.setResponse(jsonObject.get(campo));
                } else {
                    if (value instanceof JSONArray) {
                        json = new JSONObject(((JSONArray)value).get(0).toString());
                        System.out.println(json);
                        keySegundo = json.keys();
                        interacaoJson(keySegundo, json, campo);
                        continue;
                    }

                    if (value instanceof Integer) {
                        if (!key.equals(campo)) {
                            continue;
                        }

                        kafkaResponseJSON.setResponse(jsonObject.get(campo));
                    } else {
                        if (!(value instanceof Boolean) || !key.equals(campo)) {
                            continue;
                        }

                        kafkaResponseJSON.setResponse(jsonObject.get(campo));
                    }
                }
            }

            return kafkaResponseJSON.getResponse();
        }
    }
}
