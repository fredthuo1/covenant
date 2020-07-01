package com.cevenant.backend.data.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrganizationController {

    @Autowired
    final private OrganizationRepo organizationRepo;

    @Autowired
    final private OrganizationService organizationService;

    public OrganizationController(OrganizationRepo organizationRepo, OrganizationService organizationService) {
        this.organizationRepo = organizationRepo;
        this.organizationService = organizationService;
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/organizations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Organization> getAllOrganizations() {
        return organizationRepo.findAll();
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/addOrganization", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<Organization> addOrganization( @RequestBody Organization organization ) {
        organizationService.save( organization );
        System.out.println( organization.toString() );
        return new ResponseEntity<Organization>( organization, HttpStatus.CREATED );
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/updateOrganizationInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Organization> editOrganizationInfo( @RequestBody Organization organization ) {
        List<Organization> organizationList = organizationService.findAll();
        for ( int i = 0; i <= organizationList.size(); i++ ) {
            if ( organization.getOrganization_name().equals(organizationList.get(i).getOrganization_name()) ) {
                organizationList.get(i).setOrganization_name(organization.getOrganization_name());
                organizationList.get(i).setOrganization_addresses(organization.getOrganization_addresses());
            }
        }

        return new ResponseEntity<Organization>( organization, HttpStatus.OK );
    }

    // Get user profile
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/getOrganization", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Optional<Organization> getOrganization(@RequestParam Long id ) {
        Optional<Organization> organization = organizationService.findById(id);
        System.out.println(organization);
        return organization;
    }
}
