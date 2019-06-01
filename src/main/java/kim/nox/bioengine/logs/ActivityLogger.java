package kim.nox.bioengine.logs;

import kim.nox.bioengine.Singleton;
import kim.nox.bioengine.models.Activity;

public class ActivityLogger {

    public static void LogStaffCreated(String document, Long id) {
        Singleton singleton = Singleton.getInstance();
        String description = String.format("Personal creado con el id %s identificado con el documento %s", id, document);
        singleton.server.save(new Activity(document, description));
    }

    public static void LogFingerprintCreated(String document, Long id) {
        Singleton singleton = Singleton.getInstance();
        String description = String.format("Huella creada con el id %s añadida al personal con documento %s", id, document);
        singleton.server.save(new Activity(document, description));
    }
}
