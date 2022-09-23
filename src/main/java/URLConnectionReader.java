import java.net.*;
import java.io.*;
    public class URLConnectionReader{

        public static void main(String[] args)
        {
            String output  = getUrlContents();
            System.out.println(output);
        }

        private static String getUrlContents()
        {
            StringBuilder content = new StringBuilder();

            try
            {
                URL url = new URL("https://en.wikipedia.org/wiki/Cannabis_(drug)");
                URLConnection urlConnection = url.openConnection();


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    content.append(line).append("\n");
                }
                bufferedReader.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return content.toString();
        }
    }

