package task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebAddressParser {
    private URL address;

    public WebAddressParser(String address){
        try {
            this.address = new URL(address);
        } catch (MalformedURLException e) {
            this.address = null;
        }
    }

    public String getLogin(){
        if(isValid()) {
            String[] Auth = address.getAuthority().split("@");
            if(Auth.length >= 2) {
                String[] infoUser = Auth[0].split(":");
                if (infoUser.length >= 2) {
                    return infoUser[0];
                }
            }
        }
        return "";
    }

    public String getPassword(){
        if(isValid()) {
            String[] Auth = address.getAuthority().split("@");
            if(Auth.length >= 2) {
                String[] infoUser = Auth[0].split(":");
                if (infoUser.length >= 2) {
                    return infoUser[1];
                }
            }
        }
        return "";
    }

    public String getScheme(){
        if(isValid()) {
            return address.getProtocol();
        }
        else {
            return "";
        }
    }

    public boolean isValid(){
        return address != null;
    }

    public String getHost(){
        if(isValid()) {
            return address.getHost();
        }
        else{
            return "";
        }
    }

    public String getPort(){
        if(isValid() && address.getPort() != -1) {
            return Integer.toString(address.getPort());
        }
        else {
            return "";
        }
    }

    public String getUrl(){
        if(isValid()) {
            return address.getPath().replaceFirst("/", "");
        }
        else {
            return "";
        }
    }

    public HashMap<String, String> getParameters(){
        HashMap<String, String> parameters = new HashMap<>();

        if(isValid() && address.getQuery() != null) {

            String[] Par = address.getQuery().split("&");
            String p[];

            for (int i = 0; i < Par.length; i++) {
                p = Par[i].split("=");
                parameters.put(p[0], p[1]);
            }
        }
        return parameters;
    }

    public String getFragment(){
        if(isValid() && address.getRef() != null) {
            return address.getRef();
        }
        else {
            return "";
        }
    }
}
