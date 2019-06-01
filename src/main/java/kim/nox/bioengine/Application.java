package kim.nox.bioengine;

import kim.nox.bioengine.biometrics.BioResult;
import kim.nox.bioengine.biometrics.Enroller;
import kim.nox.bioengine.biometrics.Matcher;
import kim.nox.bioengine.database.Engine;
import kim.nox.bioengine.requests.MainRequest;

class Application {

    private MainRequest mainRequest;

    Application(String[] args) {
        try {
            mainRequest = new MainRequest(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    void bootstrap() {
        Singleton singleton = Singleton.getInstance();
        singleton.server = new Engine().start();

        BioResult result;

        if(mainRequest.getCommand().equals("enroll")) {
            Enroller enroller = new Enroller(mainRequest.getDocument(), mainRequest.getFingerprintPath());
            result =  enroller.enrollBioTemplateToDatabase();
        } else if (mainRequest.getCommand().equals("match")) {
            Matcher matcher = new Matcher();
            result = matcher.matchAgainstDatabase(mainRequest.getDocument(), mainRequest.getFingerprintPath());
            System.out.println(result + " " + matcher.getScore());
        }
    }
}
