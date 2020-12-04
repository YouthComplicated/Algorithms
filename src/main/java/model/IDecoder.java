package model;

/**
 * @author: nj
 * @date: 2020-08-12 14:35
 * @version: 0.0.1
 */
public interface IDecoder {

    /**
     * 接口方法
     * @param method
     * @param code
     * @return
     */
    Exception decode(String method, Integer code);

    /**
     * 接口内部实现类 不是静态内部类
     */
    class Default implements IDecoder{
        @Override
        public Exception decode(String method, Integer code) {
            if(method == null || "".equals(method)){
                return new Exception("错误........");
            }else{
                System.out.println("method 为空........");
                return null;
            }
        }
    }


}