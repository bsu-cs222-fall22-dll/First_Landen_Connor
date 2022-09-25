import java.util.List;

public class Redirects {
    private String redirectFrom;
    private String redirectTo;
    public Redirects(List<String> redirectFrom, List<String> redirectTo) {
        if (redirectFrom.isEmpty() && redirectTo.isEmpty()) {
            this.redirectFrom = "N/A";
            this.redirectTo = "N/A";
        } else {
            this.redirectFrom = redirectFrom.get(0);
            this.redirectTo = redirectTo.get(0);
        }
    }

    public String from(){
        return redirectFrom;
    }

    public String to(){
        return redirectTo;
    }
}
