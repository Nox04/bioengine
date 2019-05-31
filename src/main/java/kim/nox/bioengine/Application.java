package kim.nox.bioengine;

import kim.nox.bioengine.database.Engine;

class Application {

    private Singleton singleton;

    void bootstrap() {
        singleton = Singleton.getInstance();
        singleton.server = new Engine().start();
    }
}
