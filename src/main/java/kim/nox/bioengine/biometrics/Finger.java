package kim.nox.bioengine.biometrics;

public enum Finger {

    R_THUMB("1", "pulgar derecho"),
    R_INDEX("2", "índice derecho"),
    R_MIDDLE("3", "corazón derecho"),
    R_RING("4", "anular derecho"),
    R_LITTLE("5", "meñique derecho"),
    L_THUMB("6", "pulgar izquierdo"),
    L_INDEX("7", "índice izquierdo"),
    L_MIDDLE("8", "corazón izquierdo"),
    L_RING("9", "anular izquierdo"),
    L_LITTLE("10", "meñique izquierdo");

    private String key;
    private String value;

    private Finger(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString(){
        return value;
    }

    public static String getEnumByString(String key) {
        for(Finger finger : Finger.values()){
            if(key.equals(finger.key)) return finger.value;
        }
        return null;
    }
}
