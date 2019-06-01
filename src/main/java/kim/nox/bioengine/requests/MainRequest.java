package kim.nox.bioengine.requests;

public class MainRequest {

    private String command;
    private String fingerprintPath;
    private String document;

    public MainRequest(String[] args) {
        parseArgs(args);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getFingerprintPath() {
        return fingerprintPath;
    }

    public void setFingerprintPath(String fingerprintPath) {
        this.fingerprintPath = fingerprintPath;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    private void parseArgs(String[] args) throws IllegalArgumentException {
        if(args.length != 3) {
            throw new IllegalArgumentException("Exactly 3 parameters required!");
        } else {
            this.command = args[0];
            this.document = args[1];
            this.fingerprintPath = args[2];
        }
    }
}
