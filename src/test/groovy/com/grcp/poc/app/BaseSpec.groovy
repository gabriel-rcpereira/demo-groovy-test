package com.grcp.poc.app

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import spock.lang.Specification

class BaseSpec extends Specification {

    def setupSpec(){
        FixtureFactoryLoader.loadTemplates("com.grcp.poc.app.template");
    }
}
