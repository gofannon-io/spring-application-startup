package io.gofannon.applicationstartup.webapp.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/star")
public class StarController {

    @GetMapping(produces = {"application/json"})
    public String processJson() {
        return """
                {
                    "message": "Hello, world"
                }
                """;
    }

    @GetMapping(produces = {"application/xml"})
    public String processXml() {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <message>Hello, world</message>
                """;
    }
}
