package br.com.placeholder.Data;
import org.json.JSONObject;

public class RandomDataGenerator {

    public static String generateRandomUserRequestBody() {

        int randomNumber = generateRandomNumber();
        int randomNumber2 = generateRandomNumber();
        String randomLetters = generateRandomLetters();
        String randomLetters2 = generateRandomLetters();
        
        JSONObject user = new JSONObject();
        user.put("id", 11);
        user.put("name", "Name " + randomLetters + " " + randomLetters2); 
        user.put("username", "Username_" + randomLetters2 + randomLetters); 
        user.put("email", "Name" + randomLetters + "." + randomNumber + "@example.com"); 
        user.put("phone", "1-770-736-8031 x" + randomNumber);
        user.put("website", "www.meusite" + randomLetters +".com.br");

        JSONObject address = new JSONObject();
        address.put("street", "Rua: " + randomLetters2 + randomLetters2 + " " + randomLetters);
        address.put("suite", "Número: " + (randomNumber-1));
        address.put("city", randomLetters + randomLetters + " - SP");
        String str1 = (randomNumber2-10) + "" + (randomNumber-20) + "" + (randomNumber-30);
        String result1 = limitToMaxLength(str1, 8);
        address.put("zipcode", result1);
        user.put("address", address);
        
        JSONObject geo = new JSONObject();
        geo.put("lat", + randomNumber + "." + randomNumber2);
        geo.put("lng", + randomNumber2 + "." + randomNumber);
        address.put("geo", geo);
      
        JSONObject company = new JSONObject();
        company.put("name", "Grupo " + randomLetters2 + " LTDA"); 
        company.put("catchPhrase", "Desenvolvimento de Sistemas " + randomLetters +" e automações");
        company.put("bs", "Você sonha e a " + randomLetters + " realiza"); 
        user.put("company", company);

        return user.toString();
    }
    public static int generateRandomNumber() {
        return (int)(Math.random() * 10000) + 1;
    }
    public static String generateRandomLetters() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char randomChar = (char)('a' + Math.random() * ('z' - 'a' + 1));
            sb.append(randomChar);
        }
        return sb.toString();
    }
    public static String limitToMaxLength(String str, int maxLength) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        if (str.length() > maxLength) {
            return str.substring(0, maxLength);
        }
        return str;
    }
}
