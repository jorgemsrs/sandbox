package com.jorgesilva.sandbox;

import org.springframework.stereotype.Component;

/**
 * TODO: doc
 *
 * @author Jorge Silva <juniorjoca at gmail dot com>
 */
@Component
public class AdvisedBean {

    public void sayHello() {
        System.out.println("Hello");
    }
}
