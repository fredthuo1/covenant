package com.cevenant.backend.data.nylas;

import com.nylas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.io.IOException;


@RestController
@CrossOrigin( origins = "http://localhost:3000" )
public class NylasController {

    @Autowired
    final private NylasRepository nylasRepository;

    @Autowired
    final private NylasService nylasService;

    public NylasController(NylasRepository nylasRepository, NylasService nylasService) {
        this.nylasRepository = nylasRepository;
        this.nylasService = nylasService;
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/getToken", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public void get() throws IOException, RequestFailedException {
        NylasClient nylasClient = new NylasClient();
        NylasApplication application = nylasClient.application("", "");
        NativeAuthentication authentication = application.nativeAuthentication();
        String accessToken = authentication.fetchToken("").getAccessToken();
        NylasAccount account = nylasClient.account(accessToken);
    }
}
