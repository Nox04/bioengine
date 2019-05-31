package kim.nox.bioengine;

import io.ebean.EbeanServer;

public class Singleton {
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    // variable of type String
    public EbeanServer server;


    // private constructor restricted to this class itself
    private Singleton() {}


    /**
     * Static method to create instance of Singleton class.
     * @return Singleton instance.
     */
    public static Singleton getInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }

        return single_instance;
    }
}