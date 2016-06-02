package com.sonam.soap;

import javax.jws.WebService;

@WebService
public interface Greeter {

    public String greetMe(String name);

    public String bye();

    public void throwException(String message);
}
