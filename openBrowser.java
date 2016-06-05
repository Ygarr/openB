package kdiv;

public class openBrowser {
 
    public static void main(String args[]) {
        String url = "2ip.com.ua";
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try {
            if (os.contains("win")) {
                // no links containing # "
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url); // open URL through cmd
            } else if (os.contains("mac")) {
                rt.exec("open " + url); 
            } else if (os.contains("nix") || os.contains("nux")) {
                //nix
                String[] browsers = {"chromium", "firefox-bin", "x-www-browser", "epiphany" , "opera", "links2 -g", "vivaldi"};
                // calling all browsers in Shell with OR
                StringBuilder cmd = new StringBuilder();
                for (int i = 0; i < browsers.length; i++)
                    cmd.append(i == 0 ? "" : " || ").append(browsers[i]).append(" \"").append(url).append("\" ");
                rt.exec(new String[]{"sh", "-c", cmd.toString()});
            } else {
                return;
            }
        } catch (Exception e) {
            //Error? Do nothing!
        }
    }
}

