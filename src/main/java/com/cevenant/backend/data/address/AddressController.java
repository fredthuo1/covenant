package com.cevenant.backend.data.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

    @Autowired
    final private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/addAddress", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<Address> addAddress(@RequestBody Address address ) {
        addressService.save(address);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }
}
