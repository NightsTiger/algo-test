import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexMatches {

    public static void main(String args[]) {
        String str = "asdfasdf  /172.998.214.12:8080asdasd  a172.231.214.12sd asd s  ";
        String ipv4Pattern = "\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}";
        //String ipv4Pattern="((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
        Pattern r = Pattern.compile(ipv4Pattern);
        Matcher m = r.matcher(str);


        while(m.find()){
            String group = m.group();
            System.out.println(group);
            Matcher matcher = r.matcher(group);
            System.out.println(matcher.matches());
        }
    }

}
