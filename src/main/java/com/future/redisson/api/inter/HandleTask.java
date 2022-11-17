package com.future.redisson.api.inter;

/**
 * handle task func
 *
 * @author liuyunfei
 */
@FunctionalInterface
public interface HandleTask {

    /**
     * task
     */
    void handle();

}
