package kim.nox.bioengine.logs;

import kim.nox.bioengine.Singleton;
import kim.nox.bioengine.biometrics.Finger;
import kim.nox.bioengine.models.Activity;

public class ActivityLogger {

    public static void logStaffCreated(String document, Long id) {
        Singleton singleton = Singleton.getInstance();
        String description = String.format("Personal creado con el id %s identificado con el documento %s", id, document);
        singleton.server.save(new Activity(document, description));
    }

    public static void logFingerprintCreated(String document, Long id, String position) {
        Singleton singleton = Singleton.getInstance();
        String description = String.format(
                "Huella del %s creada con el id %s añadida a personal con documento %s",
                Finger.getEnumByString(position),
                id,
                document
        );
        singleton.server.save(new Activity(document, description));
    }

    public static void logUserNotFound(String document) {
        Singleton singleton = Singleton.getInstance();
        String description = String.format(
                "Intento de verificación de personal no registrado con documento %s",
                document
        );
        singleton.server.save(new Activity(document, description));
    }

    public static void logMatchFailed(String document) {
        Singleton singleton = Singleton.getInstance();
        String description = String.format(
                "Intento de verificación fallido de personal con documento %s",
                document
        );
        singleton.server.save(new Activity(document, description));
    }

    public static void logMatchSuccesful(String document, String position) {
        Singleton singleton = Singleton.getInstance();
        String description = String.format(
                "Verificación exitosa de personal con documento %s usando el dedo %s",
                document,
                Finger.getEnumByString(position)
        );
        singleton.server.save(new Activity(document, description));
    }
}
