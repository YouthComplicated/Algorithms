package model;

/**
 * @author: nj
 * @date: 2020-08-12 14:41
 * @version: 0.0.1
 */
public interface IEncoder {

    void Encode(String method, Integer code);


    static class Default implements  IEncoder{

        @Override
        public void Encode(String method, Integer code) {
            
        }
    }

}