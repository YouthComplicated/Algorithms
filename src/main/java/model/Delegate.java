package model;

/**
 * @author: nj
 * @date: 2020-08-12 15:29
 * @version: 0.0.1
 */
public class Delegate implements IDecoder {

    IDecoder decoder;

    /**
     * final修饰的成员变量必需初始化或者体现在构造函数中
     * @param method
     * @param code
     * @return
     */
//    final IEncoder encoder;

//    public Delegate(IDecoder decoder) {
//        this.decoder = decoder;
//    }


    @Override
    public Exception decode(String method, Integer code) {
        return null;
    }
}