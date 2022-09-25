public class RevisionFormatter {

    private Revision revision;
    private String user;
    private String timestamp;

    public RevisionFormatter(Revision revision) {
        this.revision = revision;
        this.user = revision.getUser();
        this.timestamp = revision.getTimestamp();
    }

    public String format() {
        return date() + "\t" + time() + "\t" + user;
    }

    private String date(){
        return timestamp.substring(0,10);
    }

    private String time(){
        return timestamp.substring(11,19);
    }

}
