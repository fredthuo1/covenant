package com.cevenant.backend.data.donation;

import com.cevenant.backend.data.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DonationsController {
    @Autowired
    final DonationService donationService;

    @Autowired
    final DonationRepository donationRepository;

    public DonationsController(DonationService donationService, DonationRepository donationRepository) {
        this.donationService = donationService;
        this.donationRepository = donationRepository;
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/donations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Donation> getAllDonations() {
        return donationService.findAll();
    }

    // Add new donation
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/addDonation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Donation> addDonations(@RequestBody Donation donation ) {
        donationService.save( donation );
        System.out.println(donation.toString() );
        return new ResponseEntity<Donation>(donation, HttpStatus.CREATED);
    }

    // Delete donation
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/deleteDonation/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Donation> deleteDonation( @RequestBody Donation donation ){
        donationService.delete(donation);
        return new ResponseEntity<Donation>(donation, HttpStatus.OK);
    }

    // Edit donation Info
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/updateDonationInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Donation> editDonationInfo( @RequestBody Donation donation ){
        List<Donation> donationList = donationService.findAll();
        for ( int i = 0; i <= donationList.size(); i++ ) {
            if(donation.getId() == donationList.get(i).getId()){
                donationList.get(i).setDonation_name(donation.getDonation_name());
                donationList.get(i).setPerson(donation.getPerson());
            }
        }
        return new ResponseEntity<Donation>(donation, HttpStatus.OK);
    }

    // Get Donation
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/getDonation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Optional<Donation> getDonation(@RequestParam Long id ) {
        Optional<Donation> donation = donationService.findById(id);
        System.out.println(donation);
        return donation;
    }
}
