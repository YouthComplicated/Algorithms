package model;

/**
 * @author: nj
 * @date: 2020-08-12 15:21
 * @version: 0.0.1
 */
public final class FinalDelegate implements IDecoder{

    final IDecoder decoder;

    /**
     *
     * @param decoder
     */
    public FinalDelegate(IDecoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Exception decode(String method, Integer code) {
        return null;
    }
}