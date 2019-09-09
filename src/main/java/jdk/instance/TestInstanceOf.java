package jdk.instance;

import java.util.HashMap;

public class TestInstanceOf {


    public static class ParamMap<V> extends HashMap<String, V> {

        private static final long serialVersionUID = -2212268410512043556L;

        @Override
        public V get(Object key) {
            if (!super.containsKey(key)) {
                throw new RuntimeException("Parameter '" + key + "' not found. Available parameters are " + keySet());
            }
            return super.get(key);
        }

    }


    public static class StrictMap<V> extends HashMap<String, V> {

        private static final long serialVersionUID = -5741767162221585340L;

        @Override
        public V get(Object key) {
            if (!super.containsKey(key)) {
                throw new RuntimeException("Parameter '" + key + "' not found. Available parameters are " + this.keySet());
            }
            return super.get(key);
        }

    }


}
