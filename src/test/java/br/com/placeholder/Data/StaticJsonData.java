package br.com.placeholder.Data;
import org.json.JSONObject;

public class StaticJsonData {
    
    public static String generatePutJsonData() {
        
        JSONObject user = new JSONObject();
        user.put("id", 1);
        user.put("name", "Peterson Petravicius"); 
        user.put("username", "Petpet"); 
        user.put("email", "petpet@example.com"); 
        user.put("phone", "1-770-736-8031 x1234" );
        user.put("website", "www.meusite.com.br");
        
        JSONObject address = new JSONObject();
        address.put("street", "Rua: Gilberto Amado");
        address.put("suite", "Número: 170");
        address.put("city", "Praia Grande - SP");
        address.put("zipcode", "11704290");
        user.put("address", address);
        
        JSONObject geo = new JSONObject();
        geo.put("lat", "3392.20");
        geo.put("lng", "03.9432");
        address.put("geo", geo);
      
        JSONObject company = new JSONObject();
        company.put("name", "Grupo PetPet LTDA"); 
        company.put("catchPhrase", "Desenvolvimento de Sistemas e automações"); 
        company.put("bs", "Você sonha e a PetPet realiza"); 
        user.put("company", company);

        return user.toString();
    }
    public static String generateGetJsonData() {
        
        JSONObject user = new JSONObject();
        user.put("id", 2);
        user.put("name", "Ervin Howell"); 
        user.put("username", "Antonette"); 
        user.put("email", "Shanna@melissa.tv"); 
        user.put("phone", "010-692-6593 x09125" );
        user.put("website", "anastasia.net");
        
        JSONObject address = new JSONObject();
        address.put("street", "Victor Plains");
        address.put("suite", "Suite 879");
        address.put("city", "Wisokyburgh");
        address.put("zipcode", "90566-7771");
        user.put("address", address);
        
        JSONObject geo = new JSONObject();
        geo.put("lat", "-43.9509");
        geo.put("lng", "-34.4618");
        address.put("geo", geo);
      
        JSONObject company = new JSONObject();
        company.put("name", "Deckow-Crist"); 
        company.put("catchPhrase", "Proactive didactic contingency");
        company.put("bs", "synergize scalable supply-chains"); 
        user.put("company", company);

        return user.toString();
    }
    public static String generateDeleteJsonData() {
        
        JSONObject user = new JSONObject();
        user.put("id", 3);
        return user.toString();
    }
}
