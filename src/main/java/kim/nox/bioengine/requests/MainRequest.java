package kim.nox.bioengine.requests;

public class MainRequest {

  private String command;
  private String fingerprintPath;
  private String document;
  private String position;

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

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  private void parseArgs(String[] args) throws IllegalArgumentException {
    if (args.length < 3) {
      throw new IllegalArgumentException(Response.INVALID_ARGUMENTS_COUNT.name());
    } else if (args.length == 3) {
      if (args[0].equals("enroll")) {
        throw new IllegalArgumentException(Response.FOUR_PARAMS_ENROLL.name());
      }
      this.command = args[0];
      this.document = args[1];
      this.fingerprintPath = args[2];
    } else if (args.length == 4) {
      this.command = args[0];
      this.document = args[1];
      this.fingerprintPath = args[2];
      this.position = args[3];
    }
  }
}
