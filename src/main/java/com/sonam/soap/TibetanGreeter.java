package com.sonam.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TibetanGreeter implements Greeter {

    private Logger logger = LoggerFactory.getLogger( getClass( ) );

    public String greetMe( String name ) {
        logger.debug( "Tashi Delek, '{}'", name );
        return "Tashi Delek, " + name;
    }

    public String bye( ) {
        return "good bye";
    }
}
