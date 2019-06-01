package kim.nox.bioengine;

import kim.nox.bioengine.biometrics.BioResult;
import kim.nox.bioengine.biometrics.Enroller;
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
        if(mainRequest.getCommand().equals("enroll")) {
            Enroller enroller = new Enroller(mainRequest.getDocument(), mainRequest.getFingerprintPath());
            BioResult result =  enroller.enrollBioTemplateToDatabase();
        }
    }
}
